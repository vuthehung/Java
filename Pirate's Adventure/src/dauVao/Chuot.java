/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dauVao;
/**
 *
 * @author Admin
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import trangThai.KhoiTaoTrangThai;
import main.GamePanel;

public class Chuot implements MouseListener, MouseMotionListener {

    private GamePanel gamePanel;

    public Chuot(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (KhoiTaoTrangThai.trangThai) {
            case PLAYING->
                gamePanel.getGame().getPlaying().mouseDragged(e);
            case OPTIONS->
                gamePanel.getGame().getGameOptions().mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (KhoiTaoTrangThai.trangThai) {
            case MENU->
                gamePanel.getGame().getMenu().mouseMoved(e);
            case PLAYING->
                gamePanel.getGame().getPlaying().mouseMoved(e);
            case OPTIONS->
                gamePanel.getGame().getGameOptions().mouseMoved(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (KhoiTaoTrangThai.trangThai) {
            case PLAYING->
                gamePanel.getGame().getPlaying().mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (KhoiTaoTrangThai.trangThai) {
            case MENU->
                gamePanel.getGame().getMenu().mousePressed(e);
            case PLAYING->
                gamePanel.getGame().getPlaying().mousePressed(e);
            case OPTIONS->
                gamePanel.getGame().getGameOptions().mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (KhoiTaoTrangThai.trangThai) {
            case MENU->
                gamePanel.getGame().getMenu().mouseReleased(e);
            case PLAYING->
                gamePanel.getGame().getPlaying().mouseReleased(e);
            case OPTIONS->
                gamePanel.getGame().getGameOptions().mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
