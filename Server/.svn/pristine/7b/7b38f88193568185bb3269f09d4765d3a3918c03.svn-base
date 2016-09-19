package commands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coloretto.commands.HelpCommand;
import coloretto.player.Logued;
import coloretto.player.Player;
import coloretto.player.Turn;
import coloretto.player.TurnPut;
import coloretto.player.WaitTurn;
import coloretto.player.WaitingGame;
import coloretto.server.ClientConnection;

public class TestHelp {
	
	private HelpCommand help;
	private String command;
	private ClientConnection cc;
	private Logued logued;
	private Turn turn;
	private TurnPut turnPut;
	private WaitingGame waitingGame;
	private WaitTurn waitTurn;
	private List<Player> players;
	private Player player1, player2, player3, player4;
	
	@Before
	public void setUp(){
		player1 = new PlayerMock("Andrés");
		player2 = new PlayerMock("Fernando");
		player3 = new PlayerMock("Eusebio");
		player4 = new PlayerMock("Dionisio");
		
		players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		
		cc = new ClientConnection("Andrés");
		cc.setPlayers(players);
	}
	
	@Test
	public void testAnonymous() {
		command = "HELP";
		help = new HelpCommand(command, cc);
		assertEquals("\nComandos disponibles:" +
				    "\n\n> login [nombre]	... Registrarse en el servidor con tu nombre\n" +
				    "> exit			... Desconectarse del servidor\n", help.execute());
	}
	
	@Test
	public void testLogued() {
		command = "HELP";
		logued = new Logued();
		cc.getPlayer().setCurrentState(logued);
		help = new HelpCommand(command, cc);
		assertEquals("\nComandos disponibles:" +
					"\n\n> show			... Mostrar mesas existentes\n" +
					"> create		... Crear una nueva mesa\n" +
					"> join [idMesa]		... Unirse a una mesa ya existente\n" +
					"> exit			... Desconectarse del servidor\n", help.execute());
	}
	
	@Test
	public void testTurn() {
		command = "HELP";
		turn = new Turn();
		cc.getPlayer().setCurrentState(turn);
		help = new HelpCommand(command, cc);
		assertEquals("\nComandos disponibles:" +
					"\n\n> draw			... Robar carta\n" +
					"> take [idFila]		... Tomar una fila\n" +
					"> leave			... Salir de la mesa\n", help.execute());
	}

	@Test
	public void testTurnPut() {
		command = "HELP";
		turnPut = new TurnPut();
		cc.getPlayer().setCurrentState(turnPut);
		help = new HelpCommand(command, cc);
		assertEquals("\nComandos disponibles:" +
				    "\n\n> put [idFila]		... Colocar carta en una fila\n", help.execute());
	}
	
	@Test
	public void testWaitingGame() {
		command = "HELP";
		waitingGame = new WaitingGame();
		cc.getPlayer().setCurrentState(waitingGame);
		help = new HelpCommand(command, cc);
		assertEquals("\nComandos disponibles:" +
					"\n\n> show			... Mostrar mesas existentes\n" +
					"> start			... Solicitar inicio de partida\n" +
					"> leave			... Salir de la mesa\n", help.execute());
	}
	
	@Test
	public void testWaitTurn() {
		command = "HELP";
		waitTurn = new WaitTurn();
		cc.getPlayer().setCurrentState(waitTurn);
		help = new HelpCommand(command, cc);
		assertEquals("\nComandos disponibles:" +
					"\n\n> leave			... Salir de la partida\n", help.execute());
	}
}