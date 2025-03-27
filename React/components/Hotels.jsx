import React from "react";
import { Card, Button, Container, Row, Col } from "react-bootstrap";
import { useNavigate } from "react-router-dom"; // ✅ Import useNavigate

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

const Hotels = () => {
  const navigate = useNavigate(); // ✅ Initialize navigation

  const handleBookNow = () => {
    navigate("/form"); // ✅ Navigate directly to the form
  };

  return (
    <Container>
      <h2 className="text-center my-4">Available Rooms</h2>
      <Row>
        {rooms.map((room) => (
          <Col md={4} sm={6} xs={12} key={room.id} className="mb-4">
            <Card>
              <Card.Img variant="top" src={room.image} alt={room.name} />
              <Card.Body>
                <Card.Title>{room.name}</Card.Title>
                <Card.Text>Price: ${room.price} per night</Card.Text>
                <Button variant="primary" onClick={handleBookNow}>
                  Book Now
                </Button>
              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
    </Container>
  );
};

export default Hotels;
