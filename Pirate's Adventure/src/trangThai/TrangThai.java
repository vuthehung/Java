/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trangThai;
/**
 *
 * @author Admin
 */

import java.awt.event.MouseEvent;

import amThanh.AmThanh;
import giaoDien.ManHinhChinh;

import main.Game;

public class TrangThai {

    protected Game game;

    public TrangThai(Game game) {
        this.game = game;
    }

    //kiểm tra nếu phát hiện tương tác của chuột với ô đó thì thực hiện nó
    public boolean coTuongTac(MouseEvent e, ManHinhChinh mb) {
        return mb.getBien().contains(e.getX(), e.getY());
    }

    public Game getGame() {
        return game;
    }

    public void thayDoiTrangThai(KhoiTaoTrangThai trangThai) {
        switch (trangThai) {
            case MENU->
                game.getAmThanh().batBaiHat(AmThanh.MENU_1);
            case PLAYING->
                game.getAmThanh().setBaiHat(game.getPlaying().getQuanLiLvl().getViTriLvl());
        }

        KhoiTaoTrangThai.trangThai = trangThai;
    }

}
