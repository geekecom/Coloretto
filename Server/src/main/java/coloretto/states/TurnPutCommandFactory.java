package coloretto.states;

import java.util.HashMap;
import java.util.Map;


import coloretto.commands.Command;
import coloretto.commands.CommandFactory;

import coloretto.commands.HelpCommand;
import coloretto.commands.PutACardCommand;
import coloretto.server.ClientConnection;

public class TurnPutCommandFactory extends CommandFactory {
	protected Map<String, Class<?>> allowedCommands = new HashMap<String, Class<?>>();

	public TurnPutCommandFactory() {
		super();
		allowedCommands.put("HELP", HelpCommand.class);
		allowedCommands.put("PUT", PutACardCommand.class);
	}

	public Command createCommand(String command, ClientConnection cc) {
		return create(command, cc, allowedCommands);
	}
}
