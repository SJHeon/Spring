import "./css/BoardListPage.css";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import readBoard from "../api/readBoard";
import { Pagination } from "../component/Pagination";

function BoardListPage() {
  const [data, setData] = useState([]);
  const [check, setCheck] = useState(false);
  const [pageNo, setPageNo] = useState(1);

  useEffect(() => {
    readBoard(setData, pageNo);
  }, [check, pageNo]);

  console.log(pageNo);
  console.log(data);
  return (
    <div>
      <h2 className="title">
        <span>게시판 </span>
        <Link to="/BoardRegistration">
          <span>등록</span>
        </Link>
      </h2>
      <div className="tableBox">
        <table>
          <thead>
            <tr>
              <th>#</th>
              <th>제목</th>
              <th>작성자</th>
              <th>등록일</th>
            </tr>
          </thead>
          <tbody>
            {data.dtoList &&
              data.dtoList.map((data, index) => {
                return (
                  <tr key={index}>
                    <td>{data.boardNo}</td>
                    <td>
                      <Link
                        to={`/BoardInfo/${data.boardNo}`}
                        state={{
                          boardNo: data.boardNo,
                        }}
                      >
                        {data.boardTitle}
                      </Link>
                    </td>
                    <td>
                      {data.user.userEmail.substring(
                        0,
                        data.user.userEmail.indexOf("@")
                      )}
                    </td>
                    <td>
                      {data.registeredDate &&
                        data.registeredDate.substring(
                          0,
                          data.registeredDate.indexOf("T")
                        )}
                    </td>
                  </tr>
                );
              })}
          </tbody>
        </table>
        <Pagination data={data} setPageNo={setPageNo} />
      </div>
    </div>
  );
}

export default BoardListPage;
