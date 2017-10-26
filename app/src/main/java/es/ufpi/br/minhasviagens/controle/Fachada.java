package es.ufpi.br.minhasviagens.controle;

import android.app.Application;

import java.util.List;

import es.ufpi.br.minhasviagens.dados.Gasto;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.dados.Viagem;
import es.ufpi.br.minhasviagens.visao.Configuracoes;

/**
 * Created by armandosoaressousa on 26/10/17.
 */

public class Fachada extends Application{
    private static Fachada singleton=null;

    private ControladorUsuarios cu;
    private ControladorViagens cv;
    private ControladorConfiguracoes cc;
    private ControladorGastos cg;

    public Fachada() {
        cu = new ControladorUsuarios();
        cv = new ControladorViagens();
        cc = new ControladorConfiguracoes();
        cg = new ControladorGastos();
    }

    /**
     * Uso do padrão singleton para garantir que a Fachada é única para toda a aplicação
     * @return
     */
    public static Fachada getIntance(){
        if (singleton == null){
            singleton = new Fachada();
        }
        return singleton;
    }

    /*
    Insere usuário via ControladorUsuario
     */
    public void inserirUsuario(Usuario u){
        cu.inserir(u);
    }

    /*
    Faz a busca de um usuário dado um e-mail
     */
    public Usuario buscarUsuarioEmail(String email){
        return cu.carregarDadosUsuario(email);
    }

    /**
     * Popula usuários aleatórios no repositório para efeito de testes
     */
    public void populaUsuarios(){
        cu.popular();
    }

    /**
     * Lista todos os usuários cadastrados
     */
    public void listarUsuarios(){
        //TODO implementar listarUsuarios
    }

    /**
     * Altera um usuários
     * @param original dados originais
     * @param novo novos dados do usuário
     */
    public void alterarUsuario(Usuario original, Usuario novo){
        //TODO implementar alterarUsuario
    }

    /**
     * Insere uma nova viagem
     * @param v viagem
     */
    public void inserirViagem(Viagem v){

    }

    /**
     * Dado um usuário retorna todas as suas viagens cadastradas
     * @param usuario Usuarios
     * @return lista com todas as vigens do usuário
     */
    public List<Viagem> listarViagensUsario(Usuario usuario){
        return cv.listarViagens(usuario);
    }

    /**
     * Popula uma lista de viagens para efeito de testes
     */
    public void popularViagens(){
        cv.popula();
    }

    /**
     * Insere uma nova viagem de um usuário
     * @param usuario Usuário
     * @param viagem Viagem
     */
    public void novaViagem(Usuario usuario, Viagem viagem){
        cv.novaViagem(usuario, viagem);
    }

    /**
     * Insere as configurações de um usuário
     * @param c Configuração
     * @param u Usuario
     */
    public void inserirConfiguracao(Configuracoes c, Usuario u){
        //TODO implementar inserir configuraçao
    }

    /**
     * Insere os gastos do usuário em uma viagem
     * @param g Gasto
     * @param u Usuario
     * @param v Viagem
     */
    public void inserirGasto(Gasto g, Usuario u, Viagem v){
        //TODO implementar inserir gasto
    }
}