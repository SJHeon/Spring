import { Outlet } from "react-router-dom";
import styled from "styled-components";
import "./App.css";
import Footer from "./component/Footer";
import Header from "./component/Header";
function App() {
  return (
    <div className="App">
      <Header />
      <div>
        <Outlet />
      </div>
      <Footer />
    </div>
  );
}

export default App;
