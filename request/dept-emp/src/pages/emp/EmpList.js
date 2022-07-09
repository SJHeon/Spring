import React from "react";

const EmpList = ({ data }) => {
  console.log(data);
  return (
    <>
      {data.map((data) => (
        <li key={data.empno}>
          {data.empno} - {data.ename}
        </li>
      ))}
    </>
  );
};

export default EmpList;
