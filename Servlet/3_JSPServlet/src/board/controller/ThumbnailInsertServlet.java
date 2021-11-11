package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class ThumbnailInsertServlet
 */
@WebServlet("/insert.th")
public class ThumbnailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
		
//		System.out.println(title);
//		System.out.println(content);
		
		// cos.jar
		// enctype이 multipart/form-data로 전송되었는지 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10; // 10Mbyte정도
			String root = request.getSession().getServletContext().getRealPath("/"); // 웹 서버 컨테이너 경로 추출 : WebContent
			String savePath = root + "thumbnail_uploadFiles/";
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			// DefaultFileRenamePolicy(cos.jar 안에 존재)
			// : 같은 파일명이 있는지 검사하고, 있을 경우 파일명 뒤에 숫자를 붙임
			// ex. aaa.jpg, aaa1.jpg, aaa2.jpg
			// 원래는 규약 안 만들어줘도 됨 위의 Policy가 원래 cos.jar 안에 이미 존재하기 때문에
			// 하지만 파일 안정성을 위해 규약 만듦
			
			System.out.println(savePath);
			
			// cos.jar
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			// 일단 매개변수 request로 받아옴
			// saveDirectory : 저장할 공간
			// maxPostSize : 최대 크기
			// encoding : 인코딩 타입
			// policy : 파일 규약
			
			ArrayList<String> saveFiles = new ArrayList<String>();		// 파일의 바뀐 이름을 저장할 ArrayList
			ArrayList<String> originFiles = new ArrayList<String>(); 	// 파일의 원래 이름을 저장할 ArrayList
			
			Enumeration<String> files = multiRequest.getFileNames(); // Iterator와 같은 동작을 하는 enumeration이 반환값
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				// Img 4,3,2,1 뜸. 이미지 세 개를 업로드 해도 넣는 칸은 네 곳이기 때문
				// 전송순서의 역순으로 가져온다
				if(multiRequest.getFilesystemName(name) != null) { // null이면 사진이 들어가있지 않다는 뜻
					saveFiles.add(multiRequest.getFilesystemName(name)); // 바뀐 이름 가져오기
					originFiles.add(multiRequest.getOriginalFileName(name)); // 원래 이름 가져오기
				}
			}
			
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String writer = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			
			Board b = new Board(0, 2, "10", title, content, writer, null, 0, null, null, null);
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			for(int i = originFiles.size() -1; i >= 0; i--) {
			// 역순이라 originFile.size -1로 시작해야 함
				Attachment a = new Attachment();
				a.setFilePath(savePath);
				a.setOriginName(originFiles.get(i));
				a.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size() - 1) { // 맨 마지막 사진(제일  처음 업로드하는 사진)이라면
					a.setFileLevel(0); // 썸네일
				} else {
					a.setFileLevel(1); // 다른 건 썸네일 아님
				}
				
				fileList.add(a);
			}
			
			int result = new BoardService().insertThumbnail(b, fileList);
			
			if(result >= 1+fileList.size()) { // board랑 file리스트의 결과를 가져오기 때문에 0보다 큰 것으로 조건 걸기 애매함
				response.sendRedirect("list.th");
			} else {
				request.setAttribute("msg", "사진 게시판 등록 실패");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
				
				for(int i = 0; i < saveFiles.size(); i++) {
					File fail = new File(savePath + saveFiles.get(i)); // 삭제할 파일의 경로, 이름 찾기
					fail.delete(); // 찾아서 등록 실패한 파일 삭제
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
