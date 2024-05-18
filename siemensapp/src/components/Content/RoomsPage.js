import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import ButtonGroup from '@mui/material/ButtonGroup';
import Button from '@mui/material/Button';
import Modal from '@mui/material/Modal';
import styles from './RoomPage.module.css';

const RoomsPage = ({ userId }) => {
  const { id } = useParams();
  const [rooms, setRooms] = useState([]);
  const [hotels, setHotels] = useState([]);
  const [openModal, setOpenModal] = useState(false);
  const [selectedRoom, setSelectedRoom] = useState(null);
  const navigate = useNavigate();

  const handleCheckInClick = (room) => {
    setSelectedRoom(room);
    setOpenModal(true);
  };

  const handleCloseModal = () => {
    setOpenModal(false);
    setSelectedRoom(null);
  };

  useEffect(() => {
    fetch('http://localhost:8080/hotels/getAll')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        console.log('Received hotel data:', data);
        setHotels(data);
      })
      .catch(error => console.error('Error fetching hotels:', error));
  }, []);

  useEffect(() => {
    fetch(`http://localhost:8080/rooms/getAvailable/${id}`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        setRooms(data);
      })
      .catch(error => {
        console.error('Error fetching rooms:', error);
      });
  }, [id]);

  const currentHotel = hotels.find(hotel => hotel.id === parseInt(id));

  if (!currentHotel) {
    return <div>Hotel not found</div>;
  }
  const handleReservationSubmit = (event) => {
    event.preventDefault(); // Prevent the form from submitting the traditional way
  
    const userData = {
      name: document.getElementById('name').value,
      phoneNumber: document.getElementById('phoneNumber').value,
    };
  
    fetch(`http://localhost:8080/users/reservation/${currentHotel.id}/${selectedRoom.id}?name=${userData.name}&phone=${userData.phoneNumber}&userId=${userId}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
    })
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        handleCloseModal();
        navigate(`/success`);
      })
      .catch(error => {
        console.error('Error making reservation:', error);
      });
  };
  

  return (
    <div className={styles.bigList}>
      <h1>Rooms for {currentHotel.name}</h1>
      <ul className={styles.roomList}>
        {rooms.map(room => (
          <li key={room.id} className={styles.roomItem}>
            <div>Room Number: {room.roomNumber}</div>
            <div>Type: {room.type}</div>
            <div>Price: ${room.price}</div>
            <div>Available: {room.available ? 'Yes' : 'No'}</div>
            {room.available && (
              <ButtonGroup variant="contained" aria-label="Basic button group">
                <Button onClick={() => handleCheckInClick(room)}>CheckIn</Button>
              </ButtonGroup>
            )}
          </li>
        ))}
      </ul>
      <Modal open={openModal} onClose={handleCloseModal}>
        <div className={styles.modal}>
          <h2>Complete Reservation</h2>
          <form onSubmit={handleReservationSubmit}>
            <div className={styles.formGroup}>
              <label htmlFor="name">Name:</label>
              <input type="text" id="name" name="name" required />
            </div>
            <div className={styles.formGroup}>
              <label htmlFor="phoneNumber">Phone Number:</label>
              <input type="tel" id="phoneNumber" name="phoneNumber" required />
            </div>
            <Button type="submit">Submit</Button>
          </form>
        </div>
      </Modal>
    </div>
  );
};

export default RoomsPage;
