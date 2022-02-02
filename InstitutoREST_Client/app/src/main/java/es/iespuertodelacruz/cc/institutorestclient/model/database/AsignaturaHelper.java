package es.iespuertodelacruz.cc.institutorestclient.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AsignaturaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AsignaturaMatriculaContract;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Asignatura;

public class AsignaturaHelper extends DatabaseHelper implements CRUDHelper<Asignatura, Integer> {

    public AsignaturaHelper(@Nullable Context context) {
        super(context);
    }

    @Override
    public List<Asignatura> selectAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AsignaturaContract.AsignaturaEntry.TABLE, null,
                null, null, null, null, null);
        return getResultList(cursor);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Asignatura> selectById(Integer id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AsignaturaContract.AsignaturaEntry.TABLE, null,
                AsignaturaContract.AsignaturaEntry.ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null);
        return Optional.of(getSingleResult(cursor));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Asignatura> selectAsignaturaByMatricula(Integer matriculaId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AsignaturaMatriculaContract.AsignaturaMatriculaEntry.TABLE, null,
                AsignaturaMatriculaContract.AsignaturaMatriculaEntry.MATRICULA + " = ?",
                new String[]{String.valueOf(matriculaId)}, null, null, null);
        List<Asignatura> results = new ArrayList<>();
        while (cursor.moveToNext()) {
            Optional<Asignatura> optional = selectById(cursor.getInt(1));
            if (optional.isPresent())
                results.add(optional.get());
        }
        return results;
    }

    @Override
    public boolean insert(Asignatura entity) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.insert(AsignaturaContract.AsignaturaEntry.TABLE, null, entity.toContentValues());
        return affected > 0;
    }

    @Override
    public boolean update(Asignatura entity) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.update(AsignaturaContract.AsignaturaEntry.TABLE, entity.toContentValues(),
                AsignaturaContract.AsignaturaEntry.ID + " = ?", new String[]{String.valueOf(entity.getId())});
        return affected > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.delete(AsignaturaContract.AsignaturaEntry.TABLE, AsignaturaContract.AsignaturaEntry.ID + " = ?",
                new String[]{String.valueOf(id)});
        return affected > 0;
    }

    @Override
    public boolean delete(Asignatura entity) {
        return deleteById(entity.getId());
    }

    @Override
    public Asignatura getSingleResult(Cursor cursor) {
        while (cursor.moveToNext()) {
            Asignatura asignatura = new Asignatura();
            asignatura.setId(cursor.getInt(0));
            asignatura.setNombre(cursor.getString(1));
            asignatura.setCurso(cursor.getString(2));
            return asignatura;
        }
        return null;
    }

    @Override
    public List<Asignatura> getResultList(Cursor cursor) {
        List<Asignatura> results = new ArrayList<>();
        while (cursor.moveToNext()) {
            Asignatura asignatura = new Asignatura();
            asignatura.setId(cursor.getInt(0));
            asignatura.setNombre(cursor.getString(1));
            asignatura.setCurso(cursor.getString(2));
            results.add(asignatura);
        }
        return results;
    }
}
