/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package levels;
/**
 *
 * @author Admin
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import main.Game;
import phuongThucTaiSuDung.DocHinhAnh;

public class QuanLiLvl {

    private Game game;
    private BufferedImage[] anhDat;
    private BufferedImage[] anhNuoc;
    private ArrayList<Lvl> lvl;
    private int viTriLvl = 0;
    private int danhDauHieuUng;
    private int soLuongHieuUng;

    public QuanLiLvl(Game game) {
        this.game = game;
        lvl = new ArrayList<>();
        //tải tất cả các map
        BufferedImage[] maps = DocHinhAnh.DocMap();
        for (BufferedImage img : maps) {
            lvl.add(new Lvl(img));
        }
        
        BufferedImage cl = DocHinhAnh.LuuHinhAnh(DocHinhAnh.CHAT_LIEU_MAP);
        anhDat = new BufferedImage[48];
        // chia ra thanh moi o vuong co 32 x 32 => chiều cao ảnh chia 4, chiều dài ảnh chia 12
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 12; i++) {
                int index = j * 12 + i;
                anhDat[index] = cl.getSubimage(i * 32, j * 32, 32, 32);
            }
        }
        
        //lưu trữ hình ảnh NƯỚC
        //chia hình ảnh thành 4 ô vuông 32 x 32 để có thể tạo hiệu ứng sóng lặp đi lặp lại có ảnh nhỏ.
        anhNuoc = new BufferedImage[5];
        BufferedImage nuoc = DocHinhAnh.LuuHinhAnh(DocHinhAnh.MAT_NUOC);
        for (int i = 0; i < 4; i++) {
            anhNuoc[i] = nuoc.getSubimage(i * 32, 0, 32, 32);
        }
        anhNuoc[4] = DocHinhAnh.LuuHinhAnh(DocHinhAnh.NUOC);
    }

    public void taiLvlTiepTheo() {
        Lvl lvlMoi = lvl.get(viTriLvl);
        game.getPlaying().getQuanLiQV().taiQuaiVat(lvlMoi);
        game.getPlaying().getCuopBien().taiChatLieuMap(lvlMoi.getChatLieu());
        game.getPlaying().setbuLvlToiDa(lvlMoi.getBu());
        game.getPlaying().getQuanLiO().taiVatThe(lvlMoi);
    }

    public void ve(Graphics g, int buLvl) {
        for (int j = 0; j < 14; j++) {
            for (int i = 0; i < lvl.get(viTriLvl).getChatLieu()[0].length; i++) {
                int index = lvl.get(viTriLvl).getGiaTriChatLieu(i, j);
                int x = 48 * i - buLvl;
                int y = 48 * j;
                if (index == 48) {
                    g.drawImage(anhNuoc[soLuongHieuUng], x, y, 48, 48, null);
                } else if (index == 49) {
                    g.drawImage(anhNuoc[4], x, y, 48, 48, null);
                } else {
                    g.drawImage(anhDat[index], x, y, 48, 48, null);
                }
            }
        }
    }
    
    public void capNhat() {
        //tạo hiệu ứng SÓNG
        danhDauHieuUng++;
        if (danhDauHieuUng == 40) {
            danhDauHieuUng = 0;
            soLuongHieuUng++;

            if (soLuongHieuUng == 4) {
                soLuongHieuUng = 0;
            }
        }
    }
     
    public int getSoLuongMap() {
        return lvl.size();
    }
    
    public Lvl getLvlHienTai() {
        return lvl.get(viTriLvl);
    }

    public int getViTriLvl() {
        return viTriLvl;
    }

    public void setViTriLvl(int viTriLvl) {
        this.viTriLvl = viTriLvl;
    }
}
