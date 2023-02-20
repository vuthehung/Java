/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaCollections;

import java.util.*;

/**
 *
 * @author Admin
 */
public class JKT015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st1 = new Stack();
        Stack<Character> st2 = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                if (!st1.empty()) {
                    st2.add(st1.pop());
                }
            } else if (s.charAt(i) == '>') {
                if (!st2.empty()) {
                    st1.add(st2.pop());
                }
            } else if (s.charAt(i) == '-') {
                if (!st1.empty()) {
                    st1.pop();
                }
            } else {
                st1.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st1.empty()) {
            sb.append(st1.pop());
        }
        sb = sb.reverse();
        System.out.print(sb);
        while (!st2.empty()) {
            System.out.print(st2.pop());
        }
    }
}
