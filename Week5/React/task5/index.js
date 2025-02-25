import React from 'react';
import ReactDOM from 'react-dom';
import './styles.css'; // Import styles
import App from './App'; // Import the main App component

// Render the App component inside the root div in index.html
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
