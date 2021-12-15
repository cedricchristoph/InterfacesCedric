package interfaces_01.model.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase FileManager.
 * @author Cedric Christoph
 */
public class FileManager {
    
    public static final String PERSONAS_FILE = "personas.csv";
    public static final String INDEX_FILE = "index.txt";
    
    private Path file;
    private Path indexFile;
    
    /**
     * Constructor de clase FileManager
     * @param file Archivo al que guardar los datos
     * @param indexFile Archivo con el que realizar el indexado
     */
    public FileManager(String file, String indexFile) {
        this.file = Paths.get(file);
        this.indexFile = Paths.get(indexFile);
        System.out.println(this.file.toFile().getAbsolutePath());
    }
    
    /**
     * Funcion que devuelve el contenido de un fichero de texto como Lista de string separado por lineas
     * ! PRECAUCION ! No se recomienda su uso con ficheros grandes.
     * @return 
     */
    public List<String> readAllLines() {
        try {
            return Files.readAllLines(file, Charset.forName("UTF-8"));
        } catch (IOException ex) {
        }
        return new ArrayList<String>();
    }
    
    /**
     * Metodo que inserta una linea de texto al fichero indicado
     * @param line Texto a insertar al documento
     */
    public void insert(String data) {
        Transaction transaction = new Transaction(file);
        transaction.begin();
        
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            writer.write(data);
            writer.close();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollBack();
            try {
                writer.close();
            } catch (Exception ex) {
            }
        }
    }
    
    /**
     * Overwrites the entire file with the specified lines
     * @param lines Lines to write to file
     */
    public void overwrite(List<String> lines) throws Exception {
        BufferedWriter writer = null;

        try {
            writer = Files.newBufferedWriter(file, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            for (String line : lines)
                writer.write(line);
            writer.close();
        } catch (Exception e) {
            try {
                writer.close();
            } catch (Exception ex) {
            }
            throw new Exception(e);
        }
    }
    
    /**
     * Funcion que reemplaza una linea de datos con determinado index por otra.
     * La funcion se asegura del correcto funcionamiento del guardado. En caso de un error reestablece el fichero
     * original asegurandose de mantener el fichero intacto.
     * 
     * @param data Linea de datos nueva. NULL para eliminar la fila
     * @param index Index de la linea a reemplazar
     * @throws Exception Throws the exception that has ocurred.
     */
    public void update(String data, Integer index) throws Exception {
        BufferedReader reader = null;
        List<String> newLines = new ArrayList<String>();
        Transaction transaction = new Transaction(file);
        transaction.begin();
        try {
            reader = Files.newBufferedReader(file);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(";");
                Integer i = Integer.parseInt(split[0]);
                if (i == index) {
                    if (data != null)
                        newLines.add(data);
                } else {
                    newLines.add(line + "\n");
                }
            }
            overwrite(newLines);
            transaction.commit();
        } catch (Exception e) {     
            transaction.rollBack();
            throw new Exception("Ocurrio un error al manipular el fichero. Se han rescatado los datos anteriores a la manipulacion");
        }
    }
    
    /**
     * Metodo para eliminar una file del fichero. Utiliza el metodo update con un valor NULL en data
     * @param index Posicion de fila a eliminar
     * @throws Exception 
     */
    public void delete(Integer index) throws Exception {
        update(null, index);
    }
    
    /**
     * Funcion que devuelve el siguiente Index y lo aumenta automaticamente
     * @return Integer index value
     */
    public Integer getIndex() {
        BufferedWriter writer = null;
        BufferedReader reader = null;
        Integer index = null;
        Transaction transaction = new Transaction(indexFile);
        transaction.begin();
        try {
            try {
                reader = Files.newBufferedReader(indexFile);
                index = Integer.parseInt(reader.readLine());
                reader.close();
            } catch (Exception e) {}
            writer = Files.newBufferedWriter(indexFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            if (index == null) {
                writer.write("1");
                index = 0;
            } else
                writer.write(index + 1 + "");
            writer.close();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollBack();
            index = null;
            try {
                writer.close();
                reader.close();
            } catch (Exception ex) {
                
            }
        }
        return index;
    }
}
