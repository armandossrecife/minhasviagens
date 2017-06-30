package es.ufpi.br.minhasviagens.dados;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by armandosoaressousa on 29/06/17.
 */

public class Ponto {
    LatLng pontoGeografico;
    String nomeCidade;
    double latitude;
    double longitude;

    public Ponto(String nomeCidade, double latitude, double logintude){
        pontoGeografico = new LatLng(latitude, logintude);
        this.nomeCidade = nomeCidade;
    }

    public LatLng getPontoGeografico() {
        return pontoGeografico;
    }

    public void setPontoGeografico(LatLng pontoGeografico) {
        this.pontoGeografico = pontoGeografico;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}