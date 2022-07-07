import { NavLink } from "react-router-dom";

function Header() {
  function activeStyle({ isActive }) {
    return {
      textDecoration: isActive ? "underline" : undefined,
      fontSize: isActive ? "24px" : undefined,
    };
  }
  return (
    <div>
      <NavLink to="/" style={activeStyle}>
        Home
      </NavLink>
      <NavLink to="/dept" style={activeStyle}>
        Dept
      </NavLink>
      <NavLink to="/emp" style={activeStyle}>
        emp
      </NavLink>
    </div>
  );
}
export default Header;
