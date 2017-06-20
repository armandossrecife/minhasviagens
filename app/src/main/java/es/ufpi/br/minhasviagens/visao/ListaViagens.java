package es.ufpi.br.minhasviagens.visao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ufpi.br.minhasviagens.R;

import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.controle.*;

public class ListaViagens extends AppCompatActivity {
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viagens);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }
        this.listarViagens();
    }

    public void listarViagens(){
        new ControladorViagens().listarViagens(usuario);
    }
}
