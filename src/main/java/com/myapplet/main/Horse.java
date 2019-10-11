package com.myapplet.main;

import java.util.concurrent.TimeUnit;
import com.myapplet.winners.Podium;


public class Horse extends Thread implements Runnable {
	private int horsenum;
	private int x;
	private int y;
	Podium podium = new Podium();

	public Horse(int id, int x, int y) {
		this.horsenum = id;
		this.x = x;
		this.y = y;
	}

	public Horse() {}

	public int getHorsenum() {
		return horsenum;
	}

	public void setHorsenum(int horsenum) {
		this.horsenum = horsenum;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void run() {
		while (x < 1100) {
			try {
				TimeUnit.SECONDS.sleep(1);
				x += 10;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		podium.getWinners(horsenum, x, y);
	}

	public void feed() {
		if (x < 1100) {
			x += 20;
			System.out.print("\n"+horsenum);
		} else {
			x = 1100;
		}
	}

}
