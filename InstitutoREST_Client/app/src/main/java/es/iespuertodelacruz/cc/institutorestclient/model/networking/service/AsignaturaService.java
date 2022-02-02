package es.iespuertodelacruz.cc.institutorestclient.model.networking.service;

import java.util.List;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Asignatura;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.APIUtils;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AsignaturaService {

    @GET(APIUtils.V1 + "asignaturas")
    Call<List<Asignatura>> selectAll();

    @GET(APIUtils.V1 + "asignaturas/{id}")
    Call<Asignatura> selectById(@Path("id") int id);

    @POST(APIUtils.V2 + "asignaturas")
    Call<Asignatura> insert(@Body Asignatura asignatura);

    @PUT(APIUtils.V2 + "asignaturas/{id}")
    Call<Asignatura> update(@Path("id") int id, @Body Asignatura asignatura);

    @DELETE(APIUtils.V2 + "asignaturas/{id}")
    Call<Asignatura> delete(@Path("id") int id);

}
