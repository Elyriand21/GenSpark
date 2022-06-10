import React from 'react';
import ReactDOM from 'react-dom/client';
import Bio from "./Components/Bio";
import Title from "./Components/Title";
import Projects from "./Components/Projects";
import reportWebVitals from './reportWebVitals';
import './index.css';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
      <Title />
    <div className="container" stlye={{"display": "flex","border":"1px solid black"}}>
      <Bio /> 
      <Projects />
    </div>
    </div>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
