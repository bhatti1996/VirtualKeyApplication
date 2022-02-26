package virtualkey;

import screens.WelcomeScreen;

public class VirtualKeyApplication {

	public static void main(String[] args) {
		
		WelcomeScreen welcomescreen = new WelcomeScreen();
		welcomescreen.showWelcomeMessge();
		welcomescreen.getInputFromUser();		
	}

}
