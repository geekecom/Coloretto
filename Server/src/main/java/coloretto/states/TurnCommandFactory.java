package coloretto.states;


import java.util.HashMap;
import java.util.Map;


import coloretto.commands.Command;
import coloretto.commands.CommandFactory;
import coloretto.commands.DrawACardCommand;

import coloretto.commands.HelpCommand;
import coloretto.commands.LeaveGameCommand;
import coloretto.commands.TakeARowCommand;
import coloretto.server.ClientConnection;

public class TurnCommandFactory extends CommandFactory {
	protected Map<String, Class<?>> allowedCommands = new HashMap<String, Class<?>>();

	public TurnCommandFactory() {
		super();
		allowedCommands.put("LEAVE", LeaveGameCommand.class);
		allowedCommands.put("HELP", HelpCommand.class);
		allowedCommands.put("DRAW", DrawACardCommand.class);
		allowedCommands.put("TAKE", TakeARowCommand.class);
	}

	@Override
	public Command createCommand(String command, ClientConnection cc) {
		return create(command, cc, allowedCommands);
	}

}
