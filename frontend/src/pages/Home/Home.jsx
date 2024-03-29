import React, { useEffect, useState } from "react";
import Movie from "./components/MovieCard";
import MovieSearch from "./components/MovieSearch";

export default function Home() {
  const [movies, setMovies] = useState([]);
  const [filters, setFilters] = useState({
    title: "",
    genre: "",
    ageRating: "",
    startTime: "",
    language: "",
    rating: "",
    suggestion: "",
  });

  async function fetchMovies() {
    try {
      let url = `${import.meta.env.VITE_API_URL}/movies?`;
      for (const key in filters) {
        if (filters[key]) {
          url += `${key}=${filters[key]}&`;
        }
      }
      const response = await fetch(url);
      if (!response.ok) throw new Error("Data could not be fetched");
      const data = await response.json();
      setMovies(data);
    } catch (error) {
      console.error("Fetching error: ", error);
    }
  }

  useEffect(() => {
    fetchMovies();
  }, [filters]);

  const handleFilterChange = (e) => {
    setFilters({
      ...filters,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div>
      <div className="search-container">
        <MovieSearch
          filters={filters}
          handleFilterChange={handleFilterChange}
        />
      </div>
      <div className="movies-container">
        {movies.map((movie, index) => (
          <Movie key={movie.id} movie={movie} index={index} />
        ))}
      </div>
    </div>
  );
}
