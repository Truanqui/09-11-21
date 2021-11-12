import { Component } from "react";
import React from "react";
import api from "../api";
import { Link } from "react-router-dom";

class Index extends Component {
  state = {
    contatos: [],
  };

  async componentDidMount() {
    const responseContatos = await api.get("/contatos");
    this.setState({ contatos: responseContatos.data });
  }

  render() {
    const { contatos } = this.state;
    return (
      <div className="container-index">
        <Link to="/" id="botao-pagina-index">
          <button type="button" className="botao-voltar-index">
            Voltar
          </button>
        </Link>
        <div className="container-getAll">
          {console.log(contatos)}
          {contatos.map((contato) => (
            <div key={contato.id} className="box-getAll">
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
            </div>
          ))}
        </div>
      </div>
    );
  }
}
export default Index;