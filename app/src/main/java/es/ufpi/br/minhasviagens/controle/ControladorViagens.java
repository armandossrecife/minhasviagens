package es.ufpi.br.minhasviagens.controle;

import java.util.List;

import es.ufpi.br.minhasviagens.dados.RepositorioViagens;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.dados.Viagem;

/**
 * Created by armandosoaressousa on 19/06/17.
 */
public class ControladorViagens {
    public List<Viagem> listarViagens(Usuario usuario){
        System.out.println("chama o servico que lista viagens do usuario " + usuario.getNome());

        RepositorioViagens viagens = new RepositorioViagens();
        viagens.populaRepositorioViagens();
        return(viagens.getViagens());
    }

    public void novaViagem(Usuario usuario, Viagem viagem){
        //TODO: implementar servico de inserir uma viagem de um usuario
        System.out.println("Salva nova viagem do usuario " + usuario.getNome() + "com destino " + viagem.getDestino());
    }
}
