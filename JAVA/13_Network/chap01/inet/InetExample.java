package com.kh.example.chap01.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetExample {
	public static void main(String[] args) {
		try {
			InetAddress localIP = InetAddress.getLocalHost(); //static 메소드 
			// 지역 호스트(네트워크에 연결돼있는 컴퓨터)의 Host명과 IP주소 반환
			System.out.println("localIP : " + localIP);
			System.out.println("내 PC 명 : " + localIP.getHostName()); // 호스트 이름 반환
			System.out.println("내 IP : " + localIP.getHostAddress()); // 호스트 IP주소 반환
			// 내 IP : 121.160.183.63
			
			byte[] ipAddress = localIP.getAddress(); // IP주소를 byte배열로 반환
			for(byte b:ipAddress) {
				System.out.print(b + " ");
				// 121 -96 -73 63 (오버플로우)
				// => 128을 초과하면 거꾸로 되돌아가서 초과된 만큼 -128까지도 가기 때문에 음수가 나올 수 있음
			}	
				System.out.println();
				System.out.println();
				
				InetAddress iei = InetAddress.getByName("www.iei.or.kr"); // 도메인을 통해 IP주소를 얻음
				System.out.println("iei 서버명 : " + iei.getHostName());
				System.out.println("iei 서버 IP : " + iei.getHostAddress());
			
				System.out.println();
				
				InetAddress[] google = InetAddress.getAllByName("www.google.com");
				System.out.println("구글 IP 개수 : " + google.length);
				for(InetAddress ip : google) {
					System.out.println(ip.getHostAddress());
				}
				
				System.out.println();
				
				InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
				System.out.println("네이버 IP 개수 : " + naver.length);
				for(InetAddress ip : naver) {
					System.out.println(ip);
				}
					
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
