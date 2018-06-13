package es.ufpi.br.minhasviagens.visao;

import android.app.Activity;
import android.os.Bundle;

import es.ufpi.br.minhasviagens.R;

import es.ufpi.br.minhasviagens.dados.Ponto;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.controle.*;
import es.ufpi.br.minhasviagens.dados.Viagem;
import es.ufpi.br.minhasviagens.utilidades.Mensagens;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Tela que Lista as viagens do usuario
 */
public class ListaViagens extends Activity {
    Usuario usuario = new Usuario();
    private Bundle bundleListaPontos = new Bundle();
    private Button botao;
    private ListView listView;
    List<Viagem> viagensUsuario = new LinkedList<Viagem>();
    List<Ponto> pontosViagensUsuario = new LinkedList<Ponto>();
    private Fachada fachada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viagens);
        //Faz referência a Fachada da Aplicação
        fachada = Fachada.getIntance();
        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();

        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }

        this.listarViagens();

        listView = (ListView) findViewById(R.id.listViewViagens);
        ArrayList<String> lista = new ArrayList<String>();

        for (Viagem v : viagensUsuario){
               lista.add(v.getDestino());
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);
        //listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        botao = (Button) findViewById(R.id.buttonMapa);
        botao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                exibeMapa(view);
            }
        });
    }

    /**
     *  Exige a lista de cidades de cada viagem realizada pelo usuario
     */
    public void listarViagens(){
        //Mostra a lista de viagens na Tela
        viagensUsuario = fachada.listarViagensUsario(usuario);
        if (viagensUsuario != null){
            /**
             *
             Carrega os pontos de cada viagem List<Ponto> listaPontos
             lista de pontos (latitude, longitude) das viagens listadas
             E preciso criar um bundle para passar os pontos para o Mapa
             bundleListaPontos...
             Cada ponto corresponde a um ponto geográfico de uma cidade registrada em uma viagem
             */
            for (Viagem vu : viagensUsuario) {
                pontosViagensUsuario.add(vu.getCidade());
            }
        }
    }

    /**
     * Exibe o mapa com as cidade de cada viagem realizada do usuario
     * @param view view corrente
     */
    public void exibeMapa(View view){
        Intent intentMostraMapaViagens = new Intent(this, MapaViagens.class);
        //intentMostraViagens.putExtras(bundleListaPontos) carrega os pontos para o Mapa
        startActivity(intentMostraMapaViagens);
        //TODO garantir que o google play services foi devidamente instalado no emulador
        //exemplo para emulador genymotion https://inthecheesefactory.com/blog/how-to-install-google-services-on-genymotion/en
    }
}
