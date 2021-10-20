package main.java.POJO;

public class Olympics {
	
	private String country;
	private String playerFirstName;
	private String playerLastName;
	private String sports;
	private String medal;
	private String olympicEvent;
	public Olympics(String country, String playerFirstName, String playerLastName, String sports, String medal,
			String olympicEvent) {
		super();
		this.country = country;
		this.playerFirstName = playerFirstName;
		this.playerLastName = playerLastName;
		this.sports = sports;
		this.medal = medal;
		this.olympicEvent = olympicEvent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPlayerFirstName() {
		return playerFirstName;
	}
	public void setPlayerFirstName(String playerFirstName) {
		this.playerFirstName = playerFirstName;
	}
	public String getPlayerLastName() {
		return playerLastName;
	}
	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = playerLastName;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getMedal() {
		return medal;
	}
	public void setMedal(String medal) {
		this.medal = medal;
	}
	public String getOlympicEvent() {
		return olympicEvent;
	}
	public void setOlympicEvent(String olympicEvent) {
		this.olympicEvent = olympicEvent;
	}
	
}
