import React, { useState } from 'react';
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

            }   );
            setName("");
            setEmail("");
            setTelefone("");      

            }
            return(
                <div className="form-create">
                    <form onSubmit={handleSubmit}>
                        <Link to="/" id="botao-pagina-insert">
                            <button type="button" className="botao-voltar-insert">Voltar</button>
                        </Link>
                        <ul className="ul-create">
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
                                <button name="botao-form-confirmar-insert" type="submit" className="input-insert">Confirmar</button>
                            </li>
                        </ul>
                    </form>
                </div>
            );
        }
        
    }
    export default Insert;