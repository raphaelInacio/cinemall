package com.cinemall.auction;

import java.util.HashMap;
import java.util.Map;

public class Auction {
	
	private int turns;
	private Properties properties;
	private Map<Long, Player> listBidPlayers = new HashMap<Long, Player>();

	public Auction(Properties properties) {
		this.properties = properties;
		this.turns = Constants.NUM_TURNS;
		startAuction();
	}

	private void startAuction(){
		this.turns--;
	}
	
	private void finishtAuction(){
		
	}

	private void winnerAuction(){
		
	}
	
	public void nextBid(Player player){
		if(this.listBidPlayers.containsKey(player.getId())){
			Player currentPlayer = listBidPlayers.get(player.getId());
		}else{			
			listBidPlayers.put(player.getId(), player);
		}
		nextTurn();
	}
	
	private void nextTurn(){
		if(turns < 0){
			this.turns--;			
		}else{
			finishtAuction();
		}
	}

}
