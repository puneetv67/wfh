package com.puneet.file.csv;

public class Sports {
	private String playerName;
	private String country;
	private String sports;
	
	public Sports(String country, String playerName, String sports) {
		super();
		this.country = country;
		this.playerName = playerName;
		this.sports = sports;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	@Override
	public String toString(){
		return "Country: " + country +"\tPlayer: " + playerName + "\tSports: " + sports;
	}
}
