/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces_01.model.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Transaction Class
 * @author cedric christoph
 */
public class Transaction {
    
    private Path file;
    private Path backup;
    
    /**
     * Constructor of the Transaction
     * @param file File to preserve
     */
    public Transaction(Path file) {
        this.file = file;
        this.backup = Paths.get(file.getFileName().toString() + "_transaction");
    }

    /**
     * Starts the transaction / Creates backup file without changes
     * @return True and only true if backup file has been created
     */
    public boolean begin() {
        try {
            File sourceFile = file.toFile();
            File destFile = backup.toFile();
            
            if (!sourceFile.exists()) 
                sourceFile.createNewFile();
            
            if (!destFile.exists()) 
                destFile.createNewFile();
            
            FileChannel source = null;
            FileChannel destination = null;
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
            return true;
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return false;
    }

    /**
     * Ends the transaction and deletes the backup file
     * @return True if backup has been deleted
     */
    public boolean commit() {
        File destFile = backup.toFile();
        return destFile.delete();
    }
    
    /**
     * True if successfuly the backup file has replaced the original maintaining the data before any changes have been made.
     * @return True if rollBack was successful.
     */
    public boolean rollBack() {
        if (file.toFile().delete()) {
            backup.toFile().renameTo(file.toFile());
            return true;
        }
        return false;
    }
}
