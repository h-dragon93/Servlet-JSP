package com.edu.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	public MyListener() {
		System.out.println("MyListener Object Created!");
	}
	
    //ServletContext 객체 생성(서버 시작)시 호출
	public void contextDestroyed(ServletContextEvent arg0) {
		// web app 초기화
		System.out.println("ServletContext Object Created!");
	}

    //ServletContext 객체 삭제(서버 중지)시 호출
	public void contextInitialized(ServletContextEvent arg0) { 
		// TODO Auto-generated method stub
		
	}

}
