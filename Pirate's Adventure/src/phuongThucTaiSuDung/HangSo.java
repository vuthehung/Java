/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phuongThucTaiSuDung;
/**
 *
 * @author Admin
 */


public class HangSo {

    public static class CuopBien {

        public static final int Dung = 0;
        public static final int DiChuyen = 1;
        public static final int Nhay = 2;
        public static final int Roi = 3;
        public static final int TanCong = 4;
        public static final int BiTanCong = 5;
        public static final int Chet = 6;

        public static int ViTriHinhAnh(int trangThai) {
            switch (trangThai) {
                case Dung:
                    return 5;
                case DiChuyen:
                    return 6;
                case Nhay:
                    return 3;
                case Roi:
                    return 1;
                case TanCong:
                    return 3;
                case BiTanCong:
                    return 4;
                case Chet:
                    return 8;
                default:
                    return 1;
            }
        }
    }
    
    public static class QuaiVat {

        public static final int Cua = 0;
        public static final int SaoBien = 1;
        public static final int CaMap = 2;

        public static final int Dung = 0;
        public static final int DiChuyen = 1;
        public static final int TanCong = 2;
        public static final int BiTanCong = 3;
        public static final int Chet = 4;

        public static int ViTriHinhAnh(int quaiVat, int trangThai) {
            switch (trangThai) {
                case Dung: {
                    if (quaiVat == Cua) {
                        return 9;
                    } else if (quaiVat == SaoBien || quaiVat == CaMap) {
                        return 8;
                    }
                }
                case DiChuyen:
                    return 6;
                case TanCong:
                    if (quaiVat == CaMap) {
                        return 8;
                    }
                    return 7;
                case BiTanCong:
                    return 4;
                case Chet:
                    return 5;
            }

            return 0;

        }

        public static int MauQuaiVat(int quaiVat) {
            switch (quaiVat) {
                case Cua:
                    return 50;
                case SaoBien:
                    return 35;
                case CaMap:
                    return 30;
                default:
                    return 1;
            }
        }

        public static int SatThuong(int quaiVat) {
            switch (quaiVat) {
                case Cua:
                    return 15;
                case SaoBien:
                    return 20;
                case CaMap:
                    return 25;
                default:
                    return 0;
            }
        }
    }

    public static class Huong {
        //Đánh số hướng đi
        public static final int Trai = 0;
        public static final int Len = 1;
        public static final int Phai = 2;
        public static final int Xuong = 3;
    }

    public static class viTriCacVatThe {

        public static final int LoMau = 0;
        public static final int LoNangLuong = 1;
        public static final int Thung = 2;
        public static final int Hop = 3;
        public static final int Bay = 4;
        public static final int PhaoTrai = 5;
        public static final int PhaoPhai = 6;
        public static final int Cay_1 = 7;
        public static final int Cay_2 = 8;
        public static final int Cay_3 = 9;

        public static final int luongMauHoiPhuc = 15;
        public static final int nangLuongHoiPhuc = 10;

        public static int layAnhVatThe(int loaiVatThe) {
            switch (loaiVatThe) {
                case LoMau, LoNangLuong:
                    return 7;
                case Thung, Hop:
                    return 8;
                case PhaoTrai, PhaoPhai:
                    return 7;
            }
            return 1;
        }

        public static int toaDoX(int loaiCay) {
            switch (loaiCay) {
                case Cay_1:
                    return -5;
                case Cay_2:
                    return 19;
                case Cay_3:
                    return 79;
            }

            return 0;
        }

        public static int toaDoY(int loaiCay) {

            switch (loaiCay) {
                case Cay_1:
                    return -42;
                case Cay_2, Cay_3:
                    return -43;
            }
            return 0;

        }

        public static int chieuDaiCay(int loaiCay) {
            switch (loaiCay) {
                case Cay_1:
                    return 58;
                case Cay_2:
                    return 93;
                case Cay_3:
                    return -93;

            }
            return 0;
        }

        public static int chieuCaoCay(int loaiCay) {
            switch (loaiCay) {
                case Cay_1:
                    return 138;
                case Cay_2, Cay_3:
                    return 81;

            }
            return 0;
        }
    }


}
