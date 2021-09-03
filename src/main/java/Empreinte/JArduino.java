package Empreinte;


public class JArduino extends ArduinoSerialComm implements JArduinoControle {

	private static final long COMM_TIME_WAIT = 1000;

	public static final int INPUT = 0;
	public static final int OUTPUT = 1;

	public static final int LOW = 0;
	public static final int HIGH = 1;

	public JArduino(String portDescription) {
		super(portDescription);
		if (openConnection()) {
			System.out.println("Connection to port success ");
		} else {
			System.out.println("Can not connect to port ");
		}
	}

	public void pinMode(int pin, int mode) {
		String commande = String.format("1%02d%03d", pin, mode);
		System.out.println(commande);
		sendCommande(commande);
	}

	public void digitalWrite(int pin, int value) {
		String commande = String.format("2%02d%03d", pin, value);
		System.out.println(commande);
		sendCommande(commande);
	}

	public int digitalRead(int pin) {
		String commande = String.format("3%02d%03d", pin, 0);
		System.out.println(commande);
		return readValue(commande);
	}

	public void analogWrite(int pin, int value) {
		String commande = String.format("4%02d%03d", pin, value);
		System.out.println(commande);
		sendCommande(commande);
	}

	public int analogRead(int pin) {
		String commande = String.format("5%02d%03d", pin, 0);
		System.out.println(commande);
		return readValue(commande);
	}

	private void sendCommande(String commande) {
		String res = "";
		while (!res.contains("ok")) {
			serialWrite(commande);
			try {
				Thread.sleep(COMM_TIME_WAIT);
			} catch (Exception Exception) {
			}
			res = serialRead();
		}
	}

	private int readValue(String commande) {
		serialWrite(commande);
		String value = "";
		while (value.equals("")) {
			serialWrite(commande);
			try {
				Thread.sleep(COMM_TIME_WAIT);
			} catch (Exception Exception) {
			}
			value = serialRead();
		}
		value = value.replace("\n", "");
		System.out.println("value : " + value);
		return Integer.parseInt(value);
	}


	public void envoyerIdEmpreinte(int id) {
		// TODO Auto-generated method stub
		String commande = String.format("6%03d%03d", id, 0);
		System.out.println(commande);
		sendCommande(commande);
		
	}

	@Override
	public int recupererIdEmpreinte() {
		// TODO Auto-generated method stub
		String commande = String.format("7%03d%03d", 0, 0);
		System.out.println(commande);
		return readValue(commande);
	}

	@Override
	public void simpleMeth() {
		// TODO Auto-generated method stub
		String commande = String.format("8%03d%03d", 0, 0);
		System.out.println(commande);
		sendCommande(commande);
		
	}

	@Override
	public void swipServoMoteurtoclose() {
		// TODO Auto-generated method stub
		
	}

}
