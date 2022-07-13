import axios from "axios";

export const deleteBoardByBoardNo = async (boardNo) => {
  await axios.delete(`/api/board/${boardNo}`);
};
