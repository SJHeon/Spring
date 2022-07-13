import axios from "axios";
import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import { deleteBoardByBoardNo } from "../api/deleteBoard";
import BoardCommentsPage from "./BoardCommentsPage";
import "./css/BoardInfoPage.css";

function BoardInfoPage() {
  const [data, setData] = useState([]);
  const [comData, setComData] = useState([]);
  const [inputCheck, setInputCheck] = useState(false);
  const [comCheck, setComCheck] = useState(false);
  const [check, setCheck] = useState(false);

  const location = useLocation();
  const boardNo = location.state.boardNo;

  useEffect(() => {
    findBoardByBoardNo();
    getAllCommentsByBoardNo();
  }, [inputCheck, comCheck, check]);

  const findBoardByBoardNo = () => {
    axios
      .get(`/api/board/${boardNo}`)
      .then((res) => res.data)
      .then((data) => {
        setData(data);
      });
  };

  const updateBoardByBoardNo = async (setInputCheck, inputCheck) => {
    const boardNo = data.boardNo;
    const boardTitle = document.getElementById("title");
    const boardContent = document.getElementById("content");
    await axios
      .put(
        `/api/board/${boardNo}`,
        { boardTitle: boardTitle.value, boardContent: boardContent.value },
        { headers: { "Content-Type": `application/json` } }
      )
      .then(() => setInputCheck(!inputCheck));
  };

  const getAllCommentsByBoardNo = () => {
    axios
      .get(`/api/comment/${boardNo}`)
      .then((res) => res.data)
      .then((data) => {
        setComData(data);
      });
  };

  const insertCommentByCommentNo = () => {
    const commenter = document.getElementById("commeter");
    const commentContent = document.getElementById("comment_content");
    axios
      .post(
        `/api/comment`,
        {
          board: { boardNo: boardNo },
          commenter: commenter.value,
          commentContent: commentContent.value,
        },
        { headers: { "Content-Type": `application/json` } }
      )
      .then(setCheck(!check));
  };

  return (
    <div className="container">
      <div className="infoBox">
        <h2>게시판 보기</h2>
        <br />
        <h4>제목</h4>
        {inputCheck ? (
          <input className="input" id="title" defaultValue={data.boardTitle} />
        ) : (
          <div className="output">{data.boardTitle}</div>
        )}

        <h4>내용</h4>
        {inputCheck ? (
          <input
            className="input"
            id="content"
            defaultValue={data.boardContent}
          />
        ) : (
          <div className="output">{data.boardContent}</div>
        )}

        <h4>작성자</h4>

        <div className="output">{data.user && data.user.userName}</div>

        <h4>등록일</h4>
        <div className="output">{data.registeredDate}</div>
        <h4>수정일</h4>
        <div className="output">{data.modifiedDate}</div>

        <br />
        <div>
          <a href="/">
            <button className="button">리스트로</button>
          </a>
          {inputCheck ? (
            <span>
              <span>
                <button
                  className="button"
                  onClick={() => {
                    updateBoardByBoardNo(setInputCheck, inputCheck);
                  }}
                >
                  그랭!
                </button>
              </span>
              <button
                className="button"
                onClick={() => setInputCheck(!inputCheck)}
              >
                아닝!
              </button>
            </span>
          ) : (
            <button
              className="button"
              onClick={() => setInputCheck(!inputCheck)}
            >
              수정할래?
            </button>
          )}
          <a href="/">
            <button
              className="button"
              onClick={async () => {
                await deleteBoardByBoardNo(data.boardNo);
              }}
            >
              삭제하기
            </button>
          </a>
        </div>
        <div>
          <button className="button" onClick={getAllCommentsByBoardNo}>
            댓글
          </button>
          <button className="button" onClick={() => setComCheck(!comCheck)}>
            댓글작성
          </button>
        </div>
        {comCheck ? (
          <div>
            <div>
              <span>댓글 작성자 : </span>
              <input className="input" id="commeter"></input>
            </div>
            <div>
              <span>댓글 내 용 : </span>
              <input className="input" id="comment_content"></input>
              <button className="button" onClick={insertCommentByCommentNo}>
                작성
              </button>
            </div>
          </div>
        ) : (
          <></>
        )}
        <BoardCommentsPage comData={comData} boardNo={boardNo} />
      </div>
    </div>
  );
}

export default BoardInfoPage;
