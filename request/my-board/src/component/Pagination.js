import "./css/Pagination.css";

export const Pagination = ({ data, setPageNo }) => {
  return (
    <div className="pagination">
      {data.pageList &&
        data.pageList.map((page, index) => {
          return (
            <span key={index}>
              <button className="button" onClick={() => setPageNo(page)}>
                {page}
              </button>
            </span>
          );
        })}
    </div>
  );
};
