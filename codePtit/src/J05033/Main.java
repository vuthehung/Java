/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package J05033;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<ThoiGian> a = new ArrayList<>();
        while(t-- > 0) {
            a.add(new ThoiGian(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a);
        for(ThoiGian tg : a) {
            System.out.println(tg);
        }
    }
}
