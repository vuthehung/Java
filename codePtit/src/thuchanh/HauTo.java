/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh;

import java.util.*;

/**
 *
 * @author Admin
 */
public class HauTo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            System.out.println(tinhGiaTri(s));
        }
    }

    public static long tinhGiaTri(String str) {
        Stack<Long> stack = new Stack<>();
        String[] tmp = str.split(" ");
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].equals("+") || tmp[i].equals("-") || tmp[i].equals("*") || tmp[i].equals("/")) {
                long a = stack.pop(), b = stack.pop();
                long temp = 0;
                switch (tmp[i]) {
                    case "+":
                        temp = b + a;
                        break;
                    case "-":
                        temp = b - a;
                        break;
                    case "*":
                        temp = b * a;
                        break;
                    case "/":
                        temp = b / a;
                        break;
//                        case '^': temp = (int)Math.pow(b, a); break;
//                        case '%': temp = b%a; break;

                }
                stack.push(temp);
            } else {
                stack.push(Long.parseLong(tmp[i]));
            }
        }
        return stack.peek();
    }
}
