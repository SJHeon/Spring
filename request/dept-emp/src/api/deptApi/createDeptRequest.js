import axios from "axios";

function createDeptRequest() {
  const insertDept = () => {
    const deptno = document.getElementById("deptno");
    const dname = document.getElementById("dname");
    const loc = document.getElementById("loc");

    axios
      .postMessage(
        "/dept",
        {
          deptno: deptno.value,
          dname: dname.value,
          loc: loc.value,
        },
        { headers: { "Content-Type": `application/json` } }
      )
      .then((res) => console.log(res));
  };
}
