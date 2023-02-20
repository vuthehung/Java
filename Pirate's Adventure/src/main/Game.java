/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Admin
 */

import java.awt.Graphics;

import amThanh.AmThanh;
import trangThai.Options;
import trangThai.KhoiTaoTrangThai;
import trangThai.Menu;
import trangThai.Playing;
import giaoDien.NutAmThanh;

public class Game implements Runnable {

    private GamePanel gamePanel;
    private Thread gameThread;

    private Playing playing;
    private Menu menu;
    private Options gameOptions;
    private NutAmThanh dieuChinhAm;
    private AmThanh amThanh;

    public Game() {
        khoiTaoLop();
        gamePanel = new GamePanel(this);
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocusInWindow();
        vongLapGame();
    }

    private void khoiTaoLop() {
        dieuChinhAm = new NutAmThanh(this);
        amThanh = new AmThanh();
        menu = new Menu(this);
        playing = new Playing(this);
        gameOptions = new Options(this);
    }

    private void vongLapGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void capNhat() {
        switch (KhoiTaoTrangThai.trangThai) {

            case MENU ->
                menu.capNhat();
            case PLAYING ->
                playing.capNhat();
            case OPTIONS ->
                gameOptions.capNhat();
            case QUIT ->
                System.exit(0);
        }
    }

    public void render(Graphics g) {
        switch (KhoiTaoTrangThai.trangThai) {
            case MENU ->
                menu.ve(g);
            case PLAYING ->
                playing.ve(g);
            case OPTIONS ->
                gameOptions.ve(g);
        }
    }

    @Override
    public void run() {

        //dạng nano giây: thời gian cho 1 khung hình, 1 lần cập nhật
        // mong muốn FPS = 120, UPS = 200;
        double TPF = 1000000000.0 / 120;
        double TPU = 1000000000.0 / 200;

        long thoiGianBatDau = System.nanoTime();

        int khungHinh = 0;
        int capNhat = 0;
        long thoiDiemKT = System.currentTimeMillis();

        double dU = 0;
        double dF = 0;

        while (true) {

            long thoiGianHienTai = System.nanoTime();
            
            dU += (thoiGianHienTai - thoiGianBatDau) / TPU;
            dF += (thoiGianHienTai - thoiGianBatDau) / TPF;
            thoiGianBatDau = thoiGianHienTai;

            ////tuong duong voi: thoiGianHienTai - thoiGianBatDau >= UFP
            if (dU >= 1) {
                capNhat();
                capNhat++;
                dU--;
            }
            //tuong duong voi: thoiGianHienTai - thoiGianBatDau >= TFP
            if (dF >= 1) {
                gamePanel.repaint();
                khungHinh++;
                dF--;
            }

            //thời gian sau 1 giây
            if (System.currentTimeMillis() - thoiDiemKT >= 1000) {
                thoiDiemKT = System.currentTimeMillis();
                khungHinh = 0;
                capNhat = 0;
            }

        }
    }

    public void windowFocusLost() {
        if (KhoiTaoTrangThai.trangThai == KhoiTaoTrangThai.PLAYING) {
            playing.getCuopBien().datLaiHuong();
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Options getGameOptions() {
        return gameOptions;
    }

    public NutAmThanh getNutDieuDinhAmThanh() {
        return dieuChinhAm;
    }

    public AmThanh getAmThanh() {
        return amThanh;
    }
}
