package br.edu.iftm.pdm.patrimonizador.ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import br.edu.iftm.pdm.patrimonizador.R;
import br.edu.iftm.pdm.patrimonizador.data.FileManager;
import br.edu.iftm.pdm.patrimonizador.data.PatrimonioDAOSingleton;
import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.list_builders.ImagemListBuilder;

public class CadastraPatrimonioActivity extends AppCompatActivity {

    public static final String PATRIMONIO_ID_KEY = "CadastraPatrimonioActivity.PATRIMONIO_ID";

    private static final int TIRAR_FOTO_REQ_CODE = 1235;

    private Spinner spinCategoria;
    private Spinner spinEstado;
    private EditText etxtMarca;
    private EditText etxtValor;
    private EditText etxtDescricao;
    private RecyclerView rvImgList;

    private ArrayList<String> pathImagens;
    private File ultimaFoto;
    private ImagemListBuilder imagemListBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_patrimonio);

        this.spinCategoria = findViewById(R.id.spinCategoria);
        this.spinEstado = findViewById(R.id.spinEstado);
        this.etxtMarca = findViewById(R.id.etxtMarca);
        this.etxtValor = findViewById(R.id.etxtValor);
        this.etxtDescricao = findViewById(R.id.etxtDescricao);
        this.rvImgList = findViewById(R.id.rvImgList);

        this.pathImagens = new ArrayList<>();
        this.imagemListBuilder = new ImagemListBuilder(this, this.rvImgList, this.pathImagens);
        this.imagemListBuilder.load();

        // Ajustes dos spinners
        ArrayAdapter<CharSequence> adapterCategoria = ArrayAdapter.createFromResource(
                this, R.array.categorias, android.R.layout.simple_spinner_item
        );
        adapterCategoria.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        this.spinCategoria.setAdapter(adapterCategoria);

        ArrayAdapter<CharSequence> adapterEstado = ArrayAdapter.createFromResource(
                this, R.array.estados, android.R.layout.simple_spinner_item
        );
        adapterEstado.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );
        this.spinEstado.setAdapter(adapterEstado);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro_patrimonio, menu);
        MenuItem actionTirarFotos = menu.findItem(R.id.actionTirarFotos);
        actionTirarFotos.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                tirarFoto();
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void tirarFoto() {
        //TODO (13) Você deverá criar aqui um método que permita acessar o aplicativo de câmera
        // e salvar a imagem no caminho conforme descrito pelo método FileManager.createImageFile();
        // observe que existe um atributo desta classe que se chama ultimaFoto, você deve usá-lo aqui.
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 0);
        }
    }

    public void onClickSalvar(View view) {
        //TODO (14) Você deverá implementar um método para que o patrimônio seja persistido no
        // banco e retorne, como resultado, o ID do patrimônio guardado para a activity requisitante.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //TODO (15) Caso seja possível tirar a foto, guarde-a na estrutura de dados e mostre-a
        // na Lista de imagens
    }
}