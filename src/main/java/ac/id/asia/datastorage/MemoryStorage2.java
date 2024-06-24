/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.id.asia.datastorage;

import java.util.ArrayList;

/**
 *
 * @author D-11
 */
public class MemoryStorage2 implements DataStorage {
    private ArrayList<String> data;
    
    public MemoryStorage2() {
        this.data = new ArrayList<>();
    }
    
    @Override
    public void writeData(String data) {
        this.data.add(data);
    }
    
    @Override
    public String readData() {
        StringBuilder sb = new StringBuilder();
        for (String item : this.data) {
            sb.append(item);
        }
        return sb.toString();
    }
}



