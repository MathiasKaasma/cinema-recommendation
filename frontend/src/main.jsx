import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home/Home";
import Booking from "./pages/Booking/Booking";
import Header from "./pages/Header/Header";
import "./index.css";
import Confirmation from "./pages/Confirmation/Confirmation";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <Router>
      <Header />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/broneering/:movieId" element={<Booking />} />
        <Route path="/kinnitus/:movieId" element={<Confirmation />} />
      </Routes>
    </Router>
  </React.StrictMode>
);
