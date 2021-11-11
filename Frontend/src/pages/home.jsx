import React from 'react';
import '../styles/home.css';
import {Link} from "react-router-dom";

    function Home(){
        return(
           <>
                <section className="container-home-menu" >
                    <ul>
                        <li>
                            <!--Index-->
                            <Link to="index">
                                <button id="botao-index" type="button" className="botao-home-menu">Index</button>
                            </Link>  
                        </li>
                        <li>
                            <!--Show-->
                            <Link to="show">
                                <button id="botao-show" type="button" className="botao-home-menu">Show</button>
                            </Link> 
                        </li>
                        <li>
                            <!--Create = insert-->
                            <Link to="/insert">
                                <button id="botao-insert" type="button" className="botao-home-menu">Insert</button>
                            </Link>
                        </li>
                        <li>
                            <!--Edit = Update-->
                            <Link to="/update">
                            <button id="botao-update" type="button" className="botao-home-menu">Edit</button>
                            </Link>
                        </li>
                        <li>
                            <!--Delete-->
                            <Link to="delete">
                                <button id="botao-delete"type="button" className="botao-home-menu">Delete</button>
                            </Link>
                        </li>
                    </ul>
                </section>
            </>
        )
    }
    export default Home;