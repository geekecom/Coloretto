package coloretto.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import coloretto.player.Game;
import coloretto.player.Lobby;
import coloretto.player.Player;
import coloretto.player.State;
import coloretto.player.Turn;
import coloretto.player.TurnPut;
import coloretto.player.WaitTurn;
import coloretto.player.WaitingGame;

public class GameServer {
	private ServerSocket ss;
	private Set<ClientConnection> connections;
	private static final int port = 6000;
	private List<Game> games;
	private List<Player> players;
	private List<Lobby> lobbys;
	
	public GameServer() {
		connections = new HashSet<ClientConnection>();
		players = new ArrayList<Player>();
		games = new ArrayList<Game>();
		lobbys = new ArrayList<Lobby>();
	}

	public boolean initServer() {
		boolean res = true;
		try {
			ss = new ServerSocket(port);
			System.out.println("Servidor abierto en puerto " + port);
			while (true) {
				Socket clientSocket = ss.accept();
				createClientConnection(clientSocket);
			}
		} catch (IOException e) {
			res = false;
		}
		return res;
	}

	private void createClientConnection(Socket clientSocket) {
		ClientConnection cc = new ClientConnection(clientSocket, this); //Quitado anonymous
		connections.add(cc);
		new Thread(cc).start();
		/*Message message = new Message("Server", cc.getIp() + " conectado");
		sendChatMessage(cc, message);*/
	}

	public void sendChatMessage(ClientConnection source, Message message) {
		for (ClientConnection dest : connections) {
			if (dest != source)
				dest.sendMessage(message);
		}
	}

	public void disconnectClient(ClientConnection clientConnection) {
		connections.remove(clientConnection);
		System.out.println("Cliente " + clientConnection.getIp()
				+ " desconectado");
	/*	Message message = new Message("Server", clientConnection.getIp()
				+ " desconectado");
		sendChatMessage(null, message);
		*/
	}

	public void closeServer() {
		for (ClientConnection clients : connections) {
			clients.close();
		}
		connections.clear();
	}

	public List<Game> getGames() {
		return games;
	}

	public List<Player> getPlayers() {
		return players;
	}

	// @Override
	public Lobby createLobby() {
		Lobby currentLobby = new Lobby();
		lobbys.add(currentLobby);
		return currentLobby;
	}

	public List<Lobby> getLobbys() {
		return lobbys;
	}

	public void setLobbys(List<Lobby> lobbys) {
		this.lobbys = lobbys;
	}

	// @Override
	public void leave(Player player) {
		
		State<?> currentState = player.getCurrentState();
		
		if(currentState instanceof WaitingGame || player.isStart()){
			
			Lobby currentLobby = player.getCurrentLobby();
			
			if(currentLobby.getPlayers().size() == 1 ){
				ServerMain.server.getLobbys().remove(currentLobby);
			}else{
				
				ServerMain.server.sendMessageToLobbyPlayers(currentLobby, 
						 player.getPlayerID() + 
						" se ha desconectado");
				currentLobby.getPlayers().remove(player);
			}
		}
		if((currentState instanceof WaitTurn && !player.isStart()) || currentState instanceof TurnPut
					|| currentState instanceof Turn){
			
			Game currentGame = player.getCurrentGame();
			
			ServerMain.server.sendMessageToGamePlayers(currentGame, 
					"Partida Finalizada, " + player.getPlayerID() + 
					" se ha desconectado");
			currentGame.resetPlayers();
			ServerMain.server.getGames().remove(currentGame);
			
		}	
		
		ServerMain.server.getPlayers().remove(player);
	}

	// @Override
	public void joinGame(Integer idGame, String idPlayer) {
		for (Game g : games) {
			if (g.getGameID().equals(idGame)) {
				for (Player p : players) {
					if (p.getPlayerID().equals(idPlayer)) {
						g.addPlayer(p);
						break;
					}
				}
				break;
			}
		}
	}
	
	public void sendMessageToGamePlayers(Game game,String message){
		try{
			for(ClientConnection cc: connections){
				if(cc.getPlayer().getCurrentGame().getGameID().equals(game.getGameID())){
					cc.sendMessage(message);
					
				}
			}
		}catch(Exception e){
			
		}
	}

	public void sendMessageToLobbyPlayers(Lobby currentLobby, String info) {
		// TODO Auto-generated method stub
		
		try{
			for(ClientConnection cc: connections){
				if(cc.getPlayer().getCurrentLobby().getLobbyID().equals(currentLobby.getLobbyID())){
					cc.sendMessage(info);
				}
			}
		}catch (Exception e){
		}
		
		
	}

}