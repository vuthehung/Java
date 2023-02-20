/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.HashSet;
import java.util.Scanner;


/**
 *
 * @author Admin
 */
public class J03010 {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> resSet = new HashSet<>();
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0) {
            String s = sc.nextLine().toLowerCase(), res = "";
            String[] s_arr = s.trim().split("\\s+");
            res += s_arr[s_arr.length - 1];
            for(int i = 0; i < s_arr.length - 1; i++) {
                res += s_arr[i].charAt(0);
            }
            if(resSet.contains(res)){
                int i = 2;
                while(resSet.contains(res.concat(String.valueOf(i)))) {
                    i++;
                }
                res = res.concat(String.valueOf(i));
            }
            resSet.add(res);
            System.out.println(res + "@ptit.edu.vn");
        }
    }
}
