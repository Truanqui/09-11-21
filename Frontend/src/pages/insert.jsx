import React, { useState } from 'react';
import api from "../api";
import {Link} from "react-router-dom";

    function Insert(){

        const [name, setName] = useState("");
        const [email, setEmail] = useState("");
        const [telefone, setTelefone] = useState("");

        const handleSubmit = (e) =>{
            e.preventDefault();
            const postContatos = {
                contatosName: name,
                contatosEmail: email,
                contatosTelefone: telefone
            }
            api.post('/contatos', postContatos).then((resp) => {
                console.log(resp);

            }   );
            setName("");
            setEmail("");
            setTelefone("");      

            }
            return(
                <div className="form-insert">
                    <form onSubmit={handleSubmit}>
                        <Link to="/" id="botao-pagina-insert">
                            <button type="button" className="botao-voltar-insert">Voltar</button>
                        </Link>
                        <ul className="ul-insert">
                            <li>
                                <input name="InputName" onChange={value => setName(value.target.value)} value={name} className="input-insert" type="text" placeholder="Name"></input>
                            </li>
                            <li>
                                <input name="InputEmail" onChange={value => setEmail(value.target.value)} value={email} className="input-insert" type="text" placeholder="Email"></input>
                            </li>
                            <li>
                                <input name="InputTelefone" onChange={value => setTelefone(value.target.value)} value={telefone} className="input-insert" type="text" placeholder="Telefone"></input>
                            </li>
                            <li>
                                <button name="botao-form-confirmar" type="submit" className="input-insert">Confirmar</button>
                            </li>
                        </ul>
                    </form>
                </div>
            );
        }   
    export default Insert;