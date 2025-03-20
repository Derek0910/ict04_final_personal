package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.BoardDTO;
import com.example.demo.repo.BoardRepository;

@Service
public class BoardServiceImpl {

	@Autowired
	private BoardRepository repository;
	
	// 게시글 목록	
	@Transactional(readOnly=true)
	public List<BoardDTO> boardList(){
		System.out.println("BoardServiceImpl - boardList");
		return repository.findAll();
	}
	
	// 게시글 등록
	@Transactional  // 서비스 함수가 종료될 때 commit할지 rollback할지 트랜잭션 관리하겠다.
	public BoardDTO saveBoard(BoardDTO dto){
		System.out.println("BoardServiceImpl - saveBoard");
		return repository.save(dto);
	}
	
	// 게시글 상세
	@Transactional(readOnly = true)
	public BoardDTO findById(int b_num) {
		return repository.findById(b_num)
				.orElseThrow(() -> new IllegalArgumentException("게시글 번호를 확인해 주세요.!!"));
	}
	
	// 게시글 등록
	@Transactional  // 서비스 함수가 종료될 때 commit할지 rollback할지 트랜잭션 관리하겠다.
	public String deleteBoard(int b_num){
		System.out.println("BoardServiceImpl - saveBoard");
		repository.deleteById(b_num);
		return "삭제완료";
	}
	
	// 게시글 수정
	@Transactional  // 
	public BoardDTO updateBoard(int b_num, BoardDTO dto){ // BoardDTO return : 상세페이지로 리턴하기 위해 
		System.out.println("BoardServiceImpl - updateBoard");
		BoardDTO board = repository.findById(b_num)
				.orElseThrow(() -> new IllegalArgumentException("게시글 번호를 확인해 주세요.!!"));
		board.setB_title(dto.getB_title());
		board.setB_content(dto.getB_content());
		board.setB_writer(dto.getB_writer());
		board.setB_password(dto.getB_password());
		
		return board;
	}
}
