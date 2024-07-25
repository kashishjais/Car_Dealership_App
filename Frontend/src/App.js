import React, { useEffect ,useState} from "react";
import CarDetail from "./Components/CarDetail";
import CarForm from "./Components/CarForm";

import {Router,Route,Routes,useLocation} from 'react-router-dom';
import NavBar from "./Components/NavBar";
import Home from "./Components/Home";
import Grid from "./Components/Grid";
import AuthForm from "./Components/AuthForm";

import EditGrid from "./Components/EditGrid";
import UpdateForm from "./Components/UpdateForm";
import LoginForm from "./Components/LoginForm";



const App=()=>{
  const [role,setRole]=useState('ROLE_USER');
  useEffect(()=>{
    const storedRole=localStorage.getItem('role');
    if(storedRole){
      setRole(storedRole);
    }
  },[]);
  const location=useLocation();
  const showNavBar=!['/','/signin'].includes(location.pathname);
  return(
      <div>
        {showNavBar && <NavBar role={role}/>}
      
      <main>    
        <Routes>
        <Route exact path="/home" element={<Home/>}/>
        
        <Route exact path="/catalog" element={<Grid></Grid>}/>
        <Route exact path="/add" element={<CarForm></CarForm>}/>
        <Route exact path="/edit" element={<EditGrid></EditGrid>}/>
        
        <Route  path="/updateForm/" element={<UpdateForm></UpdateForm>}/>
        
        <Route exact path="/search/:id" element={<CarDetail></CarDetail>}/>
        <Route exact path="/" element={<AuthForm></AuthForm>} />
        <Route exact path="/signin" element={<LoginForm></LoginForm>} />
        </Routes>
        
      </main>
      </div>
     
      
    
    
  );
};

export default App;