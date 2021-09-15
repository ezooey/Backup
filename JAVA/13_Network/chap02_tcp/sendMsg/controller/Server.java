package com.kh.example.chap02_tcp.sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
//	TCP(Transmission Control Protocol)
//		서버와 클라이언트 간의 1:1 소켓 통신(연결 지향적 프로토콜)
//		데이터 전송 전 먼저 서버와 클라이언트가 연결되어 있어야 함
//			==> 서버와 클라이언트를 따로 구현하고 서버가 먼저 실행되어 클라이언트의 요청을 기다림
//	
//	ServerSocket
//		포트와 연결되어 외부의 요청을 기다리다 요청이 들어오면 수락 후 Socket을 생성해 소켓과 소켓 간의 통신이 이루어지게 함
//		한 포트에 한 ServerSocket만 연결 가능
//	Socket
//		프로세스 간 통신 담당
//		InputStream/OutputStream 보유 : 이 스트림으로 프로세스 간의 통신이 이루어짐
	
	public void serverStart() {
		// 서버용 TCP 소켓 프로그래밍 순서
		// 1. 서버 포트번호 정하기
		// 2. 서버용 소켓 객체 생성 후 포트와 결합
		// 3. 클라이언트 쪽에서 요청이 오길 기다림
		// 4. 요청이 오면 수락 후 해당 클라이언트에 대한 소켓 객체 생성
		// 5. 연결된 클라이언트와 입출력 스트림 생성
		// 6. 보조스트림을 통해 성능 개선
		// 7. 스트림을 통해 읽고 쓰기
		// 8. 통신 종료
		
		// 1. 서버 포트번호 정하기 : 0~65535 (1023 이하는 이미 사용중인 포트가 많아 그 이상의 숫자 권장, 보통 5천번대 이상)
		int port = 8500;
		
		// 2. 서버용 소켓 객체(ServerSocket) 생성 후 포트와 결합
		try {
			ServerSocket server = new ServerSocket(port); // port를 집어넣음으로써 결합된 것
			
		// 3. 클라이언트 쪽에서 요청이 오길 기다림
			System.out.println("클라이언트의 요청을 기다리고 있습니다...");
			
		// 4. 요청이 오면 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			Socket client = server.accept(); 
		// 새 객체를 만드는 게 아니라 수락해서 반환해주는 게 소켓 객체를 생성하는 것
			
			String clientIP = client.getInetAddress().getHostAddress(); // IP주소도 받아옴
			System.out.println(clientIP + "가 연결을 요청함...");
			
		// 5. 연결된 클라이언트와 입출력 스트림 생성
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
		// 6. 보조스트림을 통해 성능 개선
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(out);
			
		// 7. 스트림을 통해 읽고 쓰기
			// 클라이언트 -> 서버로 전송한 메세지 읽기
			String message = br.readLine();
			System.out.println(clientIP + "가 보낸 메세지 : " + message);
			// 서버 -> 클라이언트로 메세지 전송
			pw.println("만나서 반갑습니다.");
			pw.flush();

		// 8. 통신 종료
			pw.close();
			br.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
