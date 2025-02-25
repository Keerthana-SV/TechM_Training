import React, { useState } from 'react';

function App() {
  const [inputString, setInputString] = useState('');
  const [result, setResult] = useState('');

  const handleCheck = () => {
    const length = inputString.length;
    // Check if the length of the string is even or odd
    const message = length % 2 === 0
      ? 'The length of the string is even.'
      : 'The length of the string is odd.';

    setResult(message);
  };

  return (
    <div className="app">
      <h1>Check if String Length is Even or Odd</h1>
      <input 
        type="text" 
        value={inputString} 
        onChange={(e) => setInputString(e.target.value)} 
        placeholder="Enter a string"
      />
      <button onClick={handleCheck}>Check Length</button>
      <div className="result">
        <p>{result}</p>
      </div>
    </div>
  );
}

export default App;
