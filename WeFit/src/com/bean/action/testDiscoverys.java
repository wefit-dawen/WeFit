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
//	�뽫�û���¼�����Ϣ�����뵽 session��
	public String doTest1(int pageIndex) throws Exception {
		JSONObject params=new JSONObject();
		JSONObject jsonObject=new JSONObject();
		List<JSON> discoverys=new ArrayList<>();
		jsonObject.put("pageIndex", pageIndex);
		jsonObject.put("name", "����");
		jsonObject.put("context", "һ���ڻ�ʦ���򳡴�����ɣ�");
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
}





