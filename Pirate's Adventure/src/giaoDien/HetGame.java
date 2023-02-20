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

public class HetGame {

    private Playing playing;
    private BufferedImage anhGC, anhBanDoTo;
    private ManHinhChinh quit;
    private int X, Y, W, H;

    public HetGame(Playing playing) {
        this.playing = playing;
        //đọc ảnh và truyền tham số để vẽ ảnh
        anhGC = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MANHINH_HET_GAME);
        W = (int) (anhGC.getWidth() * 1.5f);
        H = (int) (anhGC.getHeight() * 1.5f);
        X = 1248 / 2 - W / 2;
        Y = (int) (100 * 1.5f);
        
        anhBanDoTo = DocHinhAnh.LuuHinhAnh(DocHinhAnh.BANDOTO);
        //tạo nút quit trên màn hình gc
        quit = new ManHinhChinh(1248 / 2, (int) (220 * 1.5f), 2, KhoiTaoTrangThai.MENU);
    }


    public void ve(Graphics g) {
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, 1248, 672);

        g.drawImage(anhGC, X, Y, W, H, null);
        g.drawImage(anhBanDoTo, 100, 200, (int) (anhBanDoTo.getWidth() * 0.25f), (int) (anhBanDoTo.getHeight() * 0.25f), null);
        g.drawImage(anhBanDoTo, 910, 200, (int) (anhBanDoTo.getWidth() * 0.25f), (int) (anhBanDoTo.getHeight() * 0.25f), null);
        quit.ve(g);
    }

    public void capNhat() {
        quit.capNhat();
    }

    //kiểm tra nếu phát hiện tương tác của chuột với ô đó thì thực hiện nó
    private boolean coTuongTac(ManHinhChinh b, MouseEvent e) {
        return b.getBien().contains(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        quit.setMouseOver(false);

        if (coTuongTac(quit, e)) {
            quit.setMouseOver(true);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (coTuongTac(quit, e)) {
            if (quit.isMousePressed()) {
                playing.lamMoiTatCa();
                playing.datLai();
                playing.thayDoiTrangThai(KhoiTaoTrangThai.MENU);
            }
        }
        quit.datLai();
    }

    public void mousePressed(MouseEvent e) {
        if (coTuongTac(quit, e)) {
            quit.setMousePressed(true);
        }
    }
}
