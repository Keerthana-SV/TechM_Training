import React from "react";
import "./contact.css";

const Contact = () => {
  return (
    <div className="contact-container">
      <h2>Contact Us</h2>
      <p>Have any questions? Get in touch with us!</p>
      <div className="contact-info">
        <p><strong>📍 Address:</strong> 123 Luxury Street, New York, NY 10001, USA</p>
        <p><strong>📞 Phone:</strong> +1 555-123-4567</p>
        <p><strong>✉️ Email:</strong> contact@bookrooms.com</p>
      </div>
    </div>
  );
};

export default Contact;

