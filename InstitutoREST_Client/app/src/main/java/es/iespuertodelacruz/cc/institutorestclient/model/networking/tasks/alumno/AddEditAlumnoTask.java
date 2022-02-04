package es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.alumno;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import es.iespuertodelacruz.cc.institutorestclient.controller.AddEditAlumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.ApiSyncException;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.LocalException;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.Response;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AlumnoRepository;

public class AddEditAlumnoTask extends AsyncTask<Object, Object, Object> {

    Context context;
    TaskListener listener;
    Alumno alumno;
    boolean createNew;

    AlumnoRepository repo;

    public AddEditAlumnoTask(Context context, TaskListener listener, Alumno alumno, boolean createNew) {
        this.context = context;
        this.listener = listener;
        this.alumno = alumno;
        this.createNew = createNew;
        repo = new AlumnoRepository(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Object doInBackground(Object... objects) {
        if (createNew) {
            try {
                repo.insert(alumno);
                listener.onTaskCompleted(Response.send(false,"Añadido correctamente"));
            } catch (LocalException e) {
                listener.onTaskCompleted(Response.send(true, "No se pudo añadir a la base de datos"));
            } catch (ApiSyncException e) {
                listener.onTaskCompleted(Response.send(true, "No se pudo sincronizar con el servidor"));
            }
        } else {
            try {
                repo.update(alumno);
                listener.onTaskCompleted(Response.send(false,"Actualizado correctamente"));
            } catch (LocalException e) {
                listener.onTaskCompleted(Response.send(true, "No se pudo actualizar a la base de datos"));
            } catch (ApiSyncException e) {
                listener.onTaskCompleted(Response.send(true, "No se pudo sincronizar con el servidor"));
            }
        }
        return null;
    }
}
