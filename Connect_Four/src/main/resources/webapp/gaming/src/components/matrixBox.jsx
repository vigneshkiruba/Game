import React, { Component } from "react";
import axios from "axios";
var URL = "http://localhost:8080/API/START";
var prefix = "https://cors-anywhere.herokuapp.com/";
class MatrixBox extends Component {
  state = {};

  callAPI() {
    axios(prefix + URL, {
      method: "POST",
    }).then((response) => {
      console.log(response.data);
    });
  }
  render() {
    return (
      <div>
        <button type="button" onClick={this.callAPI}>
          Let's Play
        </button>
      </div>
    );
  }
}

export default MatrixBox;
