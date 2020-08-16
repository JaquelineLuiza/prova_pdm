package br.edu.iftm.pdm.patrimonizador.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import br.edu.iftm.pdm.patrimonizador.R;

public abstract class DialogEditarPatrimonio extends AlertDialog.Builder {

    private Spinner spinEditEstado;

    public DialogEditarPatrimonio(Context context) {
        super(context);
        this.setTitle(R.string.edit_estado);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_editar, null);
        this.setView(view);
        this.spinEditEstado = view.findViewById(R.id.spinEditEstado);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                context, R.array.estados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinEditEstado.setAdapter(adapter);
        this.setPositiveButton(R.string.aplicar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickAplicar(spinEditEstado.getSelectedItem().toString());
            }
        });
        this.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onClickCancel();
            }
        });
        this.create().show();
    }

    public abstract void onClickAplicar(String estadoSelecionado);
    public abstract void onClickCancel();
}
