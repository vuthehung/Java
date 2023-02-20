/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_basic;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Exception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try{
                int n = Integer.parseInt(sc.nextLine());
                System.out.println(n);
                break;
            } catch(NumberFormatException e) {
                System.out.println("Nhap lai");
            }
        }
    }
    /*
    -- Exception:
    + catch: bắt: try__catch: lỗi xảy ra ở đâu thì chuyển xuống catch
    + throw: đẩy: 1 là đẩy ra khỏi hàm(throws): (declare exception)đẩy trách nhiệm cho hàm khác thực hiện
                  2 (throw): cú pháp: throw new Exception;
    + 2 nhóm ngoại lệ: Checked: and unchecked: do lỗi lập trình
    + 
    */
}
