package coloretto.states;


import java.util.HashMap;
import java.util.Map;


import coloretto.commands.Command;
import coloretto.commands.CommandFactory;

import coloretto.commands.HelpCommand;
import coloretto.commands.LeaveGameCommand;
import coloretto.commands.ShowGamesCommand;
import coloretto.commands.StartGameCommand;
import coloretto.server.ClientConnection;

public class WaitingGameCommandFactory extends CommandFactory{
	
	protected Map<String, Class<?>> allowedCommands = new HashMap<String, Class<?>>();
	
	public WaitingGameCommandFactory(){
		super();
		allowedCommands.put("HELP", HelpCommand.class);
		allowedCommands.put("LEAVE", LeaveGameCommand.class);
		allowedCommands.put("SHOW", ShowGamesCommand.class);
		allowedCommands.put("START", StartGameCommand.class);
	}
	
	public Command createCommand(String command, ClientConnection cc) {
		return create(command, cc, allowedCommands);
	}

}
