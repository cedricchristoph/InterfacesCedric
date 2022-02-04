package es.iespuertodelacruz.cc.institutorestclient.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import es.iespuertodelacruz.cc.institutorestclient.R;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Asignatura;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.MatriculaDTO;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.AsignaturaMatriculaTask;

public class MatriculaDetails extends AppCompatActivity implements TaskListener {

    private MatriculaDTO matriculaDto;
    private Matricula matricula;
    private Alumno alumno;

    private TextView txtTitle;
    private TextView txtNombreAlumno;
    private ListView listView;

    private ArrayAdapter<Asignatura> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula_details);
        Bundle bundle = getIntent().getExtras();
        matricula = (Matricula) bundle.get("matricula");
        alumno = (Alumno) bundle.get("alumno");
        init();
        reloadAsignaturas();
    }

    private void init() {
        txtTitle = findViewById(R.id.txtTitle);
        txtNombreAlumno = findViewById(R.id.txtNombre);
        listView = findViewById(R.id.listview);

        txtTitle.setText("Matrícula #" + matricula.getId());
        txtNombreAlumno.setText(alumno.getNombre() + " " + alumno.getApellidos());
    }

    private void reloadAsignaturas() {
        AsignaturaMatriculaTask task = new AsignaturaMatriculaTask(getApplicationContext(), matricula, alumno, this);
        task.execute(null, null, null);
    }

    @Override
    public void onTaskCompleted(Object result) {
        matriculaDto = (MatriculaDTO) result;
        runOnUiThread(() -> {
            adapter = new ArrayAdapter<Asignatura>(this, android.R.layout.simple_list_item_1, matriculaDto.getAsignaturas());
            listView.setAdapter(adapter);
        });
    }
}