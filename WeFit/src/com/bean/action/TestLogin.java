package com.bean.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bean.db.DB;
import com.bean.service.UserService;
import com.bean.vo.UserBean;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/")
public class TestLogin {
	@Autowired
	private UserService userServlic;
	
//	@RequestMapping(value={"doTest1","login"},produces="application/json;charset=UTF-8")
////	请将用户登录后的信息，放入到 session中
//	public String doTest1(UserBean vo) {
////		System.out.println(vo);
//////		for(int i=0;i<100;i++){
//////			System.out.println("doTest1");
//////		}
////		boolean bl=true;
////		if(bl){//运行时异常
//////		throw new RuntimeException("自定义的异常");
//////		throw new Exception("自定义的异常");
////		}
////		return "ok";
//	}
	
	@ResponseBody
	@RequestMapping(value={"doTest1","login"},produces="application/json;charset=UTF-8")
//	请将用户登录后的信息，放入到 session中
	public String doTest1(String name,String password) throws Exception {
		ClassPathXmlApplicationContext cpa;
		String str="spring-configs.xml";
	    cpa=new ClassPathXmlApplicationContext(str);
	    DB db=cpa.getBean("db",DB.class);
	    userServlic.setDb(db);
		UserBean userBean=new UserBean();
		userBean.setName(name);
		userBean.setPassword(password);
		JSONObject params=new JSONObject();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("password", password);
		params.put("list", jsonObject);
		if(userServlic.insert(userBean))
			System.out.println("插入数据成功");
		return params.toString();
	}
	
	@ResponseBody
	@RequestMapping(value={"doTest2","chazhao"},produces="application/json;charset=UTF-8")
//	请将用户登录后的信息，放入到 session中
	public String doTest2() throws Exception {
		ClassPathXmlApplicationContext cpa;
		String str="spring-configs.xml";
	    cpa=new ClassPathXmlApplicationContext(str);
	    DB db=cpa.getBean("db",DB.class);
	    userServlic.setDb(db);
	    List<UserBean> list=userServlic.query();
	    String str1=JSON.toJSONString(list);
	    return str1;
	}
	
//	@ResponseBody
//	@RequestMapping(value={"doTest2","wxlogin"},produces="application/json;charset=UTF-8")
////	请将用户登录后的信息，放入到 session中
//	public String doTest2(String name,String password) {
//		UserBean userBean=new UserBean();
//		userBean.setName(name);
//		userBean.setPassword(password);
//		userServlic.insert(userBean);
//		return userBean.toString();
//	}
	
	
	
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
	//...........
	//...........

	public void setUserServlic(UserService userServlic) {
		this.userServlic = userServlic;
	}
	
}





