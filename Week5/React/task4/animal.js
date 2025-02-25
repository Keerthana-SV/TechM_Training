import React from 'react';

function Animal(props) {
  return (
    <div className="animal-container">
      <h2>Animal Name: {props.name}</h2>
      <p>Type: {props.type}</p>
    </div>
  );
}

export default Animal;
