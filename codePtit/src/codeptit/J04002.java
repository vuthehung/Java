/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
class Rectangle {
    double width, height;
    String color;
    
    void input(Scanner sc) {
        width = sc.nextInt();
        height = sc.nextInt();
        color = sc.next().toLowerCase();
        color = color.substring(0, 1).toUpperCase() + color.substring(1);
    }
    
    int check() {
        int w = (int) this.width;
        int h = (int) this.height;
        if(w != width || h != height || w <= 0 || h <= 0)
            return 0;
        return 1;
    }
    
    double c() {
        return (width + height) * 2;
    }
    
    double s() {
        return width * height;
    }
}

public class J04002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle r = new Rectangle();
        r.input(sc);
        if(r.check() == 0) System.out.println("INVALID");
        else System.out.printf("%d %d %s", (int)r.c(), (int)r.s(), r.color);
    }
}
