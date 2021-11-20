import { Component } from "react";
import React, { useState, useEffect } from "react";
import api from "../api";
import { Link } from "react-router-dom";

function Show() {
  const [contatos, setContato] = useState();
  const [id, setId] = useState(0);
  const [name, setNome] = useState("")
  const [telefone, setTelefone] = useState("")
  const [email, setEmail] = useState("")

  const contatosToShow = {
    idContatos: contatos,
    contatosName: name,
    contatosTelefone: telefone,
    contatosEmail: email,
  }

  const pesquisar = {
    id: id,
  };
  

  

  async function handleSubmit(e) {
    e.preventDefault();
    await pesquisa(pesquisar);
  }
  async function pesquisa(idPesquisa) {
    console.log(idPesquisa);
    const response = await api.get("/contatos/find/" + id);
    if (response.status == 200) {
      this.setContato({ contatos: response.data });
    }
  }
  return (
    <>
      <Link to="/">
        <button type="button" className="botao-voltar">
          Voltar
        </button>
      </Link>
      <form onSubmit={(e) => handleSubmit(e)}>
        Informe o ID do contato que deseja mostrar:
        <input
          type="number"
          name="id"
          onChange={(value) => setId(value.target.value)}
          value={id}
        />
        <button type="submit">Submit</button>
      </form>
      <p>
        {console.log(contatos)}
        {contatos?.map((contato) => (
          <span key={contato.id}>
            <p>
              <span>ID: </span>
              {contato.idContatos}
            </p>
            <p>
              <span>Name: </span>
              {contato.contatosName}
            </p>
            <p>
              <span>Email: </span>
              {contato.contatosEmail}
            </p>
            <p>
              <span>Telefone: </span>
              {contato.contatosTelefone}
            </p>
          </span>
        ))}
      </p>
    </>
  );
}
export default Show;
