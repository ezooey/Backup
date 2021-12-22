package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.board.model.exception.BoardException;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.common.Pagination;
import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.model.vo.Reply;

@Controller
public class BoardController {
	
	@Autowired // 의존성 주입
	private BoardService bService;
	
	@RequestMapping("blist.bo")
	public /*String*/ModelAndView boardList(@RequestParam(value="page", required=false) Integer page, /*Model model*/ModelAndView mv) { 
		// Integer는 클래스타입이기 때문에 Integer라고 해주면 int일 때 null과 비교를 못하던 것과 달리 비교가 가능해진다.
		// 항상 필요한 것은 아니므로 required=false 처리 필요
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int listCount = bService.getListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Board> list = bService.selectList(pi);
		
		if(list != null) {
			// 1. 반환 값이 String인 상태에서 view에 데이터 전달 : Model
//			model.addAttribute("pi", pi);
//			model.addAttribute("list", list);
			
			// 2. 반환 값을 ModelAndView로 변경한 상태에서 view에 데이터 전달
			mv.addObject("pi", pi);
			mv.addObject("list", list);
			mv.setViewName("boardListView");
		} else {
			throw new BoardException("게시글 전체 조회에 실패하였습니다.");
		}
		
//		return "boardListView";
		return mv;
	}
	
	@RequestMapping("binsertView.bo")
	public String boardInsertView() {
		return "boardInsertForm";
	}
	
	@RequestMapping("binsert.bo")
	public String boardInsert(@ModelAttribute Board b, @RequestParam("uploadFile") MultipartFile uploadFile, 
							  HttpServletRequest request) {
		// uploadFile은 파일이 안 들어갔다고 해서 null이 아님 getOriginalFilename이용해서 파일이 들어왔는지 여부 판단해야!
		
		System.out.println(b);
		System.out.println(uploadFile);
		System.out.println(uploadFile.getOriginalFilename());
		
//		if(!uploadFile.getOriginalFilename().equals("")) {} 혹은
		if(uploadFile != null && !uploadFile.isEmpty()) {
			String renameFileName = saveFile(uploadFile, request);
			
			if(renameFileName != null) {
				b.setOriginalFileName(uploadFile.getOriginalFilename());
				b.setRenameFileName(renameFileName);
			}
		}
		
		int result = bService.insertBoard(b);
		
		if(result > 0) {
			return "redirect:blist.bo";
		} else {
			throw new BoardException("게시글 작성에 실패하였습니다.");
		}
	}
	
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/buploadFiles";
		
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String originFileName = file.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "." + 
								originFileName.substring(originFileName.lastIndexOf(".") + 1);
		
		String renamePath = folder + "/" + renameFileName;
		try {
			file.transferTo(new File(renamePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return renameFileName;
	}
	
	@RequestMapping("bdetail.bo")
	public String boardDetailView(@RequestParam("page") int page, @RequestParam("bId") int bId, Model model) {
		
		Board board = bService.selectBoard(bId);
		
		if(board != null) {
			model.addAttribute("board", board);
			model.addAttribute("page", page);
			// page를 보내는 이유 : 상세페이지에서 목록으로 돌아갈 때 해당 게시글이 있는 목록으로 돌아가기 위함.
			return "boardDetailView";
		} else {
			throw new BoardException("게시글 상세 조회에 실패하였습니다.");
		}
	}
	
	@RequestMapping("bupView.bo")
	public String boardUpdateView(@RequestParam("bId") int bId, @RequestParam("page") int page, Model model) {
		
		Board b = bService.selectBoard(bId);
		
		model.addAttribute("board", b).addAttribute("page", page);
		
		return "boardUpdateForm";
	}
	
	@RequestMapping("bupdate.bo")
	public String updateBoard(@ModelAttribute Board b, @RequestParam("page") int page,
							  @RequestParam("reloadFile") MultipartFile reloadFile,
							  HttpServletRequest request, Model model) {
		
		if(reloadFile != null && !reloadFile.isEmpty()) { // 수정할 파일 존재
			// 수정할 파일 존재 + 기존 파일 존재 = 기존 파일 삭제
			if(b.getRenameFileName() != null) {
				deleteFile(b.getRenameFileName(), request);
			}
			
			String renameFileName = saveFile(reloadFile, request);
			
			if(renameFileName != null) {
				b.setOriginalFileName(reloadFile.getOriginalFilename());
				b.setRenameFileName(renameFileName);
			}
		}
		
		int result = bService.updateBoard(b);
		
		if(result > 0) {
			model.addAttribute("page", page);
		} else {
			throw new BoardException("게시글 수정에 실패하였습니다.");
		}
		
		return "redirect:bdetail.bo?bId=" + b.getBoardId();	
	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/buploadFiles";
		
		File f = new File(savePath + "/" + fileName);
		
		if(f.exists()) {
			f.delete();
		}
	}
	
	@RequestMapping("bdelete.bo")
	public String deleteBoard(@RequestParam("bId") int bId, HttpServletRequest request) {
		
		Board b = bService.selectBoard(bId);
		if(b.getOriginalFileName() != null) {
			deleteFile(b.getRenameFileName(), request);
		}
		
		int result = bService.deleteBoard(bId);
		
		if(result > 0) {
			return "redirect:blist.bo";
		} else {
			throw new BoardException("게시글 삭제에 실패하였습니다.");
		}
	}
	
	// 반환형은 String, 반환하는 값은 success가 되도록 만들 것
	
	@RequestMapping("addReply.bo")
	@ResponseBody
	public String addReply(@ModelAttribute Reply r, HttpServletRequest request) {
		String rWriter = ((Member)request.getSession().getAttribute("loginUser")).getId();
		r.setReplyWriter(rWriter);
		
		int result = bService.insertReply(r);
		
		if(result > 0) {
			return "success";
		} else {
			throw new BoardException("댓글 등록에 실패하였습니다.");
		}
	}
	
}
