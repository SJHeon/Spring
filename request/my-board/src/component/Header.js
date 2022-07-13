import React from "react";
import styled from "styled-components";
const Headers = styled.div`
  display: flex;
  // position: fixed;
  color: white;
  background-color: #af01c3;
  width: 100%;
`;

function Header() {
  return (
    <Headers>
      <h1>HEON'S BOARD</h1>
    </Headers>
  );
}

export default Header;
