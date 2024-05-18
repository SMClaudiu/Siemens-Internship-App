import React, { useEffect, useState } from 'react';

const ExistingReservations = () => {
    const [reservations, setReservations] = useState([]);
    const [isLoading, setIsLoading] = useState(true); // Add a loading state
  
    useEffect(() => {
        // Fetch reservations data from your backend API
        fetch('http://localhost:8080/users/getReservations/1') // Replace with your actual API endpoint
          .then(response => response.json())
          .then(data => {
            // Remove extra quotes from name and phoneNumber
            data.name = data.name.replace(/"/g, '');
            data.phoneNumber = data.phoneNumber.replace(/"/g, '');
            setReservations([data]); // Wrap data in an array
            setIsLoading(false); // Set loading to false after data is fetched
          })
          .catch(error => {
            console.error('Error fetching reservations:', error);
            setIsLoading(false); // Also set loading to false if an error occurs
          });
      }, []);
      
  
    if (isLoading) {
      return <div>Loading...</div>; // Display a loading indicator
    }

  return (
    <div>
      <h1>Reservations Made</h1>
      <div>
        {Array.isArray(reservations) && reservations.map(reservation => (
          <div key={reservation.id}>
            <h2>User: {reservation.name}</h2>
            <p>Phone: {reservation.phoneNumber}</p>
            {reservation.reservedRooms.map(room => (
              <div key={room.id}>
                <p>Room Number: {room.roomNumber}</p>
                <p>Room Type: {room.type}</p>
                <p>Price: ${room.price}</p>
              </div>
            ))}
          </div>
        ))}
      </div>
    </div>
  );
};

export default ExistingReservations;
