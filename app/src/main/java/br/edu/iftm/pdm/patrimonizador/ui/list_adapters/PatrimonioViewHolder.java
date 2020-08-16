package br.edu.iftm.pdm.patrimonizador.ui.list_adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import br.edu.iftm.pdm.patrimonizador.R;
import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;

public class PatrimonioViewHolder extends RecyclerView.ViewHolder
                            implements View.OnClickListener, View.OnLongClickListener {

    private TextView txtResumo;
    private TextView txtEstado;
    private ImageView imgEditar;
    private ItemList<Patrimonio> patrimonioAtual;
    private PatrimonioAdapter patrimonioAdapter;
    private int posAtual;

    public PatrimonioViewHolder(@NonNull View itemView, PatrimonioAdapter patrimonioAdapter) {
        super(itemView);
        this.txtResumo = this.itemView.findViewById(R.id.txtResumo);
        this.txtEstado = this.itemView.findViewById(R.id.txtEstado);
        this.imgEditar = this.itemView.findViewById(R.id.imgEditar);
        this.patrimonioAdapter = patrimonioAdapter;
        this.itemView.setOnClickListener(this);
        this.itemView.setOnLongClickListener(this);
        this.imgEditar.setOnClickListener(this);
    }

    public void bind(ItemList<Patrimonio> patrimonioItemList) {
        // TODO (24) Crie aqui a reciclagem dos dados.
    }

    @Override
    public void onClick(View v) {
        if(this.patrimonioAdapter.listener != null) {
            if (v.getId() == this.imgEditar.getId()) {
                this.patrimonioAdapter.listener.onClickEditar(this.patrimonioAtual.item,
                        this.posAtual);
            }
            else {
                this.patrimonioAdapter.listener.onClickDetalhar(this.patrimonioAtual.item);
            }
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(this.patrimonioAdapter.selectionNotifier != null) {
            this.patrimonioAtual.isSelected = !this.patrimonioAtual.isSelected;
            v.setSelected(this.patrimonioAtual.isSelected);
            if(this.patrimonioAtual.isSelected) {
                this.patrimonioAdapter.nSelected++;
                this.patrimonioAdapter.selectionNotifier.notifySelection(this.patrimonioAdapter.nSelected);
            }
            else {
                this.patrimonioAdapter.nSelected--;
                this.patrimonioAdapter.selectionNotifier.notifySelection(this.patrimonioAdapter.nSelected);
                if(this.patrimonioAdapter.nSelected < 1) {
                    this.patrimonioAdapter.selectionNotifier.notifyClearSelection();
                }
            }
            return true;
        }
        return false;
    }
}