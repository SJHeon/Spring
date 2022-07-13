import React from "react";
import { insertBoard } from "../api/createBoard";
import "./css/BoardRegistrationPage.css";

function BoardRegistrationPage() {
  return (
    <div className="Registration">
      <div className="container">
        <h2>게시판 등록</h2>
        <div>제목</div>
        <input id="board_title" type="text"></input>
        <div>내용</div>
        <input id="board_content" type="text"></input>
        <div>작성자</div>
        <input id="user_email" type="text"></input>
        <br />
        <a
          className="regist"
          href="/"
          onClick={async () => {
            await insertBoard();
          }}
        >
          등록
        </a>
      </div>
    </div>
  );
}

export default BoardRegistrationPage;
