import React from "react";
import backg2 from '../assets/backg2.jpg'

const Home=()=>{

    return(
       
        <div className="home-container" 
        style={{backgroundImage:`url(${backg2})`}}>
        <h1>Car Dealership App</h1>
        </div>
        
    );
}

export default Home;