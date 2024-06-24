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
public class MemoryStorage1 implements DataStorage {
    private String data;
    
    @Override
    public void writeData(String data) {
        this.data = data;
    }
    
    @Override
    public String readData() {
        return this.data;
    }
}

