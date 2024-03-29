import React from "react";
import { Link } from "react-router-dom";

export default function Movie({ movie, index }) {
  return (
    <Link to={`broneering/${movie.id}`}>
      <div className="movie" key={index}>
        <div className="primary-data">
          <h2>{movie.title}</h2>
          <h3>Zanr: {movie.genre}</h3>
          <p>{movie.description}</p>
          <h3>
            Hinnang:{" "}
            {(Math.round(movie.rating * 1000) / 1000).toFixed(3).slice(0, -1)}
          </h3>
        </div>
        <div className="secondary-data">
          <h2>{movie.language}</h2>
          <h3>Vanusepiirang: {movie.ageRating}</h3>
          <h3>Algusaeg: {new Date(movie.startTime).toLocaleString("et-EE")}</h3>
        </div>
      </div>
    </Link>
  );
}
