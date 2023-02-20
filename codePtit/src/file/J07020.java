/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author Admin
 */
import java.io.*;
import java.util.*;

class HoaDon {

    private String MaMatHang, MaKhachHang;
    private int SoLuong;

    public HoaDon(String ThongTin) {
        this.MaKhachHang = ThongTin.split(" ")[0];
        this.MaMatHang = ThongTin.split(" ")[1];
        this.SoLuong = Integer.parseInt(ThongTin.split(" ")[2]);
    }

    public String getMaKhachHang() {
        return this.MaKhachHang;
    }

    public String getMaMatHang() {
        return this.MaMatHang;
    }

    public int getSoLuong() {
        return this.SoLuong;
    }
}

class KhachHang {

    private int Ma;
    private String Ten, GioiTinh, NgaySinh, DiaChi;

    public KhachHang(int Ma, String Ten, String GioiTinh, String NgaySinh, String DiaChi) {
        this.Ma = Ma;
        this.Ten = Ten;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
    }

    public String getTen() {
        return this.Ten;
    }

    public String getDiaChi() {
        return this.DiaChi;
    }
}

class MatHang {

    private int Ma, Mua, Ban;
    private String Ten, DonVi;

    public MatHang(int Ma, String Ten, String DonVi, int Mua, int Ban) {
        this.Ma = Ma;
        this.Ten = Ten;
        this.DonVi = DonVi;
        this.Mua = Mua;
        this.Ban = Ban;
    }

    public String getTen() {
        return this.Ten;
    }

    public String getDonVi() {
        return this.DonVi;
    }

    public int getMua() {
        return this.Mua;
    }

    public int getBan() {
        return this.Ban;
    }
}

public class J07020 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner KHin = new Scanner(new File("KH.in"));
        Scanner MHin = new Scanner(new File("MH.in"));
        Scanner HDin = new Scanner(new File("HD.in"));
        Map<String, KhachHang> KH = new HashMap<>();
        Map<String, MatHang> MH = new HashMap<>();
        int n = Integer.parseInt(KHin.nextLine());
        for (int i = 0; i < n; i++) {
            KH.put(String.format("KH%03d", i + 1), new KhachHang(i + 1, KHin.nextLine(), KHin.nextLine(), KHin.nextLine(), KHin.nextLine()));
        }
        n = Integer.parseInt(MHin.nextLine());
        for (int i = 0; i < n; i++) {
            MH.put(String.format("MH%03d", i + 1), new MatHang(i + 1, MHin.nextLine(), MHin.nextLine(), Integer.parseInt(MHin.nextLine()), Integer.parseInt(MHin.nextLine())));
        }
        n = Integer.parseInt(HDin.nextLine());
        for (int i = 0; i < n; i++) {
            HoaDon x = new HoaDon(HDin.nextLine());
            System.out.printf("HD%03d %s %s %s %s %d %d %d %d\n", i + 1, KH.get(x.getMaKhachHang()).getTen(), KH.get(x.getMaKhachHang()).getDiaChi(), MH.get(x.getMaMatHang()).getTen(), MH.get(x.getMaMatHang()).getDonVi(), MH.get(x.getMaMatHang()).getMua(), MH.get(x.getMaMatHang()).getBan(), x.getSoLuong(), x.getSoLuong() * MH.get(x.getMaMatHang()).getBan());
        }
    }
}
