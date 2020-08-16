package br.edu.iftm.pdm.patrimonizador.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.edu.iftm.pdm.patrimonizador.R;
import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.list_builders.ImagemListBuilder;

public class VerPatrimonioActivity extends AppCompatActivity {

    public static final String PATRIMONIO_KEY = "VerPatrimonioActivity.PATRIMONIO";

    private Patrimonio patrimonio;

    private TextView txtShowId;
    private TextView txtShowCategoria;
    private TextView txtShowEstado;
    private TextView txtShowMarca;
    private TextView txtShowValor;
    private TextView txtShowDescricao;
    private RecyclerView rvImgShowList;

    private ImagemListBuilder imagemListBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_patrimonio);

        this.txtShowId = findViewById(R.id.txtShowId);
        this.txtShowCategoria = findViewById(R.id.txtShowCategoria);
        this.txtShowEstado = findViewById(R.id.txtShowEstado);
        this.txtShowMarca = findViewById(R.id.txtShowMarca);
        this.txtShowValor = findViewById(R.id.txtShowValor);
        this.txtShowDescricao = findViewById(R.id.txtShowDescricao);
        this.rvImgShowList = findViewById(R.id.rvImgShowList);

        //TODO (19) Você precisa aqui acessar os dados do patrimônio.

        this.txtShowId.setText(Long.toString(this.patrimonio.getId()));
        this.txtShowCategoria.setText(this.patrimonio.getCategoria());
        this.txtShowEstado.setText(this.patrimonio.getEstado());
        this.txtShowMarca.setText(this.patrimonio.getMarca());
        this.txtShowValor.setText(Float.toString(this.patrimonio.getValor()));
        this.txtShowDescricao.setText(this.patrimonio.getDescricao());

        this.imagemListBuilder = new ImagemListBuilder(this,
                this.rvImgShowList, this.patrimonio.getImagens());
        this.imagemListBuilder.load();
    }
}