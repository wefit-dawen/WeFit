package com.bean.excption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllException {
	
	@ExceptionHandler(Exception.class)
	public String doException(Exception exception){
		System.out.println("全局的");
		exception.printStackTrace();
		return "err";
	}
}//下午要完成 完整的； 是我出题目。你们解决。。。。
