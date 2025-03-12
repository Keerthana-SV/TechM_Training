import React from "react";
import "./Home.css";
import Hotels from "./Hotels"; 
import roomImage from "../public/room.jpg"; 


const Home = () => {
  return (
    <div className="home">
      <nav className="navbar">
      <h2 className="logo">BookRooms</h2>
        <ul className="nav-links">
       
        <Link to="/">Home</Link>
    <Link to="/hotels">Hotels</Link>
    <Link to="/bookings">Bookings</Link>
    <Link to="/payment">Payment</Link>
    <Link to="/contact">Contact</Link>
    <Link to="/login">Login/Sign up</Link>
        </ul>
      </nav>
  
      <section className="hero">


      <h1>Welcome to BookRooms!</h1>
        <h2>Find Your Perfect Stay</h2>
        <p>Book luxury and budget-friendly hotels in just a few clicks.</p>
        <button className="book-now">Book Now</button>
      </section>

      <section className="hotels-section">
        <Hotels />
      </section>
      <section className="hotels-section">
        <Form />
      </section>

    </div>
  );
};

export default Home;
