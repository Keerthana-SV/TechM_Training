import React from 'react';
import Java from './Java';
import Javascript from './Javascript';
import ReactComponent from './ReactComponent';
import Angular from './Angular';

function Training() {
  return (
    <div className="training-container">
      <h1>Topics for Training</h1>
      <div className="training-topic">
        <Java />
      </div>
      <div className="training-topic">
        <Javascript />
      </div>
      <div className="training-topic">
        <ReactComponent />
      </div>
      <div className="training-topic">
        <Angular />
      </div>
    </div>
  );
}

export default Training;
