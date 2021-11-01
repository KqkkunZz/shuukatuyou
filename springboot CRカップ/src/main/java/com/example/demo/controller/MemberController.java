package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;

	@RequestMapping(value = "/crcup", method = RequestMethod.GET)
	public ModelAndView displayList(ModelAndView mav) {
		// 検索画面を表示
		mav.setViewName("crcup");
		return mav;
	}

	@RequestMapping(value = "/crcup/all", method = RequestMethod.GET)
	@ResponseBody
	public String searchAll() {
		// 全メンバーを検索する
		return memberService.searchAll();
	}
	
	@RequestMapping(value = "/crcup/register", params="register", method = RequestMethod.GET)
	public ModelAndView registerView(ModelAndView mav) {
		// 登録画面を表示
		mav.setViewName("register");
		return mav;
	}

	@RequestMapping(value = "/crcup/search", method=RequestMethod.POST)
	@ResponseBody
	public String search(@RequestParam(name = "searchId", defaultValue = "" )String id,
			@RequestParam(name = "teamName", defaultValue = "")String team,
			@RequestParam(name = "country", defaultValue = "")String country) {
		// 入力フォームで入力された文字列をmemberServiceのselectメソッドに引数として渡す
		return memberService.select(id, team, country);
	}

	@RequestMapping(value = "/crcup/register/data", method = RequestMethod.POST)
	@ResponseBody
    public String create(@ModelAttribute Member member, 
    		@RequestParam(name = "country")String country,
    		@RequestParam(name = "team")String team,
    		@RequestParam(name = "leader")String leader,
    		@RequestParam(name = "memberA")String member1,
    		@RequestParam(name = "memberB")String member2,
    		@RequestParam(name = "coachA")String coachA,
    		@RequestParam(name = "coachB")String coachB,
    		@RequestParam(name = "coachC")String coachC) {
		// 入力フォームで入力された文字列をmemberServiceのcreateMemberメソッドに引数として渡す
		return memberService.createMember(country, team, leader, member1, member2, coachA, coachB, coachC);
    }

}