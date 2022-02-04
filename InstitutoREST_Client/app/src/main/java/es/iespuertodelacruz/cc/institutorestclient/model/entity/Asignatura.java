package es.iespuertodelacruz.cc.institutorestclient.model.entity;

import android.content.ContentValues;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AsignaturaContract;

/**
 * Entity Class Asignatura
 * @author cedric
 */
public class Asignatura {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("curso")
    @Expose
    private String curso;
    @SerializedName("nombre")
    @Expose
    private String nombre;

    public Asignatura() {}

    public Asignatura(int id, String curso, String nombre) {
        this.id = id;
        this.curso = curso;
        this.nombre = nombre;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AsignaturaContract.AsignaturaEntry.ID, id);
        values.put(AsignaturaContract.AsignaturaEntry.CURSO, curso);
        values.put(AsignaturaContract.AsignaturaEntry.NOMBRE, nombre);
        return values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return id == that.id && Objects.equals(curso, that.curso) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curso, nombre);
    }

    @Override
    public String toString() {
        return nombre + "  " + curso;
    }
}
