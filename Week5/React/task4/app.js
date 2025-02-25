import React from 'react';
import Animal from './Animal'; // Import the Animal component

function App() {
  return (
    <div className="App">
      <Animal name="Lion" type="Mammal" /> {/* Pass name and type props */}
      <Animal name="Eagle" type="Bird" /> {/* Another example with different animal */}
    </div>
  );
}

export default App;
