package com.example.demo.dto;

import java.sql.Date;	// 주의

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="mvc_board_tbl")
public class BoardDTO {

	@Id
	@SequenceGenerator(schema="springboot_ict04", name="BOARD_NUM_SEQ", sequenceName="BOARD_NUM_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="BOARD_NUM_SEQ")
	@Column(name="b_num")
	private int b_num;				// 글번호
	private String b_title;			// 글제목
	private String b_content;		// 글내용
	private String b_writer;		// 작성자
	private String b_password;		// 수정, 삭제용 비밀번호
	private int b_read_cnt;			// 조회수	
	private Date b_reg_date;			// 작성일
	private int b_comment_count;	// 댓글갯수
	
	public BoardDTO() {
		super();
	}

	public BoardDTO(int b_num, String b_title, String b_content, String b_writer, String b_password, int b_readCnt,
			Date b_regDate, int b_comment_count) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_password = b_password;
		this.b_read_cnt = b_read_cnt;
		this.b_reg_date = b_reg_date;
		this.b_comment_count = b_comment_count;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_writer() {
		return b_writer;
	}

	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	public String getB_password() {
		return b_password;
	}

	public void setB_password(String b_password) {
		this.b_password = b_password;
	}

	public int getB_read_cnt() {
		return b_read_cnt;
	}

	public void setB_read_cnt(int b_read_cnt) {
		this.b_read_cnt = b_read_cnt;
	}

	public Date getB_reg_date() {
		return b_reg_date;
	}

	public void setB_reg_date(Date b_reg_date) {
		this.b_reg_date = b_reg_date;
	}

	public int getB_comment_count() {
		return b_comment_count;
	}

	public void setB_comment_count(int b_comment_count) {
		this.b_comment_count = b_comment_count;
	}

	@Override
	public String toString() {
		return "BoardDTO [b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content + ", b_writer="
				+ b_writer + ", b_password=" + b_password + ", b_read_cnt=" + b_read_cnt + ", b_reg_date=" + b_reg_date
				+ ", b_comment_count=" + b_comment_count + "]";
	}
	
	
}

//CREATE TABLE mvc_board_tbl(  
//	    b_num         NUMBER(7)  PRIMARY KEY,		-- 글번호
//		b_title       VARCHAR2(50)  NOT NULL,		-- 글제목
//		b_content     CLOB  NOT NULL,		        -- 글내용
//		b_writer      VARCHAR2(30)  NOT NULL,	    -- 작성자
//		b_password    VARCHAR2(30)  NOT NULL,       -- 수정, 삭제용 비밀번호
//		b_readCnt     NUMBER(6)   DEFAULT 0,		-- 조회수
//		b_regDate     DATE  DEFAULT sysdate,	    -- 작성일
//		b_comment_count  NUMBER(6)   DEFAULT 0	    --  댓글갯수
//	);

//-- 시퀀스 생성(리액트 + 부트에서 게시글 insert 시 게시글번호 자동 증가)
//CREATE SEQUENCE BOARD_NUM_SEQ
//START WITH 1 NOCACHE ORDER;
