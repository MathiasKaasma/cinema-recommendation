import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export default function Booking() {
  const [seats, setSeats] = useState([]);

  async function fetchSeats() {
    try {
      const response = await fetch(
        `${import.meta.env.VITE_API_URL}/movies/seats`
      );
      if (!response.ok) throw new Error("Data could not be fetched");
      const data = await response.json();
      setSeats(data);
    } catch (error) {
      console.error("Fetching error: ", error);
    }
  }

  useEffect(() => {
    fetchSeats();
    console.log(seats);
  }, []);

  return (
    <div className="seats-container">
      <div className="seating">
        {seats.map((row, rowIndex) => (
          <div key={rowIndex} className="row">
            {row.map((seat, seatIndex) => (
              <Link to="/kinnitus">
                <div
                  key={seatIndex}
                  className={`seat ${
                    seat === 1
                      ? "available"
                      : seat === 2
                      ? "optimal"
                      : "occupied"
                  }`}
                >
                  {seat}
                </div>
              </Link>
            ))}
          </div>
        ))}
      </div>
    </div>
  );
}
