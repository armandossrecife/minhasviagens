package es.ufpi.br.minhasviagens.visao;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import es.ufpi.br.minhasviagens.R;
import es.ufpi.br.minhasviagens.dados.Ponto;
import es.ufpi.br.minhasviagens.utilidades.Mensagens;

/**
 * Tela que carrega um Mapa com as cidades de cada viagem realizada
 */
public class MapaViagens extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_mapa_viagens);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }catch (Exception e){
            String mensagem="Erro: " + e.getMessage();
            new Mensagens().mostraMensagem(this, mensagem);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        try {
            Ponto teresina = new Ponto("Teresina", -5.056682, -42.790264);

            //cria os marcadores de cada ponto
            mMap.addMarker(new MarkerOptions().position(teresina.getPontoGeografico()).title(teresina.getNomeCidade()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(teresina.getPontoGeografico()));
        }catch (Exception e){
            String mensagem="Erro: " + e.getMessage();
            new Mensagens().mostraMensagem(this, mensagem);
        }
    }
}
