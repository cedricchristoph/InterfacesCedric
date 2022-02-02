package es.iespuertodelacruz.cc.institutorestclient.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import es.iespuertodelacruz.cc.institutorestclient.R;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Alumno;

public class AlumnoListAdapter extends RecyclerView.Adapter<AlumnoListAdapter.ViewHolderAlumno> implements View.OnClickListener {

    ArrayList<Alumno> alumnos;
    private View.OnClickListener listener;

    public AlumnoListAdapter(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public AlumnoListAdapter.ViewHolderAlumno onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumno_layout,null,false);
        view.setOnClickListener(this);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolderAlumno(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAlumno holder, int position) {
        try {
            holder.txtNombre.setText(alumnos.get(position).getNombre());
            holder.txtDni.setText(alumnos.get(position).getDni());
        } catch (Exception e){}
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

    public class ViewHolderAlumno extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtDni;
        public ViewHolderAlumno(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtDni = itemView.findViewById(R.id.txtDni);
        }
    }
}