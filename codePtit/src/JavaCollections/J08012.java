/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaCollections;

/**
 *
 * @author Admin
 */
import java.util.*;

public class J08012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int key = sc.nextInt();
            if (m.containsKey(key)) {
                m.put(key, m.get(key) + 1);
            } else {
                m.put(key, 1);
            }
            key = sc.nextInt();
            if (m.containsKey(key)) {
                m.put(key, m.get(key) + 1);
            } else {
                m.put(key, 1);
            }
        }
        int dem = 0;
        boolean check = true;
        for (Map.Entry<Integer, Integer> x : m.entrySet()) {
            if (x.getValue() == n - 1) {
                dem += 1;
                if (dem >= 2) {
                    check = false;
                    break;
                }
            } else if (x.getValue() != 1) {
                check = false;
                break;
            }
        }
        if (!check) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
