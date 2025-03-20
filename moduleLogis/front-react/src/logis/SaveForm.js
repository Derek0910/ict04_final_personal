import React, { useState } from 'react';
import { Button, Form } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
// import { Navigate } from 'react-router-dom'; // 에러임, useNavigate를 대신 사용

const SaveForm = () => {

    const navigate = useNavigate();

    // 입력한 값들을 submit하려면 값을 상태로 보관한다.
    // 입력한 값들을 set해서 board 변수(BoardDTO)에 대입한 후, submit할 때 board 값을 한꺼번에 전송한다.
    const[board, setBoard] = useState({
        b_title:'',
        b_content:'',
        b_writer:'',
        b_password:'',
    });

    const changeValue = (e) => {
        setBoard({
            ...board,   // 최종 입력 한 input에 입력한 값이 지워지지 않게 해준다.
            // 이 문구가 없으면 가장 마지막 Form.Control(input) 값만 저장 됨
            // 예) ...board 생략 시 content 작성 시 title의 내용이 사라지고, writer 작성 시 content 내용이 사라짐
            [e.target.name] : e.target.value // 동적으로 키값 만들기(compute properties)
        })
    }

    const submitBoard = (e) => {
        e.preventDefault();
        fetch("http://localhost:8081/api/board", {
            method: "POST", // insert는 POST로 전달
            headers: {
               "Content-Type": "application/json;charset-utf-8", // 데이터를 json으로 받겠다. 
            },
            body: JSON.stringify(board)
         }).then(res => {
            console.log(1, res);
            if (res.status === 201)
               return res.json();
            else return null;
         }).then(res => {
            console.log('정상', res);
            if (res !== null)
               navigate('/boardList');
            else alert('게시글 작성에 실패하였습니다.');
         }).catch(error => {
            console.log('실패', error);
         });
    }

    return (
      <Form onSubmit={submitBoard}> {/* submit 버튼 클릭 시 submitBoard 함수 호출, onClick으로 해도 된다.*/}
        <Form.Group className="mb-3" controlId="b_title">
          <Form.Label>글제목</Form.Label>
          <Form.Control type="text" placeholder="Enter title" onChange={changeValue}  name="b_title"/>
        </Form.Group>
  
        <Form.Group className="mb-3" controlId="b_content">
          <Form.Label>글내용</Form.Label>
          <Form.Control type="text" placeholder="Enter content" onChange={changeValue} name="b_content"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="b_writer">
          <Form.Label>아이디</Form.Label>
          <Form.Control type="text" placeholder="Enter id" onChange={changeValue} name="b_writer"/>
        </Form.Group>

        <Form.Group className="mb-3" controlId="b_password">
          <Form.Label>비밀번호</Form.Label>
          <Form.Control type="password" placeholder="Enter password" onChange={changeValue} name="b_password"/>
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    )
}

export default SaveForm;