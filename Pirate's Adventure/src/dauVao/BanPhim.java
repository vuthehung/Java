/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dauVao;
/**
 *
 * @author Admin
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import trangThai.KhoiTaoTrangThai;
import main.GamePanel;

public class BanPhim implements KeyListener {

    private GamePanel gamePanel;

    public BanPhim(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (KhoiTaoTrangThai.trangThai) {
            case MENU->
                gamePanel.getGame().getMenu().keyReleased(e);
            case PLAYING->
                gamePanel.getGame().getPlaying().keyReleased(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (KhoiTaoTrangThai.trangThai) {
            case MENU->
                gamePanel.getGame().getMenu().keyPressed(e);
            case PLAYING->
                gamePanel.getGame().getPlaying().keyPressed(e);
            case OPTIONS->
                gamePanel.getGame().getGameOptions().keyPressed(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
