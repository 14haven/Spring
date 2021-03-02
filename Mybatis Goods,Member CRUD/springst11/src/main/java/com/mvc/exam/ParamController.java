package com.mvc.exam;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {

	@RequestMapping(value="/param1.do", method = RequestMethod.GET)
	public ModelAndView param1(@RequestParam(value = "name", required = false , defaultValue="empty") String name,
			@RequestParam( value = "age", defaultValue = "0") int age, ModelAndView modelAndView) throws Exception {
		
		System.out.println("name : "+name+" age : "+age);
		modelAndView.setViewName("param1link");
		return modelAndView;
	}
	
	@RequestMapping(value="/param2.do", method = RequestMethod.GET)
	public ModelAndView param2(Goods goods, ModelAndView modelAndView) throws Exception{
		
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		System.out.println("code : "+goods.getCode());
		System.out.println("name : "+goods.getName());
		System.out.println("price : "+goods.getPrice());
		System.out.println("color : "+goods.getColor());
		System.out.println("date : "+goods.getNow_date());
		
		modelAndView.setViewName("form01");
		return modelAndView;
	}
}
