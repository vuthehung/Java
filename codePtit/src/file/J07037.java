/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.util.*;

/**
 *
 * @author Admin
 */
class DoanhNghiep {
    String maDN, tenDN;
    int soSV;
    
    void input(Scanner sc) {
        sc.nextLine();
        maDN = sc.nextLine();
        tenDN = sc.nextLine();
        soSV = sc.nextInt();
    }
    
    @Override
    public String toString() {
        return maDN + " " + tenDN + " " + soSV;
    }
}
public class J07037 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = sc.nextInt();
        ArrayList<DoanhNghiep> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            DoanhNghiep dn = new DoanhNghiep();
            dn.input(sc);
            a.add(dn);
        }
        Collections.sort(a, (DoanhNghiep o1, DoanhNghiep o2) -> o1.maDN.compareTo(o2.maDN));
        for(DoanhNghiep x : a) {
            System.out.println(x);
        }
    }
}
