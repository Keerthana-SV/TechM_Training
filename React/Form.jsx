import React, { useState } from "react";
import { Form, Button } from "react-bootstrap";

const BookingForm = () => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    checkIn: "",
    checkOut: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Booking Details:", formData);
  };

  return (
    <Form onSubmit={handleSubmit} className="mt-4">
      <h4>Book a Room</h4>
      <Form.Group>
        <Form.Label>Name</Form.Label>
        <Form.Control type="text" name="name" onChange={handleChange} required />
      </Form.Group>
      <Form.Group>
        <Form.Label>Email</Form.Label>
        <Form.Control type="email" name="email" onChange={handleChange} required />
      </Form.Group>
      <Form.Group>
        <Form.Label>Check-In Date</Form.Label>
        <Form.Control type="date" name="checkIn" onChange={handleChange} required />
      </Form.Group>
      <Form.Group>
        <Form.Label>Check-Out Date</Form.Label>
        <Form.Control type="date" name="checkOut" onChange={handleChange} required />
      </Form.Group>
      <Button variant="success" type="submit" className="mt-2">Submit</Button>
    </Form>
  );
};

export default BookingForm;
