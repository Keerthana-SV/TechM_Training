import React, { useState } from 'react';

function App() {
  const [num, setNum] = useState(''); // State for input number
  const [result, setResult] = useState('');

  const handleCheck = () => {
    const number = Number(num); // Convert the input to a number

    // Using if statement
    if (number % 13 === 0) {
      setResult('Using if: The number is divisible by 13!');
    }

    // Using logical &&
    if (number % 13 === 0) {
      setResult('Using &&: The number is divisible by 13!');
    }

    // Using ternary operator
    const message = number % 13 === 0
      ? 'Using ternary: The number is divisible by 13!'
      : 'Using ternary: The number is NOT divisible by 13!';
    
    setResult(message);
  };

  return (
    <div className="app">
      <h1>Check if a Number is Divisible by 13</h1>
      <input 
        type="number" 
        value={num} 
        onChange={(e) => setNum(e.target.value)} 
        placeholder="Enter a number"
      />
      <button onClick={handleCheck}>Check Divisibility</button>
      <div className="result">
        <p>{result}</p>
      </div>
    </div>
  );
}

export default App;
