import React, { useState, useEffect } from "react";
import api from "../api";
import { Link } from "react-router-dom";

function Delete() {
  const [id, setId] = useState();

  useEffect(() => {
    handleContato();
  }, []);

  async function handleContato() {
    const response = await api.delete("/contatos/delete/"+id);
    console.log(id);
    if (response.status == 200) {
        alert("Contatoo deleted");
    } else {
        alert("Error");
    }
  }
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(id);
    setId("");
  };

  return (
    <div className="container-delete">
      <div >
        <Link to="/" id="botao-pagina-delete">
          <button type="button" className="botao-voltar-delete">
            Voltar
          </button>
        </Link>
        <form onSubmit={handleContato} className="flex-delete">
          <input
            onChange={(value) => setId(value.target.value)}
            value={id}
            type="text"
            className="input-create"
            id="input-delete"
          />
          <button id="botao-form-submit-delete" type="submit" className="input-insert">
            Submit
          </button>
        </form>
      </div>
    </div>
  );
}
export default Delete;