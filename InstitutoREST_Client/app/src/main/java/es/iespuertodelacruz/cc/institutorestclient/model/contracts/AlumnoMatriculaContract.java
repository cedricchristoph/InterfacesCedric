package es.iespuertodelacruz.cc.institutorestclient.model.contracts;

public class AlumnoMatriculaContract {

    private AlumnoMatriculaContract() {}

    public static class AlumnoMatriculaEntry {

        public static final String TABLE = "alumno_matricula";
        public static final String ID = "id";
        public static final String ALUMNO = "idAlumno";
        public static final String MATRICULA = "idMatricula";

        public static final String[] COLUMNS = {ID, ALUMNO, MATRICULA};

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ALUMNO + " INTEGER, " +
                MATRICULA + " INTEGER, " +
                "FOREIGN KEY (" + ALUMNO + ") REFERENCES " +
                AlumnoContract.AlumnoEntry.TABLE + " (" + AlumnoContract.AlumnoEntry.DNI +
                ") ON UPDATE CASCADE ON DELETE CASCADE, " +
                "FOREIGN KEY (" + MATRICULA + ") REFERENCES " +
                MatriculaContract.MatriculaEntry.TABLE + " (" + MatriculaContract.MatriculaEntry.ID +
                ") ON UPDATE CASCADE ON DELETE CASCADE" +
                ");";

        public static final String SELECT_ALL = "SELECT " + Contract.getColumnList(COLUMNS, false) +
                " FROM " + TABLE;
        public static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + ID + " = ?";
        public static final String INSERT = "INSERT INTO " + TABLE + " (" + ALUMNO + ", " + MATRICULA + ") VALUES (?,?)";
        public static final String UPDATE = "UPDATE " + TABLE + " SET " + ALUMNO + " = ?, " + MATRICULA + " = ?" +
                " WHERE " + ID + " = ?";
        public static final String DELETE = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";
        public static final String DELETE_BY_MATRICULA = "DELETE FROM " + TABLE + " WHERE " + MATRICULA + " = ?";
        public static final String DELETE_BY_ASIGNATURA = "DELETE FROM " + TABLE + " WHERE " + ALUMNO + " = ?";
        public static final String ERASE = "DELETE FROM " + TABLE;
    }

}
