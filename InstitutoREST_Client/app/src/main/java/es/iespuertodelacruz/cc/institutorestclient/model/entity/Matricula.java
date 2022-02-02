package es.iespuertodelacruz.cc.institutorestclient.model.entity;

import android.content.ContentValues;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.MatriculaContract;

public class Matricula {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("alumnoDni")
    @Expose
    private String alumnoDni;
    @SerializedName("asignaturas")
    @Expose
    private List<Asignatura> asignaturas;

    public Matricula() {}

    public Matricula(int id, int year, String alumnoDni, List<Asignatura> asignaturas) {
        this.id = id;
        this.year = year;
        this.alumnoDni = alumnoDni;
        this.asignaturas = asignaturas;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(MatriculaContract.MatriculaEntry.ID, id);
        values.put(MatriculaContract.MatriculaEntry.YEAR, year);
        values.put(MatriculaContract.MatriculaEntry.DNI_ALUMNO, alumnoDni);
        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAlumnoDni() {
        return alumnoDni;
    }

    public void setAlumnoDni(String alumnoDni) {
        this.alumnoDni = alumnoDni;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matricula matricula = (Matricula) o;
        return id == matricula.id && year == matricula.year && alumnoDni.equals(matricula.alumnoDni) && Objects.equals(asignaturas, matricula.asignaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, alumnoDni, asignaturas);
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", year=" + year +
                ", alumnoDni='" + alumnoDni + '\'' +
                ", asignaturas=" + asignaturas +
                '}';
    }
}

