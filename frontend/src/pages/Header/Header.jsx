import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <div className="header-container">
      <Link to="/">
        <h2>Avalehele</h2>
      </Link>
    </div>
  );
}
