package Empreinte;


import java.io.PrintWriter;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class ArduinoSerialComm {
	private static SerialPort comPort;
	private String portDescription;
	private int baud_rate;

	public ArduinoSerialComm(String portDescription, int baud_rate) {
		this.portDescription = portDescription;
		comPort = SerialPort.getCommPort(this.portDescription);
		this.baud_rate = baud_rate;
		comPort.setBaudRate(this.baud_rate);
	}

	public ArduinoSerialComm(String portDescription) {
		this.portDescription = portDescription;
		comPort = SerialPort.getCommPort(this.portDescription);
		this.baud_rate = 9600;
		comPort.setBaudRate(this.baud_rate);
	}

	public boolean openConnection() {
		return comPort.openPort();
	}

	public void closeConnection() {
		comPort.closePort();
	}

	public void setPortDescription(String portDescription) {
		this.portDescription = portDescription;
		comPort = SerialPort.getCommPort(this.portDescription);
	}

	public void setBaudRate(int baud_rate) {
		this.baud_rate = baud_rate;
		comPort.setBaudRate(this.baud_rate);
	}

	public String getPortDescription() {
		return portDescription;
	}

	public SerialPort getSerialPort() {
		return comPort;
	}

	public String serialRead() {
		comPort.setComPortTimeouts(1, 0, 0);
		String out = "";
		Scanner in = new Scanner(comPort.getInputStream());
		try {
			while (in.hasNext())
				out = out + in.next() + "\n";
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	public String serialRead(int limit) {
		comPort.setComPortTimeouts(1, 0, 0);
		String out = "";
		int count = 0;
		Scanner in = new Scanner(comPort.getInputStream());
		try {
			while ((in.hasNext()) && (count <= limit)) {
				out = out + in.next() + "\n";
				count++;
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	public void serialWrite(String s) {
		comPort.setComPortTimeouts(65536, 0, 0);
		try {
			Thread.sleep(5L);
		} catch (Exception localException) {
		}
		PrintWriter pout = new PrintWriter(comPort.getOutputStream());
		pout.print(s);
		pout.flush();
	}

	public void serialWrite(String s, int noOfChars, int delay) {
		comPort.setComPortTimeouts(65536, 0, 0);
		try {
			Thread.sleep(5L);
		} catch (Exception localException) {
		}
		PrintWriter pout = new PrintWriter(comPort.getOutputStream());
		for (int i = 0; i < s.length(); i += noOfChars) {
			pout.write(s.substring(i, i + noOfChars));
			pout.flush();
			System.out.println(s.substring(i, i + noOfChars));
			try {
				Thread.sleep(delay);
			} catch (Exception localException1) {
			}
		}
		pout.write(noOfChars);
		pout.flush();
	}

	public void serialWrite(char c) {
		comPort.setComPortTimeouts(65536, 0, 0);
		try {
			Thread.sleep(5L);
		} catch (Exception localException) {
		}
		PrintWriter pout = new PrintWriter(comPort.getOutputStream());
		pout.write(c);
		pout.flush();
	}

	public void serialWrite(char c, int delay) {
		comPort.setComPortTimeouts(65536, 0, 0);
		try {
			Thread.sleep(5L);
		} catch (Exception localException) {
		}
		PrintWriter pout = new PrintWriter(comPort.getOutputStream());
		pout.write(c);
		pout.flush();
		try {
			Thread.sleep(delay);
		} catch (Exception localException1) {
		}
	}
}
