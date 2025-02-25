import React, { useState } from 'react';

function App() {
  const flowers = ['Rose', 'Jasmine', 'Lotus']; // Array of flowers
  const [inputString, setInputString] = useState('');
  const [result, setResult] = useState('');

  const checkFlower = () => {
    // Check if the input string matches any flower in the array (case-insensitive)
    const lowercasedInput = inputString.toLowerCase();
    const isFlower = flowers.some(flower => flower.toLowerCase() === lowercasedInput);

    const message = isFlower
      ? "It's a flower!"
      : "It's not a flower.";

    setResult(message); // Update result state
  };

  return (
    <div className="app">
      <h1>Flower Checker</h1>
      <input
        type="text"
        value={inputString}
        onChange={(e) => setInputString(e.target.value)} // Update inputString state
        placeholder="Enter a flower name"
      />
      <button onClick={checkFlower}>Check</button>
      <div className="result">
        <p>{result}</p>
      </div>
    </div>
  );
}

export default App;
