package me.juztn.de.main;

public enum ServerMessages {
	
	PLAYER_NOT_ONLINE("§cDieser Spieler ist nicht online"),
	PLAYER_UNKKNOWN("§cDieser Spieler ist unbekannt"),
	NO_PERMISSION("§cDu hast nicht das Recht dazu");
	
	String message = "";
	
	ServerMessages(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return this.getMessage();
	}
	
}
