import React from "react";
import styled from "styled-components";
import { deleteDeptByDeptno } from "../../api/deptApi/deleteDeptRequest";

const Container = styled.div`
  max-width: 1000px;
  margin-right: auto;
  margin-left: auto;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const Table = styled.div`
  width: 100%;
  border: 1px solid $color-form-highlight;
`;

const TableHeader = styled.div`
  display: flex;
  width: 100%;
  background: #000;
`;

const TableHedaerItem = styled.div`
  flex: 1 1 20%;
  text-align: center;
`;

const TalbeRow = styled.div`
  display: flex;
  width: 100%;
`;

const TableData = TableHedaerItem;

const FilterLink = styled.div`
  color: white;
  width: 100%;
  padding: ($half-spacing-unit * 1.5) 0;

  &:nth-of-type(odd) {
    background: $color-form-highlight;
  }
`;

const DeptList = ({ data, check, setCheck }) => {
  console.log(data);
  return (
    <Container>
      <Table>
        <TableHeader>
          <TableHedaerItem>
            <FilterLink>deptno</FilterLink>
          </TableHedaerItem>
          <TableHedaerItem>
            <FilterLink>dname</FilterLink>
          </TableHedaerItem>
          <TableHedaerItem>
            <FilterLink>loc</FilterLink>
          </TableHedaerItem>
          <TableHedaerItem>
            <FilterLink>option</FilterLink>
          </TableHedaerItem>
        </TableHeader>

        <TableHedaerItem>
          {data.map((data, index) => (
            <TalbeRow
              key={index}
              style={
                index % 2 === 1
                  ? { backgroundColor: "#F2F2F2" }
                  : { backgroundColor: "white" }
              }
            >
              <TableData>{data.deptno}</TableData>
              <TableData>{data.dname}</TableData>
              <TableData>{data.loc}</TableData>
              <TableData>
                <button
                  onClick={async () => {
                    await deleteDeptByDeptno(data.deptno);
                    setCheck(!check);
                  }}
                >
                  delete
                </button>
              </TableData>
            </TalbeRow>
          ))}
        </TableHedaerItem>
      </Table>
    </Container>
  );
};

export default DeptList;
