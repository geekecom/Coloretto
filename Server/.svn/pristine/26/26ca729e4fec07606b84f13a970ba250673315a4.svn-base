package coloretto.commands;

import coloretto.server.ClientConnection;

public class ErrorCommand extends Command {
	private String message;
	
	public ErrorCommand (String message, ClientConnection cc){
		
		super (message, cc);
		this.message=message;
	}
	@Override
	public String execute() {
		return message;
	}

}
