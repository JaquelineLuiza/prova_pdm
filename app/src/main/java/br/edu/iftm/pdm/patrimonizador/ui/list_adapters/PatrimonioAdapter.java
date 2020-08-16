package br.edu.iftm.pdm.patrimonizador.ui.list_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;

import br.edu.iftm.pdm.patrimonizador.R;
import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;

public class PatrimonioAdapter extends RecyclerView.Adapter<PatrimonioViewHolder> {

    // TODO -- Observe com bastante atenção como esta classe funciona, bem como sua view holder

    private ArrayList<ItemList<Patrimonio>> patrimonios;
    protected OnClickPatrimonioListener listener;
    protected SelectionNotifier selectionNotifier;
    protected int nSelected;

    public interface OnClickPatrimonioListener {
        void onClickDetalhar(Patrimonio patrimonio);
        void onClickEditar(Patrimonio patrimonio, int pos);
    }

    public interface SelectionNotifier {
        void notifySelection(int nSelected);
        void notifyClearSelection();
    }

    public PatrimonioAdapter(ArrayList<Patrimonio> patrimonios) {
        this.patrimonios = new ArrayList<>();
        this.nSelected = 0;
        // TODO (20) Transforme patrimonios em uma Lista de ItemList;
    }

    public void setOnClickPatrimonioListener(OnClickPatrimonioListener listener) {
        this.listener = listener;
    }

    public void setSelectionNotifier(SelectionNotifier selectionNotifier) {
        this.selectionNotifier = selectionNotifier;
    }

    @NonNull
    @Override
    public PatrimonioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO (21) Crie as ViewHolders observando bem os dados que são requisitados pelo
        // construtor do PatrimonioViewHolder
        //apague a linha abaixo quando fizer a modificação deste método
        return new PatrimonioViewHolder(new TextView(parent.getContext()), this);
    }

    @Override
    public void onBindViewHolder(@NonNull PatrimonioViewHolder holder, int position) {
        holder.bind(this.patrimonios.get(position));
    }

    @Override
    public int getItemCount() {
        return this.patrimonios.size();
    }

    // Métodos auxiliares

    public void insereNovoPatrimonio(Patrimonio patrimonio) {
        // TODO (22) Insira o patrimônio na lista e atualize a lista com o novo patrimônio inserido.
    }

    public ArrayList<Long> removePatrimoniosSelecionados() {
        //TODO (23) Remova todos os patrimonios selecionados e retorne uma lista contendo
        // os ids dos patrimonios removidos
        return null;
    }
}
