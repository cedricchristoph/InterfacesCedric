package es.iespuertodelacruz.cc.institutorestclient.model.contracts;


public class AsignaturaContract {

    private AsignaturaContract() {}

    public static class AsignaturaEntry {

        public static final String TABLE = "asignaturas";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String CURSO = "curso";

        public static final String[] COLUMNS = {ID, NOMBRE, CURSO};

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOMBRE + " VARCHAR(50), " +
                CURSO + " VARCHAR(50) " +
                ");";
        public static final String SELECT_ALL = "SELECT " + Contract.getColumnList(COLUMNS, false) +
                " FROM " + TABLE;
        public static final String SELECT_BY_ID = SELECT_ALL + " WHERE " + ID + " = ?";
        public static final String INSERT = "INSERT INTO " + TABLE + " (" + NOMBRE + ", " + CURSO + ") VALUES (?,?)";
        public static final String UPDATE = "UPDATE " + TABLE + " SET " + NOMBRE + " = ?, " + CURSO + " = ?" +
                " WHERE " + ID + " = ?";
        public static final String DELETE = "DELETE FROM " + TABLE + " WHERE " + ID + " = ?";

    }

}
