/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package levels;
/**
 *
 * @author Admin
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import nhanVat.*;
import vatThe.*;

import static phuongThucTaiSuDung.HangSo.QuaiVat.*;
import static phuongThucTaiSuDung.HangSo.viTriCacVatThe.*;

public class Lvl {

    private BufferedImage anh;
    private int[][] chatLieu;

    private ArrayList<Cua> cua = new ArrayList<>();
    private ArrayList<SaoBien> saoBien = new ArrayList<>();
    private ArrayList<CaMap> caMap = new ArrayList<>();
    private ArrayList<LoThuoc> loThuoc = new ArrayList<>();
    private ArrayList<Bay> bay = new ArrayList<>();
    private ArrayList<ThungChua> thungChua = new ArrayList<>();
    private ArrayList<Phao> phao = new ArrayList<>();
    private ArrayList<Cay> cay = new ArrayList<>();
    private ArrayList<Co> co = new ArrayList<>();

    private int doRongO;
    private int buOToiDa;
    private int buXToiDa;
    
    private Point viTriCuopBien;

    public Lvl(BufferedImage anh) {
        this.anh = anh;
        chatLieu = new int[anh.getHeight()][anh.getWidth()];
        
        //đọc màu để load vật thể
        // Lặp qua các màu của hình ảnh một lần.
        for (int y = 0; y < anh.getHeight(); y++) {
            for (int x = 0; x < anh.getWidth(); x++) {
                Color c = new Color(anh.getRGB(x, y));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                taiChatLieuMap(r, x, y);
                taiNhanVat(g, x, y);
                taiVatThe(b, x, y);
            }
        }
        
        doRongO = anh.getWidth();
        buOToiDa = doRongO - 26;
        buXToiDa = 48 * buOToiDa;
    }

    //tải chất liệu map(ĐẤT) tương ứng với giá trị R trong RGB
    private void taiChatLieuMap(int r, int x, int y) {
        if (r == 50) {
            chatLieu[y][x] = 0;
        } else {
            chatLieu[y][x] = r;
        }
        switch (r) {
            //các bề mặt xanh mà cỏ có thể mọc
            case 0, 1, 2, 3, 30, 31, 33, 34, 35, 36, 37, 38, 39 ->
                co.add(new Co((int) (x * 48), (int) (y * 48) - 48, (x % 2)));
        }
    }

    //tải các nhân vật tương ứng với giá trị G trong RGB
    //cua:0, saobien:1, caMap:2
    private void taiNhanVat(int g, int x, int y) {
        switch (g) {
            case Cua ->
                cua.add(new Cua(x * 48, y * 48));
            case SaoBien ->
                saoBien.add(new SaoBien(x * 48, y * 48));
            case CaMap ->
                caMap.add(new CaMap(x * 48, y * 48));
            case 100 ->
                viTriCuopBien = new Point(x * 48, y * 48);
        }
    }
    //tải các vật thể tương ứng với màu B trong RGB
    private void taiVatThe(int b, int x, int y) {
        switch (b) {
            case LoMau, LoNangLuong ->
                loThuoc.add(new LoThuoc(x * 48, y * 48, b));
            case Hop, Thung ->
                thungChua.add(new ThungChua(x * 48, y * 48, b));
            case Bay ->
                bay.add(new Bay(x * 48, y * 48, Bay));
            case PhaoTrai, PhaoPhai ->
                phao.add(new Phao(x * 48, y * 48, b));
            case Cay_1, Cay_2, Cay_3 ->
                cay.add(new Cay(x * 48, y * 48, b));
        }
    }


    public int getGiaTriChatLieu(int x, int y) {
        return chatLieu[y][x];
    }

    public int[][] getChatLieu() {
        return chatLieu;
    }

    public int getBu() {
        return buXToiDa;
    }

    public Point getViTriCuopBien() {
        return viTriCuopBien;
    }

    public ArrayList<Cua> getCua() {
        return cua;
    }

    public ArrayList<CaMap> getCaMap() {
        return caMap;
    }

    public ArrayList<LoThuoc> getLoThuoc() {
        return loThuoc;
    }

    public ArrayList<ThungChua> getThungChua() {
        return thungChua;
    }

    public ArrayList<Bay> getBay() {
        return bay;
    }

    public ArrayList<Phao> getPhao() {
        return phao;
    }

    public ArrayList<SaoBien> getSaoBien() {
        return saoBien;
    }

    public ArrayList<Cay> getCay() {
        return cay;
    }

    public ArrayList<Co> getCo() {
        return co;
    }

}
