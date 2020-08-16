package br.edu.iftm.pdm.patrimonizador.ui.list_builders;

import android.content.Context;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.list_adapters.PatrimonioAdapter;

public class PatrimonioListBuilder {

    // TODO -- Preste atenção em como esta classe foi implementada

    private Context context;
    private RecyclerView rvPatrimonio;
    private ArrayList<Patrimonio> patrimonios;
    private LinearLayoutManager linearLayoutManager;
    private PatrimonioAdapter patrimonioAdapter;

    public PatrimonioListBuilder(Context context, RecyclerView rvPatrimonio,
                                 ArrayList<Patrimonio> patrimonios) {
        this.context = context;
        this.rvPatrimonio = rvPatrimonio;
        this.patrimonios = patrimonios;
    }

    public void load() {
        this.linearLayoutManager = new LinearLayoutManager(this.context);
        this.patrimonioAdapter = new PatrimonioAdapter(this.patrimonios);
        this.rvPatrimonio.setLayoutManager(this.linearLayoutManager);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this.context,
                this.linearLayoutManager.getOrientation());
        this.rvPatrimonio.addItemDecoration(itemDecoration);
        this.rvPatrimonio.setAdapter(this.patrimonioAdapter);
    }

    public PatrimonioAdapter getAdapter() {
        return this.patrimonioAdapter;
    }

    public void atualizaListaInsercao(Patrimonio patrimonio) {
        this.patrimonioAdapter.insereNovoPatrimonio(patrimonio);
    }

    public void atualizaListaUpdateEstado(int posicao) {
        this.patrimonioAdapter.notifyItemChanged(posicao);
    }

    public ArrayList<Long> deletarPatrimoniosSelectionados() {
        return this.patrimonioAdapter.removePatrimoniosSelecionados();
    }
}
