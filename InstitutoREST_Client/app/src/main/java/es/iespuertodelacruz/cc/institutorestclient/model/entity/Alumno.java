package es.iespuertodelacruz.cc.institutorestclient.model.entity;

import android.content.ContentValues;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import es.iespuertodelacruz.cc.institutorestclient.model.contracts.AlumnoContract;

/**
 * Entity Class Alumno
 * @author cedric
 */
public class Alumno {

    @SerializedName("dni")
    @Expose
    private String dni;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("apellidos")
    @Expose
    private String apellidos;
    @SerializedName("fechanacimiento")
    @Expose
    private long fechanacimiento;

    public Alumno() {}

    public Alumno(String dni, String nombre, String apellidos, long fechanacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AlumnoContract.AlumnoEntry.DNI, dni);
        values.put(AlumnoContract.AlumnoEntry.NOMBRE, nombre);
        values.put(AlumnoContract.AlumnoEntry.APELLIDOS, apellidos);
        values.put(AlumnoContract.AlumnoEntry.FECHANACIMIENTO, fechanacimiento);
        return values;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(long fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return fechanacimiento == alumno.fechanacimiento && dni.equals(alumno.dni) && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellidos, alumno.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, apellidos, fechanacimiento);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                '}';
    }
}
