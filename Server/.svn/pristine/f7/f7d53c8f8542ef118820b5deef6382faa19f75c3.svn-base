package coloretto.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.StringTokenizer;

import coloretto.server.ClientConnection;

public abstract class CommandFactory {

	public abstract Command createCommand(String command, ClientConnection cc);
	
	public Command create(String command, ClientConnection cc, Map<String, Class<?>> m){
		
		Command res = new ErrorCommand("Error en el procesamiento", cc);
		StringTokenizer tokenizer = new StringTokenizer(command, " ");
		if (tokenizer.hasMoreTokens()) {
			String keyword = tokenizer.nextToken().toUpperCase();
			if (m.containsKey(keyword)) {
					try {
						res = (Command) (m.get(keyword)
								.getConstructor(String.class,
										ClientConnection.class).newInstance(
								command, cc));
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}
					 
			} else {
				res = new ErrorCommand("Comando no permitido", cc);
			}
		}
		return res;
		
	}
}
