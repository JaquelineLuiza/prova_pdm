package br.edu.iftm.pdm.patrimonizador.ui.list_builders;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.iftm.pdm.patrimonizador.ui.list_adapters.ImagemAdapter;

public class ImagemListBuilder {

    // TODO -- Preste atenção em como esta classe foi implementada

    private Context context;
    private RecyclerView rvImagens;
    private ArrayList<String> pathImagens;
    private LinearLayoutManager linearLayoutManager;
    private ImagemAdapter imagemAdapter;

    public ImagemListBuilder(Context context, RecyclerView rvImagens, ArrayList<String> pathImagens) {
        this.context = context;
        this.rvImagens = rvImagens;
        this.pathImagens = pathImagens;
    }

    public void load() {
        this.linearLayoutManager = new LinearLayoutManager(this.context,
                RecyclerView.HORIZONTAL, false);
        this.imagemAdapter = new ImagemAdapter(this.pathImagens);
        this.rvImagens.setLayoutManager(this.linearLayoutManager);
        this.rvImagens.setAdapter(this.imagemAdapter);
    }

    public void notificaNovaImagemInseridaNoFinal() {
        this.imagemAdapter.notifyItemInserted(this.pathImagens.size() - 1);
    }
}
