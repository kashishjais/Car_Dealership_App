import React,{useEffect} from "react";
import { useDispatch,useSelector } from "react-redux";
import CarCard from "./CarCard";
import { fetchAllCars } from "../carSlice";
import { RootState ,AppDispatch} from "../store/redux_store";
import {Car} from '../types';
import  '../styles/Grid.css'; 

const Grid:React.FC=()=>{
    const dispatch:AppDispatch=useDispatch();
    const cars=useSelector((state:RootState)=>state.car.cars);
    

    useEffect(()=>{
        dispatch(fetchAllCars());
    },[dispatch]);

    return(
        <div className="car-list">
            
                {cars.map((car:Car)=>(
                    <CarCard key={car.id} car={car}/>
                ))}
           
        </div>
    );
}

export default Grid;