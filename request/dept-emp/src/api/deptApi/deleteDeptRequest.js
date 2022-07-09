import axios from "axios";

export const deleteDeptByDeptno = async (deptno) => {
  await axios.delete("api/dept/" + deptno);
};
