/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phuongThucTaiSuDung;
/**
 *
 * @author Admin
 */

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class DocHinhAnh {

    //hình ảnh nhân vật
    public static final String CUOP_BIEN = "cuop_bien.png";
    public static final String SAO_BIEN = "sao_bien.png";
    public static final String CA_MAP = "cap_map.png";
    public static final String CUA = "cua.png";
    
    //hình ảnh lựa chọn
    public static final String ANH_NEN = "anh_nen4.jpg";
    public static final String MANHINH_LUACHON = "khi_chon_option.png";
    public static final String NUT_LUA_CHON = "nut_lua_chon.png";
    public static final String MENU_BACKGROUND = "menu_background.png";
    public static final String MANHINH_PAUSE = "khi_pause.png";
    public static final String NutTatBat_Am = "nut_bat_tat_am.png";
    public static final String NUT_QL_TT = "nut_quaylai_tieptuc.png";
    public static final String THANH_KEO = "thanh_keo_dc_am.png";
    public static final String ANH_NEN_TRONG_GAME = "anh_nen_tronggame.png";
    public static final String MANHINH_HET_GAME = "game_completed.png";
    public static final String MANHINH_KHI_CHET = "khi_chet.png";
    public static final String MANHINH_QUA_MAP = "qua_map.png";
    public static final String BANDO = "ban_do.png";
    public static final String BANDOTO = "anh_bando2.jpg";
    
    //ảnh tạo nên map
    public static final String MAY_LON = "dammay_lon.png";
    public static final String MAY_NHO = "dammay_nho.png";
    public static final String CHAT_LIEU_MAP = "chat_lieu_map.png";
    public static final String CO = "co.png";
    public static final String TREE_ONE_ATLAS = "tree_one_atlas.png";
    public static final String TREE_TWO_ATLAS = "tree_two_atlas.png";
    public static final String MAT_NUOC = "mat_nuoc.png";
    public static final String NUOC = "nuoc.png";
    public static final String THUYEN = "thuyen.png";
    
    //ảnh vật phẩm
    public static final String THANH_MAU_NL = "thanh_mau_nl.png";
    public static final String LO_THUOC = "lo_thuoc.png";
    public static final String THUNG_CHUA = "thung_chua.png";
    public static final String BAY = "bay.png";
    public static final String PHAO = "phao.png";
    public static final String DAN_PHAO = "dan_phao.png";
    
    
    public static BufferedImage LuuHinhAnh(String tenFile) {
        BufferedImage anh = null;
        try {
            anh = ImageIO.read(new File("data/" + tenFile));
        } catch (IOException e) {
        }

        return anh;
    }

    public static BufferedImage[] DocMap() {

        BufferedImage[] maps = new BufferedImage[3];

        for (int i = 0; i < maps.length; i++)
        try {
//            maps[i] = ImageIO.read(new File("data/demo/" + (i + 1) + ".png"));
            maps[i] = ImageIO.read(new File("data/map/" + (i + 1) + ".png"));
        } catch (IOException e) {
        }

        return maps;
    }

}
