import React, { useEffect, useState, useCallback,useRef } from "react";
import axios from "axios";
 const Login = () => {
  const [userId,setUserId] = useState("");
  const [password,setPassword] = useState("");
  const usernameRef = useRef();
  const passwordRef = useRef();

  const handleLogin =()=>{
    axios
    .get(`http://localhost:8080/api/loginAction`,{
      userId : userId,
      password : password
  }
    )
    .then((response) => {
    
    })
    .catch((error) => console.log(error));
  };

  return (
   <div className="Login">
      <div class="">
        <form id="">
            <label>아이디:</label>
            <input type="text" name="username" className="inputText" onChange={(e)=>setUserId(e.target.value)}></input>
            <label>비밀번호:</label>
            <input type="password" name="password" className="inputText" onChange={(e)=>setPassword(e.target.value)}></input>
        </form>
      </div>
    <button onClick={handleLogin}>Login</button>

   </div>
   )
};
export default Login;
