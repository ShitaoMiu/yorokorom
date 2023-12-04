import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Board from "./common/Board";
import Login from "./component/Login";
import { useEffect } from "react";

function App() {
 useEffect(() => console.log("app is loading"), [])
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/login" element={<Login/>}></Route>
      <Route path="/board/:bbsId" element={<Board />}></Route>
      <Route path="/board/:bbsId/new" element={<Board />}></Route>
      <Route path="/board/:bbsId/post/:postId" element={<Board />}></Route>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
