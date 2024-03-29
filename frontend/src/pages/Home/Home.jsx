import React, { useEffect, useState } from "react";
import Movie from "./components/Movie";

export default function Home() {
  const [movies, setMovies] = useState([]);

  async function fetchMovies() {
    try {
      console.log("API URL:", import.meta.env.VITE_API_URL);
      const response = await fetch(`${import.meta.env.VITE_API_URL}/movies`);
      if (!response.ok) throw new Error("Data could not be fetched");
      const data = await response.json();
      console.log(data);
      setMovies(data);
    } catch (error) {
      console.error("Fetching error: ", error);
    }
  }

  useEffect(() => {
    fetchMovies();
  }, []);

  return (
    <div>
      <div>Hi</div>
      <div className="movies-container">
        {movies.map((movie, index) => (
          <Movie movie={movie} index={index} />
        ))}
      </div>
    </div>
  );
}
