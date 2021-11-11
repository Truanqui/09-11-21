import React, { useState } from 'react';
import '../styles/home.css';
import api from "../api";
import {Link} from "react-router-dom";

    function Insert(){

        const [contatoName, setName] = useState("");
        const [contatoEmail, setEmail] = useState("");
        const [contatoTelefone, setTelefone] = useState("");

        const handleSubmit = (e) =>{
            e.preventDefault();
            const postContatos = {
                name: contatoName,
                email: contatoEmail,
                telefone: contatoTelefone
            }
            api.post('/contatos', postContatos).then((resp) => {
                console.log(resp);
            });
            return(
                <>
                    <form className="form-insert" onSubmit={handleSubmit}>
                        <Link to="/">
                            <button type="button" className="botao-voltar">Voltar</button>
                        </Link>
                        <ul>
                            <li>
                                <input onChange={value => setName(value.target.value)} value={contatoName} className="input-insert" type="text" placeholder="Name"></input>
                            </li>
                            <li>
                                <input onChange={value => setEmail(value.target.value)} value={contatoEmail} className="input-insert" type="text" placeholder="Email"></input>
                            </li>
                            <li>
                                <input onChange={value => setTelefone(value.target.value)} value={contatoTelefone} className="input-insert" type="text" placeholder="Telefone"></input>
                            </li>
                            <li>
                                <button id="botao-form-confirmar" type="submit" className="input-insert">Confirmar</button>
                            </li>
                        </ul>
                    </form>
                </>
            );
        }
        
    }
    export default Insert;