package es.ufpi.br.minhasviagens.visao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.ufpi.br.minhasviagens.R;
import es.ufpi.br.minhasviagens.controle.ControladorUsuarios;
import es.ufpi.br.minhasviagens.controle.Fachada;
import es.ufpi.br.minhasviagens.dados.Usuario;
import es.ufpi.br.minhasviagens.utilidades.Mensagens;

/**
 * Classe que implementa a Tela de Login da Aplicacao
 */
public class Login extends Activity {
    private EditText usuario;
    private EditText senha;
    private Fachada fachada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //instacia e inicializa a Fachada única da aplicação
        fachada = new Fachada();

        //carrega o conteudo dos editText
        usuario = (EditText)findViewById(R.id.editTextEmail);
        senha = (EditText) findViewById(R.id.editTextSenha);
    }

    /**
     * Dadas informacoes de uma view executa o login
     * @param v view corrente
     */
    public void login(View v) {
        String usuarioInformado = usuario.getText().toString();
        String senhaInformada = senha.getText().toString();
        //tratar excecao de erro de conexao ou qualquer outra excecao
        try {
            fachada.populaUsuarios(); //Para efeito de testes //TODO remover quando tiver com acesso real ao serviço de dados dos usuários
            Usuario usuario = fachada.buscarUsuarioEmail(usuarioInformado);
            //verifica os dados do usuario
            if (usuario != null){
                if (usuarioInformado.equals(usuario.getEmail()) && senhaInformada.equals(usuario.getSenha())) {
                    //chama servico de verificacao de credenciais (checarCredenciais)
                    //cria um bundle para enviar informacoes das credenciais do usuario
                    Bundle bundle = new Bundle();
                    bundle.putString("nomeUsuario", usuario.getNome());
                    bundle.putString("emailUsuario", usuario.getEmail());
                    Intent intent = new Intent(this, Dashboard.class);
                    intent.putExtras(bundle);
                    //carrega a tela principal e passa dados do Usuario
                    startActivity(intent);
                }else {
                    //erro de autenticacao
                    String mensagemErroAutenticacao = "Erro de autenticação";
                    new Mensagens().mostraMensagem(this, mensagemErroAutenticacao);
                    limpaCamposEntrada();
                }
            }else {
                //erro de autenticacao
                String mensagemErroAutenticacao = "Usuario não existe!";
                new Mensagens().mostraMensagem(this, mensagemErroAutenticacao);
                limpaCamposEntrada();
            }
        } catch (Exception ex) {
            new Mensagens().mostraMensagem(this, ex.getMessage());
            limpaCamposEntrada();
        }
    }

    /**
     * Chama a tela e servico de recuperacao de senha
     * @param view
     */
    public void esqueciSenha(View view){
        //TODO: metodo nao implementado
        //sugestao: mostrar uma tela pedindo o e-mail e depois dispara um servico passando a senha para o e-mail passado.
        String mensagem = "Método não implementado";
        new Mensagens().mostraMensagem(this, mensagem);
    }

    /**
     * Limpa os campos de usuario e senha da tela corrente
     */
    public void limpaCamposEntrada(){
        usuario.setText("");
        senha.setText("");
    }

}