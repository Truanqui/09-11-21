import { useState } from "react"
import api from '../api'

export default function Delete() {
    const [id, setId] = useState(0)

    const deletar = {
        id: id
    }

    async function handleSubmit(e) {
        e.preventDefault();
        await cadastrar(deletar);
    }

    async function cadastrar(deletar) {
        console.log(deletar);
        const response = await api.delete(
            '/contatos/delete/'+id,
            deletar
        )
        console.log(response.status);
        if (response.status === 200) {
            alert("Contato deletado com sucesso!")
        } else {
            alert("Contato não encontrado")
        }
    }
    
    return(
        <>
            <form onSubmit={(e) => handleSubmit(e)}>
                    Informe o ID do contato que deseja deletar:
                    <input type="number" name="id" onChange={value => setId(value.target.value)} value={id} />
                    <button type="submit" >Submit</button>
            </form>
        </>
    )
}