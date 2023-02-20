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
import java.awt.event.*;
import java.awt.image.BufferedImage;

import main.Game;
import giaoDien.ManHinhChinh;
import phuongThucTaiSuDung.DocHinhAnh;

public class Menu extends TrangThai implements PhuongThuc {

    private ManHinhChinh[] nut = new ManHinhChinh[3];
    private BufferedImage anh_nen_menu;

    public Menu(Game game) {
        super(game);
        anh_nen_menu = DocHinhAnh.LuuHinhAnh(DocHinhAnh.ANH_NEN);
        
        nut[0] = new ManHinhChinh(1248 / 2, (int) (100 * 1.5f), 0, KhoiTaoTrangThai.PLAYING);
        nut[1] = new ManHinhChinh(1248 / 2, (int) (170 * 1.5f), 1, KhoiTaoTrangThai.OPTIONS);
        nut[2] = new ManHinhChinh(1248 / 2, (int) (240 * 1.5f), 2, KhoiTaoTrangThai.QUIT);

    }

    @Override
    public void capNhat() {
        for (ManHinhChinh mb : nut) {
            mb.capNhat();
        }
    }

    @Override
    public void ve(Graphics g) {
        g.drawImage(anh_nen_menu, 0, 0, 1248, 672, null);
        for (ManHinhChinh mc : nut) {
            mc.ve(g);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (ManHinhChinh mc : nut) {
            if (coTuongTac(e, mc)) {
                mc.setMousePressed(true);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (ManHinhChinh mc : nut) {
            if (coTuongTac(e, mc)) {
                if (mc.isMousePressed()) {
                    mc.suDungTrangThai();
                }
                if (mc.getTrangThai()== KhoiTaoTrangThai.PLAYING) {
                    game.getAmThanh().setBaiHat(game.getPlaying().getQuanLiLvl().getViTriLvl());
                }
                break;
            }
        }
        //đặt lại trạng thái chuột
        for (ManHinhChinh mc : nut) {
            mc.datLai();
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        for (ManHinhChinh mc : nut) {
            mc.setMouseOver(false);
        }

        for (ManHinhChinh mc : nut) {
            if (coTuongTac(e, mc)) {
                mc.setMouseOver(true);
                break;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
