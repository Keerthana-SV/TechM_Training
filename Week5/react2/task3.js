import React, { useState } from 'react';

function App() {
  const [arr, setArr] = useState([9, 4, 24]); // Initial array
  const [result, setResult] = useState('');

  const checkArrayLength = () => {
    const arrayLength = arr.length;

    // Check if the length of the array is divisible by 3
    const message = arrayLength % 3 === 0
      ? 'The number of elements in the array is a multiple of 3.'
      : 'The number of elements in the array is not a multiple of 3.';
    
    setResult(message);
  };

  return (
    <div className="app">
      <h1>Check if the Array Length is a Multiple of 3</h1>
      <button onClick={checkArrayLength}>Check Array Length</button>
      <div className="result">
        <p>{result}</p>
      </div>
      <div className="array-display">
        <h2>Array: {JSON.stringify(arr)}</h2>
      </div>
    </div>
  );
}

export default App;
