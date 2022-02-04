package es.iespuertodelacruz.cc.institutorestclient.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import es.iespuertodelacruz.cc.institutorestclient.R;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.MatriculaTask;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.alumno.DeleteAlumnoTask;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.Response;
import es.iespuertodelacruz.cc.institutorestclient.view.AlumnoListAdapter;
import es.iespuertodelacruz.cc.institutorestclient.view.MatriculaListAdapter;

public class AlumnoDetails extends AppCompatActivity implements TaskListener {

    private Alumno alumno;
    private List<Matricula> matriculas;

    private TextView txtNombreApellidos;
    private TextView txtDni;
    private TextView txtFecha;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_details);
        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.get("alumno");
        init();
        reloadMatriculas();
    }

    private void init() {
        txtNombreApellidos = findViewById(R.id.nombreAlumno);
        txtDni = findViewById(R.id.dni);
        txtFecha = findViewById(R.id.fechaNacimiento);
        recycler = findViewById(R.id.recycler);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtNombreApellidos.setText(alumno.getNombre() + " " + alumno.getApellidos());
        txtDni.setText("DNI: " + alumno.getDni());
        txtFecha.setText("Fecha de Nacimiento: " + sdf.format(new Date(alumno.getFechanacimiento())));
    }

    public void onAddMatriculaClick(View view) {

    }

    public void onDeleteClicked(View view) {
        new DeleteAlumnoTask(getApplicationContext(), alumno, this).execute(null, null, null);
        Intent intent = new Intent(AlumnoDetails.this, MainActivity.class);
        startActivity(intent);
    }

    public void onEditarClicked(View view) {
        Intent intent = new Intent(AlumnoDetails.this, AddEditAlumno.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("alumno", alumno);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void reloadMatriculas() {
        MatriculaTask task = new MatriculaTask(this, getApplicationContext(), alumno.getDni());
        task.execute(null, null, null);
    }

    @Override
    public void onTaskCompleted(Object result) {
        matriculas = new ArrayList<>();
        Response response = (Response) result;
        if (response.getMessage() != null && !response.getMessage().isEmpty())
            runOnUiThread( () -> Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_SHORT).show());
        if (response.getBody() == null) return;
        try {
            matriculas.addAll((Collection<? extends Matricula>) response.getBody());
        } catch (ClassCastException ex) {
            matriculas.add((Matricula) response.getBody());
        }
        MatriculaListAdapter adapter = new MatriculaListAdapter((ArrayList<Matricula>) matriculas);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlumnoDetails.this, MatriculaDetails.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alumno", alumno);
                bundle.putSerializable("matricula", matriculas.get(recycler.getChildAdapterPosition(view)));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        runOnUiThread(() -> {
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setAdapter(adapter);
            if (matriculas.isEmpty())
                Toast.makeText(getApplicationContext(), R.string.no_results, Toast.LENGTH_LONG).show();
        });
    }

}