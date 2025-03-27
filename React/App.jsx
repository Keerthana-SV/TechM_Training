import 'bootstrap/dist/css/bootstrap.min.css';
import Contact from "./components/contact"; 
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import axios from "axios";
import Navbar from "./components/Navbar";
import Home from "./components/Home";  
import RoomList from "./components/Hotels";
import BookingForm from "./components/form"; // Correct casing


const App = () => {
  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    axios.get("https://api.example.com/rooms") // Replace with actual API
      .then(response => setRooms(response.data))
      .catch(error => console.error("Error fetching rooms:", error));
  }, []);

  return (
    <Router>  {/* ✅ Wrap everything inside Router */}
      <Navbar />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Home />} /> {/* ✅ Home loads first */}
          <Route path="/hotels" element={<RoomList rooms={rooms} />} />
          <Route path="/form" element={<BookingForm />} />
          <Route path="/contact" element={<Contact />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;

