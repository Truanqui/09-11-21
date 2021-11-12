import { Component } from "react";
import React, { useState, useEffect } from "react";
import api from "../api";
import { Link } from "react-router-dom";

function Show() {
  const [contatos, setContato] = useState();
  const [search, setSearch] = useState();
  
  useEffect(() => {
    handleContato();
  }, []);

  async function handleContato() {
    const response = await api.get("/contatos");

    if (response.status !== 204) {
      setContato(response.data);
    }
  }
  async function showByEmail() {
    const response = await api.get(`/contatos/${search}`);

    if (response.status !== 204) {
      setContato(response.data);
    }
  }
 const handleSubmit = (e) =>{
    e.preventDefault();
   
}
  

  return (
    <>
      <Link to="/">
        <button type="button" className="botao-voltar">
          Voltar
        </button>
      </Link>
      <form onSubmit={handleSubmit}>
        <input
          onChange={(value) => setSearch(value.target.value)}
          value={search}
          type="text"
        />
         <button id="botao-form-confirmar" type="submit" className="input-create">Confirmar</button>
        {console.log(search)}
      </form>
      <p>
        {console.log(contatos)}
        {contatos?.map((contato) => (
          <span key={contato.id}>
            <p>
              <span>ID: </span>
              {contato.id}
            </p>
            <p>
              <span>Name: </span>
              {contato.name}
            </p>
            <p>
              <span>Email: </span>
              {contato.email}
            </p>
            <p>
              <span>Telefone: </span>
              {contato.telefone}
            </p>
          </span>
        ))}
      </p>
    </>
  );
}
export default Show;