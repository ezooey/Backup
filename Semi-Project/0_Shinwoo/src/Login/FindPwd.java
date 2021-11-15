package Login;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class FindPwd
 */
@WebServlet("/findPwd.lo")
public class FindPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwd() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static String getRamdomPassword(int len) { 
    	char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
    								  'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
    								  'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
    								  'U', 'V', 'W', 'X', 'Y', 'Z' }; 
    	int idx = 0; 
    	StringBuffer sb = new StringBuffer(); 
    	for (int i = 0; i < len; i++) { 
    		idx = (int)(charSet.length * Math.random()); 
    	sb.append(charSet[idx]); 
    	} 
    	return sb.toString();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		
		String email = new MemberService().findPwd(memberId);
		
			request.setAttribute("email", email);
			response.sendRedirect("login.lo");
			
			if(email != null) {
				request.getRequestDispatcher("WEB-INF/views/login/login.jsp").forward(request, response);
				String receiver = request.getParameter("email"); // 받는 사람
//				String receiver = "testmail3@naver.com"; // 테스트
				String title = "[ShinwooUniversity] 임시 비밀번호 발급 안내";
				String content = "임시 비밀번호는 " + getRamdomPassword(10) + " 입니다.<br>임시 비밀번호로 로그인하여 비밀번호 변경 뒤 서비스 이용 가능합니다.";
				String host = "smtp.naver.com";
				String sender = "testmail3";
				String senderPwd = "dkssudgktpdy";
				
				Properties prop = new Properties();
				prop.put("mail.smtp.host", host);
				prop.put("mail.smtp.auth", "true");
				
				Session session = Session.getDefaultInstance(prop, new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(sender, senderPwd);
					}
				});
				
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(sender));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
					message.setSubject(title);
					message.setText(content, "UTF-8", "html");
					
					Transport.send(message);
					
					response.getWriter().println("success");
				} catch (AddressException e) {
					e.printStackTrace();
					response.getWriter().println("fail");
				} catch (MessagingException e) {
					e.printStackTrace();
					response.getWriter().println("fail");
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
