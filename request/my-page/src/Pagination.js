import React from "react";
import styled from "styled-components";

const PaginationUl = styled.ul`
  list-style: none;
  display: flex;
  justify-content: center;
  padding: 10px;
`;
const PaginationLi = styled.li`
  padding: 5px;
  font-size: 32px;
  border-radius: 5px;
  &:hover {
    cursor: pointer;
    color: green;
    background-color: orange;
  }
`;

const Pagination = ({ postsPerPage, totalPosts, setCurrentPage }) => {
  const pageNumbers = [];
  for (let i = 1; i <= Math.ceil(totalPosts / postsPerPage); i++) {
    pageNumbers.push(i);
  }

  return (
    <div>
      <div>
        <PaginationUl>
          {pageNumbers.map((number) => (
            <PaginationLi key={number}>
              <span onClick={() => setCurrentPage(number)}>{number}</span>
            </PaginationLi>
          ))}
        </PaginationUl>
      </div>
    </div>
  );
};

export default Pagination;
