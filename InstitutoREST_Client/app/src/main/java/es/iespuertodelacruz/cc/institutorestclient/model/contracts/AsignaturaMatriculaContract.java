package es.iespuertodelacruz.cc.institutorestclient.model.contracts;

public class AsignaturaMatriculaContract {

    private AsignaturaMatriculaContract() {}

    public static class AsignaturaMatriculaEntry {

        public static final String TABLE = "asignatura_matricula";
        public static final String ID = "id";
        public static final String ASIGNATURA = "idAsignatura";
        public static final String MATRICULA = "idMatricula";

        public static final String[] COLUMNS = {ID, ASIGNATURA, MATRICULA};

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ASIGNATURA + " INTEGER, " +
                MATRICULA + " INTEGER, " +
                "FOREIGN KEY (" + ASIGNATURA + ") REFERENCES " +
                AsignaturaContract.AsignaturaEntry.TABLE + " (" + AsignaturaContract.AsignaturaEntry.ID +
                ") ON UPDATE CASCADE ON DELETE CASCADE, " +
                "FOREIGN KEY (" + MATRICULA + ") REFERENCES " +
                MatriculaContract.MatriculaEntry.TABLE + " (" + MatriculaContract.MatriculaEntry.ID +
                ") ON UPDATE CASCADE ON DELETE CASCADE" +
                ");";

        public static final String SELECT_ALL = "SELECT " + Contract.getColumnList(COLUMNS, false) +
                " FROM " + TABLE;
        public static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + ID + " = ?";
        public static final String INSERT = "INSERT INTO " + TABLE + " (" + ASIGNATURA + ", " + MATRICULA + ") VALUES (?,?)";
        public static final String UPDATE = "UPDATE " + TABLE + " SET " + ASIGNATURA + " = ?, " + MATRICULA + " = ?" +
                " WHERE " + ID + " = ?";
        public static final String DELETE = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";
        public static final String DELETE_BY_MATRICULA = "DELETE FROM " + TABLE + " WHERE " + MATRICULA + " = ?";
        public static final String DELETE_BY_ASIGNATURA = "DELETE FROM " + TABLE + " WHERE " + ASIGNATURA + " = ?";
    }

}
