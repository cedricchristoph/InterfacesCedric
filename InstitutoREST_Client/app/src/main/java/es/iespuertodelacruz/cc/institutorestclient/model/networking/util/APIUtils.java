package es.iespuertodelacruz.cc.institutorestclient.model.networking.util;

import es.iespuertodelacruz.cc.institutorestclient.model.networking.RetrofitClient;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.service.AlumnoService;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.service.AsignaturaService;

public class APIUtils {

    private APIUtils(){
    };

    public static final String API_URL = "https://rest-instituto.herokuapp.com/api/";
    public static final String V1 = "";
    public static final String V2 = "";
    public static final String V3 = "";

    public static AlumnoService getAlumnoService(){
        return RetrofitClient.getClient(API_URL).create(AlumnoService.class);
    }

    public static AsignaturaService getAsignaturaService() {
        return RetrofitClient.getClient(API_URL).create(AsignaturaService.class);
    }

}