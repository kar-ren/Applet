package com.myapplet.audience;

import java.util.Random;

import com.myapplet.main.MainApplet;

public class Audience extends Thread implements Runnable {
	Random random = new Random();
	boolean throwSpin = true;

	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
				MainApplet.horselist[random.nextInt(10)].feed();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
