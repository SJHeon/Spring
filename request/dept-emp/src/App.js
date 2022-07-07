import "./App.css";
import { Routes, Route, NavLink, Outlet } from "react-router-dom";
import Header from "./component/Header";
import Footer from "./component/Footer";

function App() {
  function activeStyle({ isActive }) {
    return {
      textDecoration: isActive ? "underline" : undefined,
      fontSize: isActive ? "24px" : undefined,
    };
  }
  return (
    <div className="App">
      <Header />
      <hr />
      <div>
        <Outlet></Outlet>
      </div>
      <hr />
      <Footer />
    </div>
  );
}

export default App;
