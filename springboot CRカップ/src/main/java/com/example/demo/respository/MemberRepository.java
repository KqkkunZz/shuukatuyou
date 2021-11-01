package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Member;
import com.exemple.demo.custom.MemberRepositoryCustom;

// customインターフェースを継承することでMemberRepositoryServiceで
// 設定したメソッドをJPARepositoryとして使えるようにする
// Specificationは何らかの検索条件を表すインターフェース
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor<Member>, 
MemberRepositoryCustom{
	
}
