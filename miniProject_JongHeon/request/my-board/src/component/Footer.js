import React from "react";
import styled from "styled-components";

const Footers = styled.div`
  display: flex;
  color: white;
  background-color: #af01c3;
  position: fixed;

  bottom: 0;
  width: 100%;
`;

function Footer() {
  return (
    <Footers>
      <h2>heon's board</h2>
    </Footers>
  );
}

export default Footer;
