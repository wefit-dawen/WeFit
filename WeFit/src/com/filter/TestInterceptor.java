package com.filter;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component   //������ע��
public class TestInterceptor implements HandlerInterceptor{
	//�߲���,һ��ʵ��
//	private long time=0L;//����������ԣ�
//	ר��дһ�������� ������� session���Ƿ��� �û����ڣ����û�С�
//	ֱ�� return false ͬʱ��Ҫ���ض��� login.jsp(login.html)
	
	/**
	 * 1. session���(a.��¼��ʱ����session��ֵ b.�������м��)
	 * 2. Ȩ�޼��(a.�ڵ�¼��ʱ�򣬶�ȡ�û�Ȩ������map����������洢�� session��
	 * 			 b.ÿ�η���.do�������ʱ����������飬�û��Ƿ��з��������Դ��Ȩ��
	 * )
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("�� login֮ǰִ��");
		long time=System.currentTimeMillis();//�õ���ǰʱ��
		request.setAttribute("time", time);//���� request����
////		��������
//		Calendar c=Calendar.getInstance();
//		c.set(Calendar.HOUR_OF_DAY, 10);// 11:00:00
//		c.set(Calendar.MINUTE,0);
//		c.set(Calendar.SECOND,0);
//		long timeA=c.getTimeInMillis();//������
//		if(time > timeA){
//			return false;
//		}
		return true;//TRUE ���� 
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("��login֮��ִ��");
		long time1=System.currentTimeMillis();
		long time=(Long)request.getAttribute("time");
		System.out.println(time1-time);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("����ͼʱ��ִ��");
	}
	
}
