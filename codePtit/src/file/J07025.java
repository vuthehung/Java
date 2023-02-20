/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author Admin
 */
class KhachHang implements Comparable<KhachHang>{
    private String Ten,GioiTinh,DiaChi;
    private LocalDate NgaySinh;
    private int Ma;
    KhachHang(int Ma, String Ten, String GioiTinh, String NgaySinh, String DiaChi){
        this.Ma=Ma;
        this.Ten="";
        StringTokenizer st=new StringTokenizer(Ten);
        while(st.hasMoreTokens()){
            String s=st.nextToken();
            this.Ten+=s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase()+" ";
        }
        this.GioiTinh=GioiTinh;
        this.NgaySinh=LocalDate.parse(NgaySinh,DateTimeFormatter.ofPattern("d/M/yyyy"));
        this.DiaChi=DiaChi;
    }
    public LocalDate getNgaySinh(){
        return this.NgaySinh;
    }
    @Override
    public int compareTo(KhachHang x){
        if(this.getNgaySinh().isBefore(x.getNgaySinh()))return -1;
        return 1;
    }
    @Override
    public String toString(){
        return String.format("KH%03d %s%s %s %s", this.Ma, this.Ten, this.GioiTinh, this.DiaChi, this.NgaySinh.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}

public class J07025 {

    public static String chuanHoa(String s) {
        StringBuilder res = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken().toLowerCase();
            res.append(Character.toUpperCase(tmp.charAt(0)));
            for (int i = 1; i < tmp.length(); i++) {
                res.append(tmp.charAt(i));
            }
            res.append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("D:\\code\\Java\\codePtit\\src\\file\\SV.in"));
        ArrayList<KhachHang> a = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            KhachHang kh = new KhachHang(i, chuanHoa(sc.nextLine()), sc.nextLine(), sc.nextLine(), sc.nextLine());
            a.add(kh);
        }
        Collections.sort(a);
        for (KhachHang x : a) {
            System.out.println(x);
        }
    }
}
