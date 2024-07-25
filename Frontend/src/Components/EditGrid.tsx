import React,{useEffect} from "react";
import { useDispatch,useSelector } from "react-redux";
import EditCard from "./EditCard";
import { fetchAllCars } from "../carSlice";
import { RootState ,AppDispatch} from "../store/redux_store";
import {Car} from '../types';
import  '../styles/Grid.css'; 

const EditGrid:React.FC=()=>{
    const dispatch:AppDispatch=useDispatch();
    const cars=useSelector((state:RootState)=>state.car.cars);
    const status=useSelector((state:RootState)=>state.car.status);
    const error=useSelector((state:RootState)=>state.car.error);

    useEffect(()=>{
        dispatch(fetchAllCars());
    },[dispatch]);

    return(
        <div className="car-list">
            
                {cars.map((car:Car)=>(
                    <EditCard key={car.id} car={car}/>
                ))}
           
        </div>
    );
}

export default EditGrid;