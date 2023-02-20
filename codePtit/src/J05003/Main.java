/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05003;

import java.text.ParseException;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        ArrayList<SinhVien> ds = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= n; i++) {
            SinhVien tmp = new SinhVien(i, in.nextLine(), in.nextLine(), in.nextLine(), Float.parseFloat(in.nextLine()));
            ds.add(tmp);
        }
        for(SinhVien sv : ds) {
            System.out.println(sv);
        }
    }
}
