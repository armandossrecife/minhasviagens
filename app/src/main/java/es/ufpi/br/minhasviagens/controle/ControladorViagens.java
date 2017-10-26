package es.ufpi.br.minhasviagens.controle;

import java.util.List;

import es.ufpi.br.minhasviagens.dados.RepositorioViagens;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.dados.Viagem;

/**
 * Created by armandosoaressousa on 19/06/17.
 */
public class ControladorViagens {
    private RepositorioViagens viagens;

    public ControladorViagens(){
        viagens = new RepositorioViagens();
    }

    /**
     * Lista todas as viagens cadastradas no repositorio
     * @param usuario
     * @return
     */
    public List<Viagem> listarViagens(Usuario usuario){
        System.out.println("chama o servico que lista viagens do usuario " + usuario.getNome());
        return(viagens.getViagens());
    }

    /**
     * Insere uma nova viagem
     * @param usuario dados do usuario
     * @param viagem dados da viagem
     */
    public void novaViagem(Usuario usuario, Viagem viagem){
        //TODO: implementar servico de inserir uma viagem de um usuario
        System.out.println("Implementar método nova viagem do usuario " + usuario.getNome() + "com destino " + viagem.getDestino());
        viagem.setUsuario(usuario);
        viagens.insereViagem(viagem);
    }

    public void popula(){
        viagens.populaRepositorioViagens();
    }
}
