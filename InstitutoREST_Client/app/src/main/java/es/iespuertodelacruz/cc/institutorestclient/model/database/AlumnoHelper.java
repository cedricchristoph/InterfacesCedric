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

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AlumnoContract;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;

public class AlumnoHelper extends DatabaseHelper implements CRUDHelper<Alumno, String>{

    public AlumnoHelper(@Nullable Context context) {
        super(context);
    }

    @Override
    public List<Alumno> selectAll() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AlumnoContract.AlumnoEntry.TABLE,
                null, null, null, null, null, null);
        return getResultList(cursor);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Alumno> selectById(String id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AlumnoContract.AlumnoEntry.TABLE, null,
                AlumnoContract.AlumnoEntry.DNI + " = ?", new String[]{id},
                null, null, null, null);
        Alumno alumno = getSingleResult(cursor);
        if (alumno == null)
            return Optional.empty();
        return Optional.of(alumno);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Alumno> selectByNombre(String nombre) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(AlumnoContract.AlumnoEntry.TABLE, null,
                AlumnoContract.AlumnoEntry.NOMBRE + " = ?",
                new String[]{nombre}, null, null, null, null);
        List<Alumno> results = getResultList(cursor);
        return results;
    }

    @Override
    public boolean insert(Alumno entity) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.insert(AlumnoContract.AlumnoEntry.TABLE, null, entity.toContentValues());
        return affected > 0;
    }

    @Override
    public boolean update(Alumno entity) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.update(AlumnoContract.AlumnoEntry.TABLE, entity.toContentValues(),
                AlumnoContract.AlumnoEntry.DNI + " = ?", new String[]{entity.getDni()});
        return affected > 0;
    }

    @Override
    public boolean deleteById(String id) {
        SQLiteDatabase db = getWritableDatabase();
        long affected = db.delete(AlumnoContract.AlumnoEntry.TABLE,
                AlumnoContract.AlumnoEntry.DNI + " = ?",
                new String[]{id});
        return affected > 0;
    }

    @Override
    public boolean delete(Alumno entity) {
        return deleteById(entity.getDni());
    }

    @Override
    public Alumno getSingleResult(Cursor cursor) {
        while (cursor.moveToNext()) {
            Alumno alumno = new Alumno();
            alumno.setDni(cursor.getString(1));
            alumno.setNombre(cursor.getString(2));
            alumno.setApellidos(cursor.getString(3));
            alumno.setFechanacimiento(cursor.getLong(4));
            return alumno;
        }
        return null;
    }

    @Override
    public List<Alumno> getResultList(Cursor cursor) {
        List<Alumno> results = new ArrayList<>();
        while (cursor.moveToNext()) {
            Alumno alumno = new Alumno();
            alumno.setDni(cursor.getString(0));
            alumno.setNombre(cursor.getString(1));
            alumno.setApellidos(cursor.getString(2));
            alumno.setFechanacimiento(cursor.getLong(3));
            results.add(alumno);
        }
        return results;
    }
}
