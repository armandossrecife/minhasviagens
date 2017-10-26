package es.ufpi.br.minhasviagens.visao;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import es.ufpi.br.minhasviagens.R;
import es.ufpi.br.minhasviagens.controle.*;
import es.ufpi.br.minhasviagens.dados.*;
import es.ufpi.br.minhasviagens.utilidades.Mensagens;

public class NovaViagem extends AppCompatActivity {
    Usuario usuario = new Usuario();
    Button botaoDataEntrada;
    Button botaoDataSaida;
    int ano, mes, dia;
    EditText destino, orcamento, quantidadePessoas;
    RadioButton lazer, negocios;
    Fachada fachada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_viagem);
        //faz referência a Fachada da Aplicação
        fachada = Fachada.getIntance();
        //pega dados do usuario corrente da aplicacao
        Bundle dadosUsuario = getIntent().getExtras();

        if (dadosUsuario != null){
            usuario.setNome(dadosUsuario.getString("nomeUsuario"));
            usuario.setEmail(dadosUsuario.getString("emailUsuario"));
        }

        destino = (EditText) findViewById(R.id.editTextDestino);
        orcamento = (EditText) findViewById(R.id.editTextValorOrcamento);
        quantidadePessoas = (EditText) findViewById(R.id.editTextQuantidadePessoas);
        lazer = (RadioButton) findViewById(R.id.radioLazer);
        negocios = (RadioButton) findViewById(R.id.radioNegocios);

        exibeDataAtual();
    }

    /**
     * Carrega a data atual nos campos de data de entrada e saida
     */
    public void exibeDataAtual(){
        botaoDataEntrada = (Button) findViewById(R.id.buttonDataEntrada);
        botaoDataSaida = (Button) findViewById(R.id.buttonDataSaida);

        Calendar calendario = Calendar.getInstance();
        ano = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);

        botaoDataEntrada.setText(dia + "/"+ mes + "/" + ano);
        botaoDataSaida.setText(dia + "/"+ mes + "/" + ano);
    }

    /**
     * Seleciona a data de entrada via DatePickerDialog
     * @param view view atual
     */
    public void selecionarDataEntrada(View view){
        showDialog(view.getId());
    }

    /**
     * Seleciona a data de saida via DatePickerDialog
     * @param view
     */
    public void selecionarDataSaida(View view){
        showDialog(view.getId());
    }

    /**
     * DatePickerDialog da data de entrada ou saida
     * @param id botao selecionado
     * @return nova data selecionada
     */
    protected Dialog onCreateDialog(int id){
        if (R.id.buttonDataEntrada == id){
            return new DatePickerDialog(this, listener, ano, mes, dia);
        }
        if (R.id.buttonDataSaida == id){
            return  new DatePickerDialog(this, listener2, ano, mes, dia);
        }
        return null;
    }

    /**
     * Listener do datepicker de data de entrada
     */
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int anoAno, int mesAno, int diaMes) {
            ano = anoAno;
            mes = mesAno;
            dia = diaMes;
            botaoDataEntrada.setText(dia +"/" + (mes+1) + "/" + ano);
        }
    };

    /**
     * Listener do datepicker de data de saida
     */
    private DatePickerDialog.OnDateSetListener listener2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int anoAno, int mesAno, int diaMes) {
            ano = anoAno;
            mes = mesAno;
            dia = diaMes;
            botaoDataSaida.setText(dia +"/" + (mes+1) + "/" + ano);
        }
    };

    /**
     * Salva uma nova viagem do usuario
     * @param view view corrente
     */
    public void criarNovaViagem(View view){
        Date dataInicio;
        Date dataFinal;
        String inicio = botaoDataEntrada.getText().toString();
        String fim = botaoDataSaida.getText().toString();
        Viagem viagem = new Viagem();

        try{
            viagem.setUsuario(usuario);
            String valorOrcamento = orcamento.getText().toString();
            viagem.setValor(Double.valueOf(valorOrcamento));
            viagem.setDataInicio(inicio);
            viagem.setDataFim(fim);
            viagem.setDescricao(destino.getText().toString());
            viagem.setDestino(destino.getText().toString());
            viagem.setCidade(null); //TODO pegar o ponto geográfico da cidade
            try{
                String padrao = "dd/MM/yyyy";
                SimpleDateFormat formato = new SimpleDateFormat(padrao);
                dataInicio = formato.parse(inicio);
                dataFinal = formato.parse(fim);

                if (checaDataInicioFim(dataInicio, dataFinal)){
                    inserirViagem(viagem);
                    new Mensagens().mostraMensagem(this, "Viagem destino " + viagem.getDestino() + " cadastrada com sucesso!");
                    limparCampos();
                }else{
                    new Mensagens().mostraMensagem(this, "Data de início > Data de fim");
                }
            }catch (ParseException pe){
                new Mensagens().mostraMensagem(this, "Erro de data" + pe.getMessage());
            }
        }catch (Exception ex){
            new Mensagens().mostraMensagem(this, "Erro ao inserir viagem!" + ex.getMessage());
        }
    }

    /**
     * Insere uma nova viagem
     */
    public void inserirViagem(Viagem viagem){
        fachada.novaViagem(usuario, viagem);
    }

    /**
     * Verifica se a data de final e maior que a data inicial
     * @param dataInicial inicio da viagem
     * @param dataFinal final da viagem
     * @return true se a final > inicio
     */
    public boolean checaDataInicioFim(Date dataInicial, Date dataFinal){
        if (dataFinal.after(dataInicial)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Reseta os campos do formulario
     */
    public void limparCampos(){
        destino.setText("");
        orcamento.setText("");
        quantidadePessoas.setText("");
        exibeDataAtual();
        destino.setFocusable(true);
        destino.requestFocus();
    }
}