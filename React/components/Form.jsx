import React, { useState } from "react";
import { Form, Button, Container, Row, Col } from "react-bootstrap";

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

    // ✅ Show an alert confirmation
    alert("Your booking request has been submitted successfully!");

    // ✅ Reset the form after submission
    setFormData({
      name: "",
      email: "",
      checkIn: "",
      checkOut: "",
    });
  };

  return (
    <Container className="mt-4">
      <Row className="justify-content-center">
        <Col md={6}>
          <h4 className="text-center mb-3">Book a Room</h4>
          <Form onSubmit={handleSubmit} className="p-4 border rounded shadow-sm bg-light">
            <Form.Group>
              <Form.Label>Name</Form.Label>
              <Form.Control
                type="text"
                name="name"
                value={formData.name}
                onChange={handleChange}
                placeholder="Enter your name"
                required
              />
            </Form.Group>

            <Form.Group>
              <Form.Label>Email</Form.Label>
              <Form.Control
                type="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
                placeholder="Enter your email"
                required
              />
            </Form.Group>

            <Form.Group>
              <Form.Label>Check-In Date</Form.Label>
              <Form.Control
                type="date"
                name="checkIn"
                value={formData.checkIn}
                onChange={handleChange}
                required
              />
            </Form.Group>

            <Form.Group>
              <Form.Label>Check-Out Date</Form.Label>
              <Form.Control
                type="date"
                name="checkOut"
                value={formData.checkOut}
                onChange={handleChange}
                required
              />
            </Form.Group>

            <Button variant="success" type="submit" className="mt-3 w-100">
              Submit Booking
            </Button>
          </Form>
        </Col>
      </Row>
    </Container>
  );
};

export default BookingForm;
