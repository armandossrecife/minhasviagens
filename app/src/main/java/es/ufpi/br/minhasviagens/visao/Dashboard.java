package es.ufpi.br.minhasviagens.visao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import es.ufpi.br.minhasviagens.R;
import es.ufpi.br.minhasviagens.dados.Usuario;

public class Dashboard extends AppCompatActivity {
    private Usuario usuario = new Usuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }

    }

    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(this, "Usuário já logado!", Toast.LENGTH_SHORT);
    }

    //listarViagens
    public void listarViagens(View v){
        //chama a Tela de listar viagens ja registradas
        Bundle bundle = new Bundle();
        bundle.putString("nomeUsuario", usuario.getNome());
        bundle.putString("emailUsuario", usuario.getEmail());
        Intent intentListarViagens = new Intent(this, ListaViagens.class);
        intentListarViagens.putExtras(bundle);
        //carrega a tela principal e passa dados do Usuario
        startActivity(intentListarViagens);
    }

    //inserirViagem
    public void inserirViagem(View v){
        //chama a Tela de inserir uma nova viagem
        // pode ser viagem de lazer ou de negocios
        Bundle bundle = new Bundle();
        bundle.putString("nomeUsuario", usuario.getNome());
        bundle.putString("emailUsuario", usuario.getEmail());
        Intent intentInserirViagens = new Intent(this, NovaViagem.class);
        intentInserirViagens.putExtras(bundle);
        //carrega a tela principal e passa dados do Usuario
        startActivity(intentInserirViagens);
    }

    //inserirGasto
    public void inserirGasto(View v){
        // TODO: chama a Tela de inserir um gasto de acordo com uma categoria (refeicao, combustivel, cinema, ...)
    }

    //fazConfiguracoes
    public void fazConfiguracoes(View v){
        // TODO: chama a tela que faz a configuracao do aplicativo
        // as configuracoes sao locais
    }

    public void sobre(View v){
        // TODO: chama a tela sobre a aplicacao
    }
}
