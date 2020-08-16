package br.edu.iftm.pdm.patrimonizador.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import br.edu.iftm.pdm.patrimonizador.R;

public abstract class DialogApagarPatrimonio extends AlertDialog.Builder {

    public DialogApagarPatrimonio(Context context) {
        super(context);
        this.setTitle(R.string.delete_patrimonio);
        this.setMessage(R.string.certeza_deletar_patrimonio);
        this.setPositiveButton(R.string.deletar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickDeletar();
            }
        });
        this.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickCancelar();
            }
        });
        this.create().show();
    }

    public abstract void onClickDeletar();
    public abstract void onClickCancelar();
}
