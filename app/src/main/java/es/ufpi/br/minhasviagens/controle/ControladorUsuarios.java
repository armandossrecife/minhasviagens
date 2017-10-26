package es.ufpi.br.minhasviagens.controle;

import es.ufpi.br.minhasviagens.dados.RepositorioUsuarios;
import es.ufpi.br.minhasviagens.dados.Usuario;

/**
 * Created by armandosoaressousa on 19/06/17.
 */
public class ControladorUsuarios {
    private RepositorioUsuarios usuarios;

    public ControladorUsuarios(){
        usuarios = new RepositorioUsuarios();
    }

    /**
     * Dado um email retorna os dados do usuario
     * @param email email do usuario
     * @return usuario
     */
    public Usuario carregarDadosUsuario(String email){
        Usuario usuario = new Usuario();

        //Recupera informacoes do repositorio ou servico de base de usuarios
        usuario = usuarios.buscaUsuario(email);

        if (usuario != null){
            return usuario;
        }else {
            return null;
        }
    }

    /**
     * Insere um novo usuario
     * @param u dados do usuario
     */
    public void inserir(Usuario u){
        usuarios.insereUsuario(u);
    }

    /**
     * Popula dados aleatórios de usuários
     */
    public void popular(){
        usuarios.popoulaRepositorioUsuarios();
    }
}
