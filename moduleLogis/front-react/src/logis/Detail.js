import React /*{ useEffect, useState }*/ from 'react';
import { /* Button,*/ Card, CardBody, CardSubtitle /*, CardText, CardTitle */} from 'react-bootstrap';
// import { useNavigate } from 'react-router-dom';

const Detail = (props) => {
    // const navigator = useNavigate();
    
    // const propsParam = useParams();
    // const b_num = propsParam.b_num;

    // const [ board, setBoardDetail ] = useState({
    //     b_num:'',
    //     b_title:'',
    //     b_content:'',
    //     b_writer:'',
    //     b_password:'',

    // });

    // useEffect(()=>{
    //     fetch('http://localhost:8081/api/board/' + b_num)
    //     .then(res => res.json())
    //     .then(res => {
    //         setBoardDetail(res)
    //     })
    //     .catch(err => console.error('Error fetching board:', err));
    // },[]);

    // // 수정
    // const updateBoard = () =>{
    //     navigator(`/updateForm/${b_num}`); // App.js의 Router에서 UpdateForm 호출출
    // }

    // // 삭제
    // const deleteBoard = () =>{
    //     fetch('http://localhost:8081/api/board/' + b_num , {
    //         method: "DELETE",
    //     })
    //     .then((res) => res.text())
    //     .then((res) =>{
    //         if(res === "삭제완료"){
    //             navigator('/boardList'); // 게시글 목록으로 이동
    //         } else{
    //             alert('삭제 실패') // catch로 변경해도 된다.
    //         }
    //     })
    // }

    return (
        <div>
            <Card>
                <CardBody>
                    {/* <CardTitle>Detail - {board.b_num}</CardTitle> */}
                    <CardSubtitle>
                        <div className='board_secondline'>
                            {/* <div>글제목 : {board.b_title} </div>
                            <div>작성자 : {board.b_writer}</div> */}
                            욥
                        </div>
                    </CardSubtitle>
                    {/* <CardText>{board.b_content}</CardText>
                    <CardText>{board.b_password}</CardText> */}
                    <div>
                        욥
                        {/* <Button variant="warning" onClick={updateBoard}>수정</Button>
                        <Button variant="warning" onClick={deleteBoard}>삭제</Button> */}
                    </div>
                </CardBody>
            </Card>
        </div>
    )
}

export default Detail;