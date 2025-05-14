/* eslint-disable */

import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';

function App() {
  let post = "강남 만두 맛집";
  let [title, setTitle] = useState(['강남 만두','고향 만두', '실리카겔 만두', '나라 만두']);
  let [likes, setLikes] = useState(0);

  function like() {
    setLikes(likes + 1);
  }

  function sortTitle() {
    let copy = [...title];
    setTitle(copy.sort());
  }
  
  return (
    <div className="App">
      <header className='black-nav'>
        <h2>블로그임</h2>
      </header>
      <button onClick={sortTitle}>sort</button>
      <div>{title}</div>
      <div onClick={like}>좋아요</div><span>{likes}</span>
      <div className='hello'>
        <h2 style={{"color":"red"}}>{title[0]}</h2>
        <h2 style={{"color":"red"}}>{title[1]}</h2>
        <h2 style={{"color":"red"}}>{title[2]}</h2>
      </div>
    </div>
  );
}

export default App;
