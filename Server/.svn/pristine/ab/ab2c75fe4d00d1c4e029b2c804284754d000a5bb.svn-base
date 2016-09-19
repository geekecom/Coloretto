package coloretto.states;


import java.util.HashMap;
import java.util.Map;

import coloretto.commands.Command;
import coloretto.commands.CommandFactory;
import coloretto.commands.CreateGameCommand;
import coloretto.commands.HelpCommand;
import coloretto.commands.JoinGameCommand;
import coloretto.commands.LogoutCommand;
import coloretto.commands.ShowGamesCommand;
import coloretto.server.ClientConnection;

public class LoguedCommandFactory extends CommandFactory {
	protected Map<String, Class<?>> allowedCommands = new HashMap<String, Class<?>>();

	public LoguedCommandFactory() {
		allowedCommands.put("HELP", HelpCommand.class);
		allowedCommands.put("EXIT", LogoutCommand.class);
		allowedCommands.put("CREATE", CreateGameCommand.class);
		allowedCommands.put("SHOW", ShowGamesCommand.class);
		allowedCommands.put("JOIN", JoinGameCommand.class);
	}

	public Command createCommand(String command, ClientConnection cc) {
			return create(command, cc, allowedCommands);
		
	}

}
