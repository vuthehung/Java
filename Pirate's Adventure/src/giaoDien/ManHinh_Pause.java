/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaoDien;
/**
 *
 * @author Admin
 */

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import trangThai.*;
import phuongThucTaiSuDung.DocHinhAnh;

public class ManHinh_Pause {

    private Playing playing;
    private BufferedImage anhPause;
    private int X, Y, W, H;
    private NutAmThanh nutDieuChinhAmThanh;
    private Nut_QL_TT quayLaiMenu, choiLai, tiepTucChoi;

    public ManHinh_Pause(Playing playing) {
        this.playing = playing;
        //tải ảnh và truyền tham số để vể ảnh
        anhPause = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MANHINH_PAUSE);
        W = (int) (anhPause.getWidth() * 1.5f);
        H = (int) (anhPause.getHeight() * 1.5f);
        X = 1248 / 2 - W / 2;
        Y = (int) (25 * 1.5f);
        
        nutDieuChinhAmThanh = playing.getGame().getNutDieuDinhAmThanh();
        //tạo các nút
        quayLaiMenu = new Nut_QL_TT(469, 487, 84, 84, 2);
        choiLai = new Nut_QL_TT(580, 487, 84, 84, 1);
        tiepTucChoi = new Nut_QL_TT(693, 487, 84, 84, 0);
    }

    public void capNhat() {

        quayLaiMenu.capNhat();
        choiLai.capNhat();
        tiepTucChoi.capNhat();

        nutDieuChinhAmThanh.capNhat();

    }

    public void ve(Graphics g) {
        g.drawImage(anhPause, X, Y, W, H, null);

        // vẽ các nút quay lại, tiếp tục
        quayLaiMenu.ve(g);
        choiLai.ve(g);
        tiepTucChoi.ve(g);

        nutDieuChinhAmThanh.ve(g);

    }

    public void mouseDragged(MouseEvent e) {
        nutDieuChinhAmThanh.mouseDragged(e);
    }

    public void mousePressed(MouseEvent e) {
        if (coTuongTac(e, quayLaiMenu)) {
            quayLaiMenu.setMousePressed(true);
        } else if (coTuongTac(e, choiLai)) {
            choiLai.setMousePressed(true);
        } else if (coTuongTac(e, tiepTucChoi)) {
            tiepTucChoi.setMousePressed(true);
        } else {
            nutDieuChinhAmThanh.mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (coTuongTac(e, quayLaiMenu)) {
            if (quayLaiMenu.isMousePressed()) {
                playing.lamMoiTatCa();
                playing.thayDoiTrangThai(KhoiTaoTrangThai.MENU);
                playing.tiepTuc();
            }
        } else if (coTuongTac(e, choiLai)) {
            if (choiLai.isMousePressed()) {
                playing.lamMoiTatCa();
                playing.tiepTuc();
            }
        } else if (coTuongTac(e, tiepTucChoi)) {
            if (tiepTucChoi.isMousePressed()) {
                playing.tiepTuc();
            }
        } else {
            nutDieuChinhAmThanh.mouseReleased(e);
        }

        quayLaiMenu.datLaiGiaTriBoo();
        choiLai.datLaiGiaTriBoo();
        tiepTucChoi.datLaiGiaTriBoo();

    }

    public void mouseMoved(MouseEvent e) {
        quayLaiMenu.setMouseOver(false);
        choiLai.setMouseOver(false);
        tiepTucChoi.setMouseOver(false);

        if (coTuongTac(e, quayLaiMenu)) {
            quayLaiMenu.setMouseOver(true);
        } else if (coTuongTac(e, choiLai)) {
            choiLai.setMouseOver(true);
        } else if (coTuongTac(e, tiepTucChoi)) {
            tiepTucChoi.setMouseOver(true);
        } else {
            nutDieuChinhAmThanh.mouseMoved(e);
        }
    }

    //kiểm tra nếu phát hiện tương tác của chuột với ô đó thì thực hiện nó
    private boolean coTuongTac(MouseEvent e, NutTrenManHinh_Pause b) {
        return b.getBien().contains(e.getX(), e.getY());
    }

}
