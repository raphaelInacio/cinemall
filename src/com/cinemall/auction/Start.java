package com.cinemall.auction;

import java.util.ArrayList;
import java.util.List;

public class Start {

	private List<Properties> listProperties = new ArrayList<Properties>();

	private List<Player> listPlayers = new ArrayList<Player>();

	private List<Auction> listAuctions = new ArrayList<Auction>();

	public void loadProperties() {
		for (int i = 0; i < Constants.NUM_PROPERTIES_AUCTION; i++) {
			this.listProperties.add(createProperties(i));
		}
	}

	public void loadPlayers() {
		boolean humamnPlayer = false;
		for (int i = 0; i < Constants.NUM_PLAYERS_AUCTION; i++) {
			if (!humamnPlayer) {
				this.listPlayers.add(createHumanPlayer(i));
				humamnPlayer = true;
			} else {
				this.listPlayers.add(createIAPlayer(i));
			}
		}
	}

	private HumanPlayer createHumanPlayer(int id) {
		HumanPlayer humanPlayer = new HumanPlayer(id, "Sr. " + Math.random(), Constants.INITIAL_VALUE_PLAYERS);
		System.out.println(humanPlayer.getName());
		return humanPlayer;
	}

	private IAPlayer createIAPlayer(int id) {
		IAPlayer iaPlayer = new IAPlayer(id, "AI. " + Math.random(), Constants.INITIAL_VALUE_PLAYERS);
		System.out.println(iaPlayer.getName());
		return iaPlayer;
	}

	private Properties createProperties(int id) {
		Properties properties = new Properties(id, Math.random() + "");
		System.out.println(properties.getName());
		return properties;
	}

	private Auction createAuction(Properties properties) {
		return new Auction(properties);
	}

	private void processAuction(){
		for (Properties properties : listProperties) {
			Auction auction = createAuction(properties);
			this.startAuction(auction);
		}
	}

	public void startAuction(Auction auction) {
		while(true){
			for (Player player : listPlayers) {
				System.out.println(player);
			}
		}
	}
	
	
	
	public void bidAuction(){
		
	}

	public static void main(String[] args) {
		Start start = new Start();
		start.loadPlayers();
		start.loadProperties();
		start.processAuction();
	}

}
