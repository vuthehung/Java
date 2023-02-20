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

public class ManHinhQuaMap {

    private Playing playing;
    private Nut_QL_TT quayLaiMenu, choiTiep;
    private BufferedImage anhQuaMap, anhBanDo;
    private int bgX, bgY, bgW, bgH;

    public ManHinhQuaMap(Playing playing) {
        this.playing = playing;
        
        //đọc ảnh và truyền giá trị cho tham số để vẽ ảnh
        anhQuaMap = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MANHINH_QUA_MAP);
        bgW = (int) (anhQuaMap.getWidth() * 1.5f);
        bgH = (int) (anhQuaMap.getHeight() * 1.5f);
        bgX = 1248 / 2 - bgW / 2;
        bgY = (int) (70 * 1.5f);
        
        anhBanDo = DocHinhAnh.LuuHinhAnh(DocHinhAnh.BANDO);
        
        //tạo các nút có trong màn hình qua map: gồm quay lại menu và chơi tiếp
        choiTiep = new Nut_QL_TT(667, 292, 84, 84, 0);
        quayLaiMenu = new Nut_QL_TT(495, 292, 84, 84, 2);
    }

    public void ve(Graphics g) {
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(0, 0, 1248, 672);

        g.drawImage(anhQuaMap, bgX, bgY, bgW, bgH, null);
        
        g.drawImage(anhBanDo, 200, 270 , (int) (anhBanDo.getWidth() * 4.0f), (int) (anhBanDo.getHeight() * 4.0f), null);
        g.drawImage(anhBanDo, 1000, 270 , (int) (anhBanDo.getWidth() * 4.0f), (int) (anhBanDo.getHeight() * 4.0f), null);
        
        choiTiep.ve(g);
        quayLaiMenu.ve(g);
    }

    public void capNhat() {
        choiTiep.capNhat();
        quayLaiMenu.capNhat();
    }

    //kiểm tra nếu phát hiện tương tác của chuột với ô đó thì thực hiện nó
    private boolean coTuongTac(Nut_QL_TT b, MouseEvent e) {
        return b.getBien().contains(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
        choiTiep.setMouseOver(false);
        quayLaiMenu.setMouseOver(false);

        if (coTuongTac(quayLaiMenu, e)) {
            quayLaiMenu.setMouseOver(true);
        } else if (coTuongTac(choiTiep, e)) {
            choiTiep.setMouseOver(true);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (coTuongTac(quayLaiMenu, e)) {
            if (quayLaiMenu.isMousePressed()) {
                playing.lamMoiTatCa();
                playing.thayDoiTrangThai(KhoiTaoTrangThai.MENU);
            }
        } else if (coTuongTac(choiTiep, e)) {
            if (choiTiep.isMousePressed()) {
                playing.taiLvlTiepTheo();
                playing.getGame().getAmThanh().setBaiHat(playing.getQuanLiLvl().getViTriLvl());
            }
        }

        quayLaiMenu.datLaiGiaTriBoo();
        choiTiep.datLaiGiaTriBoo();
    }

    public void mousePressed(MouseEvent e) {
        if (coTuongTac(quayLaiMenu, e)) {
            quayLaiMenu.setMousePressed(true);
        } else if (coTuongTac(choiTiep, e)) {
            choiTiep.setMousePressed(true);
        }
    }

}
