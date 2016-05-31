package com.mkucuk.model;

public class Pit {
	
	private int stones;		//number of stones
	private int player;		//player which owns this pit
	
	public int getStones() {
		return stones;
	}
	
	public void setStones(int stones) {
		this.stones = stones;
	}
	
	public int getPlayer() {
		return player;
	}
	
	public void setPlayer(int player) {
		this.player = player;
	}
	
	public String toString(){
		return this.stones + "";
	}
	
}