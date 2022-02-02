package es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.rest.AlumnoREST;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AlumnoRepository;

/**
 * This task executes the repository commands Async
 */
public class AlumnoTask extends AsyncTask<Object, Object, Object> {

    TaskListener listener;
    Context context;
    String dni;

    public AlumnoTask(TaskListener listener, @NonNull Context context, @Nullable String dni) {
        this.listener = listener;
        this.context = context;
        this.dni = dni;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Object doInBackground(Object... objects) {
        AlumnoRepository alumnos = new AlumnoRepository(context);
        if (dni == null || dni.isEmpty()) {
            Optional<List<Alumno>> optional = alumnos.selectAll();
            if (optional.isPresent())
                listener.onTaskCompleted(optional.get());
        } else {
            Optional<Alumno> optional = alumnos.selectById(dni);
            if (optional.isPresent())
                listener.onTaskCompleted(optional.get());
        }
        return null;
    }
}
