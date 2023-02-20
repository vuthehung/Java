/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanVat;
/**
 *
 * @author Admin
 */

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import trangThai.Playing;
import levels.Lvl;
import phuongThucTaiSuDung.DocHinhAnh;
import static phuongThucTaiSuDung.HangSo.QuaiVat.*;

public class PhuongThucChung_QuaiVat {

    private Playing playing;
    private BufferedImage[][] cua, saoBien, caMap;
    private Lvl mapHienTai;

    public PhuongThucChung_QuaiVat(Playing playing) {
        this.playing = playing;
        //đọc ảnh quái vật
        cua = taiAnh(DocHinhAnh.LuuHinhAnh(DocHinhAnh.CUA), 9, 5, 72, 32);
        saoBien = taiAnh(DocHinhAnh.LuuHinhAnh(DocHinhAnh.SAO_BIEN), 8, 5, 34, 30);
        caMap = taiAnh(DocHinhAnh.LuuHinhAnh(DocHinhAnh.CA_MAP), 8, 5, 34, 30);
    }

    public void taiQuaiVat(Lvl map) {
        this.mapHienTai = map;
    }

    public void capNhat(int[][] chatLieu) {
        boolean dangDiChuyen = false;
        for (Cua c : mapHienTai.getCua()) {
            if (c.dangDiChuyen()) {
                c.capNhat(chatLieu, playing);
                dangDiChuyen = true;
            }
        }

        for (SaoBien s : mapHienTai.getSaoBien()) {
            if (s.dangDiChuyen()) {
                s.capNhat(chatLieu, playing);
                dangDiChuyen = true;
            }
        }

        for (CaMap cm : mapHienTai.getCaMap()) {
            if (cm.dangDiChuyen()) {
                cm.capNhat(chatLieu, playing);
                dangDiChuyen = true;
            }
        }

        if (!dangDiChuyen) {
            playing.setHoanThanhLvl(true);
        }
    }

    public void ve(Graphics g, int buX) {
        //vẽ cua
        for (Cua c : mapHienTai.getCua()) {
            if (c.dangDiChuyen()) {
                g.drawImage(cua[c.getTrangThai()][c.getAniI()], (int) c.getHitbox().x - buX - 39 + c.daoX(), (int) c.getHitbox().y - 13, 112 * c.daoW(), 48, null);

//				c.veHitbox(g, xLvlOffset);
//				c.veAttackBox(g, xLvlOffset);
            }
        }
        //vẽ sao biển
        for (SaoBien s : mapHienTai.getSaoBien()) {
            if (s.dangDiChuyen()) {
                g.drawImage(saoBien[s.getTrangThai()][s.getAniI()], (int) s.getHitbox().x - buX - 13 + s.daoX(),
                        (int) s.getHitbox().y - 10 + (int) s.getTocDoXuongKhiBiDayLui(), 51 * s.daoW(), 45, null);
//				s.veHitbox(g, xLvlOffset);
            }
        }
        //vẽ cá mập
        for (CaMap cm : mapHienTai.getCaMap()) {
            if (cm.dangDiChuyen()) {
                g.drawImage(caMap[cm.getTrangThai()][cm.getAniI()], (int) cm.getHitbox().x - buX - 12 + cm.daoX(),
                        (int) cm.getHitbox().y - 9 + (int) cm.getTocDoXuongKhiBiDayLui(), 51 * cm.daoW(), 45, null);
//				cm.veHitbox(g, xLvlOffset);
//				cm.veAttackBox(g, xLvlOffset);
            }
        }
    }


    //kiểm tra quái vật có bị tấn công không. Nếu có sẽ bị mất máu
    //dựa vào sự va chạm giữa các hitbox
    public void kiemTraQuaiVatBiTanCong(Rectangle2D.Float attackBox) {
        for (Cua c : mapHienTai.getCua()) {
            if (c.dangDiChuyen()) {
                if (c.getTrangThai() != Chet && c.getTrangThai() != BiTanCong) {
                    //va chạm giữa cướp biển va entity
                    if (attackBox.intersects(c.getHitbox())) {
                        c.truMau(20);
                        return;
                    }
                }
            }
        }

        for (SaoBien s : mapHienTai.getSaoBien()) {
            if (s.dangDiChuyen()) {
                if (s.getTrangThai() == TanCong && s.getAniI() >= 3) {
                    return;
                } else {
                    if (s.getTrangThai() != Chet && s.getTrangThai() != BiTanCong) {
                        //va chạm giữa cướp biểnintersects va entity
                        if (attackBox.intersects(s.getHitbox())) {
                            s.truMau(20);
                            return;
                        }
                    }
                }
            }
        }

        for (CaMap cm : mapHienTai.getCaMap()) {
            if (cm.dangDiChuyen()) {
                if (cm.getTrangThai() != Chet && cm.getTrangThai() != BiTanCong) {
                    //va chạm giữa cướp biển va entity
                    if (attackBox.intersects(cm.getHitbox())) {
                        cm.truMau(20);
                        return;
                    }
                }
            }
        }
    }


    private BufferedImage[][] taiAnh(BufferedImage anh, int x, int y, int W, int H) {
        BufferedImage[][] a = new BufferedImage[y][x];
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a[j].length; i++) {
                a[j][i] = anh.getSubimage(i * W, j * H, W, H);
            }
        }
        return a;
    }

    public void lamMoiQuaiVat() {
        for (Cua c : mapHienTai.getCua()) {
            c.lamMoi();
        }
        for (SaoBien s : mapHienTai.getSaoBien()) {
            s.lamMoi();
        }
        for (CaMap cm : mapHienTai.getCaMap()) {
            cm.lamMoi();
        }
    }

}
