package br.edu.iftm.pdm.patrimonizador.ui.list_adapters;

import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.edu.iftm.pdm.patrimonizador.R;

public class ImagemViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgFoto;

    public ImagemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imgFoto = this.itemView.findViewById(R.id.imgFoto);
    }

    public void bind(String path) {
        this.imgFoto.setImageBitmap(BitmapFactory.decodeFile(path));
    }
}
