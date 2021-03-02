package com.mvc.exam;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class); // logger log 출력

	@RequestMapping(value="/message.do", method = RequestMethod.GET)
	
	public ModelAndView message(ModelAndView modelAndView) {

		
		logger.debug("message 실행");
		
		modelAndView.setViewName("message"); 
		
		modelAndView.addObject("data1", "홍길동"); 
		modelAndView.addObject("data2", "10");	
		modelAndView.addObject("today", new java.util.Date());
		return modelAndView;
	}
}
