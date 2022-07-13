import CommentsList from "../component/CommentsList";

function BoardCommentsPage({ comData }) {
  return (
    <div>
      {comData.map((comData, index) => {
        return <CommentsList key={index} comData={comData} />;
      })}
    </div>
  );
}

export default BoardCommentsPage;
