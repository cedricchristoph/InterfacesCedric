package es.iespuertodelacruz.cc.institutorestclient.model.contracts;

public class Contract {

    public static String getColumnList(String[] COLUMNS, boolean excludeFirst) {
        String list = "";
        for (int i = 0; i < COLUMNS.length; i++) {
            if (i == 0 && !excludeFirst)
                list = COLUMNS[i];
            else if (i == 1 && excludeFirst)
                list = COLUMNS[i];
            else if (i != 0)
                list += ", " + COLUMNS[i];
        }
        return list;
    }

}
