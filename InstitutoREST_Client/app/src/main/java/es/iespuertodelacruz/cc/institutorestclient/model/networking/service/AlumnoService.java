package es.iespuertodelacruz.cc.institutorestclient.model.networking.service;

import java.util.List;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.MatriculaDTO;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.APIUtils;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlumnoService {

    // Objetos alumno

    @GET(APIUtils.V2 + "alumnos")
    Call<List<Alumno>> selectAll();

    @GET(APIUtils.V2 + "alumnos?nombre={nombre}")
    Call<List<Alumno>> selectByNombre(@Path("nombre") String nombre);

    @POST(APIUtils.V2 + "alumnos")
    Call<Alumno> insert(@Body Alumno entity);

    @GET(APIUtils.V2 + "alumnos/{id}")
    Call<Alumno> selectById(@Path("id") String dni);

    @PUT(APIUtils.V2 + "alumnos/{id}")
    Call<Alumno> update(@Path("id") String dni,
                        @Body Alumno entity);

    @DELETE(APIUtils.V2 + "alumnos/{id}")
    Call<Alumno> delete(@Path("id") String dni);

    // Objetos matriculas de un alumno

    @GET(APIUtils.V2 + "alumnos/{dni}/matriculas")
    Call<List<Matricula>> selectAllMatriculasFromAlumno(@Path("dni") String dni);

    @GET(APIUtils.V2 + "alumnos/{dni}/matriculas/{id}")
    Call<Matricula> selectMatriculaById(@Path("dni") String dni,
                                        @Path("id") int id);

    @POST(APIUtils.V2 + "alumnos/{dni}/matriculas")
    Call<Matricula> insertMatricula(@Path("dni") String dni,
                                    @Body Matricula matricula);

    @PUT(APIUtils.V2 + "alumnos/{dni}/matriculas/{id}")
    Call<Matricula> updateMatricula(@Path("dni") String dni,
                                    @Path("id") int id,
                                    @Body Matricula matricula);

    @DELETE(APIUtils.V2 + "alumnos/{dni}/matriculas/{id}")
    Call<Matricula> deleteMatricula(@Path("dni") String dni,
                                    @Path("id") int id);

    // Objetos Asignatura de matricula
    @GET(APIUtils.V2 + "alumnos/{dni}/matriculas/{id}")
    Call<MatriculaDTO> selectAllAsignaturasFromMatricula(@Path("dni") String dni, @Path("id") Integer id);
}
