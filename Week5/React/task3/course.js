import React, { Component } from 'react';

class Course extends Component {
  render() {
    return (
      <div className="course-container">
        <h2>The name of the course is: {this.props.name}</h2>
      </div>
    );
  }
}

export default Course;
