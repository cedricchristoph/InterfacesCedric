package es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.MatriculaDTO;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AlumnoRepository;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AsignaturaRepository;

public class AsignaturaMatriculaTask extends AsyncTask<Object, Object, Object> {

    private Context context;
    private Matricula matricula;
    private Alumno alumno;
    private TaskListener listener;

    public AsignaturaMatriculaTask(Context context, Matricula matricula, Alumno alumno, TaskListener listener) {
        this.context = context;
        this.matricula = matricula;
        this.listener = listener;
        this.alumno = alumno;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Object doInBackground(Object... objects) {
        AlumnoRepository repo = new AlumnoRepository(context);
        Optional<MatriculaDTO> matriculas = repo.selectAllAsignaturasFromMatricula(alumno.getDni(), matricula.getId());
        if (matriculas.isPresent())
            listener.onTaskCompleted(matriculas.get());
        return null;
    }
}
