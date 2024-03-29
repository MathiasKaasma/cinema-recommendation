import React, { useEffect, useState } from "react";

export default function Booking() {
  const [seats, setSeats] = useState([]);

  async function fetchSeats() {
    try {
      const response = await fetch(`${import.meta.env.VITE_API_URL}/seats?`);
      if (!response.ok) throw new Error("Data could not be fetched");
      const data = await response.json();
      setSeats(data);
    } catch (error) {
      console.error("Fetching error: ", error);
    }
  }

  useEffect(() => {
    fetchSeats();
  }, []);

  return <h1>hi</h1>;
}
