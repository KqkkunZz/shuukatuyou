package com.exemple.demo.custom;

import java.util.List;

import com.example.demo.entity.Member;

// 使いたいSQL文を作成するためのインターフェース
// findBy○○（H2で作成した列名）で指定した列名の中から検索する
public interface MemberRepositoryCustom {
	// 完全一致で検索
	List<Member> findByIdIs(String id);
	// 部分一致で検索
	List<Member> findByTeamnameContaining(String teamname);
	// 完全一致で検索
	List<Member> findByCountryIs(String country);
}
