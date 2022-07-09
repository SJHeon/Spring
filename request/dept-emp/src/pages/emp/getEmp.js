import React, { useState, useEffect } from "react";
import axios from "axios";
import EmpList from "./EmpList";
import Pagination from "../Pagination";

function EmpInfo() {
  const [data, setData] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [dataPerPage, setDataPerPage] = useState(10);

  useEffect(() => {
    getAllEmps();
  }, []);

  const insertEmp = () => {
    const empno = document.getElementById("empno_insert");
    const ename = document.getElementById("ename_insert");
    const job = document.getElementById("job_insert");
    const mgr = document.getElementById("mgr_insert");
    const hireDate = document.getElementById("hireDate_insert");
    const sal = document.getElementById("sal_insert");
    const comm = document.getElementById("comm_insert");
    const deptno = document.getElementById("deptno_insert");

    axios.post(
      "/api/emp",
      {
        empno: empno.value,
        ename: ename.value,
        job: job.value,
        mgr: mgr.value,
        hireDate: hireDate.value,
        sal: sal.value,
        comm: comm.value,
        dept: { deptno: deptno.value },
      },
      { headers: { "Content-Type": `application/json` } }
    );
  };

  const getAllEmps = async () => {
    await axios.get("/api/emps").then((res) => {
      setData(res.data);
    });
  };

  const selectEmpByEmpno = () => {
    const empno = document.getElementById("empno_select");
    axios.get("/api/emp/" + empno.value).then((res) => {
      setData([res.data]);
    });
  };

  const updateEmpByEmpno = () => {
    const empno = document.getElementById("empno_update");
    const ename = document.getElementById("ename_update");
    const job = document.getElementById("job_update");
    const mgr = document.getElementById("mgr_update");
    const hireDate = document.getElementById("hireDate_update");
    const sal = document.getElementById("sal_update");
    const comm = document.getElementById("comm_update");
    const deptno = document.getElementById("deptno_update");
    axios.put(
      "api/emp/" + empno.value,
      {
        empno: empno.value,
        ename: ename.value,
        job: job.value,
        mgr: mgr.value,
        hireDate: hireDate.value,
        sal: sal.value,
        comm: comm.value,
        dept: { deptno: deptno.value },
      },
      { headers: { "Content-Type": `application/json` } }
    );
  };

  const deleteEmpByEmpno = () => {
    const empno = document.getElementById("empno_delete");
    axios.delete("api/emp/" + empno.value);
  };

  const lastPage = currentPage * dataPerPage;
  const firstPage = lastPage - dataPerPage;
  const currentData = (data) => {
    let currentData = 0;
    currentData = data.slice(firstPage, lastPage);
    return currentData;
  };

  return (
    <div>
      {console.log(data)}
      <h2>REQUEST EMP INFO</h2>
      <hr />
      <div>
        <h3>RESULT SECTION</h3>
        <EmpList data={currentData(data)} />
        <Pagination
          dataPerPage={dataPerPage}
          totalData={data.length}
          setCurrentPage={setCurrentPage}
        />
      </div>
      <h3>INSERT EMP</h3>
      <input id="empno_insert" type="text" placeholder="empno" />
      <input id="ename_insert" type="text" placeholder="ename" />
      <input id="job_insert" type="text" placeholder="job" />
      <input id="mgr_insert" type="text" placeholder="mgr" />
      <br />
      <input id="hireDate_insert" type="text" placeholder="hiredate" />
      <input id="sal_insert" type="text" placeholder="sal" />
      <input id="comm_insert" type="text" placeholder="comm" />
      <input id="deptno_insert" type="text" placeholder="deptno" />
      <br />
      <input type="button" value="CREATE" onClick={insertEmp} />
      <hr />
      <h3>SELECT EMP</h3>
      <button onClick={getAllEmps}>AllEmps</button>
      <br />
      <input id="empno_select" type="text" placeholder="empno"></input>
      <button onClick={selectEmpByEmpno}>READ</button>
      <hr />
      <h3>UPDATE EMP</h3>
      <input id="empno_update" type="text" placeholder="empno" />
      <input id="ename_update" type="text" placeholder="ename" />
      <input id="job_update" type="text" placeholder="job" />
      <input id="mgr_update" type="text" placeholder="mgr" />
      <br />
      <input id="hireDate_update" type="text" placeholder="hiredate" />
      <input id="sal_update" type="text" placeholder="sal" />
      <input id="comm_update" type="text" placeholder="comm" />
      <input id="deptno_update" type="text" placeholder="deptno" />
      <br />
      <button onClick={updateEmpByEmpno}>UPDATE</button>
      <hr />
      <h3>DELETE EMP</h3>
      <input id="empno_delete" type="text" placeholder="empno"></input>
      <button onClick={deleteEmpByEmpno}>DELETE</button>
    </div>
  );
}

export default EmpInfo;
