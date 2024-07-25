import React from "react";
import { NavLink } from "react-router-dom";

interface NavBarProps{
    role:String;
}

const NavBar:React.FC<NavBarProps>=({role})=>{
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
                <NavLink to="/">Logout</NavLink>
                </li>
            </ul>
        </nav>
    );
}
export default NavBar;