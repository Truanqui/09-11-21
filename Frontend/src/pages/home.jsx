import React from 'react';
import {Link} from "react-router-dom";

    function Home(){
        return(
           <>
                <section className="container-home-menu" >
                    <ul>
                        <li>
                            
                            <Link to="/index">
                                <button id="botao-index" type="button" className="botao-home-menu">Index</button>
                            </Link>  
                        </li>
                        <li>
                           
                            <Link to="/show">
                                <button id="botao-show" type="button" className="botao-home-menu">Show</button>
                            </Link> 
                        </li>
                        <li>
                            
                            <Link to="/contatos">
                                <button id="botao-insert" type="button" className="botao-home-menu">Insert</button>
                            </Link>
                        </li>
                        <li>
                            
                            <Link to="/edit">
                            <button id="botao-edit" type="button" className="botao-home-menu">Edit</button>
                            </Link>
                        </li>
                        <li>
                            
                            <Link to="/delete">
                                <button id="botao-delete"type="button" className="botao-home-menu">Delete</button>
                            </Link>
                        </li>
                    </ul>
                </section>
            </>
        )
    }
    export default Home;