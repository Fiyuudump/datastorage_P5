/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.id.asia.datastorage;

/**
 *
 * @author D-11
 */
public class Main {
    public static void main(String[] args) {
        
        // Contoh penggunaan MemoryStorage
        DataStorage memoryStorage = new MemoryStorage1();
        memoryStorage.writeData("Data stored in memory");
        System.out.println("Memory storage: " + memoryStorage.readData());
        
        // Contoh penggunaan FileStorage
        DataStorage fileStorage = new FileStorage("file_data/data.txt");
        fileStorage.writeData("Data stored in file");
        System.out.println("File storage: " + fileStorage.readData());
        
        // Contoh penggunaan DatabaseStorage
        DataStorage databaseStorage = new DatabaseStorage("db_data/database.db");
        databaseStorage.writeData("Data stored in database");
        System.out.println("Database storage: " + databaseStorage.readData());
        
    }
}
