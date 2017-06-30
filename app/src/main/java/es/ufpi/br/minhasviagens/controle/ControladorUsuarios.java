package es.ufpi.br.minhasviagens.controle;

import es.ufpi.br.minhasviagens.dados.RepositorioUsuarios;
import es.ufpi.br.minhasviagens.dados.Usuario;

/**
 * Created by armandosoaressousa on 19/06/17.
 */
public class ControladorUsuarios {
    public Usuario carregaDadosUsuario(String email){
        Usuario usuario = new Usuario();

        //Recupera informacoes do repositorio ou servico de base de usuarios
        RepositorioUsuarios usuarios = new RepositorioUsuarios();
        usuarios.popoulaRepositorioUsuarios();
        usuario = usuarios.buscaUsuario(email);

        if (usuario != null){
            return usuario;
        }else {
            String mensagem="Usuario não existe!";
            System.out.println(mensagem);
            return null;
        }
    }
}
