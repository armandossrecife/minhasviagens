package es.ufpi.br.minhasviagens.controle;

import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.dados.Viagem;

/**
 * Created by armandosoaressousa on 19/06/17.
 */
public class ControladorViagens {
    public void listarViagens(Usuario usuario){
        //TODO: implementar servico de listar viagens de um usuario
        System.out.println("chama o servico que lista viagens do usuario " + usuario.getNome());
    }

    public void novaViagem(Usuario usuario, Viagem viagem){
        //TODO: implementar servico de inserir uma viagem de um usuario
        System.out.println("insere nova viagem do usuario " + usuario.getNome());
    }
}
