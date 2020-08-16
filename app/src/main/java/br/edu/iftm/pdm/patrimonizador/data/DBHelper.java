package br.edu.iftm.pdm.patrimonizador.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.edu.iftm.pdm.patrimonizador.ui.activities.MainActivity;

public class DBHelper extends SQLiteOpenHelper {

    private static String DBNAME = "patrimonizador.db";
    private static int DBVERSION = 1;

    public DBHelper() {
        super(MainActivity.getINSTANCE(), DBNAME, null, DBVERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO (4) Crie as tabelas aqui OK
        db.execSQL(DBSchema.ImagemT.getCreationQuery());
        db.execSQL(DBSchema.PatrimonioT.getCreationQuery());
        db.execSQL(DBSchema.PatrimonioT.getViewCreationQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do nothing
    }
}
