/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;
import java.io.*;
import java.text.*;
import java.util.*;
/**
 *
 * @author Admin
 */
class DSLT implements Comparable<DSLT>{
    private String maKH, ten, maP;
    private Date nDen, nDi;
    private long nLT;
    
    public DSLT(int n, String ten, String maP, String nDen, String nDi) throws ParseException{
        this.maKH = "KH" + String.format("%02d", n);
        this.ten = ten;
        this.maP = maP;
        this.nDen = new SimpleDateFormat("dd/MM/yyyy").parse(nDen);
        this.nDi = new SimpleDateFormat("dd/MM/yyyy").parse(nDi);  
        long nLT = (this.nDi.getTime() - this.nDen.getTime()) / (24 * 60 * 60 * 1000);
        this.nLT = nLT;
    }
    @Override
    public String toString() {
        return maKH + " " + ten + " " + maP + " " + nLT;
    }
    @Override
    public int compareTo(DSLT o) {
        return (int) (o.nLT - this.nLT);
    }
}
public class J07046 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
       Scanner sc = new Scanner(new File("KHACH.in"));
       ArrayList<DSLT> a = new ArrayList<>();
       int n = Integer.parseInt(sc.nextLine());
       for(int i = 1; i <= n; i++) {
           DSLT tmp = new DSLT(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
           a.add(tmp);
       }
       Collections.sort(a);
       for(DSLT x : a) {
           System.out.println(x);
       }
    }
}
