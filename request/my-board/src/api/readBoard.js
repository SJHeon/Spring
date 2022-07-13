import axios from "axios";

function readBoard(setData, pageNo) {
  const getBoards = async (pageNo = 1) => {
    await axios
      .get(`/api/boards?page=${pageNo}`)
      .then((res) => res.data)
      .then((data) => {
        console.log(data.dtoList);
        setData(data);
      });
  };
  return getBoards(pageNo);
}

export default readBoard;
