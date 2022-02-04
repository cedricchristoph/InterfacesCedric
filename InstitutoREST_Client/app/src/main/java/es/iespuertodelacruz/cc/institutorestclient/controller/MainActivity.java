package es.iespuertodelacruz.cc.institutorestclient.controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

import es.iespuertodelacruz.cc.institutorestclient.R;
import es.iespuertodelacruz.cc.institutorestclient.model.database.DatabaseHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.alumno.AlumnoTask;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.util.Response;
import es.iespuertodelacruz.cc.institutorestclient.view.AlumnoListAdapter;

public class MainActivity extends AppCompatActivity implements TaskListener {

    private RecyclerView recycler;
    private EditText txtDni;
    private Button btnSearch;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        reloadAlumnos();
    }

    private void init() {
        this.recycler = findViewById(R.id.recycler);
        this.txtDni = findViewById(R.id.searchDni);
        this.btnSearch = findViewById(R.id.btnSearch);
    }

    protected void reloadAlumnos() {
        new AlumnoTask(this,getApplicationContext(),null).execute(null, null, null);
    }

    @Override
    public void onTaskCompleted(Object result) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Response response = (Response) result;
        try {
            alumnos.addAll((Collection<? extends Alumno>) response.getBody());
        } catch (ClassCastException ex) {
            alumnos.add((Alumno) response.getBody());
        }
        AlumnoListAdapter adapter = new AlumnoListAdapter(alumnos);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alumno alumno = alumnos.get(recycler.getChildAdapterPosition(view));
                Intent intent = new Intent(MainActivity.this, AlumnoDetails.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("alumno", alumno);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        runOnUiThread(() -> {
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setAdapter(adapter);
            if (alumnos.isEmpty())
                Toast.makeText(getApplicationContext(), R.string.no_results, Toast.LENGTH_LONG).show();
        });
    }

    public void onSearchClicked(View view) {
        if (txtDni.getText().toString().isEmpty()) {reloadAlumnos(); return;};
        new AlumnoTask(this, getApplicationContext(), txtDni.getText().toString())
                .execute(null,null,null);
    }

    public void addAlumno(View view) {
        Intent intent = new Intent(MainActivity.this, AddEditAlumno.class);
        startActivity(intent);
    }

    public void refreshApiData(View view) {
        recycler.setAdapter(null);
        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        helper.eraseTables();
        reloadAlumnos();
    }
}