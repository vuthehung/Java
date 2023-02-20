/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05077;

import java.util.*;

/**
 *
 * @author Admin
 */
public class PhongBan {
    private static Map<String, String> pb = new HashMap<>();
    
    public PhongBan() {
        
    }
    
    public static void setPhongBan(String ma, String ten) {
        pb.put(ma, ten);
    }
    
    public String getTenPB(String ma) {
        return pb.get(ma);
    }
}
