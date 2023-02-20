/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThucHanh13_11;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
class MonThi implements Comparable<MonThi>{
    private String maM, tenM, hinhThucThi;
    
    public MonThi(String maM, String tenM, String hinhThucThi) {
        this.maM = maM;
        this.tenM = tenM;
        this.hinhThucThi = hinhThucThi;
    }

    public String getMaM() {
        return maM;
    }
    
    @Override
    public int compareTo(MonThi o) {
        return this.maM.compareTo(o.maM);
    }
    
    @Override
    public String toString() {
        return maM + " " + tenM + " " + hinhThucThi;
    }
}
public class DanhSachMonThi {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        Set<String> s = new HashSet<>();
        ArrayList<MonThi> a = new ArrayList<>();
        while(sc.hasNextLine()) {
            MonThi mt = new MonThi(sc.nextLine(), sc.nextLine(), sc.nextLine());
            if(!s.contains(mt.getMaM())) {
                a.add(mt);
                s.add(mt.getMaM());
            }
        }
        Collections.sort(a);
        for(MonThi mt : a) {
            System.out.println(mt);
        }
    }
}
