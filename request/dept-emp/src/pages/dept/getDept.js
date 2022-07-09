import React, { useState, useEffect } from "react";
import axios from "axios";
import Pagination from "../Pagination";
import DeptList from "./DeptList";
import { insertDept } from "../../api/deptApi/createDeptRequest";

function DeptInfo() {
  const [data, setData] = useState([]);
  const [check, setCheck] = useState(false);
  const [currentPage, setCurrentPage] = useState(1);
  const [dataPerPage, setDataPerPage] = useState(5);

  useEffect(() => {
    getAllDepts();
  }, [check]);

  // const insertDept = () => {
  //   const deptno = document.getElementById("deptno_insert");
  //   const dname = document.getElementById("dname_insert");
  //   const loc = document.getElementById("loc_insert");
  //   axios
  //     .post(
  //       "/api/dept",
  //       { deptno: deptno.value, dname: dname.value, loc: loc.value },
  //       { headers: { "Content-Type": `application/json` } }
  //     )
  //     .then(() => setCheck(!check));
  // };

  const getAllDepts = async () => {
    await axios.get("/api/depts").then((res) => {
      console.log(res.data);
      setData(res.data);
    });
  };

  const selectDeptByDeptno = () => {
    const deptno = document.getElementById("deptno_select");
    axios.get("/api/dept/" + deptno.value).then((res) => {
      setData([res.data]);
    });
  };

  const updateDeptByDeptno = () => {
    const deptno = document.getElementById("deptno_update");
    const dname = document.getElementById("dname_update");
    const loc = document.getElementById("loc_update");
    axios.put(
      "api/dept/" + deptno.value,
      { deptno: deptno.value, dname: dname.value, loc: loc.value },
      { headers: { "Content-Type": `application/json` } }
    );
  };

  const lastPage = currentPage * dataPerPage;
  const firstPage = lastPage - dataPerPage;
  const currentData = (posts) => {
    console.log("1111");
    console.log(posts);
    let currentData = 0;
    currentData = posts.slice(firstPage, lastPage);
    return currentData;
  };

  return (
    <div>
      {console.log(data)}
      <h2>REQUEST DEPT INFO</h2>
      <hr />
      <h3>INSERT DEPT</h3>
      <input id="deptno_insert" type="text" placeholder="deptno" />
      <input id="dname_insert" type="text" placeholder="dname" />
      <input id="loc_insert" type="text" placeholder="loc" />
      <input
        type="button"
        value="CREATE"
        onClick={async () => {
          await insertDept();
          setCheck(!check);
          console.log(check);
        }}
      />
      <hr />
      <h3>RESULT SECTION</h3>
      <DeptList data={currentData(data)} check={check} setCheck={setCheck} />
      <Pagination
        dataPerPage={dataPerPage}
        totalData={data.length}
        setCurrentPage={setCurrentPage}
      />
      <hr />
      <h3>SELECT DEPT</h3>
      <input id="deptno_select" type="text" placeholder="deptno"></input>
      <button onClick={selectDeptByDeptno}>READ</button>
      <hr />
      <h3>UPDATE DEPT</h3>
      <input id="deptno_update" type="text" placeholder="deptno"></input>
      <input id="dname_update" type="text" placeholder="dname" />
      <input id="loc_update" type="text" placeholder="loc" />
      <button onClick={updateDeptByDeptno}>UPDATE</button>
    </div>
  );
}

export default DeptInfo;
