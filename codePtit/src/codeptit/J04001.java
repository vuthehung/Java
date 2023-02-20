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
public class J04001 {
    
    private double x, y;
    
    public J04001(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double distance(J04001 a) {
        double x1 = this.x - a.x;
        double y1 = this.y - a.y;
        return Math.sqrt(x1 * x1 + y1 * y1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            J04001 point1 = new J04001(x1, y1);
            J04001 point2 = new J04001(x2, y2);
            System.out.printf("%.4f\n", point1.distance(point2));
        }
    }
}
