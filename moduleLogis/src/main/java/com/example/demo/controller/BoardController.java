package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BoardController {
	
	@Autowired
	private BoardServiceImpl service;
	
	// 게시글 목록 GetMapping = > http://localhost:8081/api/boardList
	@GetMapping("/boardList") // 조회는 GetMapping
	public ResponseEntity<List<BoardDTO>> findAll() {
		System.out.println("<<< boardList >>>");
		return new ResponseEntity<>(service.boardList(), HttpStatus.OK);
	}
	
	// 게시글 등록 PostMapping => http://localhost:8081/api/board
	@PostMapping("/board")
	public ResponseEntity<BoardDTO> save(@RequestBody BoardDTO board){
		System.out.println("<<< save >>>");
		
		return new ResponseEntity<>(service.saveBoard(board), HttpStatus.CREATED); // 201을 리턴해라
	}
	
	// 게시글 상세 GetMapping = > http://localhost:8081/api/board/{num}
	@GetMapping("/board/{b_num}") // 조회는 GetMapping
	public ResponseEntity<BoardDTO> findById(@PathVariable int b_num) {
		System.out.println("<<< /board/{b_num} - findById >>>");
		return new ResponseEntity<>(service.findById(b_num), HttpStatus.OK); // 200을 리턴해라
	}
	
	// 게시글 삭제
	@DeleteMapping("/board/{b_num}")
	public ResponseEntity<String> deleteBoard(@PathVariable int b_num){ //@PathVariable => 매개변수 가져올 때 사용
		System.out.println("<<< @DeleteMapping - findById >>>");
		
		return new ResponseEntity<String>(service.deleteBoard(b_num), HttpStatus.OK); // 200
	}
	
	// 게시글 수정 PostMapping => http://localhost:8081/api/updateForm/{b_num}
	@PutMapping("/updateForm/{b_num}")
	public ResponseEntity<BoardDTO> updateBoard(@PathVariable int b_num, @RequestBody BoardDTO board){
		System.out.println("<<< updateBoard >>>");
		
		return new ResponseEntity<>(service.updateBoard(b_num, board), HttpStatus.OK); // 200
	}
}
	
