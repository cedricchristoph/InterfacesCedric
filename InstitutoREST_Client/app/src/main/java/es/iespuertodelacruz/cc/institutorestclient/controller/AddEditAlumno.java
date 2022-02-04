package es.iespuertodelacruz.cc.institutorestclient.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import es.iespuertodelacruz.cc.institutorestclient.R;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.alumno.AddEditAlumnoTask;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.Response;

public class AddEditAlumno extends AppCompatActivity implements TaskListener {

    private Alumno alumno;

    private EditText txtDni;
    private EditText txtNombre;
    private EditText txtApellidos;
    private EditText txtFechaNacimiento;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_alumno);
        Bundle bundle = getIntent().getExtras();
        try {
            alumno = (Alumno) bundle.get("alumno");
        } catch (Exception e){}
        init();
    }

    private void init() {
        txtDni = findViewById(R.id.editTextDni);
        txtNombre = findViewById(R.id.editTextNombre);
        txtApellidos = findViewById(R.id.editTextApellidos);
        txtFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);
        if (alumno == null) return;
        txtDni.setText(alumno.getDni());
        txtNombre.setText(alumno.getNombre());
        txtApellidos.setText(alumno.getApellidos());
        txtFechaNacimiento.setText(sdf.format(new Date(alumno.getFechanacimiento())));
    }

    public void confirm(View view) {
        String dni = txtDni.getText().toString();
        String nombre = txtNombre.getText().toString();
        String apellidos = txtApellidos.getText().toString();
        String fechaStr = txtFechaNacimiento.getText().toString();
        Date fecha = null;
        try {
            fecha = sdf.parse(fechaStr);
            if (fecha == null) throw new Exception();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "La fecha de nacimiento tiene un formato incorrecto",
                    Toast.LENGTH_SHORT).show();
        }

        if (alumno == null) {  // CREATE
            alumno = new Alumno(dni, nombre, apellidos, fecha.getTime());
            new AddEditAlumnoTask(getApplicationContext(), this, alumno, true).execute(null, null, null);
        } else {  // UPDATE
            alumno = new Alumno(dni, nombre, apellidos, fecha.getTime());
            new AddEditAlumnoTask(getApplicationContext(), this, alumno, false).execute(null, null, null);
        }
    }

    @Override
    public void onTaskCompleted(Object result) {
        Response response = (Response) result;
        runOnUiThread(() -> {
            Toast.makeText(getApplicationContext(), response.getMessage(), Toast.LENGTH_LONG).show();
            if (response.isError()) return;
            Intent intent = new Intent(AddEditAlumno.this, MainActivity.class);
            startActivity(intent);
        });
    }
}