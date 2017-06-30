package es.ufpi.br.minhasviagens.utilidades;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by armandosoaressousa on 29/06/17.
 */

public class Mensagens {
    /**
     * Mostra uma mensagem ao usuario baseado em um Toast
     * @param mensagem conteudo da mensagem
     */
    public void mostraMensagem(Context context, String mensagem) {
        Toast toast = Toast.makeText(context, mensagem, Toast.LENGTH_LONG);
        toast.show();
    }
}
