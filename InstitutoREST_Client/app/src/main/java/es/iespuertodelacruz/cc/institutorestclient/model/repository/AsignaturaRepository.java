package es.iespuertodelacruz.cc.institutorestclient.model.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.database.AsignaturaHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Asignatura;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.ApiSyncException;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.LocalException;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.rest.AsignaturaREST;

public class AsignaturaRepository implements CRUDRepository<Asignatura, Integer>{

    private AsignaturaHelper helper;
    private AsignaturaREST rest;

    public AsignaturaRepository(Context context) {
        this.helper = new AsignaturaHelper(context);
        this.rest = new AsignaturaREST();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<List<Asignatura>> selectAll() {
        List<Asignatura> results = helper.selectAll();
        if (!(results == null || results.size() == 0)) return Optional.of(results);
        return rest.selectAll();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Asignatura> selectById(Integer id) {
        Optional<Asignatura> results = helper.selectById(id);
        if (results.isPresent()) return results;
        return rest.selectById(id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void insert(Asignatura entity) throws LocalException, ApiSyncException {
        // Check if entity exists in local db or api
        if (helper.selectById(entity.getId()).isPresent())
            throw new LocalException("Entity already in local db");
        if (rest.selectById(entity.getId()).isPresent())
            throw new ApiSyncException("Entity already in API");
        // Insert entity
        if (!helper.insert(entity))
            throw new LocalException("Could not create entity in local db");
        if (!rest.insert(entity))
            throw new ApiSyncException("Could not create entity in API");
    }

    @Override
    public void update(Asignatura entity) throws LocalException, ApiSyncException {
        if (!helper.update(entity))
            throw new LocalException("Could not update entity in local db");
        if (!rest.update(entity))
            throw new ApiSyncException("Could not update entity in API");
    }

    @Override
    public void deleteById(Integer id) throws LocalException, ApiSyncException {
        if (!helper.deleteById(id))
            throw new LocalException("Could not delete entity in local db");
        if (!rest.deleteById(id))
            throw new ApiSyncException("Could not delete entity in API");
    }

    @Override
    public void delete(Asignatura entity) throws LocalException, ApiSyncException {
        if (!helper.delete(entity))
            throw new LocalException("Could not delete entity in local db");
        if (!rest.deleteById(entity.getId()))
            throw new ApiSyncException("Could not delete entity in API");
    }
}
