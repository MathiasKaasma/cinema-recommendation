import React from "react";

export default function Movie({ movie, index }) {
  return (
    <div className="movie" key={index}>
      <div className="primary-data">
        <h2>{movie.title}</h2>
        <h3>Zanr: {movie.genre}</h3>
        <p>{movie.description}</p>
        <h3>Hinnang: {movie.rating.toFixed(2)}</h3>
      </div>
      <div className="secondary-data">
        <h2>{movie.language}</h2>
        <h3>Vanusepiirang: {movie.ageRating}</h3>
        <h3>Algusaeg: {new Date(movie.startTime).toLocaleString("et-EE")}</h3>
      </div>
    </div>
  );
}
