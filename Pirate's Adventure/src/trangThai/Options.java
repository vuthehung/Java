/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trangThai;
/**
 *
 * @author Admin
 */

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import main.Game;
import giaoDien.NutAmThanh;
import giaoDien.NutTrenManHinh_Pause;
import giaoDien.Nut_QL_TT;
import phuongThucTaiSuDung.DocHinhAnh;

public class Options extends TrangThai implements PhuongThuc {

    private NutAmThanh nutAmThanh;
    private BufferedImage anh_nen, anh_option;
    private int X, Y, W, H;
    private Nut_QL_TT menuB;

    public Options(Game game) {
        super(game);
        nutAmThanh = game.getNutDieuDinhAmThanh();
        
        //tải hình nền khi chọn 'Options'
        anh_nen = DocHinhAnh.LuuHinhAnh(DocHinhAnh.ANH_NEN);
        anh_option = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MANHINH_LUACHON);
        W = (int) (anh_option.getWidth() * 1.5f);
        H = (int) (anh_option.getHeight() * 1.5f);
        X = 1248 / 2 - W / 2;
        Y = (int) (33 * 1.5f);
        
        //tải lại các nút quay lại menu
        int menuX = (int) (387 * 1.5f);
        int menuY = (int) (325 * 1.5f);
        menuB = new Nut_QL_TT(menuX, menuY, 84, 84, 2);
        
        
    }


    @Override
    public void capNhat() {
        menuB.capNhat();
        nutAmThanh.capNhat();
    }

    @Override
    public void ve(Graphics g) {
        g.drawImage(anh_nen, 0, 0, 1248, 672, null);
        g.drawImage(anh_option, X, Y, W, H, null);

        menuB.ve(g);
        nutAmThanh.ve(g);
    }

    public void mouseDragged(MouseEvent e) {
        nutAmThanh.mouseDragged(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (coTuongTac(e, menuB)) {
            menuB.setMousePressed(true);
        } else {
            nutAmThanh.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (coTuongTac(e, menuB)) {
            if (menuB.isMousePressed()) {
                KhoiTaoTrangThai.trangThai = KhoiTaoTrangThai.MENU;
            }
        } else {
            nutAmThanh.mouseReleased(e);
        }
        menuB.datLaiGiaTriBoo();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        menuB.setMouseOver(false);

        if (coTuongTac(e, menuB)) {
            menuB.setMouseOver(true);
        } else {
            nutAmThanh.mouseMoved(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            KhoiTaoTrangThai.trangThai = KhoiTaoTrangThai.MENU;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    private boolean coTuongTac(MouseEvent e, NutTrenManHinh_Pause b) {
        return b.getBien().contains(e.getX(), e.getY());
    }

}
