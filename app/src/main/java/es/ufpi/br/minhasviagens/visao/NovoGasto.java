package es.ufpi.br.minhasviagens.visao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.ufpi.br.minhasviagens.R;

public class NovoGasto extends AppCompatActivity {
    private Spinner spinner;
    private List<String> tipos = new ArrayList<String>();
    private int ano, mes, dia;
    private EditText dataGasto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_gasto);
        populaTiposGastos();
        exibeDataAtual();
    }

    private void populaTiposGastos() {
        //Adiciona os tipos de gastos
        tipos.add("Alimentação");
        tipos.add("Aeroporto");
        tipos.add("Hospedagem");
        tipos.add("Transporte");

        spinner = (Spinner) findViewById(R.id.spinnerTipoGasto);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipos);
        spinner.setAdapter(arrayAdapter);
    }

    private void exibeDataAtual(){
        dataGasto = (EditText) findViewById(R.id.editTextDataGasto);

        Calendar calendario = Calendar.getInstance();
        ano = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);

        dataGasto.setText(dia + "/"+ mes + "/" + ano);
    }
}
