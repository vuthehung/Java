/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Admin
 */
class TienPhong implements Comparable<TienPhong>{
    private String maKH, tenKH;
    private int soP, dichVu;
    private long ngayO, tongT;
    private Date nDen, nDi;
    
    public TienPhong(int n, String tenKH, int soP, String nDen, String nDi, int dichVu) throws ParseException {
        this.maKH = "KH" + String.format("%02d", n);
        this.tenKH = tenKH;
        this.soP = soP;
        this.nDen = new SimpleDateFormat("dd/MM/yyyy").parse(nDen);
        this.nDi = new SimpleDateFormat("dd/MM/yyyy").parse(nDi);
        this.dichVu = dichVu;
        long nO = (this.nDi.getTime() - this.nDen.getTime()) / (24 * 60 * 60 * 1000);
        this.ngayO = nO + 1;
        long tong = 0;
        if(this.soP >= 100 && this.soP < 200) {
            tong = 25 * this.ngayO + this.dichVu;
        } else if(this.soP >= 200 && this.soP < 300) {
            tong = 34 * this.ngayO + this.dichVu;
        } else if(this.soP >= 300 && this.soP < 400) {
            tong = 50 * this.ngayO + this.dichVu;
        } else {
            tong = 80 * this.ngayO + this.dichVu;
        }
        this.tongT = tong;
    }
    @Override
    public String toString() {
        return maKH + " " + tenKH + " " + soP + " " + ngayO + " " + tongT;
    }
    @Override
    public int compareTo(TienPhong o) {
        return (int) (o.tongT - this.tongT);
    }
}
public class J07051 {
    public static String chuanHoa(String s) {
        StringBuilder kq = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken().toLowerCase();
            kq.append(Character.toUpperCase(tmp.charAt(0)));
            for(int i = 1; i < tmp.length(); i++) {
                kq.append(tmp.charAt(i));
            }
            kq.append(" ");
        }
        return kq.toString().trim();
    }
    public static void main(String[] args) throws FileNotFoundException, ParseException{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        ArrayList<TienPhong> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 1; i <= n; i++) {
            TienPhong tmp = new TienPhong(i, chuanHoa(sc.nextLine()), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
            a.add(tmp);
        }
        Collections.sort(a);
        for(TienPhong x : a) {
            System.out.println(x);
        }
    }
}
