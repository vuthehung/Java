/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05048;

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
            MatHang mh = new MatHang(sc.nextLine(), Integer.parseInt(sc.nextLine()));
            System.out.println(mh);
        }
    }
}

//3
//A001Y
//1000
//B012N
//2500
//B003Y
//4582