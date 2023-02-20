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

import main.Game;

public class NutAmThanh {

    private NutDieuChinh_Am thanhDieuChinhAm;
    private NutTatBat_Am nutAmThanh, nutHieuUng;

    private Game game;

    public NutAmThanh(Game game) {
        this.game = game;
        taoNutTatBat();
        taoThanhKeo();
    }

    //thanh kéo điều chỉnh âm thanh.
    private void taoThanhKeo() {
        int vX = (int) (309 * 1.5f);
        int vY = (int) (278 * 1.5f);
        thanhDieuChinhAm = new NutDieuChinh_Am(vX, vY, 323, 66);
    }

    //nút tắt bật âm
    private void taoNutTatBat() {
        int soundX = (int) (450 * 1.5f);
        int musicY = (int) (140 * 1.5f);
        int sfxY = (int) (186 * 1.5f);
        nutAmThanh = new NutTatBat_Am(soundX, musicY, 63, 63);
        nutHieuUng = new NutTatBat_Am(soundX, sfxY, 63, 63);
    }

    public void capNhat() {
        nutAmThanh.capNhat();
        nutHieuUng.capNhat();

        thanhDieuChinhAm.capNhat();
    }

    public void ve(Graphics g) {
        nutAmThanh.ve(g);
        nutHieuUng.ve(g);

        thanhDieuChinhAm.draw(g);
    }

    public void mouseDragged(MouseEvent e) {
        if (thanhDieuChinhAm.isMousePressed()) {
            float valueBefore = thanhDieuChinhAm.getGiaTriAmLuong();
            thanhDieuChinhAm.suThayDoi(e.getX());
            float valueAfter = thanhDieuChinhAm.getGiaTriAmLuong();
            if (valueBefore != valueAfter) {
                game.getAmThanh().setAmLuong(valueAfter);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (coTuongTac(e, nutAmThanh)) {
            nutAmThanh.setMousePressed(true);
        } else if (coTuongTac(e, nutHieuUng)) {
            nutHieuUng.setMousePressed(true);
        } else if (coTuongTac(e, thanhDieuChinhAm)) {
            thanhDieuChinhAm.setMousePressed(true);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (coTuongTac(e, nutAmThanh)) {
            if (nutAmThanh.isMousePressed()) {
                nutAmThanh.setMuted(!nutAmThanh.isMuted());
                game.getAmThanh().tatTiengBaiHat();
            }

        } else if (coTuongTac(e, nutHieuUng)) {
            if (nutHieuUng.isMousePressed()) {
                nutHieuUng.setMuted(!nutHieuUng.isMuted());
                game.getAmThanh().tatTiengHieuUng();
            }
        }

        nutAmThanh.datLaiGiaTriBoo();
        nutHieuUng.datLaiGiaTriBoo();

        thanhDieuChinhAm.datLaiGiaTriBoo();
    }

    public void mouseMoved(MouseEvent e) {
        nutAmThanh.setMouseOver(false);
        nutHieuUng.setMouseOver(false);

        thanhDieuChinhAm.setMouseOver(false);

        if (coTuongTac(e, nutAmThanh)) {
            nutAmThanh.setMouseOver(true);
        } else if (coTuongTac(e, nutHieuUng)) {
            nutHieuUng.setMouseOver(true);
        } else if (coTuongTac(e, thanhDieuChinhAm)) {
            thanhDieuChinhAm.setMouseOver(true);
        }
    }
    
    //kiểm tra nếu phát hiện tương tác của chuột với ô đó thì thực hiện nó
    private boolean coTuongTac(MouseEvent e, NutTrenManHinh_Pause b) {
        return b.getBien().contains(e.getX(), e.getY());
    }

}
