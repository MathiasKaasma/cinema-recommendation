import React from "react";

export default function Search({ filters, handleFilterChange }) {
  return (
    <div>
      <input
        type="text"
        name="title"
        placeholder="Pealkiri"
        value={filters.title}
        onChange={handleFilterChange}
      />
      <select name="genre" value={filters.genre} onChange={handleFilterChange}>
        <option value="">Kõik žanrid</option>
        <option value="Seiklus">Seiklus</option>
        <option value="Draama">Draama</option>
        <option value="Eesti">Eesti</option>
        <option value="Põnevus">Põnevus</option>
        <option value="Komöödia">Komöödia</option>
        <option value="Romantika">Romantika</option>
      </select>
      <select
        name="language"
        value={filters.language}
        onChange={handleFilterChange}
      >
        <option value="">Kõik keeled</option>
        <option value="Eesti">Eesti</option>
        <option value="Inglise">Inglise</option>
        <option value="Vene">Vene</option>
      </select>
      <select
        name="ageRating"
        value={filters.ageRating}
        onChange={handleFilterChange}
      >
        <option value="">Kõik vanused</option>
        <option value="13">13+</option>
        <option value="16">16+</option>
        <option value="18">18+</option>
      </select>
      <input
        type="datetime-local"
        name="startTime"
        value={filters.startTime}
        onChange={handleFilterChange}
      />
      <input
        type="number"
        name="rating"
        placeholder="Hinnang"
        value={filters.rating}
        onChange={handleFilterChange}
      />
      <input
        type="number"
        name="suggestion"
        placeholder="Soovitus"
        value={filters.suggestion}
        onChange={handleFilterChange}
      />
    </div>
  );
}
