package com.mvcproject.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvcproject.member.controller.model.dao.MemberDao;
import com.mvcproject.member.controller.model.service.MemberService;
import com.mvcproject.member.controller.model.vo.Member;

@Controller
public class MemberController {

	@Autowired // 있으면 넣어줘 (DI),  new 어쩌구 해서 안만들어줘도 된다는 소리
	MemberService memberService;
	
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public ModelAndView memberListService(ModelAndView modelAndView) throws Exception{
		
		List<Member> memberList = memberService.selectMemberAll();
		
		/*
		// memberList.size() list 데이터 건수를 리턴 jsp ${} jstl
		for(int i=0; i<memberList.size() ; i++) { // memberList 데이터 갯수 만큼 반복
			//System.out.println(i);
			Member member = memberList.get(i);
			System.out.println(member.getName());
		}
		*/
		
		modelAndView.addObject("memberList",memberList);
		modelAndView.setViewName("member/memberList");
		
		return modelAndView;
	}

	
	@RequestMapping(value="memberView.do", method=RequestMethod.GET)
	public String memberViewService(@RequestParam("id") String id, Model model, HttpServletRequest request) throws Exception{
		Member member = memberService.selectMember(id);
		model.addAttribute("member", member);
		return "member/memberView";
	}
	

	@RequestMapping(value="memberDel.do", method=RequestMethod.GET) // @GetMapping("memberDel.do"), @PostMapping 이랑 같은 의미
	public ModelAndView deleteMember(Member member, ModelAndView modelAndView) throws Exception {
		int cnt = memberService.deleteMember(member);
		
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberDelComplete");
		return modelAndView;
	}
	
	@RequestMapping(value="memberForm.do", method=RequestMethod.GET)
	public ModelAndView memberForm(ModelAndView modelAndView) throws Exception{
		
		modelAndView.setViewName("member/memberForm");
		return modelAndView;
	}
	
	@RequestMapping(value="memberInsert.do", method=RequestMethod.GET)
	public ModelAndView insertMember(Member member, ModelAndView modelAndView) throws Exception{
		int cnt = memberService.insertMember(member);
		
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberInsertComplete");
		return modelAndView;
	}
	
	@RequestMapping(value="memberUpdate.do", method=RequestMethod.GET)
	public ModelAndView updateMember(Member member, ModelAndView modelAndView) throws Exception{
		int cnt = memberService.updateMember(member);
		
		
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberUpdateComplete");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="memberData.do", method=RequestMethod.GET)
	@ResponseBody
	public String memberAjax(String userid) throws Exception{
		Member member = memberService.selectMember(userid);
		
		JSONObject jsonData = new JSONObject();
		
		if(member == null) {
			jsonData.put("idDup", "");
		}else {
			jsonData.put("idDup", "dup");
		}
		return jsonData.toJSONString();
	}
	
}