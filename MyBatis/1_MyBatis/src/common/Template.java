package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		
		try {
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
			SqlSessionFactory ssf = ssfb.build(stream);
			session = ssf.openSession(false); // false를 넣으면 자동커밋 방지
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
