/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.*;

/**
 *
 * @author Admin
 */
public class J02017 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int i = 0;
        while (i < list.size() - 1) {
            if ((list.get(i) + list.get(i + 1)) % 2 == 0) {
                list.remove(i);
                list.remove(i);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        System.out.println(list.size());
    }
}
