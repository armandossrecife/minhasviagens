package es.ufpi.br.minhasviagens.dados;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by armandosoaressousa on 29/06/17.
 */

public class RepositorioViagens {
    private List<Viagem> viagens;

    public RepositorioViagens(){
        this.viagens = new LinkedList<Viagem>();
    }

    public void insereViagem(Viagem viagem){
        viagens.add(viagem);
    }

    public Viagem buscaViagem(String destino){
        Viagem auxiliar=null;
        for(Viagem v : viagens){
            if (v.getDestino().equals(destino)){
                auxiliar = v;
            }
        }
        return auxiliar;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void populaRepositorioViagens(){
        Viagem viagem1 = new Viagem();

        viagem1.setDestino("Teresina");
        viagem1.setDataInicio("01/07/2017");
        viagem1.setDataFim("30/07/2017");
        viagem1.setDescricao("Viagem para conhecer Teresina");
        viagem1.setValor(1000.00);
        Ponto p = new Ponto("Teresina", -5.056682, -42.790264);
        viagem1.setCidade(p);

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Armando Soares Sousa");
        usuario1.setEmail("armando@ufpi.edu.br");
        usuario1.setEndereco("Rua Territorio Fernando de Noronha");
        usuario1.setSenha("123");
        usuario1.setSexo("Masculino");

        viagem1.setUsuario(usuario1);

        viagens.add(viagem1);
    }
}
