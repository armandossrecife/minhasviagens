package es.ufpi.br.minhasviagens.dados;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by armandosoaressousa on 29/06/17.
 */

public class RepositorioUsuarios {
    private List<Usuario> usuarios;

    public RepositorioUsuarios(){
        this.usuarios = new LinkedList<Usuario>();
    }

    public void insereUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    /**
     * Busca um usuário por e-mail
     * @param email e-mail do usuário
     * @return Usuario
     */
    public Usuario buscaUsuario(String email){
        Usuario auxiliar=null;

        for (Usuario u : usuarios){
            if (u.getEmail().equals(email)){
                auxiliar = u;
                break;
            }else{
                auxiliar = null;
            }
        }
        return auxiliar;
    }

    /**
     * Lista todos os usuários cadastrados no repositório
     * @return
     */
    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    /**
     * Popula dados de usuários aleatórios para efeito de testes
     */
    public void popoulaRepositorioUsuarios(){
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Armando Soares Sousa");
        usuario1.setEmail("armando@ufpi.edu.br");
        usuario1.setEndereco("Rua Territorio Fernando de Noronha");
        usuario1.setSenha("123");
        usuario1.setSexo("Masculino");

        insereUsuario(usuario1);
    }
}