package com.bean.excption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllException {
	
	@ExceptionHandler(Exception.class)
	public String doException(Exception exception){
		System.out.println("ȫ�ֵ�");
		exception.printStackTrace();
		return "err";
	}
}//����Ҫ��� �����ģ� ���ҳ���Ŀ�����ǽ����������
