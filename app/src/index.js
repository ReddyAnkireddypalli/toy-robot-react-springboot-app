import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import ToyRobotApp from './ToyRobotApp';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<ToyRobotApp />, document.getElementById('root'));
registerServiceWorker();
