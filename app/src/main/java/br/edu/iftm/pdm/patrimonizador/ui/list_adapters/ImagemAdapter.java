package br.edu.iftm.pdm.patrimonizador.ui.list_adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.edu.iftm.pdm.patrimonizador.R;

public class ImagemAdapter extends RecyclerView.Adapter<ImagemViewHolder> {

    private ArrayList<String> imagens;

    public ImagemAdapter(ArrayList<String> imagens) {
        this.imagens = imagens;
    }

    @NonNull
    @Override
    public ImagemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.view_imagem, parent, false);
        return new ImagemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagemViewHolder holder, int position) {
        holder.bind(this.imagens.get(position));
    }

    @Override
    public int getItemCount() {
        return this.imagens.size();
    }

}
