import React from "react";
import { NavLink ,useNavigate} from "react-router-dom";

interface NavBarProps{
    role:String;
}

const NavBar:React.FC<NavBarProps>=({role})=>{
    const navigate=useNavigate();

    const handleLogout=()=>{
        localStorage.removeItem('token');
        localStorage.removeItem('role');
        navigate('/signin');
    }
    return(
        <nav className="navbar">
            <ul className="navbar_list">
                <li>
                    <NavLink to='/home'>Home</NavLink>
                </li>
                <li>
                    <NavLink to='/catalog'>Car Catalog</NavLink>
                </li>
                {role==='[ROLE_ADMIN]' && (
                    <>
                <li>
                    <NavLink to='/add'>Add Car</NavLink>
                </li>
                <li>
                    <NavLink to='/edit'>Edit Catalog</NavLink>
                </li>
                </>
                )}
                <li>
                    <NavLink to='/search/:id'>Search here</NavLink>
                </li>
                <li>
                    <button onClick={handleLogout} >
                        Logout
                    </button>
                
                </li>
            </ul>
        </nav>
    );
}
export default NavBar;