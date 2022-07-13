import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import BoardListPage from "./pages/BoardListPage";
import BoardRegistrationPage from "./pages/BoardRegistrationPage";
import BoardInfoPage from "./pages/BoardInfoPage";
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route index element={<BoardListPage />}></Route>
        <Route path="/BoardRegistration" element={<BoardRegistrationPage />} />
        <Route path="/BoardInfo/:boardTitle" element={<BoardInfoPage />} />
      </Route>
    </Routes>
  </BrowserRouter>
);

reportWebVitals();
