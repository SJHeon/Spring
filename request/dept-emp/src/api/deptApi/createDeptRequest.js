import axios from "axios";

export const insertDept = async () => {
  const deptno = document.getElementById("deptno_insert");
  const dname = document.getElementById("dname_insert");
  const loc = document.getElementById("loc_insert");
  await axios.post(
    "/api/dept",
    { deptno: deptno.value, dname: dname.value, loc: loc.value },
    { headers: { "Content-Type": `application/json` } }
  );
};
