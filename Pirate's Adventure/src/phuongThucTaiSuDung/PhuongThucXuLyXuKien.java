/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phuongThucTaiSuDung;
/**
 *
 * @author Admin
 */

import java.awt.geom.Rectangle2D;

public class PhuongThucXuLyXuKien {

    //kiem tra xem cac nhan vat co the di chuyen den
    public static boolean CoTheDiChuyenDen(float x, float y, float w, float h, int[][] chatLieu) {
        if (!khongTheDi(x, y, chatLieu)) {
            if (!khongTheDi(x + w, y, chatLieu)) {
                if (!khongTheDi(x, y + h, chatLieu)) {
                    if (!khongTheDi(x + w, y + h, chatLieu)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //kiểm tra vị trí ô có toạ độ (x, y) có thể đi tiếp ko?
    //chẳng hạn như bị chắn bởi tường trước mặt thì ko thê đi tiếp được
    public static boolean khongTheDi(float x, float y, int[][] chatLieu) {
        //nếu đi quá chiều rộng của cưa sổ trò chơi sẽ bị chặn lại
        if (x < 0 || x >= chatLieu[0].length * 48) {
            return true;
        }
        //nếu đi quá chiều cao của cưa sổ trò chơi sẽ bị chặn lại
        if (y < 0 || y >= 672) {
            return true;
        }
        float x1 = x / 48;
        float y1 = y / 48;

        return Dat((int) x1, (int) y1, chatLieu);
    }

    //Kiểm tra ô có là "ĐẤT" không
    public static boolean Dat(int x, int y, int[][] chatLieu) {
        switch (chatLieu[y][x]) {
            //11: là hình ảnh rỗng
            //48, 49: lưu hình ảnh của "NUOC"
            case 11, 48, 49:
                return false;
            default:
                return true;
        }

    }
    //Lấy vị trí hình ảnh mà nhân vật đang đứng(là ĐẤT hay NƯỚC)
    public static int ViTriHinhAnh(float xPos, float yPos, int[][] chatLieu) {
        int x = (int) (xPos / 48);
        int y = (int) (yPos / 48);
        return chatLieu[y][x];
    }
    
    public static float ViTri_KhiNhanVatDungCanhTuong(Rectangle2D.Float hitbox, float xSpeed) {
        int currentTile = (int) (hitbox.x / 48);
        if (xSpeed > 0) {
            // Right
            int tileXPos = currentTile * 48;
            //xoffet: khoang cach giua player va vat the
            int xOffset = (int) (48 - hitbox.width);
            return tileXPos + xOffset - 1;
        } else // Left
        {
            return currentTile * 48;
        }
    }

    ////lấy vị trí(toạ độ Y) sau khi rơi xuống khi nhảy hoặc bị đẩy lùi
    public static float ViTri_KhiRoiXuong(Rectangle2D.Float hitbox, float tocDoTrenKhong) {
        int viTriHienTai = (int) (hitbox.y / 48);
        if (tocDoTrenKhong > 0) {
            // khi vừa rơi xuống nếu thực hiện hành động nhảy
            int Y = viTriHienTai * 48;
            int y = (int) (48 - hitbox.height);
            return Y + y - 1;
        } else 
        {
            //nhảy
            return viTriHienTai * 48;
        }

    }

    //Kiem tra Nhân Vật có đang đứng trên mặt đất không
    public static boolean DungTrenMatDat(Rectangle2D.Float hitbox, int[][] chatLieu) {
        if (!khongTheDi(hitbox.x, hitbox.y + hitbox.height + 1, chatLieu)) {
            if (!khongTheDi(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, chatLieu)) {
                return false;
            }
        }
        return true;
    }

    //Kiem tra khi di chuyển vẫn đứng trên mặt đất hay không
    public static boolean LaMatDat(Rectangle2D.Float hitbox, float xSpeed, int[][] chatLieu) {
        if (xSpeed > 0) {
            return khongTheDi(hitbox.x + hitbox.width + xSpeed, hitbox.y + hitbox.height + 1, chatLieu);
        } else {
            return khongTheDi(hitbox.x + xSpeed, hitbox.y + hitbox.height + 1, chatLieu);
        }
    }

    //Kiểm tra vị trí đang đứng là mặt đất(áp dụng cho Quái Vật) 
    //Quái vật chỉ có thể di chuyển qua lại trên 1 khoảng đất
    //Nếu di chuyển đến rìa vực thì sẽ quay lại
    public static boolean LaMatDat(Rectangle2D.Float hitbox, int[][] chatLieu) {
        if (!khongTheDi(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, chatLieu)) {
            if (!khongTheDi(hitbox.x, hitbox.y + hitbox.height + 1, chatLieu)) {
                return false;
            }
        }
        return true;
    }

    //Kiểm tra xem Player có trong tầm bắn của Pháo hay không?
    public static boolean TrongTamBan(int[][] chatLieu, Rectangle2D.Float fHitbox, Rectangle2D.Float sHitbox, int yTile) {
        int fXTile = (int) (fHitbox.x / 48);
        int sXTile = (int) (sHitbox.x / 48);

        if (fXTile > sXTile) {
            return KhongBiChan(sXTile, fXTile, yTile, chatLieu);
        } else {
            return KhongBiChan(fXTile, sXTile, yTile, chatLieu);
        }
    }

    //Kiểm tra xem phía trước có bị chắn bởi các bức tường(đất) không
    public static boolean KhongBiChan(int xS, int xE, int y, int[][] chatLieu) {
        for (int i = 0; i < xE - xS; i++) {
            if (Dat(xS + i, y, chatLieu)) {
                return false;
            }
        }
        return true;
    }
    
    //Kiểm tra liệu có thể đi được không
    public static boolean CoTheDi(int xS, int xE, int y, int[][] chatLieu) {
        if (KhongBiChan(xS, xE, y, chatLieu)) {
            for (int i = 0; i < xE - xS; i++) {
                if (!Dat(xS + i, y + 1, chatLieu)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Kiểm tra phía trước có thấy cướp biển ko
    public static boolean tamNhinKhongBiChan(int[][] chatLieu, Rectangle2D.Float enemyBox, Rectangle2D.Float playerBox, int yTile) {
        int fXTile = (int) (enemyBox.x / 48);

        int sXTile;
        if (khongTheDi(playerBox.x, playerBox.y + playerBox.height + 1, chatLieu)) {
            sXTile = (int) (playerBox.x / 48);
        } else {
            sXTile = (int) ((playerBox.x + playerBox.width) / 48);
        }

        if (fXTile > sXTile) {
            return CoTheDi(sXTile, fXTile, yTile, chatLieu);
        } else {
            return CoTheDi(fXTile, sXTile, yTile, chatLieu);
        }
    }

}
