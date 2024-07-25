import React from "react";
import { useDispatch } from "react-redux";
import { deleteCar } from "../carSlice";
import { Car } from "../types";
import { AppDispatch } from "../store/redux_store";
import  '../styles/EditCard.css'; 
import { NavLink } from "react-router-dom";

interface CarCardProps{
    car:Car;
}
const EditCard: React.FC<CarCardProps>=({car})=>{

    const dispatch:AppDispatch=useDispatch();
    const handleDelete=(carId:number)=>{
        const confirmDel=window.confirm('are you sure you want to remove this car?');
        if(confirmDel){
            dispatch(deleteCar(carId));
        }else{
        console.log('Delete cancelled');
        }
    }

    return(
        <div className="car-card">
            <img src={car.image_url} alt={`$car.brand`} className="car-card-image"/>
            <div className="car-card-details">
                <h2>{car.brand}  {car.model}</h2>
                <p>Year :{car.year}</p>
                <p>Price:{car.price}</p>
                <div className="edit-card-buttons">
                <button className="edit-car">
               <NavLink className="link1" to = {`/updateForm/?id=${car.id}`}>
                    Edit Details
                </NavLink> </button>
                <button className="delete-car" onClick={()=>handleDelete(car.id)}>
                    Delete
                </button>
            </div>
        </div></div>
    );
}

export default EditCard;