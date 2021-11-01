package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.respository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MemberService{

	@Autowired
	MemberRepository memberRepository;
	public String searchAll() {
		// SELECT * FROM MEMBER_LISTを実行
		List<Member> memberList = memberRepository.findAll();
		return getJson(memberList);
	}
	
	// ObjectMapperを使ってajaxに適した形にする
	private String getJson(List<Member> memberList) {
		String values = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			values = objectMapper.writeValueAsString(memberList);
		} catch(Exception e) {
			e.getStackTrace();
		}
		return values;
	}
	
	public String select(String id, String team, String country) {
		List<Member> memberList = null;
		// idにのみ入力されたとき
		if(!id.equals("") && id != null){
			// 入力された値と一致したデータをmemberListに代入
			memberList = memberRepository.findByIdIs(id);
		} 
		// teamにのみ入力されたとき
		else if(!team.equals("") && team != null){
			// 入力された文字と同じ文字が入っているチームをすべてmemberListに代入
			memberList = memberRepository.findByTeamnameContaining(team);
		}
		// プルダウンリストで出身国が選択されたとき
		else if(!country.equals("リーダーの出身国") && country != null) {
			// プルダウンリストで選択された国に対応したデータをすべてmemberListに代入
			memberList = memberRepository.findByCountryIs(country);
		} 
		
		// 入力値に適したデータがないとき
		if(memberList == null || memberList.size() == 0) {
			return null;
		}
		// memberListをJson型にして返す
		return getJson(memberList);
		
	}
	
	
	public String createMember(String country, String team, String leader, String memberA, String memberB,
			String coachA, String coachB, String coachC) {
		List<Member> memberList = null;
		if(!country.equals("リーダーの出身国") && country != null && !team.equals("") && team != null &&
				!leader.equals("") && leader != null && !memberA.equals("") && memberA != null &&
				!memberB.equals("") && memberB != null && !coachA.equals("") && coachA != null &&
				!coachB.equals("") && coachB != null && !coachC.equals("") && coachC != null){
		Member member = new Member();
		
		// formで入力された値をそれぞれの列に追加
		member.setCountry(country);
		member.setTeamname(team);
		member.setLeader(leader);
		member.setMemberA(memberA);
		member.setMemberB(memberB);
		member.setCoachA(coachA);
		member.setCoachB(coachB);
		member.setCoachC(coachC);

		// 追加された値をDBに上書き保存
		memberRepository.save(member);
		
		// SELECT * FROM MEMBER_LISTを実行
		memberList = memberRepository.findAll();
		} else {
			return null;
		}
		// memberListをJson型にして返す
		return getJson(memberList);
	}
}
