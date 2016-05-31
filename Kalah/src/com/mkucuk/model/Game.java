package com.mkucuk.model;

import java.util.List;

public class Game {

	private Pit[] pits; // Player1 owns pits 0-5 Player2 owns pits 6-11
	private Pit[] houses; // Player1 owns house 0 Player2 owns house 1
	private int playerTurn;
	private Pit currentHouse;
	
	public static final int PLAYER1_ID = 1;
	public static final int PLAYER2_ID = 2;
	public static final int NUMBER_OF_STONES = 6;

	public Game() {
		pits = new Pit[12];
		houses = new Pit[2];
		playerTurn = PLAYER1_ID;

		initPits(NUMBER_OF_STONES);
		initHouses();
		currentHouse = houses[playerTurn - 1];
	}

	/**
	 * This method adds Pit-objects into the global variable pits-array.
	 */
	private void initPits(int k) {
		for (int i = 0; i < 6; i++) {
			Pit p = new Pit();
			Pit p2 = new Pit();

			p.setStones(k);
			p2.setStones(k);

			p.setPlayer(PLAYER1_ID);
			p2.setPlayer(PLAYER2_ID);

			pits[i] = p;
			pits[i + 6] = p2;

		}
	}

	/**
	 * This method adds Pit-objects into the global variable houses-array.
	 */
	private void initHouses() {
		Pit h = new Pit();
		Pit h2 = new Pit();

		h.setPlayer(PLAYER1_ID);
		h2.setPlayer(PLAYER2_ID);

		houses[0] = h;
		houses[1] = h2;
	}

	public Pit[] getPits() {
		return pits;
	}

	public void setPits(Pit[] pits) {
		this.pits = pits;
	}

	public Pit getHouse(int playerID) {
		return houses[playerID-1];
	}

	public void setHouse(int playerID, Pit house) {
		this.houses[playerID-1] = house;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	/**
	 * This method returns the score in int-array format. 
	 * 
	 * @return First element is the score of player 1. Second element is the score of player2.
	 */
	public int[] getScore() {
		int[] score = new int[2];
		score[0] = houses[0].getStones();
		score[1] = houses[1].getStones();
		return score;
	}

	/**
	 * This method changes the turn.
	 */
	private void changeTurn() {
		if (playerTurn == PLAYER1_ID) {
			playerTurn = PLAYER2_ID;

		} else {
			playerTurn = PLAYER1_ID;
		}
		currentHouse = houses[playerTurn - 1];
	}

	/**
	 * This method returns the next element depending on the turn and the houses.
	 * 
	 * @param Current element
	 * @return Next element depending on the turn
	 */
	private int next(int pitCurrent) {
		if ((pitCurrent >= 0 && pitCurrent < 5) || (pitCurrent >= 6 && pitCurrent < 11)) {
			return ++pitCurrent;
		} else if (pitCurrent == -11) {
			return 0;
		} else if (pitCurrent == -5) {
			return 6;
		} else if (pitCurrent == 5 && playerTurn == PLAYER1_ID) {
			return -5;
		} else if (pitCurrent == 5 && playerTurn == PLAYER2_ID) {
			return 6;
		} else if (pitCurrent == 11 && playerTurn == PLAYER2_ID) {
			return -11;
		} else {
			return 0;
		}
	}

	/**
	 * @return First element is sum of Player 1's pits. Second element is sum of Player 2's pits.
	 */
	private int[] getSums() {
		int sumPits1 = 0, sumPits2 = 0;

		for (int i = 0; i < 6; i++) {
			sumPits1 += pits[i].getStones();
			sumPits2 += pits[i + 6].getStones();

		}
		int[] sums = new int[2];
		sums[0] = sumPits1;
		sums[1] = sumPits2;
		return sums;

	}

	/**
	 * This method plays a move depending on the selected pit, the player and the setup.
	 * 
	 * @param selected pit by one of the players
	 * @return updated game with corresponding setup
	 */
	public Game playMove(int pitIndex) {
		System.out.println("Play move with " + pitIndex);

		int pitSize = pits[pitIndex].getStones();
		pits[pitIndex].setStones(0);

		int pitCurrent = pitIndex;

		while (pitSize > 0) {

			pitCurrent = next(pitCurrent);
			
			if (pitCurrent == -5) {
				houses[0].setStones(houses[0].getStones() + 1);
			} else if (pitCurrent == -11) {
				houses[1].setStones(houses[1].getStones() + 1);
			} else {
				pits[pitCurrent].setStones(pits[pitCurrent].getStones() + 1);
			}

			pitSize--;
		}

		if (pitCurrent != -5 && pitCurrent != -11 && pits[pitCurrent].getStones() == 1) { // last pit was empty

			int bothSides = 1 + pits[11 - pitCurrent].getStones();

			pits[pitCurrent].setStones(0);
			pits[11 - pitCurrent].setStones(0);

			currentHouse.setStones(currentHouse.getStones() + bothSides);

		}

		if (pitCurrent != -5 && pitCurrent != -11) {
			changeTurn();
		}

		checkGameover();

		return this;

	}
	
	private void checkGameover(){
		int[] sums = getSums();

		if (sums[0] == 0 || sums[1] == 0) {
			houses[0].setStones(houses[0].getStones() + sums[0]);
			houses[1].setStones(houses[1].getStones() + sums[1]);
			initPits(0);
		}
	}
	
	public boolean isGameover(){
		int[] sums = getSums();
		if(sums[0] == 0 || sums[1] == 0){
			return true;
		}
		return false;
	}

}
