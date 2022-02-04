package es.iespuertodelacruz.cc.institutorestclient.model.repository;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.database.AlumnoHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.database.AsignaturaHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.database.CRUDHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.database.DatabaseHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.database.MatriculaHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.MatriculaDTO;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.ApiSyncException;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.LocalException;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.rest.AlumnoREST;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.service.AlumnoService;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnoRepository implements CRUDRepository<Alumno, String> {

    DatabaseHelper dbHelper;
    private AlumnoHelper helper;
    private MatriculaHelper matriculaHelper;
    private AlumnoREST rest;

    public AlumnoRepository(@Nullable Context context) {
        helper = new AlumnoHelper(context);
        matriculaHelper = new MatriculaHelper(context);
        rest = new AlumnoREST();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<List<Alumno>> selectAll() {
        List<Alumno> results = helper.selectAll();
        if (!(results == null || results.size() == 0)) return Optional.of(results);
        Optional<List<Alumno>> optional = rest.selectAll();
        if (!optional.isPresent()) return Optional.empty();
        results = optional.get();
        try {
            results.forEach(a -> helper.insert(a));
        } catch (Exception e) {e.printStackTrace();}
        return optional;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Alumno> selectById(String id) {
        Optional<Alumno> result = helper.selectById(id);
        if (result.isPresent()) return result;
        return rest.selectById(id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<List<Alumno>> selectByNombre(String nombre) {
        List<Alumno> result = helper.selectByNombre(nombre);
        if (result != null) return Optional.of(result);
        return rest.selectByNombre(nombre);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<List<Matricula>> selectAllMatriculasFromAlumno(String dni) {
        List<Matricula> matriculas = matriculaHelper.selectMatriculaByAlumno(dni);
        if (!(matriculas == null || matriculas.isEmpty())) return Optional.of(matriculas);
        return rest.selectAllMatriculasFromAlumno(dni);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<MatriculaDTO> selectAllAsignaturasFromMatricula(String dni, Integer id) {
        return rest.selectAllAsignaturasFromMatriculas(dni, id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void insert(Alumno entity) throws LocalException, ApiSyncException {
        // Check if the entity exists in local db and or api
        if (helper.selectById(entity.getDni()).isPresent())
            throw new LocalException("Entity already in database");
        if (rest.selectById(entity.getDni()).isPresent())
            throw new ApiSyncException("Entity already in API Service");

        // Insert entity
        if (!(helper.insert(entity)))
            throw new LocalException("Couldn't create entity locally. Aborting");
        if (!(rest.insert(entity)))
            throw new ApiSyncException("Couldn't create entity on API");
    }

    @Override
    public void update(Alumno entity) throws LocalException, ApiSyncException {
        if (!helper.update(entity))
            throw new LocalException("Couldn't update entity locally");
        if (!rest.update(entity))
            throw new ApiSyncException("Couldn't update entity on API");
    }

    @Override
    public void deleteById(String id) throws LocalException, ApiSyncException {
        if (!helper.deleteById(id))
            throw new LocalException("Couldn't delete entity locally");
        if (!rest.deleteById(id))
            throw new ApiSyncException("Couldn't delete entity on API");
    }

    @Override
    public void delete(Alumno entity) throws LocalException, ApiSyncException {
        deleteById(entity.getDni());
    }
}
