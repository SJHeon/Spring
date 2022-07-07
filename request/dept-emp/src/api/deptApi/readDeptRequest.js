import React, { useState } from "react";
import axios from "axios";

function readDeptRequest() {
  const getAllDepts = async () => {
    await axios.get("/depts").then((res) => {
      console.log(res);
    });
  };
  return getAllDepts;
}

export default readDeptRequest;
