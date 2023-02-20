/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05080;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            String gv = sc.nextLine();
            if(LopHoc.m.containsKey(gv)) {
                LopHoc.m.get(gv).add(new LopHoc(ma, ten, nhom, gv));
            }else {
                LopHoc.m.put(gv, new ArrayList<>(Arrays.asList(new LopHoc(ma, ten, nhom, gv))));
            }
        }
        int m = Integer.parseInt(sc.nextLine());
        while(m-- > 0) {
            String gv = sc.nextLine();
            System.out.println("Danh sach cho giang vien " + LopHoc.m.get(gv).get(0).getGv() + ":");
            Collections.sort(LopHoc.m.get(gv));
            for(LopHoc lh : LopHoc.m.get(gv)) {
                System.out.println(lh);
            }
        }
    }
}
//4
//THCS2D20
//Tin hoc co so 2 - D20
//01
//Nguyen Binh An
//CPPD20
//Ngon ngu lap trinh C++ - D20
//01
//Le Van Cong
//THCS2D20
//Tin hoc co so 2 - D20
//02
//Nguyen Trung Binh
//LTHDTD19
//Lap trinh huong doi tuong - D19
//01
//Nguyen Binh An
//1
//Nguyen Binh An