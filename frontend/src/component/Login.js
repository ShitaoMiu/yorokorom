import React, { useEffect, useState, useCallback } from "react";
import axios from "axios";
import Layout from "../layout/Layout";
const Login = () => {
  const [username,setUsername] = useState("");
  const [password,setPassword] = useState("");
  
  return (
   <div className="Login">
    <div class="">
        <input type="text" name="username" className="inputText" onChange={(e)=>setUsername(e.target.value)}></input>
        <input type="password" name="password" className="inputText" onChange={(e)=>setPassword(e.target.value)}></input>


    </div>


   </div>
   )
};
export default Login;
