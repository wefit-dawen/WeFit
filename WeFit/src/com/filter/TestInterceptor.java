package com.filter;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component   //过滤器注解
public class TestInterceptor implements HandlerInterceptor{
	//高并发,一个实例
//	private long time=0L;//这个方法可以；
//	专门写一个过滤器 用来检查 session中是否有 用户存在，如果没有。
//	直接 return false 同时，要求重定向到 login.jsp(login.html)
	
	/**
	 * 1. session检查(a.登录的时候，向session放值 b.过滤器中检查)
	 * 2. 权限检查(a.在登录的时候，读取用户权限生成map或其他对象存储到 session中
	 * 			 b.每次发送.do的请求的时候，拦截器检查，用户是否有访问这个资源的权限
	 * )
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("在 login之前执行");
		long time=System.currentTimeMillis();//得到当前时间
		request.setAttribute("time", time);//放在 request里面
////		日历对象
//		Calendar c=Calendar.getInstance();
//		c.set(Calendar.HOUR_OF_DAY, 10);// 11:00:00
//		c.set(Calendar.MINUTE,0);
//		c.set(Calendar.SECOND,0);
//		long timeA=c.getTimeInMillis();//毫秒数
//		if(time > timeA){
//			return false;
//		}
		return true;//TRUE 不拦 
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("在login之后执行");
		long time1=System.currentTimeMillis();
		long time=(Long)request.getAttribute("time");
		System.out.println(time1-time);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("在视图时候执行");
	}
	
}
