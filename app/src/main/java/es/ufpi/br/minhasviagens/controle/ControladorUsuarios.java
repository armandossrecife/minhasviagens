package es.ufpi.br.minhasviagens.controle;

import es.ufpi.br.minhasviagens.dados.Usuario;

/**
 * Created by armandosoaressousa on 19/06/17.
 */
public class ControladorUsuarios {
    public Usuario carregaDadosUsuario(String email){
        //TODO: implementar servico de busca de usuario por email
        Usuario usuario = new Usuario();
        //Procurar usuario...
        //se usuario existe
        if (email.equals("armando@ufpi.edu.br")){
            usuario.setNome("Armando Soares Sousa");
            usuario.setEmail("armando@ufpi.edu.br");
            usuario.setEndereco("Rua Territorio Fernando de Noronha");
            usuario.setSenha("123");
            usuario.setSexo("Masculino");
        }else {
            String mensagem="Usuario não existe!";
            System.out.println(mensagem);
            return null;
        }
        return usuario;
    }
}
