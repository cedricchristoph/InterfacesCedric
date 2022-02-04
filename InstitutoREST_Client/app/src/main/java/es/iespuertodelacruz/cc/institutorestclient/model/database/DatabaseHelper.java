package es.iespuertodelacruz.cc.institutorestclient.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AlumnoContract;
import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AlumnoMatriculaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AsignaturaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AsignaturaMatriculaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.contracts.MatriculaContract;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "instituto.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AlumnoContract.AlumnoEntry.CREATE_TABLE);
        db.execSQL(AsignaturaContract.AsignaturaEntry.CREATE_TABLE);
        db.execSQL(MatriculaContract.MatriculaEntry.CREATE_TABLE);
        db.execSQL(AsignaturaMatriculaContract.AsignaturaMatriculaEntry.CREATE_TABLE);
        db.execSQL(AlumnoMatriculaContract.AlumnoMatriculaEntry.CREATE_TABLE);
    }

    public void eraseTables() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(AlumnoContract.AlumnoEntry.ERASE);
        db.execSQL(AsignaturaContract.AsignaturaEntry.ERASE);
        db.execSQL(MatriculaContract.MatriculaEntry.ERASE);
        db.execSQL(AsignaturaMatriculaContract.AsignaturaMatriculaEntry.ERASE);
        db.execSQL(AlumnoMatriculaContract.AlumnoMatriculaEntry.ERASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

}
