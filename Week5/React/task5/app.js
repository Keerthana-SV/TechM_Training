import React from 'react';
import Game from './Game'; // Import the Game component

function App() {
  return (
    <div className="App">
      <Game name="Soccer" players={22} /> {/* Passing props to the Game component */}
    </div>
  );
}

export default App;
