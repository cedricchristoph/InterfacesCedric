package es.iespuertodelacruz.cc.institutorestclient.model.networking.rest;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.HttpStatus;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.service.AlumnoService;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlumnoREST implements CRUDRest<Alumno, String>{

    AlumnoService service;

    public AlumnoREST(){
        service = APIUtils.getAlumnoService();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<List<Alumno>> selectAll() {
        try {
            Response<List<Alumno>> response = service.selectAll().execute();
            if (response.code() == HttpStatus.OK.asCode())
                return Optional.of(response.body());

        } catch (IOException e) {}
        return Optional.empty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Optional<Alumno> selectById(String id) {
        try {
            Response<Alumno> response = service.selectById(id).execute();
            if (response.code() == HttpStatus.OK.asCode())
                return Optional.of(response.body());
        } catch (IOException e) {}
        return Optional.empty();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Optional<List<Alumno>> selectByNombre(String nombre) {
        try {
            Response<List<Alumno>> response = service.selectByNombre(nombre).execute();
            if (response.code() == HttpStatus.OK.asCode())
                return Optional.of(response.body());
        } catch (IOException e) {}
        return Optional.empty();
    }

    @Override
    public boolean insert(Alumno entity) {
        try {
            Response<Alumno> response = service.insert(entity).execute();
            return response.isSuccessful() && (response.code() == HttpStatus.CREATED.asCode());
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean update(Alumno entity) {
        try {
            Response<Alumno> response = service.update(entity.getDni(), entity).execute();
            return response.isSuccessful() && (response.code() == HttpStatus.OK.asCode());
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean deleteById(String id) {
        try {
            Response<Alumno> response = service.delete(id).execute();
            return response.isSuccessful() && (response.code() == HttpStatus.OK.asCode());
        } catch (IOException e) {
            return false;
        }
    }
}
