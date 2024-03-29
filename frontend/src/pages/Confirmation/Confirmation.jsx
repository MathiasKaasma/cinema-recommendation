import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function Confirmation() {
  const { movieId } = useParams();

  useEffect(() => {
    handleBooking();
  }, []);

  const handleBooking = async () => {
    try {
      const response = await fetch(
        `${import.meta.env.VITE_API_URL}/movies/booked`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ movieId: movieId, userId: 1 }),
        }
      );

      if (!response.ok) {
        throw new Error("Failed to book movie");
      }

      console.log("Movie booked successfully");
    } catch (error) {
      console.error("Error booking movie:", error);
    }
  };

  return (
    <>
      <h2>Täname Teid broneeringu tegemise eest!</h2>
    </>
  );
}
