package Empreinte;


public interface JArduinoControle {

	public void pinMode(int pin, int mode);

	public void digitalWrite(int pin, int value);

	public int digitalRead(int pin);

	public void analogWrite(int pin, int value) ;

	public int analogRead(int pin) ;
	public void envoyerIdEmpreinte(int id);
	public int recupererIdEmpreinte();
	public void simpleMeth();
	public void swipServoMoteurtoclose();

}
