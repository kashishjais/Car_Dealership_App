import { createSlice, createAsyncThunk, PayloadAction } from '@reduxjs/toolkit';
import axios from 'axios';
import { Car} from './types';

interface CarState {
    car: Car | null;
    cars: Car[];
    status: 'idle' | 'loading' | 'succeeded' | 'failed';
    error: string | null;
}

const initialState: CarState = {
    car: null,
    cars: [],
    status: 'idle',
    error: null,
};


export const fetchAllCars = createAsyncThunk<Car[]>('fetchAllCars', async () => {
    const token = localStorage.getItem('token');
  
    if (!token) {
      throw new Error('No token found in local storage');
    }
    const response = await axios.get('http://localhost:8080/cars/catalog', {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    });
    
    return response.data;
  });

export const fetchCarById = createAsyncThunk<Car, number>('fetchCarById', async (id) => {
    const token = localStorage.getItem('token');
  
    if (!token) {
      throw new Error('No token found in local storage');
    }
    const response = await axios.get(`http://localhost:8080/cars/${id}`, {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    });
    //const response = await axios.get(`http://localhost:8080/cars/${id}`);
    return response.data;
});

export const createCar = createAsyncThunk<Car, Partial<Car>>('createCar', async (newCar) => {
    const token = localStorage.getItem('token');
  
    if (!token) {
      throw new Error('No token found in local storage');
    }
    const response = await axios.post('http://localhost:8080/cars/add', newCar,{
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    });
    //const response = await axios.post('http://localhost:8080/cars/add', newCar);
    return response.data;
});

export const updateCar = createAsyncThunk<Car, Car>('updateCar', async (updatedCar) => {
    const token = localStorage.getItem('token');
  
    if (!token) {
      throw new Error('No token found in local storage');
    }
    const response = await axios.put(`http://localhost:8080/cars/edit/${updatedCar.id}`, updatedCar,{
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    });
    //const response = await axios.put(`http://localhost:8080/cars/edit/${updatedCar.id}`, updatedCar);
    return response.data;
});

export const deleteCar = createAsyncThunk<number, number>('deleteCar', async (id) => {
    const token = localStorage.getItem('token');
  
    if (!token) {
      throw new Error('No token found in local storage');
    }
    const response = await axios.post(`http://localhost:8080/cars/delete/${id}`,{
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    });
    //await axios.delete(`http://localhost:8080/cars/delete/${id}`);
    return id;
});

const carSlice = createSlice({
    name: 'car',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder
            .addCase(fetchAllCars.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(fetchAllCars.fulfilled, (state, action: PayloadAction<Car[]>) => {
                state.status = 'succeeded';
                state.cars = action.payload;
            })
            .addCase(fetchAllCars.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.error.message || 'Failed to fetch cars';
            })
            .addCase(createCar.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(createCar.fulfilled, (state, action: PayloadAction<Car>) => {
                state.status = 'succeeded';
                state.cars.push(action.payload);
            })
            .addCase(createCar.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.error.message || 'Failed to create car';
            })
            .addCase(fetchCarById.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(fetchCarById.fulfilled, (state, action: PayloadAction<Car>) => {
                state.status = 'succeeded';
                state.car = action.payload;
            })
            .addCase(fetchCarById.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.error.message || 'Failed to fetch car details';
            })
            .addCase(updateCar.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(updateCar.fulfilled, (state, action: PayloadAction<Car>) => {
                state.status = 'succeeded';
                const index = state.cars.findIndex((car) => car.id === action.payload.id);
                if (index !== -1) {
                    state.cars[index] = action.payload;
                }
            })
            .addCase(updateCar.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.error.message || 'Failed to update car';
            })
            .addCase(deleteCar.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(deleteCar.fulfilled, (state, action: PayloadAction<number>) => {
                state.status = 'succeeded';
                state.cars = state.cars.filter((car) => car.id !== action.payload);
            })
            .addCase(deleteCar.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.error.message || 'Failed to delete car';
            });
    },
});

export default carSlice.reducer;
