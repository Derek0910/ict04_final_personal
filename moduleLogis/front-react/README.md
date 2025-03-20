
### 스프링 부트
- JPA
- Oracle / Mybatis
- MAVEN
- Lombok


### React

# 플젝생성
- npx create-react-app 플젝명

# install
- 1) npm i react-bootstrap bootstrap

- 2) npm i react-router-dom

- [App.js]
- import { BrouserRouter } from 'react-router-dom';
- <Route path="/boardList" element={<BoardList />} /> {/*리스트*/}

- [Header.js]
- import { Link } from 'react-router-dom';
- <Link to="/boardList" className='nav-link'>게시판</Link>



- 3) npm i redux react-redux

 DROP TABLE mvc_board_tbl  CASCADE CONSTRAINTS;
 CREATE TABLE mvc_board_tbl(  
    b_num         NUMBER(7)  PRIMARY KEY,		-- 글번호
	b_title       VARCHAR2(50)  NOT NULL,		-- 글제-목
	b_content     CLOB  NOT NULL,		        -- 글내용
	b_writer      VARCHAR2(30)  NOT NULL,	    -- 작성자
	b_password    VARCHAR2(30)  NOT NULL,     -- 수정, 삭제용 비밀번호
	b_read_cnt     NUMBER(6)   DEFAULT 0,		-- 조회수
	b_reg_date     DATE  DEFAULT sysdate,	    -- 작성일
	b_comment_count  NUMBER(6)   DEFAULT 0	--  댓글갯수
);

 ALTER TABLE mvc_board_tbl
   ADD b_show CHAR(1) DEFAULT 'Y';
   
 SELECT * FROM mvc_board_tbl;
-- CLOB : 대용량 텍스트 자료형
-- BLOB : 대용량 텍스트 자료형  
   
-- 게시글 입력(다건)
DECLARE -- 선언문
    i   NUMBER:= 1; -- 변수 i에 1을 대입
BEGIN
    WHILE i<=9 LOOP
        INSERT INTO mvc_board_tbl(b_num, b_title, b_content, b_writer, b_password, b_read_cnt, b_reg_date, b_comment_count)
         VALUES(i, '글제목'||i, '글내용'||i, '작성자'||i, '1234', 0, sysdate, 0);
         i := i+1;
    END LOOP;
END;
/
COMMIT;   
SELECT * FROM mvc_board_tbl 
ORDER BY b_num DESC;


-- 5건으로 테스트
DELETE FROM mvc_board_tbl
WHERE b_num > 5;
COMMIT;

CORS policy ==>

@CrossOrigin // 추가
Controller에

- 5) 게시글 목록
- [BoardList.js] + [BoardItem/js]


- 6) 게시글 작성
- [SaveForm.js] + [SaveForm.js]

- 7) 상세보기
- [Detail.js]

- 8) 삭제
- [DeleteForm.js]

- 9) 수정
- [UpdateForm.js]

1. API 연동의 기본

<!-- axios를 사용해서 GET(SELECT), PUT(EDIT), POST(INSERT), DELETE(DELETE) 등의 메서드로 API 요청을 할 수 있다.

REST API 를 사용 할 때에는 하고 싶은 작업에 따라 다른 메서드로 요청을 할 수 있는데 메서드들은 다음 의미를 가지고 있습니다.

GET: 데이터 조회
POST: 데이터 등록
PUT: 데이터 수정
DELETE: 데이터 제거

@RestController
@RequestMapping(value="/samples")
public class SampleController {

// select
@GetMapping

// insert
@PostMapping

// update
@PutMapping

// Delete
@DeleteMapping
} -->