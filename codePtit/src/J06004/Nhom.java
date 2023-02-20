/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J06004;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Nhom {
    private static Map<Integer, String> g = new HashMap<>();
    
    public Nhom() {
        
    }
    
    public static void setNhom(int stt, String ndBTL) {
        g.put(stt, ndBTL);
    }
    
    public String getNhom(int stt) {
        return stt + " " + g.get(stt);
    }
}
