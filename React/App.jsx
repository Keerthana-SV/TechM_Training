
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import axios from "axios";
import Navbar from "./components/Navbar";
import Home from "./components/Home";  
import RoomList from "./components/Hotels";
import BookingForm from "./components/Form";

const App = () => {
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    axios.get("https://api.example.com/rooms") // Replace with actual API
      .then(response => setRooms(response.data))
      .catch(error => console.error("Error fetching rooms:", error));
  }, []);

  return (
    <Router> 
      <Navbar />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} /> 
          <Route path="/hotels" element={<RoomList rooms={rooms} />} />
          <Route path="/form" element={<BookingForm />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;

