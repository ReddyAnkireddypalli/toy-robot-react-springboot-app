import React from 'react';
import ReactDOM from 'react-dom';
import ToyRobotApp from './ToyRobotApp';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<ToyRobotApp />, div);
  ReactDOM.unmountComponentAtNode(div);
});
