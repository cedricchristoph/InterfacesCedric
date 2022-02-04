package es.iespuertodelacruz.cc.institutorestclient.model.contracts;

public class AlumnoContract {

    private AlumnoContract() {}

    public static class AlumnoEntry {
        public static final String TABLE = "alumnos";
        public static final String DNI = "dni";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDOS = "apellidos";
        public static final String FECHANACIMIENTO = "fechanacimiento";

        public static final String[] COLUMNS = {DNI, NOMBRE, APELLIDOS, FECHANACIMIENTO};


        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE + " (" +
                DNI + " VARCHAR(10) PRIMARY KEY, " +
                NOMBRE + " VARCHAR(50), " +
                APELLIDOS + " VARCHAR(50), " +
                FECHANACIMIENTO + " INTEGER" +
                ");";
        public static final String SELECT_ALL = "SELECT " + Contract.getColumnList(COLUMNS, false) +
                " FROM " + TABLE;
        public static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + DNI + " = ?";
        public static final String INSERT = "INSERT INTO " + TABLE + " (" + DNI + ", " + NOMBRE + ", " +
                APELLIDOS + ", " + FECHANACIMIENTO + ") VALUES (?,?,?,?)";
        public static final String UPDATE = "UPDATE " + TABLE + " SET " + NOMBRE + " = ?, " + APELLIDOS + " = ?, " +
                FECHANACIMIENTO + " = ? WHERE " + DNI + " = ?";
        public static final String DELETE = "DELETE FROM " + TABLE + " WHERE " + DNI + " = ?";
        public static final String ERASE = "DELETE FROM " + TABLE;
    }
}
