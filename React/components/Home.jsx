import React from "react";
import { Link } from "react-router-dom"; // Import Link properly
import "./Home.css";
import Hotels from "./Hotels"; 
import { useNavigate } from "react-router-dom"; // ✅ Import useNavigate
import NavigationBar from "./Navbar"; 

const rooms = [
  { id: 1, name: "Deluxe Room", price: 120, image: "/room.jpg" },
  { id: 2, name: "Suite", price: 200, image: "/room.jpg" },
  { id: 3, name: "Executive Suite", price: 250, image: "/room.jpg" },
  { id: 4, name: "Presidential Suite", price: 500, image: "/room.jpg" },
  { id: 5, name: "Standard Room", price: 80, image: "/room.jpg" },
  { id: 6, name: "Single Room", price: 60, image: "/room.jpg" },
  { id: 7, name: "Family Room", price: 180, image: "/room.jpg" },
  { id: 8, name: "Honeymoon Suite", price: 300, image: "/room.jpg" },
  { id: 9, name: "Penthouse", price: 600, image: "/room.jpg" },
];





const Home = () => {
  const navigate = useNavigate(); // ✅ Initialize navigation function

  return (
    <div className="home">
      {/* Hero Section */}
      <section className="hero">
        <h1>Welcome to BookRooms!</h1>
        <h2>Find Your Perfect Stay</h2>
        <p>Book luxury and budget-friendly hotels in just a few clicks.</p>
        <button className="book-now" onClick={() => navigate("/hotels")}>
          Book Now
        </button>
      </section>
    </div>
  );
};

export default Home;
