import React, { useState } from "react";
import axios from "axios";

function DeptInfo() {
  const [data, setData] = useState([]);

  const insertDept = () => {
    const deptno = document.getElementById("deptno_insert");
    const dname = document.getElementById("dname_insert");
    const loc = document.getElementById("loc_insert");
    axios
      .post(
        "/api/dept",
        { deptno: deptno.value, dname: dname.value, loc: loc.value },
        { headers: { "Content-Type": `application/json` } }
      )
      .then((res) => console.log(res));
  };

  const getAllDepts = async () => {
    await axios.get("/api/dept").then((res) => {
      console.log(res.data);
      setData(res.data);
    });
  };

  const selectDeptByDeptno = () => {
    const deptno = document.getElementById("deptno_select");
    axios.get("/api/dept/" + deptno.value).then((res) => {
      console.log(res.data);
      // setData(res.data);
    });
  };

  const updateDeptByDeptno = () => {
    const deptno = document.getElementById("deptno_update");
    const dname = document.getElementById("dname_update");
    const loc = document.getElementById("loc_update");
    axios
      .put(
        "api/dept/" + deptno.value,
        { deptno: deptno.value, dname: dname.value, loc: loc.value },
        { headers: { "Content-Type": `application/json` } }
      )
      .then((res) => console.log(res.data));
  };

  const deleteDeptByDeptno = () => {
    const deptno = document.getElementById("deptno_delete");
    axios
      .delete("api/dept/" + deptno.value)
      .then((res) => console.log(res.data));
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
      <input type="button" value="click" onClick={insertDept} />
      <hr />
      <h3>SELECT DEPT</h3>
      <button onClick={getAllDepts}>AllDepts</button>
      <br />
      <input id="deptno_select" type="text" placeholder="deptno"></input>
      <button onClick={selectDeptByDeptno}>click</button>
      <hr />
      <h3>UPDATE DEPT</h3>
      <input id="deptno_update" type="text" placeholder="deptno"></input>
      <input id="dname_update" type="text" placeholder="dname" />
      <input id="loc_update" type="text" placeholder="loc" />
      <button onClick={updateDeptByDeptno}>UPDATE</button>
      <hr />
      <h3>DELETE DEPT</h3>
      <input id="deptno_delete" type="text" placeholder="deptno"></input>
      <button onClick={deleteDeptByDeptno}>DELETE</button>
      <hr />
      <div>
        {data.map((dept) => {
          return (
            <div key={dept.deptno}>
              <div>
                deptno : {dept.deptno} dname : {dept.dname} loc : {dept.loc}
              </div>
            </div>
          );
        })}
      </div>
      <div></div>
    </div>
  );
}

export default DeptInfo;
