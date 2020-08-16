package br.edu.iftm.pdm.patrimonizador.ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import br.edu.iftm.pdm.patrimonizador.R;
import br.edu.iftm.pdm.patrimonizador.data.FileManager;
import br.edu.iftm.pdm.patrimonizador.data.PatrimonioDAOSingleton;
import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.dialog.DialogApagarPatrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.dialog.DialogEditarPatrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.list_adapters.PatrimonioAdapter;
import br.edu.iftm.pdm.patrimonizador.ui.list_builders.PatrimonioListBuilder;

public class MainActivity extends AppCompatActivity {

    private static MainActivity INSTANCE;
    private RecyclerView rvPatrimonio;
    private PatrimonioListBuilder patrimonioListBuilder;

    private static final int PATRIMONIO_REQ_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        INSTANCE = this;
        this.rvPatrimonio = findViewById(R.id.rvPatrimonio);
        // TODO -- descomente estas linhas abaixou para funcionar o carregamento da lista de patrimônios

        this.patrimonioListBuilder = new PatrimonioListBuilder(this,
                this.rvPatrimonio, PatrimonioDAOSingleton.getINSTANCE().getAllPatrimonios());
        this.patrimonioListBuilder.load();

        // listeners do patrimonioListBuilder
        this.patrimonioListBuilder.getAdapter().setOnClickPatrimonioListener(new PatrimonioAdapter.OnClickPatrimonioListener() {
            @Override
            public void onClickDetalhar(Patrimonio patrimonio) {
                detalharPatrimonio(patrimonio);
            }

            @Override
            public void onClickEditar(Patrimonio patrimonio, int pos) {
                editarEstadoPatrimonio(patrimonio, pos);
            }
        });
    }

    public static Context getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem actionDelete = menu.findItem(R.id.actionDelete);
        final MenuItem actionGerarRelatorio = menu.findItem(R.id.actionGerarRelatorio);

        // TODO -- descomente estas linhas abaixo para funcionar a notificação da lista de patrimônios

        this.patrimonioListBuilder.getAdapter().setSelectionNotifier(new PatrimonioAdapter.SelectionNotifier() {
            @Override
            public void notifySelection(int nSelected) {
                actionDelete.setVisible(true);
            }

            @Override
            public void notifyClearSelection() {
                actionDelete.setVisible(false);
            }
        });

        // acoes dos botoes de menu
        actionDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                deletarPatrimoniosSelecionados();
                return true;
            }
        });
        actionGerarRelatorio.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                gerarRelatorio();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void onClickAddPatrimonio(View view) {
        Intent addPatrimonio = new Intent(this, CadastraPatrimonioActivity.class);
        startActivityForResult(addPatrimonio, PATRIMONIO_REQ_CODE);
    }

    private void editarEstadoPatrimonio(final Patrimonio patrimonio, final int pos) {
        //TODO (16) Insira aqui um código que te permita criar um DialogEditarPatrimonio
        // Caso o usuário opte por "aplicar" as modificações no Patrimonio você deve persistir
        // esta atualização e notificar a lista da mudança ocorrida.
    }

    private void deletarPatrimoniosSelecionados() {
        //TODO (16) Insira aqui um código que te permita criar um DialogApagarPatrimonio
        // Caso o usuário opte por "deletar" o Patrimonio você deve persistir
        // esta operação e notificar a lista da mudança ocorrida.
    }

    public void gerarRelatorio() {
        //TODO -- Apenas observe estas linhas, elas o ajudarão a compreender como funciona a
        // criação da planilha
        ArrayList<Patrimonio> patrimonios = PatrimonioDAOSingleton.getINSTANCE().getAllPatrimonios();
        if(!patrimonios.isEmpty()) {
            try {
                FileManager.writePatrimonios(patrimonios);
                Toast.makeText(this, R.string.relatorio_gerado, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void detalharPatrimonio(Patrimonio patrimonio) {
        //TODO (17) Aqui você deverá chamar a VerPatrimonioActivity.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //TODO (18) Ao receber as informações de criação de patrimônio persista os dados e
        // notifique a lista da mudança.
    }
}