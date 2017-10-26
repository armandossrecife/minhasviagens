package es.ufpi.br.minhasviagens.visao;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import es.ufpi.br.minhasviagens.R;
import es.ufpi.br.minhasviagens.controle.Fachada;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.utilidades.Mensagens;

/**
 * Tela Principal que mostra as opcoes da aplicacao
 */
public class Dashboard extends AppCompatActivity {
    private Usuario usuario = new Usuario();
    private Bundle bundleUsuario = new Bundle();
    private Fachada fachada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        //Faz referência a Fachada da aplicação
        fachada = Fachada.getIntance();
        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }
        //carrega o bundle de Usuario para passar dados entre as Activities
        bundleUsuario.putString("nomeUsuario", usuario.getNome());
        bundleUsuario.putString("emailUsuario", usuario.getEmail());
    }

    @Override
    public void onBackPressed() {
        String mensagem="Usuário " + usuario.getNome().toString() + " já logado";
        new Mensagens().mostraMensagem(this, mensagem);
    }

    //listarViagens
    public void listarViagens(View v){
        //chama a Tela de listar viagens ja registradas
        Intent intentListarViagens = new Intent(this, ListaViagens.class);
        intentListarViagens.putExtras(bundleUsuario);
        //carrega a tela principal e passa dados do Usuario
        startActivity(intentListarViagens);
    }

    //inserirViagem
    public void inserirViagem(View v){
        //chama a Tela de inserir uma nova viagem
        // pode ser viagem de lazer ou de negocios
        Intent intentInserirViagens = new Intent(this, NovaViagem.class);
        intentInserirViagens.putExtras(bundleUsuario);
        //carrega a tela principal e passa dados do Usuario
        startActivity(intentInserirViagens);
    }

    //inserirGasto
    public void inserirGasto(View v){
        //Chama a Tela NovoGasto
        Intent intentNovoGasto = new Intent(this, NovoGasto.class);
        intentNovoGasto.putExtras(bundleUsuario);
        startActivity(intentNovoGasto);
    }

    //fazConfiguracoes
    public void fazConfiguracoes(View v){
        // TODO: chama a tela que faz a configuracao do aplicativo
        // as configuracoes sao locais
    }

    /**
     * Tela que exibe detalhes sobre a aplicacao
     * @param v view corrente
     */
    public void sobre(View v){
        Intent intentSobre = new Intent(this,Sobre.class);
        startActivity(intentSobre);
    }
}