/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
/**
 *
 * @author Admin
 */

import java.awt.*;
import javax.swing.JPanel;
import dauVao.*;

public class GamePanel extends JPanel {

	private Chuot chuot;
	private Game game;

	public GamePanel(Game game) {
		chuot = new Chuot(this);
		this.game = game;
                
		//setPanelSize
                Dimension size = new Dimension(1248, 672);
		setPreferredSize(size);
                
                //thêm sự kiện sử lý đầu vào
		addKeyListener(new BanPhim(this));
		addMouseListener(chuot);
		addMouseMotionListener(chuot);
	}

        @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}

	public Game getGame() {
		return game;
	}

}