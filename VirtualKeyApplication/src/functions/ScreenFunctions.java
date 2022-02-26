package functions;

import screens.FileOperationsScreen;
import screens.VirtualKeyScreen;
import screens.WelcomeScreen;

public class ScreenFunctions {

	// object of welcome screen class
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();
	// object of file operations screen class
	public static FileOperationsScreen FileOperationsScreen = new FileOperationsScreen();
	// assigning welcome screen to current screen
	public static VirtualKeyScreen CurrentScreen = WelcomeScreen;	
	
	// getter
	public static VirtualKeyScreen getCurrentScreen() {
		return CurrentScreen;		
	}
	// setter
	public static void setCurrentScreen(VirtualKeyScreen currentScreen) {
		CurrentScreen = currentScreen;
	}
		
}
