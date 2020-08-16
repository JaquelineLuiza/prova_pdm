package br.edu.iftm.pdm.patrimonizador.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.edu.iftm.pdm.patrimonizador.model.Patrimonio;
import br.edu.iftm.pdm.patrimonizador.ui.activities.CadastraPatrimonioActivity;
import br.edu.iftm.pdm.patrimonizador.ui.activities.MainActivity;

public class PatrimonioDAOSingleton {
    private static PatrimonioDAOSingleton INSTANCE;
    private DBHelper dbHelper;

    private PatrimonioDAOSingleton() {
        this.dbHelper = new DBHelper();
    }

    public static PatrimonioDAOSingleton getINSTANCE() {
        if(INSTANCE == null)
            INSTANCE = new PatrimonioDAOSingleton();
        return INSTANCE;
    }

    public long addPatrimonio(Patrimonio patrimonio) {
        //TODO (8) Neste método você deverá implementar a inserção de patrimônios
        // e imagens no banco.
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBSchema.PatrimonioT.CATEGORIA, patrimonio.getCategoria());
        values.put(DBSchema.PatrimonioT.MARCA, patrimonio.getMarca());
        values.put(DBSchema.PatrimonioT.ESTADO, patrimonio.getEstado());
        values.put(DBSchema.PatrimonioT.VALOR, patrimonio.getValor());
        values.put(DBSchema.PatrimonioT.DESCRICAO, patrimonio.getDescricao());

        db.insert(DBSchema.PatrimonioT.TABELA, null, values);

        db.close();

        return 0;
    }

    public void deletePatrimonio(long id) {
        //TODO (9) Implementar um método capaz de fazer a deleção de um patrimônio no banco SQLite.
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        db.delete(DBSchema.PatrimonioT.TABELA, DBSchema.PatrimonioT.ID+" = ?",
                new String[]{Long.toString(id)});
        db.close();
    }

    public void deletePatrimonios(ArrayList<Long> idList) {
        for(long id : idList) {
            this.deletePatrimonio(id);
        }
    }

    public Patrimonio getPatrimonio(long id) {
        //TODO (10) Você deverá implementar um método capaz de buscar por um patrimônio
        // de acordo com o seu id e retornar todos os seus dados.
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBSchema.PatrimonioT.TABELA, null,
                DBSchema.PatrimonioT.TABELA + " = ?",
                new String[]{Long.toString(id)}, null, null, null);
        cursor.moveToFirst();
        long p_id = cursor.getLong(cursor.getColumnIndex(DBSchema.PatrimonioT.ID));
        String p_categoria = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.CATEGORIA));
        String p_marca = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.MARCA));
        String p_estado = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.ESTADO));
        float p_valor = cursor.getFloat(cursor.getColumnIndex(DBSchema.PatrimonioT.VALOR));
        String p_descricao = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.DESCRICAO));
        String p_timestamp = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.TIMESTAMP));
        db.close();
        return new Patrimonio(p_id, p_categoria, p_marca, p_estado, p_valor, p_descricao, new ArrayList<String>(), p_timestamp);
    }

    public ArrayList<Patrimonio> getAllPatrimonios() {
        //TODO(11) Neste método você irá implementar o resgate da informação de todos os
        // patrimônios do banco sqlite. Você deverá utilizar a VIEWSELECTION.
        ArrayList<Patrimonio> patrimonios = new ArrayList<>();

        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBSchema.PatrimonioT.TABELA, null,
                null,
                null, null, null, null);
        while (cursor.moveToNext()) {
            long p_id = cursor.getLong(cursor.getColumnIndex(DBSchema.PatrimonioT.ID));
            String p_categoria = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.CATEGORIA));
            String p_marca = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.MARCA));
            String p_estado = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.ESTADO));
            float p_valor = cursor.getFloat(cursor.getColumnIndex(DBSchema.PatrimonioT.VALOR));
            String p_descricao = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.DESCRICAO));
            String p_timestamp = cursor.getString(cursor.getColumnIndex(DBSchema.PatrimonioT.TIMESTAMP));
            patrimonios.add(new Patrimonio(p_id, p_categoria, p_marca, p_estado, p_valor, p_descricao, new ArrayList<String>(), p_timestamp));
        }
        db.close();
        return patrimonios;
    }

    public void updateEstado(long id, String estado) {
        //TODO(12) você deverá implementar um método que altere a informação de estado
        // do objeto por meio da informação de seu ID.
    }
}
