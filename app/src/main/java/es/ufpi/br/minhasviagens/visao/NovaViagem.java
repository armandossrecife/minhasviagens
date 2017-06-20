package es.ufpi.br.minhasviagens.visao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ufpi.br.minhasviagens.R;
import es.ufpi.br.minhasviagens.controle.*;
import es.ufpi.br.minhasviagens.dados.*;

public class NovaViagem extends AppCompatActivity {
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_viagem);

        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();
        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }
        this.inserirViagem();
    }

    public void inserirViagem(){
        new ControladorViagens().novaViagem(usuario, null);
    }
}
