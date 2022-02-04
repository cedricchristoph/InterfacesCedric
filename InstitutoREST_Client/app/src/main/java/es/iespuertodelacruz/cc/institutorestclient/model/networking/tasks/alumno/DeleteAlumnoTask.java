package es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.alumno;

import android.content.Context;
import android.os.AsyncTask;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.ApiSyncException;
import es.iespuertodelacruz.cc.institutorestclient.model.exception.LocalException;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.Response;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AlumnoRepository;

public class DeleteAlumnoTask extends AsyncTask<Object, Object, Object> {

    Context context;
    Alumno alumno;
    TaskListener listener;

    public DeleteAlumnoTask(Context context, Alumno alumno, TaskListener listener){
        this.context = context;
        this.alumno = alumno;
        this.listener = listener;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        AlumnoRepository repo = new AlumnoRepository(context);
        try {
            repo.delete(alumno);
            Response.send(false, "Eliminado correctamente");
        } catch (LocalException e) {
            listener.onTaskCompleted(Response.send(true, "No se pudo eliminar localmente"));
        } catch (ApiSyncException e) {
            listener.onTaskCompleted(Response.send(true, "No se pudo sincronizar con el servidor"));
        }
        return null;
    }

}
