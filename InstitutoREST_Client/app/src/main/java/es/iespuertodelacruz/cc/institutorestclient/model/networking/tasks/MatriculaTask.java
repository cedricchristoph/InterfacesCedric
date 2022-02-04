package es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.Response;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AlumnoRepository;

public class MatriculaTask extends AsyncTask<Object, Object, Object> {

    TaskListener listener;
    Context context;
    String dni;

    public MatriculaTask(TaskListener listener, Context context, String dni) {
        this.listener = listener;
        this.context = context;
        this.dni = dni;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Object doInBackground(Object... objects) {
        AlumnoRepository repo = new AlumnoRepository(context);
        Optional<List<Matricula>> optional = repo.selectAllMatriculasFromAlumno(dni);
        if (optional.isPresent())
            listener.onTaskCompleted(Response.send(false, "", optional.get()));
        return null;
    }
}
