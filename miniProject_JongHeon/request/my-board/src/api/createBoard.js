import axios from "axios";

export const insertBoard = async () => {
  const boardTitle = document.getElementById("board_title");
  const boardContent = document.getElementById("board_content");
  const userEmail = document.getElementById("user_email");
  await axios.post(
    "/api/board",
    {
      user: { userEmail: userEmail.value },
      boardTitle: boardTitle.value,
      boardContent: boardContent.value,
    },
    { headers: { "Content-Type": `application/json` } }
  );
};
