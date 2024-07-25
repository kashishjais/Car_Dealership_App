import React, { Component, useState } from 'react';
import axios from 'axios';
import {styled,createGlobalStyle} from 'styled-components';


const Body=styled.div`
background: linear-gradient(135deg, #1B8AF1, #B58DED);
  min-height: 100vh;
  width: 100%;
  text-align: center;
  display:flex;
  justify-content:center;
  align-items:center;
  `

const Header4=styled.h4`
 font-family: 'Segoe UI', bold;
  font-size: 35px;
  margin-top: 4rem;
  margin-bottom: 2rem;`

const   RegisterForm=styled.form`
display: inline-block;
  align-items: center;
  height: 270px;
  width: 350px;
  margin-bottom: 170px;`

const Text=styled.div`
align-content: center;
  border-radius: 22px;
  margin-bottom: 35px;
  width: 100%;
  height: 64px;
  box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.2), 0 0 20px 0 rgba(0, 0, 0, 0.19);`
  
 const Input=styled.input`
 margin-top: 1.2rem;
  font-family: 'Montserrat regular';
  font-size: 20px;
  border: none;
  width: 80%;`
  
  const Button=styled.input`
  margin-top: 28px;
  width: 165px;
  height: 60px;
  border-radius: 30px;
  background: #B58DED;
  border: none;
  font-family: 'Montserrat';
  font-size: 20px;
  color: #FFFFFF;
  box-shadow: 0 4px 8px 0 rgba(181, 141, 237, 0.7), 0 6px 20px 0 rgba(181, 141, 237, 0.9);
  cursor: pointer;`

  const Register=styled.div`
   display: inline-block;
  background: #FFFFFF;
  width: 434px;
  height: 700px;
  margin-top: 10%;
  border-radius: 22px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);`

  const Link=styled.a`
   color: #0E4579;
  font-family: 'Montserrat light';
  font-size: 18px;
  cursor: pointer;
  display: block;
  text-decoration: none;`

const AuthForm =()=>{
  const [user_name,setUserName]=useState('');
  const [password,setPassword]=useState('');
  const [role,setRole]=useState('');

  const handleSubmit=async(e)=>{
    e.preventDefault();
    const newUser={user_name,password,role};
   try{
    const response=await axios.post('http://localhost:8080/auth/register',newUser);
    console.log('User registered successfully! ',response.data);
    setUserName('');
    setPassword('');
    setRole('');
    
   }catch(error){
    console.error('there was error adding the user!!',error);
   }
};
    return (
      <>
      
      <Body>
      <Register onSubmit={handleSubmit}>
        <Header4>Register</Header4>
        <RegisterForm>
          <Text>
            <Input
              type="text" 
              placeholder='enter username'
              value={user_name} onChange={(e)=>setUserName(e.target.value)} required/>
          </Text>
          <Text>
            <Input
              type="password" 
              placeholder='enter password'
              value={password} onChange={(e)=>setPassword(e.target.value)} required/>
          </Text>
          
          <Button
            type="submit" value="register"/>
        </RegisterForm>
        <Link  href="/signin">LogIn/SignIn</Link>
      </Register>
      </Body>
      </>
    )
  
}

export default AuthForm;