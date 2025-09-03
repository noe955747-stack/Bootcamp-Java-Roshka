import React from "react";
import "./../stylesheets/navegacion.css"
const BarraNav : React.FC = () =>{
    return(
        <nav className={"navegacion"}>
            <img src={"./../assets/react.svg"} alt={"logo"}/>
            <ul>
                <li><a>Product</a></li>
                <li><a>Resources</a></li>
                <li><a>About us</a></li>
                <li><a>Contact us</a></li>
            </ul>
        </nav>
    )
}

export default BarraNav;