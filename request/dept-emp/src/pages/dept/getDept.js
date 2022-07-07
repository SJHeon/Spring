import React, { useState, useEffect } from "react";
import axios from "axios";

function DeptInfo() {
  const [data, setData] = useState([]);
  const [check, setcheck] = useState(false);

  useEffect(() => {
    getAllDepts();
  }, [check]);

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
      .then(() => setcheck(!check));
  };

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

  const deleteDeptByDeptno = async (deptno) => {
    await axios.delete("api/dept/" + deptno);
  };

  return (
    <div>
      {console.log(data)}
      <h2>REQUEST DEPT INFO</h2>
      <h3>RESULT SECTION</h3>
      <table border={1}>
        <thead>
          <tr>
            <th>deptno</th>
            <th>dname</th>
            <th>loc</th>
            <th>
              <button onClick={() => updateDeptByDeptno}>UPDATE</button>
            </th>
          </tr>
        </thead>
        <tbody>
          {data.map((dept) => {
            return (
              <tr key={dept.deptno}>
                <th>{dept.deptno}</th>
                <th>{dept.dname}</th>
                <th>{dept.loc}</th>
                <th>
                  <button
                    onClick={async () => {
                      await deleteDeptByDeptno(dept.deptno);
                      setcheck(!check);
                    }}
                  >
                    DELETE
                  </button>
                </th>
              </tr>
            );
          })}
        </tbody>
      </table>
      <hr />
      <h3>INSERT DEPT</h3>
      <input id="deptno_insert" type="text" placeholder="deptno" />
      <input id="dname_insert" type="text" placeholder="dname" />
      <input id="loc_insert" type="text" placeholder="loc" />
      <input type="button" value="CREATE" onClick={insertDept} />
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
      <hr />
    </div>
  );
}

export default DeptInfo;
