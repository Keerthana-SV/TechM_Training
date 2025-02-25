import React, { Component } from 'react';

class Game extends Component {
  render() {
    return (
      <div className="game-container">
        <h2>Game: {this.props.name}</h2>
        <p>Number of players: {this.props.players}</p>
      </div>
    );
  }
}

export default Game;
