package coloretto.commands;

import coloretto.server.ClientConnection;

public abstract class Command {
	protected String command;
	protected ClientConnection cc;
		
	public Command (String command, ClientConnection cc) {
		this.command = command;
		this.cc = cc;
	}
	
	public abstract String execute();

}
