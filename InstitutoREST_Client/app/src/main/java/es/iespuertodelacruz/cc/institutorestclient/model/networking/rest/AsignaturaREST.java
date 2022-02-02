package es.iespuertodelacruz.cc.institutorestclient.model.networking.rest;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Asignatura;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.HttpStatus;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.service.AsignaturaService;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.APIUtils;
import retrofit2.Response;

public class AsignaturaREST implements CRUDRest<Asignatura, Integer> {

    AsignaturaService service;

    public AsignaturaREST() {
        service = APIUtils.getAsignaturaService();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<List<Asignatura>> selectAll() {
        try {
            Response<List<Asignatura>> response = service.selectAll().execute();
            if (response.code() == HttpStatus.OK.asCode())
                return Optional.of(response.body());
        } catch (IOException e) {}
        return Optional.empty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Asignatura> selectById(Integer id) {
        try {
            Response<Asignatura> response = service.selectById(id).execute();
            if (response.code() == HttpStatus.OK.asCode())
                return Optional.of(response.body());
        } catch (IOException e) {}
        return Optional.empty();
    }

    @Override
    public boolean insert(Asignatura entity) {
        try {
            Response<Asignatura> response = service.insert(entity).execute();
            return (response.isSuccessful() && response.code() == HttpStatus.CREATED.asCode());
        } catch (IOException e) {}
        return false;
    }

    @Override
    public boolean update(Asignatura entity) {
        try {
            Response<Asignatura> response = service.update(entity.getId(), entity).execute();
            return (response.isSuccessful() && response.code() == HttpStatus.OK.asCode());
        } catch (IOException e) {}
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            Response<Asignatura> response = service.delete(id).execute();
            return (response.isSuccessful() && response.code() == HttpStatus.OK.asCode());
        } catch (IOException e) {}
        return false;
    }
}
