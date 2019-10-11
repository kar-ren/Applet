package com.myapplet.main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import com.myapplet.audience.Audience;
import com.myapplet.winners.Podium;

public class MainApplet extends Applet {

	Audience audience = new Audience();
	Podium podium = new Podium();
	Image picture, back, medal1, medal2, medal3;
	int x = 0, y = 0;
	public static Horse[] horselist = new Horse[10];

	public void init() {
		resize(1500, 1000);
		setBackground(Color.WHITE);
		try {
			picture = getImage(new URL(getDocumentBase(), "/home/karen/Documents/horse.gif"));
			back = getImage(new URL(getDocumentBase(), "/home/karen/Documents/white.png"));
			//medal1 = getImage(new URL(getDocumentBase(), "/home/karen/Documents/Gold-medal.png"));
			//medal2 = getImage(new URL(getDocumentBase(), "/home/karen/Documents/Silver-medal.png"));
			//medal3 = getImage(new URL(getDocumentBase(), "/home/karen/Documents/Bronze-medal.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			horselist[i] = new Horse(i + 1, x, y);
			y += 68;
		}
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void start() {
		Thread thread = new Thread();
		thread.start();
		for (int j = 0; j < horselist.length; j++) {
			horselist[j].start();
		}
		audience.start();
	}

	public void update(Graphics g) {
		for (int i = 0; i < horselist.length; i++) {
			g.drawImage(picture, horselist[i].getX(), horselist[i].getY(), 60, 68, this);
			g.drawImage(back, horselist[i].getX() - 60, horselist[i].getY(), 60, 68, this);
		}
		g.drawLine(1100, 0, 1100, 1100);

//		g.drawImage(medal1, Podium.horse[0].getX() + 50, Podium.horse[0].getY(), 60, 68, this);
//		g.drawImage(medal2, Podium.horse[1].getX() + 50, Podium.horse[1].getY(), 60, 68, this);
//		g.drawImage(medal3, Podium.horse[2].getX() + 50, Podium.horse[2].getY(), 60, 68, this);

	}
}
