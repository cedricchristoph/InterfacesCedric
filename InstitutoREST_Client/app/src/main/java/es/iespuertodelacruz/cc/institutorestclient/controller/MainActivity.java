package es.iespuertodelacruz.cc.institutorestclient.controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import es.iespuertodelacruz.cc.institutorestclient.R;
import es.iespuertodelacruz.cc.institutorestclient.model.database.AlumnoHelper;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.taskhandlers.TaskListener;
import es.iespuertodelacruz.cc.institutorestclient.model.networking.tasks.AlumnoTask;
import es.iespuertodelacruz.cc.institutorestclient.model.repository.AlumnoRepository;
import es.iespuertodelacruz.cc.institutorestclient.view.AlumnoListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements TaskListener {

    private RecyclerView recycler;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        AlumnoHelper helper = new AlumnoHelper(getApplicationContext());
        helper.deleteById("X8741949V");
        reloadAlumnos();
    }

    private void init() {
        this.recycler = findViewById(R.id.recycler);
    }

    protected void reloadAlumnos() {
        AlumnoTask task = new AlumnoTask(this,getApplicationContext(),null);
        task.execute(null, null, null);
    }

    @Override
    public void onTaskCompleted(Object result) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.addAll((Collection<? extends Alumno>) result);
        AlumnoListAdapter adapter = new AlumnoListAdapter(alumnos);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Pulsado", Toast.LENGTH_SHORT).show();
            }
        });

        runOnUiThread(() -> {
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setAdapter(adapter);
        });
    }
}