package es.iespuertodelacruz.cc.institutorestclient.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AlumnoMatriculaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.contracts.MatriculaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;

public class MatriculaHelper extends DatabaseHelper implements CRUDHelper<Matricula, Integer> {

    public MatriculaHelper(@Nullable Context context) {
        super(context);
    }

    @Override
    public List<Matricula> selectAll() {
         SQLiteDatabase db = getReadableDatabase();
         Cursor cursor = db.query(MatriculaContract.MatriculaEntry.TABLE, null,
                 null, null, null, null, null);
         return getResultList(cursor);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Matricula> selectById(Integer id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(MatriculaContract.MatriculaEntry.TABLE, null,
                MatriculaContract.MatriculaEntry.ID + " = ?",
                new String[]{id.toString()},
                null, null, null, null);
        return Optional.of(getSingleResult(cursor));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Matricula> selectMatriculaByAlumno(String dni) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AlumnoMatriculaContract.AlumnoMatriculaEntry.TABLE,
                null, AlumnoMatriculaContract.AlumnoMatriculaEntry.ALUMNO + " = ?",
                new String[]{dni}, null, null, null, null);
        List<Matricula> results = new ArrayList<>();
        while (cursor.moveToNext()) {
            Optional<Matricula> optional = selectById(cursor.getInt(2));
            if (optional.isPresent())
                results.add(optional.get());
        }
        return results;
    }

    @Override
    public boolean insert(Matricula entity) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.insert(MatriculaContract.MatriculaEntry.TABLE, null,
                entity.toContentValues());
        return affected > 0;
    }

    @Override
    public boolean update(Matricula entity) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.update(MatriculaContract.MatriculaEntry.TABLE, entity.toContentValues(),
                MatriculaContract.MatriculaEntry.ID + " = ?", new String[]{String.valueOf(entity.getId())});
        return affected > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.delete(MatriculaContract.MatriculaEntry.TABLE, MatriculaContract.MatriculaEntry.ID + " = ?",
                new String[]{String.valueOf(id)});
        return affected > 0;
    }

    @Override
    public boolean delete(Matricula entity) {
        return deleteById(entity.getId());
    }

    @Override
    public Matricula getSingleResult(Cursor cursor) {
        while (cursor.moveToNext()) {
            Matricula matricula = new Matricula();
            matricula.setId(cursor.getInt(0));
            matricula.setYear(cursor.getInt(1));
            return matricula;
        }
        return null;
    }

    @Override
    public List<Matricula> getResultList(Cursor cursor) {
        List<Matricula> results = new ArrayList<>();
        while (cursor.moveToNext()) {
            Matricula matricula = new Matricula();
            matricula.setId(cursor.getInt(0));
            matricula.setYear(cursor.getInt(1));
            results.add(matricula);
        }
        return results;
    }
}
