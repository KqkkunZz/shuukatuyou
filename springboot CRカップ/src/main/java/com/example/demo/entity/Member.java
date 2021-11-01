package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//@Entityアノテーション・・・エンティティクラスであることを示す
@Entity
//@Dataアノテーション・・・クラス内のフィールド変数に対して、getter/setterでアクセスすることができる
@Data
//@Tableアノテーション・・・データベース内のテーブルを指定
@Table(name = "MEMBER_LIST")

// Serializable:データを保存するときにエラーが起こらないようにする
public class Member implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private String id;

	@Column(name="COUNTRY_OF_ORIGIN")
	private String country;

	@Column(name="TEAMNAME")
	private String teamname;

	@Column(name="LEADER")
	private String leader;

	@Column(name="MEMBER_A")
	private String memberA;

	@Column(name="MEMBER_B")
	private String memberB;

	@Column(name="COACH_A")
	private String coachA;

	@Column(name="COACH_B")
	private String coachB;

	@Column(name="COACH_C")
	private String coachC;
}
