package coloretto.server;

public class Message {
	private final String ip;
	private final String msg;
	
	public Message(String ip, String msg) {
		this.ip = ip;
		this.msg = msg;
	}
	
	public String getIp() {
		return ip;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public String toString () {
		return ip + " : " + msg;
	}
	
}

