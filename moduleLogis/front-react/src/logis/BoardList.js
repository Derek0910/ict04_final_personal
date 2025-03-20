import React, { useState, useEffect } from 'react';
import { Container } from 'react-bootstrap';
import { Link  } from 'react-router-dom';
import BoardItem from '../components/BoardItem';

const BoardList = () => {

    const[boardList, setBoardList] = useState([]); // 초기값을 모르므로 빈배열로 boardList에 대입

    // fetch()를 통해 서버에게 데이터를 요청
    useEffect(() =>{ // 통신 시작 하겠다.
        fetch("http://localhost:8081/api/boardList", { // 스프링부트에 요청한다.
            method: "GET" // "GET" 방식으로
        }).then(
            res => res.json() // 응답이 오면 javascript object로 바꾸겠다.
        ).then( 
            res => {
                // console.log(1, res); // setBoardList를 통해서 뿌려준다.
                setBoardList(res);
            }
        )
    }, []);
    // []은 디펜던시인데, setState()로 렌더링 될 때마다 싱행되면 안되고, 한 번만 실행하도록 빕배여ㅕ르ㅏㅏ

    return (
        <div>
            <Container>
                <h2>BoardList</h2>
                <br/>
                <form>
                    {boardList.map(board => 
                        <BoardItem key={board.b_num} board={board} />
                    )}
                    <div>
                        <Link to="/saveForm" className='nav-link'>게시판 등록</Link>
                    </div>
                </form>
            </Container>
        </div>
    )
}

export default BoardList;