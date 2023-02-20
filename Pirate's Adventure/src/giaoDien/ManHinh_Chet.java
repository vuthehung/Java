/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaoDien;
/**
 *
 * @author Admin
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import trangThai.*;
import phuongThucTaiSuDung.DocHinhAnh;

public class ManHinh_Chet {

    private Playing playing;
    private BufferedImage anh;
    private int X, Y, W, H;
    private Nut_QL_TT menu, play;

    public ManHinh_Chet(Playing playing) {
        this.playing = playing;
        //đọc ảnh và truyền tham số để vẽ ảnh
        anh = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MANHINH_KHI_CHET);
        W = (int) (anh.getWidth() * 1.5f);
        H = (int) (anh.getHeight() * 1.5f);
        X = 1248 / 2 - W / 2;
        Y = 150;
        
        //tạo nút trên màn hình bao gồm: chơi lại và quay lại menu
        int menuX = (int) (335 * 1.5f);
        int playX = (int) (440 * 1.5f);
        int y = (int) (195 * 1.5f);
        menu = new Nut_QL_TT(502, 292, 84, 84, 2);
        play = new Nut_QL_TT(660, 292, 84, 84, 0);
    }
    
    public void ve(Graphics g) {
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, 1248, 672);

        g.drawImage(anh, X, Y, W, H, null);

        menu.ve(g);
        play.ve(g);
    }

    public void capNhat() {
        menu.capNhat();
        play.capNhat();
    }

    //kiểm tra nếu phát hiện tương tác của chuột với ô đó thì thực hiện nó
    private boolean coTuongTac(Nut_QL_TT b, MouseEvent e) {
        return b.getBien().contains(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        play.setMouseOver(false);
        menu.setMouseOver(false);

        if (coTuongTac(menu, e)) {
            menu.setMouseOver(true);
        } else if (coTuongTac(play, e)) {
            play.setMouseOver(true);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (coTuongTac(menu, e)) {
            if (menu.isMousePressed()) {
                playing.lamMoiTatCa();
                playing.thayDoiTrangThai(KhoiTaoTrangThai.MENU);
            }
        } else if (coTuongTac(play, e)) {
            if (play.isMousePressed()) {
                playing.lamMoiTatCa();
                playing.getGame().getAmThanh().setBaiHat(playing.getQuanLiLvl().getViTriLvl());
            }
        }

        menu.datLaiGiaTriBoo();
        play.datLaiGiaTriBoo();
    }

    public void mousePressed(MouseEvent e) {
        if (coTuongTac(menu, e)) {
            menu.setMousePressed(true);
        } else if (coTuongTac(play, e)) {
            play.setMousePressed(true);
        }
    }

}
