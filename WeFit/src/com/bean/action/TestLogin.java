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
////	�뽫�û���¼�����Ϣ�����뵽 session��
//	public String doTest1(UserBean vo) {
////		System.out.println(vo);
//////		for(int i=0;i<100;i++){
//////			System.out.println("doTest1");
//////		}
////		boolean bl=true;
////		if(bl){//����ʱ�쳣
//////		throw new RuntimeException("�Զ�����쳣");
//////		throw new Exception("�Զ�����쳣");
////		}
////		return "ok";
//	}
	
	@ResponseBody
	@RequestMapping(value={"doTest1","login"},produces="application/json;charset=UTF-8")
//	�뽫�û���¼�����Ϣ�����뵽 session��
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
			System.out.println("�������ݳɹ�");
		return params.toString();
	}
	
	@ResponseBody
	@RequestMapping(value={"doTest2","chazhao"},produces="application/json;charset=UTF-8")
//	�뽫�û���¼�����Ϣ�����뵽 session��
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
////	�뽫�û���¼�����Ϣ�����뵽 session��
//	public String doTest2(String name,String password) {
//		UserBean userBean=new UserBean();
//		userBean.setName(name);
//		userBean.setPassword(password);
//		userServlic.insert(userBean);
//		return userBean.toString();
//	}
	
	
	
	/**
	 * ���� С��Χ�� �쳣���⣬���е��쳣
	 * ԭ���������쳣��ʱ�򣬻��ȵ��þֲ��� �쳣���� @ExceptionHandler
	 *     ��� �ֲ����쳣�޷�����,����� @ControllerAdvice
	 * 
	 * @param excption
	 * @return
	 */
//	���ǻ���ÿ������ дһ���쳣��������(Ҳ����д������)
	@ExceptionHandler(RuntimeException.class)
	public String doException(RuntimeException excption){
		System.out.println("���쳣");
		System.out.println(excption.getMessage());
		return "err";
	}
	//...........
	//...........

	public void setUserServlic(UserService userServlic) {
		this.userServlic = userServlic;
	}
	
}





