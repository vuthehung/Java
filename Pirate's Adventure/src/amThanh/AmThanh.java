/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amThanh;
/**
 *
 * @author Admin
 */

import java.io.*;
import java.util.Random;

import javax.sound.sampled.*;

public class AmThanh {
    
    //âm thanh dài(bài hát)
    public static int MENU_1 = 0;
    public static int LVL_1 = 1;
    public static int LVL_2 = 2;

    //hieuUng
    public static int Chet = 4;
    public static int Nhay = 0;
    public static int GAMEOVER = 5;
    public static int QuaMap = 6;
    public static int TanCong_1 = 1;
    public static int TanCong_2 = 2;
    public static int TanCong_3 = 3;

    private Clip[] nhacNen, hieuUng;
    private int maNhacNen;
    private float amLuong = 0.5f;
    private boolean tatBaiHat, tatHieuUng;
    private Random rand = new Random();

    public AmThanh() {
        taiNhacNen();
        taiHieuUng();
        batBaiHat(MENU_1);
    }
    
    //đọc file âm thanh
    private Clip docFileAmThanh(String name) {
        AudioInputStream audio;

        try {
            audio = AudioSystem.getAudioInputStream(new File("data/am_thanh/" + name + ".wav"));
            Clip c = AudioSystem.getClip();
            c.open(audio);
            return c;

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }

        return null;

    }

    //tải các file âm thanh cho map, menu
    private void taiNhacNen() {
        String[] names = {"menu", "level1", "level2"};
        nhacNen = new Clip[names.length];
        for (int i = 0; i < nhacNen.length; i++) {
            nhacNen[i] = docFileAmThanh(names[i]);
        }
    }

    //tải các file âm thanh hiệu ứng
    private void taiHieuUng() {
        String[] effectNames = {"nhay", "tc1", "tc2", "tc3", "chet", "gameover", "qua_map"};
        hieuUng = new Clip[effectNames.length];
        for (int i = 0; i < hieuUng.length; i++) {
            hieuUng[i] = docFileAmThanh(effectNames[i]);
        }

        capNhatAmLuongHieuUng();

    }
    
    //khởi tạo âm thanh có các level
    public void setBaiHat(int lvlI) {
        if (lvlI % 2 == 0) {
            batBaiHat(LVL_1);
        } else {
            batBaiHat(LVL_2);
        }
    }

    //cập nhật âm lượng
    public void setAmLuong(float amLuong) {
        this.amLuong = amLuong;
        capNhatAmLuongBaiHat();
        capNhatAmLuongHieuUng();
    }
    
    //bật âm thanh dài
    public void batBaiHat(int stt) {
        dungNhacNen();

        maNhacNen = stt;
        capNhatAmLuongBaiHat();
        nhacNen[maNhacNen].setMicrosecondPosition(0);
        nhacNen[maNhacNen].loop(Clip.LOOP_CONTINUOUSLY);
    }

    //dừng âm nhạc nền cho map, menu
    public void dungNhacNen() {
        if (nhacNen[maNhacNen].isActive()) {
            nhacNen[maNhacNen].stop();
        }
    }
    
    public void tatTiengBaiHat() {
        this.tatBaiHat = !tatBaiHat;
        for (Clip c : nhacNen) {
            BooleanControl booleanControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
            booleanControl.setValue(tatBaiHat);
        }
    }
    
    //bật hiệu ứng
    public void batHieuUng(int hU) {
        if (hieuUng[hU].getMicrosecondPosition() > 0) {
            hieuUng[hU].setMicrosecondPosition(0);
        }
        hieuUng[hU].start();
    }
    
    //âm thanh khi qua 1 map
    public void amThanhQuaMap() {
        dungNhacNen();
        batHieuUng(QuaMap);
    }
    
    //bật hiệu ứng tấn công
    //random 1 trong 3 hiệu ứng tấn công
    public void batHieuUngTanCong() {
        int tanCong = 1;
        tanCong += rand.nextInt(3);
        batHieuUng(tanCong);
    }

    public void tatTiengHieuUng() {
        this.tatHieuUng = !tatHieuUng;
        for (Clip c : hieuUng) {
            BooleanControl booleanControl = (BooleanControl) c.getControl(BooleanControl.Type.MUTE);
            booleanControl.setValue(tatHieuUng);
        }
        if (!tatHieuUng) {
            batHieuUng(Nhay);
        }
    }

    private void capNhatAmLuongBaiHat() {
        FloatControl gainControl = (FloatControl) nhacNen[maNhacNen].getControl(FloatControl.Type.MASTER_GAIN);
        float range = gainControl.getMaximum() - gainControl.getMinimum();
        float gain = (range * amLuong) + gainControl.getMinimum();
        gainControl.setValue(gain);
    }

    private void capNhatAmLuongHieuUng() {
        for (Clip c : hieuUng) {
            FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
            float range = gainControl.getMaximum() - gainControl.getMinimum();
            float gain = (range * amLuong) + gainControl.getMinimum();
            gainControl.setValue(gain);
        }
    }

}
