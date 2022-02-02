package es.iespuertodelacruz.cc.institutorestclient.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AlumnoMatriculaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;

public class AlumnoMatriculaHelper extends DatabaseHelper{

    Context context;

    public AlumnoMatriculaHelper(Context context) {
        super(context);
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Matricula> selectAll(Alumno alumno) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AlumnoMatriculaContract.AlumnoMatriculaEntry.TABLE,
                null, AlumnoMatriculaContract.AlumnoMatriculaEntry.ALUMNO + " = ?",
                new String[]{alumno.getDni()}, null, null, null, null);
        return getResultList(cursor);
    }

    public boolean insert(Matricula matricula, Alumno alumno) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AlumnoMatriculaContract.AlumnoMatriculaEntry.ALUMNO, alumno.getDni());
        values.put(AlumnoMatriculaContract.AlumnoMatriculaEntry.MATRICULA, matricula.getId());
        long affected = db.insert(AlumnoMatriculaContract.AlumnoMatriculaEntry.TABLE,
                null, values);
        return affected > 0;
    }

    public boolean deleteById(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.delete(AlumnoMatriculaContract.AlumnoMatriculaEntry.TABLE,
                AlumnoMatriculaContract.AlumnoMatriculaEntry.ID + " = ?",
                new String[]{String.valueOf(id)});
        return affected > 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<Matricula> getSingleResult(Cursor cursor) {
        MatriculaHelper helper = new MatriculaHelper(context);
        while (cursor.moveToNext()) {
            Optional<Matricula> optional = helper.selectById(cursor.getInt(1));
            return optional;
        }
        return Optional.empty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Matricula> getResultList(Cursor cursor) {
        List<Matricula> results = new ArrayList<>();
        MatriculaHelper helper = new MatriculaHelper(context);
        while (cursor.moveToNext()) {
            Optional<Matricula> optional = helper.selectById(cursor.getInt(1));
            if (optional.isPresent())
                results.add(optional.get());
        }
        return results;
    }
}
