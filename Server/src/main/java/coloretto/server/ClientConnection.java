package coloretto.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import coloretto.commands.Command;
import coloretto.commands.CommandFactory;
import coloretto.player.Game;
import coloretto.player.Player;

public class ClientConnection implements Runnable {
	Socket clientSocket;
	String ipAddress;
	DataInputStream input;
	DataOutputStream output;
	GameServer server;
	Player player;
	List<Player> players;

	public ClientConnection(Socket clientSocket, GameServer server) {
		this.clientSocket = clientSocket;
		this.server = server;
		this.ipAddress = clientSocket.getInetAddress().getHostAddress();
		this.player = new Player();
		players = new ArrayList<Player>();
	}

	
	public ClientConnection(String playerID) {
		this.player = new Player();
	}

	public void loginPlayer(String playerID) {
		this.player.setPlayerID(playerID);
		players.add(this.player);
		//server.getPlayers().add(this.player);
	}

	public List<Player> getPlayers() {
		return players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player getPlayer() {
		return player;
	}

	public void run() {
		try {
			input = new DataInputStream(clientSocket.getInputStream());
			output = new DataOutputStream(clientSocket.getOutputStream());
			System.out.println("Nueva conexión desde " + ipAddress);
			inputProcessing();
		} catch (Exception exception) {
		}
		
		server.leave(player);
	//	server.getPlayers().remove(player);
		server.disconnectClient(this);
	}

	private void inputProcessing() throws IOException {
		while (clientSocket.isConnected()) {
			String message = input.readUTF();
			Command dbCommand = ((CommandFactory) player.getCurrentState()
					.getFactory()).createCommand(message, this);
			String info = dbCommand.execute();
			Message msg = new Message(ipAddress, info);
			sendMessage(msg);
		}
	}

	public void sendMessage(Message message) {
		if (clientSocket.isConnected()) {
			try {
				output.writeUTF(message.toString());
			} catch (IOException e) {
			}
		}
	}

	public boolean close() {
		boolean res = true;
		try {
			clientSocket.close();
		} catch (IOException e) {
			res = false;
		}
		return res;
	}

	public String getIp() {
		return ipAddress;
	}

	public List<Game> getGames() {
		return server.getGames();
	}

	public GameServer getServer() {
		return server;
	}

	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		if (clientSocket.isConnected()) {
			try {
				output.writeUTF(message);
			} catch (IOException e) {
			}
		}
	}


	public void setServer(GameServer server2) {
		this.server = server2;
	}

}