package coloretto.states;


import java.util.HashMap;
import java.util.Map;

import coloretto.commands.Command;
import coloretto.commands.CommandFactory;
import coloretto.commands.HelpCommand;
import coloretto.commands.LoginCommand;
import coloretto.commands.LogoutCommand;
import coloretto.server.ClientConnection;

public class AnonymousCommandFactory extends CommandFactory {
	protected Map<String, Class<?>> allowedCommands = new HashMap<String, Class<?>>();

	public AnonymousCommandFactory() {
		super();
		allowedCommands.put("LOGIN", LoginCommand.class);
		allowedCommands.put("HELP", HelpCommand.class);
		allowedCommands.put("EXIT", LogoutCommand.class);
	}

	public Command createCommand(String command, ClientConnection cc) {
		return create(command, cc, allowedCommands);
	}
}
