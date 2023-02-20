/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vatThe;
/**
 *
 * @author Admin
 */

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import nhanVat.*;
import trangThai.*;
import levels.Lvl;

import phuongThucTaiSuDung.DocHinhAnh;
import static phuongThucTaiSuDung.HangSo.viTriCacVatThe.*;
import static phuongThucTaiSuDung.PhuongThucXuLyXuKien.*;

public class QuanLi_O {

    private Playing playing;
    
    private BufferedImage[][] anhLoThuoc, anhThungChua;
    private BufferedImage[][] anhCay;
    private BufferedImage[] anhPhao, anhCo;
    private BufferedImage anhBay, anhDanPhao;
    private ArrayList<LoThuoc> loThuoc;
    private ArrayList<ThungChua> thungChua;
    private ArrayList<DanPhao> danPhao = new ArrayList<>();

    private Lvl lvlHienTai;

    public QuanLi_O(Playing playing) {
        this.playing = playing;
        lvlHienTai = playing.getQuanLiLvl().getLvlHienTai();
        taiAnh();
    }

    public void taiVatThe(Lvl lvlMoi) {
        lvlHienTai = lvlMoi;
        loThuoc = new ArrayList<>(lvlMoi.getLoThuoc());
        thungChua = new ArrayList<>(lvlMoi.getThungChua());
        danPhao.clear();
    }

    private void taiAnh() {
        BufferedImage lT = DocHinhAnh.LuuHinhAnh(DocHinhAnh.LO_THUOC);
        anhLoThuoc = new BufferedImage[2][7];

        for (int i = 0; i < anhLoThuoc.length; i++) {
            for (int j = 0; j < anhLoThuoc[i].length; j++) {
                anhLoThuoc[i][j] = lT.getSubimage(12 * j, 16 * i, 12, 16);
            }
        }

        BufferedImage tc = DocHinhAnh.LuuHinhAnh(DocHinhAnh.THUNG_CHUA);
        anhThungChua = new BufferedImage[2][8];

        for (int i = 0; i < anhThungChua.length; i++) {
            for (int j = 0; j < anhThungChua[i].length; j++) {
                anhThungChua[i][j] = tc.getSubimage(40 * j, 30 * i, 40, 30);
            }
        }

        anhBay = DocHinhAnh.LuuHinhAnh(DocHinhAnh.BAY);

        anhPhao = new BufferedImage[7];
        BufferedImage p = DocHinhAnh.LuuHinhAnh(DocHinhAnh.PHAO);

        for (int i = 0; i < anhPhao.length; i++) {
            anhPhao[i] = p.getSubimage(i * 40, 0, 40, 26);
        }

        anhDanPhao = DocHinhAnh.LuuHinhAnh(DocHinhAnh.DAN_PHAO);
        anhCay = new BufferedImage[2][4];
        BufferedImage cay1 = DocHinhAnh.LuuHinhAnh(DocHinhAnh.TREE_ONE_ATLAS);
        for (int i = 0; i < 4; i++) {
            anhCay[0][i] = cay1.getSubimage(i * 39, 0, 39, 92);
        }

        BufferedImage cay2 = DocHinhAnh.LuuHinhAnh(DocHinhAnh.TREE_TWO_ATLAS);
        for (int i = 0; i < 4; i++) {
            anhCay[1][i] = cay2.getSubimage(i * 62, 0, 62, 54);
        }

        BufferedImage c = DocHinhAnh.LuuHinhAnh(DocHinhAnh.CO);
        anhCo = new BufferedImage[2];
        for (int i = 0; i < anhCo.length; i++) {
            anhCo[i] = c.getSubimage(32 * i, 0, 32, 32);
        }
    }
    
    public void ve(Graphics g, int xLvlOffset) {
        veLoThuoc(g, xLvlOffset);
        veThungChua(g, xLvlOffset);
        veBay(g, xLvlOffset);
        vePhao(g, xLvlOffset);
        veDanPhao(g, xLvlOffset);
        veCo(g, xLvlOffset);
    }

    private void veCo(Graphics g, int xLvlOffset) {
        for (Co co : lvlHienTai.getCo()) {
            g.drawImage(anhCo[co.getLoaiCo()],
                    co.getX() - xLvlOffset, co.getY(),
                    (int) (32 * 1.5f), (int) (32 * 1.5f), null);
        }
    }

    public void veCay(Graphics g, int xLvlOffset) {
        for (Cay bt : lvlHienTai.getCay()) {

            int loai = bt.getLoaiCay();
            if (loai == 9) {
                loai = 8;
            }
            g.drawImage(anhCay[loai - 7][bt.getAniI()],
                    bt.getX() - xLvlOffset + toaDoX(bt.getLoaiCay()), 
                    (int) (bt.getY() + toaDoY(bt.getLoaiCay())),
                    chieuDaiCay(bt.getLoaiCay()), chieuCaoCay(bt.getLoaiCay()), null);
        }
    }

    private void veDanPhao(Graphics g, int xLvlOffset) {
        for (DanPhao p : danPhao) {
            if (p.isTrangThaiHoatDong()) {
                g.drawImage(anhDanPhao, (int) (p.getHitbox().x - xLvlOffset),
                        (int) (p.getHitbox().y), 
                        22, 22, null);
            }
        }
    }

    private void vePhao(Graphics g, int xLvlOffset) {
        for (Phao c : lvlHienTai.getPhao()) {
            int x = (int) (c.getHitbox().x - xLvlOffset);
            int width = 60;

            if (c.getLoaiVatThe() == PhaoPhai) {
                x += width;
                width *= -1;
            }
            g.drawImage(anhPhao[c.getAniI()], x, 
                    (int) (c.getHitbox().y), width, 39, null);
        }
    }

    private void veBay(Graphics g, int xLvlOffset) {
        for (Bay b : lvlHienTai.getBay()) {
            g.drawImage(anhBay, (int) (b.getHitbox().x - xLvlOffset), 
                    (int) (b.getHitbox().y - b.getBuY()), 
                    48, 48, null);
        }

    }

    private void veThungChua(Graphics g, int xLvlOffset) {
        for (ThungChua gc : thungChua) {
            if (gc.isHoatDong()) {
                int type = 0;
                if (gc.getLoaiVatThe() == Thung) {
                    type = 1;
                }
                g.drawImage(anhThungChua[type][gc.getAniI()], 
                        (int) (gc.getHitbox().x - gc.getBuX()- xLvlOffset), 
                        (int) (gc.getHitbox().y - gc.getBuY()), 60,
                        45, null);
            }
        }
    }

    private void veLoThuoc(Graphics g, int xLvlOffset) {
        for (LoThuoc p : loThuoc) {
            if (p.isHoatDong()) {
                int type = 0;
                if (p.getLoaiVatThe() == LoMau) {
                    type = 1;
                }
                g.drawImage(anhLoThuoc[type][p.getAniI()], 
                        (int) (p.getHitbox().x - p.getBuX() - xLvlOffset), 
                        (int) (p.getHitbox().y - p.getBuY()),
                        18, 24, null);
            }
        }
    }

    public void kiemTraNeuChamVaoBay(CuopBien cb) {
        for (Bay b : lvlHienTai.getBay()) {
            if (b.getHitbox().intersects(cb.getHitbox())) {
                cb.kill();
            }
        }
    }

    public void kiemTraNeuChamVaoBay(QuaiVat e) {
        for (Bay b : lvlHienTai.getBay()) {
            if (b.getHitbox().intersects(e.getHitbox())) {
                e.truMau(100);
            }
        }
    }

    public void kiemTraNeuChamVaoLoThuoc(Rectangle2D.Float hitbox) {
        for (LoThuoc p : loThuoc) {
            if (p.isHoatDong()) {
                if (hitbox.intersects(p.getHitbox())) {
                    p.setHoatDong(false);
                    tangMauNL(p);
                }
            }
        }
    }

    public void tangMauNL(LoThuoc p) {
        if (p.getLoaiVatThe()== LoMau) {
            playing.getCuopBien().capNhatMau(luongMauHoiPhuc);
        } else {
            playing.getCuopBien().capNhatNangLuong(nangLuongHoiPhuc);
        }
    }

    public void kiemTraTanCongVaoThung(Rectangle2D.Float attackbox) {
        for (ThungChua gc : thungChua) {
            if (gc.isHoatDong() && !gc.thucHienHoatAnh) {
                if (gc.getHitbox().intersects(attackbox)) {
                    gc.setHoatAnh(true);
                    int type = 0;
                    if (gc.getLoaiVatThe() == Thung) {
                        type = 1;
                    }
                    loThuoc.add(new LoThuoc((int) (gc.getHitbox().x + gc.getHitbox().width / 2), 
                            (int) (gc.getHitbox().y - gc.getHitbox().height / 2), type));
                    return;
                }
            }
        }
    }
    
    public void capNhat(int[][] chatLieu, CuopBien cb) {  
        for (Cay c : lvlHienTai.getCay()) {
            c.capNhat();
        }
        
        for (LoThuoc p : loThuoc) {
            if (p.isHoatDong()) {
                p.capNhat();
            }
        }

        for (ThungChua gc : thungChua) {
            if (gc.isHoatDong()) {
                gc.update();
            }
        }

        capNhatPhao(chatLieu, cb);
        capNhatDanPhao(chatLieu, cb);

    }

    private void capNhatDanPhao(int[][] chatLieu, CuopBien cb) {
        for (DanPhao p : danPhao) {
            if (p.isTrangThaiHoatDong()) {
                p.capNhatViTri();
                if (p.getHitbox().intersects(cb.getHitbox())) {
                    cb.capNhatMau(-25);
                    p.setTrangThaiHoatDong(false);
                } else if (coTheBan(p, chatLieu)) {
                    p.setTrangThaiHoatDong(false);
                }
            }
        }
    }
    
    //có thể bắn đạn
    private static boolean coTheBan(DanPhao p, int[][] chatLieu) {
        return khongTheDi(p.getHitbox().x + p.getHitbox().width / 2, p.getHitbox().y + p.getHitbox().height / 2, chatLieu);
    }

    //kiểm tra cướp biển có trong tầm bắn ko?
    private boolean trongTamBan(Phao p, CuopBien cb) {
        int kc = (int) Math.abs(cb.getHitbox().x - p.getHitbox().x);
        return kc <= 48 * 5;
    }

    //kiểm tra xem người chơi đưng trước pháo hay sau pháo? đứng sau thì ko bắn?
    private boolean truocHaySau(Phao p, CuopBien cb) {
        if (p.getLoaiVatThe() == PhaoTrai) {
            if (p.getHitbox().x > cb.getHitbox().x) {
                return true;
            }

        } else if (p.getHitbox().x < cb.getHitbox().x) {
            return true;
        }
        return false;
    }

    private void capNhatPhao(int[][] chatLieu, CuopBien cb) {
        for (Phao c : lvlHienTai.getPhao()) {
            if (!c.thucHienHoatAnh) {
                if (c.getTileY() == cb.getTileY()) {
                    if (trongTamBan(c, cb)) {
                        if (truocHaySau(c, cb)) {
                            if (TrongTamBan(chatLieu, cb.getHitbox(), c.getHitbox(), c.getTileY())) {
                                c.setHoatAnh(true);
                            }
                        }
                    }
                }
            }

            c.capNhat();
            if (c.getAniI() == 4 && c.getAniT() == 0) {
                phaoBanDan(c);
            }
        }
    }

    //pháo thực hiện bắn đạn
    private void phaoBanDan(Phao c) {
        int huong = 1;
        if (c.getLoaiVatThe() == PhaoTrai) {
            huong = -1;
        }

        danPhao.add(new DanPhao((int) c.getHitbox().x, 
                (int) c.getHitbox().y, huong));
    }

    //đặt lại các tham số
    public void datLaiThamSoCuaVatThe() {
        taiVatThe(playing.getQuanLiLvl().getLvlHienTai());
        for (LoThuoc p : loThuoc) {
            p.datLaiThamSo();
        }
        for (ThungChua gc : thungChua) {
            gc.datLaiThamSo();
        }
        for (Phao c : lvlHienTai.getPhao()) {
            c.datLaiThamSo();
        }
    }
}
