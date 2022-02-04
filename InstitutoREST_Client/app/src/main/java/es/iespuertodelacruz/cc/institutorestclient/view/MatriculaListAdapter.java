package es.iespuertodelacruz.cc.institutorestclient.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.iespuertodelacruz.cc.institutorestclient.R;
import es.iespuertodelacruz.cc.institutorestclient.model.entity.Matricula;

public class MatriculaListAdapter extends RecyclerView.Adapter<MatriculaListAdapter.ViewHolderMatricula> implements View.OnClickListener {

    ArrayList<Matricula> matriculas;
    private View.OnClickListener listener;

    public MatriculaListAdapter(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @NonNull
    @Override
    public MatriculaListAdapter.ViewHolderMatricula onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.matricula_layout,null,false);
        view.setOnClickListener(this);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolderMatricula(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMatricula holder, int position) {
        System.out.println("Entrado");
        try {
            holder.txtYear.setText(matriculas.get(position).getYear() + "");
            holder.txtAsignatura.setText("Asignaturas matriculadas: " + matriculas.get(position).getAsignaturas());
        } catch (Exception e){e.printStackTrace();}
    }

    @Override
    public int getItemCount() {
        return matriculas.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }

    public class ViewHolderMatricula extends RecyclerView.ViewHolder {
        TextView txtYear;
        TextView txtAsignatura;
        public ViewHolderMatricula(@NonNull View itemView) {
            super(itemView);
            txtYear = itemView.findViewById(R.id.txtYear);
            txtAsignatura = itemView.findViewById(R.id.txtAsignaturasCount);
        }
    }
}