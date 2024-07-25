import React,{useState} from "react";

import { useDispatch,useSelector } from "react-redux";
import {createCar} from '../carSlice';


import {styled} from 'styled-components';

const ControlForm=styled.form`
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    background-color: #f9f9f9;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    `
    const Header2=styled.h2`
     text-align: center;
    margin-bottom: 20px;
    color: #333;`

    const Label=styled.label`
     display: block;
    margin-bottom: 8px;
    font-weight: bold;
    color: #555;`

    const Input=styled.input`
     width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
`

const Button=styled.button`
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    hover: background-color: #0056b3;`

const CarForm=()=>{
    const [brand,setBrand]=useState('');
    const [model,setModel]=useState('');
    const [year,setYear]=useState('');
    const [price,setPrice]=useState('');
    const [image_url,setImageUrl]=useState('');

    const dispatch=useDispatch();
    

    const handleSubmit=(e)=>{
        e.preventDefault();

        const newCar={
            brand,
            model,
            year:parseInt(year,10),
            price:parseInt(price),
            image_url,
        };
        dispatch(createCar(newCar));
        setBrand('');
        setModel('');
        setYear('');
        setPrice('');
        setImageUrl('');
    };

    return(
       
       <ControlForm onSubmit={handleSubmit}>
            <Header2>Add Car</Header2>
            <div>
                <Label>Brand</Label>
                <Input type="text" value={brand} onChange={(e)=>setBrand(e.target.value)} required/>
            </div>
            <div>
                <Label>Model</Label>
                <Input type="text" value={model} onChange={(e)=>setModel(e.target.value)} required/>
            </div>
            <div>
                <Label>Year of Mfg</Label>
                <Input type="text" value={year} onChange={(e)=>setYear(e.target.value)} required maxLength={4}/>
            </div>
            <div>
                <Label>Price</Label>
                <Input type="text" value={price} onChange={(e)=>setPrice(e.target.value)} required minLength={5}/>
            </div>
            <div>
                <Label>Image Url</Label>
                <Input type="text" value={image_url} onChange={(e)=>setImageUrl(e.target.value)} required/>
            </div>
            <Button type="submit" >Add Car</Button>
            </ControlForm>
        
    );
}

export default CarForm;