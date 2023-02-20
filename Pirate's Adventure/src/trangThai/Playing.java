/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trangThai;
/**
 *
 * @author Admin
 */

import giaoDien.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import nhanVat.*;
import levels.*;
import vatThe.*;
import phuongThucTaiSuDung.DocHinhAnh;

import main.Game;

public class Playing extends TrangThai implements PhuongThuc {

    private CuopBien cuopBien;
    private PhuongThucChung_QuaiVat quanLiQuaiVat;
    private QuanLiLvl quanLiLvl;
    private QuanLi_O quanLiO;
    private ManHinh_Pause manHinhPause;
    private ManHinhQuaMap manHinhQuaMap;
    private HetGame manHinhHetGame;
    private ManHinh_Chet manHinhChet;
    
    private int buX;
    private int buXToiDa;
    private int bienTrai = (int) (0.2 * 1248);
    private int bienPhai = (int) (0.8 * 1248);


    private BufferedImage anh_nen_trongGame, damMayLon, damMayNho;
    private BufferedImage[] anhThuyen;
    private int[] viTriMayNho;
    
    private Random rnd = new Random();

    private boolean dungGame = false;
    private boolean hoanThanhLvl;
    private boolean hoanThanhGame;
    private boolean cuopBienChet;
    private boolean gameOver;

    //vẽ thuyền
    private int hoatAnhThuyen, danhDauTocDo, huongThuyen = 1;
    private float chieuCaoTau;
    private float thayDoiChieuCaoThuyen = 0.1f;

    public Playing(Game game) {
        super(game);
        
        quanLiLvl = new QuanLiLvl(game);
        quanLiQuaiVat = new PhuongThucChung_QuaiVat(this);
        quanLiO = new QuanLi_O(this);
        cuopBien = new CuopBien(200, 200, (int) (64 * 1.5f), (int) (40 * 1.5f), this);
        cuopBien.taiChatLieuMap(quanLiLvl.getLvlHienTai().getChatLieu());
        cuopBien.setViTri(quanLiLvl.getLvlHienTai().getViTriCuopBien());

        manHinhPause = new ManHinh_Pause(this);
        manHinhChet = new ManHinh_Chet(this);
        manHinhQuaMap = new ManHinhQuaMap(this);
        manHinhHetGame = new HetGame(this);

        anh_nen_trongGame = DocHinhAnh.LuuHinhAnh(DocHinhAnh.ANH_NEN_TRONG_GAME);
        damMayLon = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MAY_LON);
        damMayNho = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MAY_NHO);
        
        buXToiDa = quanLiLvl.getLvlHienTai().getBu();
        
        viTriMayNho = new int[8];
        for (int i = 0; i < viTriMayNho.length; i++) {
            viTriMayNho[i] = (int) (70 * 1.5f) + rnd.nextInt((int) (100 * 1.5f));
        }

        anhThuyen = new BufferedImage[4];
        BufferedImage thuyen = DocHinhAnh.LuuHinhAnh(DocHinhAnh.THUYEN);
        for (int i = 0; i < anhThuyen.length; i++) {
            anhThuyen[i] = thuyen.getSubimage(i * 78, 0, 78, 72);
        }
        
        //tải các vật thể có trong game
        quanLiQuaiVat.taiQuaiVat(quanLiLvl.getLvlHienTai());
        quanLiO.taiVatThe(quanLiLvl.getLvlHienTai());
    }

    public void taiLvlTiepTheo() {
        quanLiLvl.setViTriLvl(quanLiLvl.getViTriLvl()+ 1);
        quanLiLvl.taiLvlTiepTheo();
        cuopBien.setViTri(quanLiLvl.getLvlHienTai().getViTriCuopBien());
        lamMoiTatCa();
    }


    @Override
    public void capNhat() {
        if (dungGame) {
            manHinhPause.capNhat();
        } else if (hoanThanhLvl) {
            manHinhQuaMap.capNhat();
        } else if (hoanThanhGame) {
            manHinhHetGame.capNhat();
        } else if (gameOver) {
            manHinhChet.capNhat();
        } else if (cuopBienChet) {
            cuopBien.capNhat();
        } else {
            quanLiLvl.capNhat();
            quanLiO.capNhat(quanLiLvl.getLvlHienTai().getChatLieu(), cuopBien);
            cuopBien.capNhat();
            quanLiQuaiVat.capNhat(quanLiLvl.getLvlHienTai().getChatLieu());

            int cbX = (int) cuopBien.getHitbox().x;
            int kc = cbX - buX;

            if (kc > bienPhai) {
                buX += kc - bienPhai;
            } else if (kc < bienTrai) {
                buX += kc - bienTrai;
            }
            buX = Math.max(Math.min(buX, buXToiDa), 0);
            

            //lặp đi lặp lại các hình ảnh thuyền
            danhDauTocDo++;
            if (danhDauTocDo == 40) {
                danhDauTocDo = 0;
                hoatAnhThuyen++;
                if (hoatAnhThuyen == 4) {
                    hoatAnhThuyen = 0;
                }
            }

            //hình ảnh tàu nhấp nhô
            chieuCaoTau += thayDoiChieuCaoThuyen * huongThuyen;
            chieuCaoTau = Math.max(Math.min(15, chieuCaoTau), 0);

            if (chieuCaoTau == 0) {
                huongThuyen = 1;
            } else if (chieuCaoTau == 15) {
                huongThuyen = -1;
            }
        }
    }

    @Override
    public void ve(Graphics g) {
        g.drawImage(anh_nen_trongGame, 0, 0, 1248, 672, null);

        for (int i = 0; i < 4; i++) {
            g.drawImage(damMayLon, i * 670 - (int) (buX * 0.3), (int) (200 * 1.5f), 672, 151, null);
        }

        for (int i = 0; i < viTriMayNho.length; i++) {
            g.drawImage(damMayNho, 110 * 4 * i - (int) (buX * 0.7), viTriMayNho[i], 111, 36, null);
        }

        //vẽ thuyền
        g.drawImage(anhThuyen[hoatAnhThuyen], (int) (140 * 1.5f) - buX, (int) ((285 * 1.5f) + chieuCaoTau), (int) (78 * 1.5f), (int) (72 * 1.5f), null);

        quanLiLvl.ve(g, buX);
        quanLiO.ve(g, buX);
        quanLiQuaiVat.ve(g, buX);
        cuopBien.ve(g, buX);
        quanLiO.veCay(g, buX);

        if (dungGame) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, 1248, 672);
            manHinhPause.ve(g);
        } else if (gameOver) {
            manHinhChet.ve(g);
        } else if (hoanThanhLvl) {
            manHinhQuaMap.ve(g);
        } else if (hoanThanhGame) {
            manHinhHetGame.ve(g);
        }
    }
    
    public void setHoanThanhLvl() {
        hoanThanhGame = true;
    }

    public void datLai() {
        hoanThanhGame = false;
    }

    public void lamMoiTatCa() {
        gameOver = false;
        dungGame = false;
        hoanThanhLvl = false;
        cuopBienChet = false;

        cuopBien.datLaiTatCa();
        quanLiQuaiVat.lamMoiQuaiVat();
        quanLiO.datLaiThamSoCuaVatThe();
    }

    
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void kiemTraTanCongVaoThung(Rectangle2D.Float attackBox) {
        quanLiO.kiemTraTanCongVaoThung(attackBox);
    }

    public void kiemTraQuaiVatBiTanCong(Rectangle2D.Float attackBox) {
        quanLiQuaiVat.kiemTraQuaiVatBiTanCong(attackBox);
    }

    public void kiemTraNeuChamVaoLoThuoc(Rectangle2D.Float hitbox) {
        quanLiO.kiemTraNeuChamVaoLoThuoc(hitbox);
    }

    public void kiemTraNeuChamVaoBay(CuopBien p) {
        quanLiO.kiemTraNeuChamVaoBay(p);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!gameOver) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                //bấm chuột trái
                cuopBien.setTanCong(true);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                //bấm chuột phải
                cuopBien.tanCongBangNangLuong();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!gameOver && !hoanThanhGame && !hoanThanhLvl) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    cuopBien.setTrai(true);
                    break;
                case KeyEvent.VK_D:
                    cuopBien.setPhai(true);
                    break;
                case KeyEvent.VK_SPACE:
                    cuopBien.setNhay(true);
                    break;
                case KeyEvent.VK_ESCAPE:
                    dungGame = !dungGame;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!gameOver && !hoanThanhGame && !hoanThanhLvl) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    cuopBien.setTrai(false);
                    break;
                case KeyEvent.VK_D:
                    cuopBien.setPhai(false);
                    break;
                case KeyEvent.VK_SPACE:
                    cuopBien.setNhay(false);
                    break;
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (!gameOver && !hoanThanhGame && !hoanThanhLvl) {
            if (dungGame) {
                manHinhPause.mouseDragged(e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameOver) {
            manHinhChet.mousePressed(e);
        } else if (dungGame) {
            manHinhPause.mousePressed(e);
        } else if (hoanThanhLvl) {
            manHinhQuaMap.mousePressed(e);
        } else if (hoanThanhGame) {
            manHinhHetGame.mousePressed(e);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (gameOver) {
            manHinhChet.mouseReleased(e);
        } else if (dungGame) {
            manHinhPause.mouseReleased(e);
        } else if (hoanThanhLvl) {
            manHinhQuaMap.mouseReleased(e);
        } else if (hoanThanhGame) {
            manHinhHetGame.mouseReleased(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (gameOver) {
            manHinhChet.mouseMoved(e);
        } else if (dungGame) {
            manHinhPause.mouseMoved(e);
        } else if (hoanThanhLvl) {
            manHinhQuaMap.mouseMoved(e);
        } else if (hoanThanhGame) {
            manHinhHetGame.mouseMoved(e);
        }
    }

    public void setHoanThanhLvl(boolean hoanThanhLvl) {
        game.getAmThanh().amThanhQuaMap();
        // hết tất cả các map
        if (quanLiLvl.getViTriLvl()+ 1 >= quanLiLvl.getSoLuongMap()) {
            hoanThanhGame = true;
            quanLiLvl.setViTriLvl(0);
            quanLiLvl.taiLvlTiepTheo();
            lamMoiTatCa();
            return;
        }
        this.hoanThanhLvl = hoanThanhLvl;
    }

    public void setbuLvlToiDa(int bu) {
        this.buXToiDa = bu;
    }

    public void tiepTuc() {
        dungGame = false;
    }

    public void windowFocusLost() {
        cuopBien.datLaiHuong();
    }

    public CuopBien getCuopBien() {
        return cuopBien;
    }

    public PhuongThucChung_QuaiVat getQuanLiQV() {
        return quanLiQuaiVat;
    }

    public QuanLi_O getQuanLiO() {
        return quanLiO;
    }

    public QuanLiLvl getQuanLiLvl() {
        return quanLiLvl;
    }

    public void setCuopBienChet(boolean cuopBienChet) {
        this.cuopBienChet = cuopBienChet;
    }
}
