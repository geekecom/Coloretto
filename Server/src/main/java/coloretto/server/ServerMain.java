package coloretto.server;

public class ServerMain {

	/**
	 * @param args
	 */
	public static GameServer server;
	
	public static void main(String[] args) {
		server = new GameServer();
		if (!server.initServer())
			System.out.println("No se ha podido crear el servidor");
	}
}
