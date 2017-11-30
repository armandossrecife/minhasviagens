package es.ufpi.br.minhasviagens;

import com.google.android.gms.maps.model.LatLng;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import es.ufpi.br.minhasviagens.controle.ControladorUsuarios;
import es.ufpi.br.minhasviagens.controle.ControladorViagens;
import es.ufpi.br.minhasviagens.dados.Ponto;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.dados.Viagem;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testaInsereUsuario(){
        ControladorUsuarios controle = new ControladorUsuarios();

        Usuario usuario = new Usuario();

        usuario.setNome("Armando");
        usuario.setEmail("armando@ufpi.edu.br");
        usuario.setEndereco("Rua Território Fernando de Noronha");
        usuario.setSenha("123");
        usuario.setSexo("masculino");

        //insere usuario
        controle.inserir(usuario);

        Usuario usuarioAux;
        //consulta usuario
        usuarioAux = controle.carregarDadosUsuario("armando@ufpi.edu.br");

        assertEquals(usuarioAux, usuario);

    }

    @Test
    public void testaInsereViagem(){
        ControladorViagens controle = new ControladorViagens();

        Viagem viagem = new Viagem();
        Ponto ponto = new Ponto();

        ponto.setLatitude(0);
        ponto.setLongitude(0);
        ponto.setNomeCidade("Teste");

        Usuario usuario = new Usuario();

        usuario.setNome("Armando");
        usuario.setEmail("armando@ufpi.edu.br");
        usuario.setEndereco("Rua Território Fernando de Noronha");
        usuario.setSenha("123");
        usuario.setSexo("masculino");

        viagem.setCidade(ponto);
        viagem.setDataFim("01/01/2017");
        viagem.setDataInicio("01/02/2017");
        viagem.setDescricao("Teste");
        viagem.setDestino("Teste");

        viagem.setValor(1000.0);

        //insere nova viagem
        controle.novaViagem(usuario, viagem);

        List<Viagem> lista = new LinkedList<Viagem>();

        //busca a viagem inserida
        lista = controle.listarViagens(usuario);

        assertEquals(lista.get(0), viagem);
    }
}