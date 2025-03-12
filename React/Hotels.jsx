import React from "react";
import { Card, Button } from "react-bootstrap";

const Hotels = ({ rooms }) => {
  return (
    <div className="row">
      {rooms.map((room) => (
        <div className="col-md-4 mb-4" key={room.id}>
          <Card>
            <Card.Img variant="top" src={room.image} />
            <Card.Body>
              <Card.Title>{room.name}</Card.Title>
              <Card.Text>Price: ${room.price} per night</Card.Text>
              <Button variant="primary">Book Now</Button>
            </Card.Body>
          </Card>
        </div>
      ))}
    </div>
  );
};

export default Hotels;
