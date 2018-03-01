package de.allianz.javapraxis.schach.willkommen;

public class Willkommen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(printWillkommen());
	}
	
	public static String printWillkommen (){
		String text ="";
		
		text = "__      __ _  _  _  _                                 \n" + 
				"\\ \\    / /(_)| || || |__ ___  _ __   _ __   ___  _ _ \n" +
				" \\ \\/\\/ / | || || || / // _ \\| '  \\ | '  \\ / -_)| ' \\  \n" +
				"  \\_/\\_/  |_||_||_||_\\_\\\\___/|_|_|_||_|_|_|\\___||_||_|";
		
		return text;
	}

}
