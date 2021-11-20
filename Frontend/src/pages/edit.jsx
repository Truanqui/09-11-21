import { useState } from "react";
import api from '../api'

export default function Edit() {

    const [contatos, setId] = useState(0)
    const [name, setNome] = useState("")
    const [telefone, setTelefone] = useState("")
    const [email, setEmail] = useState("")

    const toEdit = {
      idContatos: contatos,
      contatosName: name,
      contatosTelefone: telefone,
      contatosEmail: email,

    }

    async function handleSubmit(e) {
        e.preventDefault();
        await edit(toEdit);
      }
    
      async function edit(toEdit) {
        const response = await api.put("contatos/edit/" + contatos, toEdit)
    
        if (response.status == 200) {
          alert("Contato editado com Sucesso!")
        } else {
          alert("Ocorreu um erro")
        }
      }

      return (
        <div className="upadate-page">
          <div>
            <h2>Editando Contato</h2>
          </div>
          <form onSubmit={(e) => handleSubmit(e)}>
            <div className="update-form">
              <label>Nome:</label>
              <input type="text" name="nome" onChange={value => setNome(value.target.value)} value={name} />

              <label>Telefone:</label>
              <input type="text" name="telefone" onChange={value => setTelefone(value.target.value)} value={telefone} />
    
              <label>Email:</label>
              <input type="text" name="email" onChange={value => setEmail(value.target.value)} value={email} />
              
              <label>id</label>
              <input type="number" name="id" onChange={value => setId(value.target.value)} value={contatos} />
              <button type="submit" value="Editar">Confirmar</button>
            </div>
          </form>
        </div>
    
      );
    }
