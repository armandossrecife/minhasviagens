package es.ufpi.br.minhasviagens;

/**
 * Created by armandosoaressousa on 29/11/17.
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import es.ufpi.br.minhasviagens.controle.ControladorUsuarios;
import es.ufpi.br.minhasviagens.controle.ControladorViagens;
import es.ufpi.br.minhasviagens.dados.Ponto;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.dados.Viagem;

import static org.junit.Assert.*;

public class SuiteTestes {

    @Test
    public void TesteInserirUsuario(){
        ControladorUsuarios controle = new ControladorUsuarios();

        Usuario usuario = new Usuario();

        usuario.setSexo("masculino");
        usuario.setSenha("123");
        usuario.setEmail("armando@ufpi.edu.br");
        usuario.setEndereco("teste");
        usuario.setNome("armando");

        //insere um usuário
        controle.inserir(usuario);

        Usuario usuarioAuxiliar;
        //recupera o usuário inserido
        usuarioAuxiliar =  controle.carregarDadosUsuario(usuario.getEmail());

        assertEquals(usuarioAuxiliar, usuario);
    }

    @Test
    public void TesteInserViagem(){
        ControladorViagens controle = new ControladorViagens();

        Usuario usuario = new Usuario();

        usuario.setSexo("masculino");
        usuario.setSenha("123");
        usuario.setEmail("armando@ufpi.edu.br");
        usuario.setEndereco("teste");
        usuario.setNome("armando");

        Viagem viagem = new Viagem();

        viagem.setValor(1000.0);
        viagem.setUsuario(usuario);
        viagem.setDestino("Teste");
        viagem.setDescricao("Teste");
        viagem.setDataInicio("01/01/2017");
        viagem.setDataFim("01/02/2017");

        Ponto ponto = new Ponto("teste", 0, 0);

        viagem.setCidade(ponto);

        //inserir uma viagem
        controle.novaViagem(usuario, viagem);

        //recuperar a viagem inserida
        List<Viagem> listaAuxiliar = new LinkedList<>();

        listaAuxiliar = controle.listarViagens(usuario);

        assertEquals(listaAuxiliar.get(0), viagem);
    }
}
