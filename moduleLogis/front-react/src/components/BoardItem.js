import React from 'react';
import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const BoardItem = (props) => {

    const{ b_num, b_title, b_writer, b_read_cnt, b_reg_date} = props.board || {};

    console.log("b_num", b_num);

    return (
        <div>
            <Card>
                <Card.Body>
                    <Card.Title>글번호 : {b_num}</Card.Title>
                    <Card.Title>등록일 : {b_reg_date}</Card.Title>
                    <Card.Title>읽은수 : {b_read_cnt}</Card.Title>
                    <Card.Subtitle>
                        <div className='second_line'>
                            <div>
                                제목 : {b_title}
                            </div>
                            <div>
                                작성자 : {b_writer}
                            </div>
                        </div>
                        
                    </Card.Subtitle>
                    {/* <Card.Text>내용 : {b_content}</Card.Text> */}
                    <Link to={"/board/" + b_num} className="btn btn-primary">상세보기</Link>
                </Card.Body>

            </Card>
        </div>
    )
}

export default BoardItem;