import React from "react";
import {Car} from '../types';

import  '../styles/CarCard.css'; 

    interface CarCardProps{
        car:Car;
    }

  
  const CarCard: React.FC<CarCardProps>= ({car}) => {
    
  
    const handleContactDealer = () => {
      alert(`contacting dealer for ${car.brand} ${car.model}`);
    };

    return(
        <div className="car-card">
            <img src={car.image_url} alt={`$car.brand`} className="car-card-image"/>
            <div className="car-card-details">
                <h2>{car.brand ?? 'Unknown'}  {car.model}</h2>
                <p>Year :{car.year}</p>
                <p>Price:{car.price}</p>
                <button className="contact-dealer" onClick={handleContactDealer}>
                    Contact Dealer
                </button>
            </div>
        </div>
    );
}

export default CarCard;