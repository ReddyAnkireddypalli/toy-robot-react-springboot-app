import React, { Component } from "react";
import ToyRobotView from "./components/ToyRobotView";
import "./ToyRobotApp.css";
import Direction from "./components/Direction";


class ToyRobotApp extends Component {

  constructor(props) {
    super(props);

    this.state = {
      result: [],
      value: "",
      placed: false
    };

    this.handlePress = this.handlePress.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleReset = this.handleReset.bind(this);
  }

  // Reset the game
  handleReset(event) {
    this.setState({
      result: [],
      value: "",
      placed: false
    });
  }


  // Registering user event if valid
  handlePress(event) {
    if (event.key === "Enter") {
      // Split by space and comma
      const inputLine = this.state.value.split(/[\s,]+/);
      var command = inputLine[0];

      // Call API and set the values to state
      fetch('/api/'+inputLine)
                     .then(response => response.json())
                     .then(data => {
                        if (command === "REPORT") {
                            var report = `Output: ${data.lx},${data.ly},${
                            Direction.x[data.fx.toString()].y[data.fy.toString()]
                         }`;

                         this.setState({
                         result: [...this.state.result, report],
                         placed: data.placed
                         });}
                       else{
                         this.setState({
                         result: [...this.state.result, data.result],
                         placed: data.placed
                         });
                     } });

      // Reset the input value
      this.setState({ value: "" });
    }
  }

  // Change the text to uppercase
  handleChange(event) {
    const value = event.target.value.toUpperCase();
    this.setState({ value });
  }

  render() {
    // Iterate through our results to print to screen
    const results = this.state.result.map((elem, index) => (
                          <ToyRobotView key={index} value={elem} />
                        ));

    //Rendering the data to UI
    return (
      <div className="container my-2">
        <div className="row">
          <div className="col-md-8 offset-md-2">
            <h1 className="text-center">Toy Robot</h1>
          </div>
        </div>
        <div className="row">
          <div className="col-md-8 offset-md-2">
            <div className="input-group">
              <input
                onKeyPress={this.handlePress}
                onChange={this.handleChange}
                value={this.state.value}
                className="form-control"
                placeholder="Enter here to go"
              />
              {this.state.placed ? (
                <button
                  onClick={this.handleReset}
                  className="btn btn-danger btn-block mt-2"
                >
                  Reset
                </button>
              ) : (
                ""
              )}
            </div>
          </div>
        </div>
        {this.state.placed ? (
          <div className="row mt-2">
            <div className="col-md-8 offset-md-2">
              <ul className="list-group">{results}</ul>
            </div>
          </div>
        ) : (
          ""
        )}
      </div>
    );
  }
}


export default ToyRobotApp;
