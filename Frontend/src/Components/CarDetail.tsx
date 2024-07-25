import React, { useState, ChangeEvent, FormEvent } from "react";
import { useSelector, useDispatch } from "react-redux";
import { RootState, AppDispatch } from "../store/redux_store";

import { fetchCarById } from "../carSlice";
import CarCard from "./CarCard";

const CarDetail: React.FC = () => {
  const [searchId, setSearchId] = useState<number>(0);
  const dispatch: AppDispatch = useDispatch();
  const car = useSelector((state: RootState) => state.car.car);
  const loading = useSelector((state: RootState) => state.car.status);
  const error = useSelector((state: RootState) => state.car.error);

  const handleInputChange = (e: ChangeEvent<HTMLInputElement>) => {
    setSearchId(Number(e.target.value));
  };

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    if (searchId) {
      dispatch(fetchCarById(searchId));
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input 
          type="number" 
          placeholder="Enter car Id" 
          value={searchId} 
          onChange={handleInputChange} 
        />
        <button type="submit">Search</button>
      </form>
      {loading === 'loading' && <p>Loading....</p>}
      {error && <p>{error}</p>}
      <h1>Car Details</h1>
      {car && (<div> <CarCard key={car.id} car={car}  /></div>)}
    </div>
  );
}

export default CarDetail;
