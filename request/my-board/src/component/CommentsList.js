import { useState } from "react";
import axios from "axios";

function CommentsList({ comData }) {
  const [inputCheck, setInputCheck] = useState(false);
  console.log(comData);
  const updateCommentByCommentNo = () => {
    const commentNo = comData.commentNo;
    axios.put(`/api/comment/${commentNo}`).then((res) => console.log(res));
  };

  const deleteCommentByCommentNo = () => {
    const commentNo = comData.commentNo;
    axios.delete(`/api/comment/${comData.commentNo}`);
  };

  return (
    <div>
      <div>
        {inputCheck ? (
          <div>
            <input id="commeter" defaultValue={comData.commenter || ""} />
            <br />
            <input
              id="commet_content"
              defaultValue={comData.commentContent || ""}
            />
          </div>
        ) : (
          <div>
            <div>{comData.commenter}</div>
            {comData.commentContent}
            <div></div>
          </div>
        )}
        <button onClick={() => setInputCheck(!inputCheck)}>수정</button>
        <a href={`/BoardInfo/${comData.board.boardNo}`}>
          <button onClick={() => deleteCommentByCommentNo()}>삭제</button>
        </a>
      </div>
    </div>
  );
}

export default CommentsList;
