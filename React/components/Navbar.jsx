import React from "react";
import { Navbar, Nav, Container } from "react-bootstrap";
import { Link } from "react-router-dom"; // ✅ Import Link

const NavigationBar = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container>
        <Navbar.Brand as={Link} to="/">BookRooms</Navbar.Brand> {/* ✅ Correct brand link */}
        <Nav className="ms-auto">
          <Nav.Link as={Link} to="/">Home</Nav.Link> {/* ✅ Ensure correct paths */}
          <Nav.Link as={Link} to="/hotels">Hotels</Nav.Link>
          <Nav.Link as={Link} to="/form">Bookings</Nav.Link>
          <Nav.Link as={Link} to="/contact">Contact</Nav.Link> {/* ✅ Ensure correct path */}
        </Nav>
      </Container>
    </Navbar>
  );
};

export default NavigationBar;
