package es.iespuertodelacruz.cc.institutorestclient.model.contracts;

public class MatriculaContract {

    private MatriculaContract() {}

    public static class MatriculaEntry {

        public static final String TABLE = "matriculas";
        public static final String ID = "id";
        public static final String YEAR = "year";
        public static final String DNI_ALUMNO = "alumno";

        public static final String[] COLUMNS = {ID, YEAR, DNI_ALUMNO};

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                YEAR + " INTEGER, " +
                DNI_ALUMNO + " VARCHAR(10), " +
                "FOREIGN KEY (" + DNI_ALUMNO + ") REFERENCES " +
                AlumnoContract.AlumnoEntry.TABLE + " (" + AlumnoContract.AlumnoEntry.DNI +
                ")" +
                ");";
        public static final String SELECT_ALL = "SELECT " + Contract.getColumnList(COLUMNS, false) +
                " FROM " + TABLE;
        public static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + ID + " = ?";
        public static final String INSERT = "INSERT INTO " + TABLE + " (" + YEAR + ", " + DNI_ALUMNO + ") VALUES (?,?)";
        public static final String UPDATE = "UPDATE " + TABLE + " SET " + YEAR + " = ?, " + DNI_ALUMNO + " = ?" +
                " WHERE " + ID + " = ?";
        public static final String DELETE = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";

    }

}
