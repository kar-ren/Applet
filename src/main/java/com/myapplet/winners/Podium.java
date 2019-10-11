package com.myapplet.winners;


public class Podium{
	
	private static int win = 0;
	//public static Horse[] horse = new Horse[3];
	
	public void getWinners(int winner, int x, int y) {
		win++;
		if(win == 1) {
			System.out.print("\n"+winner + " won Gold");
		}else if(win == 2){
			System.out.print("\n"+winner + " won Silver");
		}else if (win == 3) {
			System.out.print("\n"+winner + " won Bronze");
		}else{
			System.out.print("\n"+winner + " loses");
		}
	}
}
