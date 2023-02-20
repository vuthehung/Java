/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codeptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Admin
 */
class Infor implements Comparable<Infor> {
    private String ten;
    private Date ns;

    public Infor(String ten, String ns) throws ParseException {
        this.ten = ten;
        this.ns = new SimpleDateFormat("dd/MM/yyyy").parse(ns);
    }
    @Override
    public int compareTo(Infor o) {
        return (int) (this.ns.getTime() / (24 * 60 * 60 * 1000) - o.ns.getTime() / (24 * 60 * 60 * 1000));
    }
    @Override
    public String toString() {
        return ten;
    }
}
public class J05032 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Infor> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            a.add(new Infor(sc.next(), sc.next()));
        }
        Collections.sort(a);
        Infor gia = a.get(0);
        Infor tre = a.get(a.size() - 1);
        System.out.println(tre);
        System.out.println(gia);
    }
}
