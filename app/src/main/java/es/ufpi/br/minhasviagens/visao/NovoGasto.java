package es.ufpi.br.minhasviagens.visao;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.ufpi.br.minhasviagens.R;
import es.ufpi.br.minhasviagens.utilidades.Mensagens;

public class NovoGasto extends AppCompatActivity {
    private Spinner spinner;
    private List<String> tipos = new ArrayList<String>();
    private int ano, mes, dia;
    private Button dataGasto;

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
        dataGasto = (Button) findViewById(R.id.buttonDataGasto);

        Calendar calendario = Calendar.getInstance();
        ano = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);

        dataGasto.setText(dia + "/"+ mes + "/" + ano);
    }

    public void selecionarDataGasto(View view){
        showDialog(view.getId());
    }

    protected Dialog onCreateDialog(int id){
        if (R.id.buttonDataGasto == id){
            return new DatePickerDialog(this, listener, ano, mes, dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int anoAno, int mesAno, int diaMes) {
            ano = anoAno;
            mes = mesAno;
            dia = diaMes;
            dataGasto.setText(dia +"/" + (mes+1) + "/" + ano);
       }
    };

    public void salvarGasto(View view){
        //TO DO implementar salvar gasto
        new Mensagens().mostraMensagem(this, "Salvar gasto ainda não foi implementado");
    }
}
