package com.bean.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.db.DB;
import com.bean.service.UserService;
import com.bean.vo.UserBean;

import net.sf.json.JSON;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/")
public class testDiscoverys {
	
	@ResponseBody
	@RequestMapping(value={"doTest1","discovery"},produces="application/json;charset=UTF-8")
//	请将用户登录后的信息，放入到 session中
	public String doTest1(int pageIndex) throws Exception {
		JSONObject params=new JSONObject();
		JSONObject jsonObject=new JSONObject();
		List<JSON> discoverys=new ArrayList<>();
		jsonObject.put("pageIndex", pageIndex);
		jsonObject.put("name", "逝言");
		jsonObject.put("context", "一起在华师篮球场打篮球吧！");
		jsonObject.put("like", 3);
		jsonObject.put("comment", 2);
		jsonObject.put("time", "2019-3-13 15:00");
		jsonObject.put("image", "/image/headpic1.jpg");
		discoverys.add(jsonObject);
		discoverys.add(jsonObject);
		discoverys.add(jsonObject);
		discoverys.add(jsonObject);
		params.put("discoverys", discoverys);
		return params.toString();
	}
	
	/**
	 * 处理 小范围的 异常问题，类中的异常
	 * 原理：当发生异常的时候，会先调用局部的 异常处理 @ExceptionHandler
	 *     如果 局部的异常无法处理,会调用 @ControllerAdvice
	 * 
	 * @param excption
	 * @return
	 */
//	我们会在每个类中 写一个异常处理方法。(也可以写个父类)
	@ExceptionHandler(RuntimeException.class)
	public String doException(RuntimeException excption){
		System.out.println("有异常");
		System.out.println(excption.getMessage());
		return "err";
	}
}





