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
    private String MaSanPham,Loai;
    private int stt,SoLuong,ThanhTien,GiamGia;
    public HoaDon(int stt, String ThongTin){
        this.stt=stt;
        this.MaSanPham=ThongTin.split(" ")[0].substring(0,2);
        this.Loai=ThongTin.split(" ")[0].substring(2);
        this.SoLuong=Integer.parseInt(ThongTin.split(" ")[1]);
    }
    public void TinhTien(int Gia){
        this.ThanhTien=this.SoLuong*Gia;
        if(this.SoLuong>=150)
            this.GiamGia=this.ThanhTien/2;
        else if(this.SoLuong>=100)
            this.GiamGia=this.ThanhTien*3/10;
        else if(this.SoLuong>=50)
            this.GiamGia=this.ThanhTien*15/100;
        else this.GiamGia=0;
        this.ThanhTien-=this.GiamGia;
    }
    public String getMaSanPham(){
        return this.MaSanPham;
    }
    public String getLoai(){
        return this.Loai;
    }
    public String Tien(){
        return String.format("%d %d", this.GiamGia, this.ThanhTien);
    }
    @Override
    public String toString(){
        return String.format("%s%s-%03d", this.MaSanPham,this.Loai,this.stt);
    }
}
class SanPham {
    private String Ten;
    private int Loai1, Loai2;
    public SanPham(String Ten, int Loai1, int Loai2){
        this.Ten=Ten;
        this.Loai1=Loai1;
        this.Loai2=Loai2;
    }
    public String getTen(){
        return this.Ten;
    }
    public int getLoai(String Loai){
        return Loai.equals("1")?this.Loai1:this.Loai2;
    }
}
public class J07019 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner file1=new Scanner(new File("DATA1.in"));
        Scanner file2=new Scanner(new File("DATA2.in"));
        Map<String,SanPham> m=new HashMap<>();
        int n=Integer.parseInt(file1.nextLine());
        while(n-->0){
            m.put(file1.nextLine(), new SanPham(file1.nextLine(),Integer.parseInt(file1.nextLine()),Integer.parseInt(file1.nextLine())));
        }
        n=Integer.parseInt(file2.nextLine());
        ArrayList<HoaDon> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            HoaDon x=new HoaDon(i+1, file2.nextLine());
            x.TinhTien(m.get(x.getMaSanPham()).getLoai(x.getLoai()));
            System.out.printf("%s %s %s\n", x, m.get(x.getMaSanPham()).getTen(), x.Tien());
        }
    }
}
