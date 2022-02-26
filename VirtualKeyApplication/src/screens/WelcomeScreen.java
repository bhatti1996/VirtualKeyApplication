package screens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import functions.DirectoryFunctions;
import functions.ScreenFunctions;

public class WelcomeScreen implements VirtualKeyScreen{

	private String welcomeText = "Welcome to VirtualKey Application";
    private String developerText = "Developed by Arpan Hade";

    private ArrayList<String> options = new ArrayList<>();
	
    // constructor
	public WelcomeScreen() {
		options.add("1. Display available files");
        options.add("2. Go to file operations menu");
        options.add("3. Exit");
	}

	public void showWelcomeMessge() {
		System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        showMenu();
	}
	
	@Override
	public void showMenu() {
		System.out.println("**********Main Menu**********");
        for (var s : options)  {
            System.out.println(s);
        }		
	}

	@Override
	public void navigateOption(int option) {
		switch (option) {
		
		case 1: {
			System.out.println("Files available in system");
			this.showFiles();
			break;
		}	
		case 2: {			
			ScreenFunctions.setCurrentScreen(ScreenFunctions.FileOperationsScreen);
			ScreenFunctions.getCurrentScreen().showMenu();			
			ScreenFunctions.getCurrentScreen().getInputFromUser();
			this.showMenu();
			break;
		}		
		default:
			 System.out.println("Please enter value less than 3");
             break;		
		}		
	}

	@Override
	public void getInputFromUser() {
		
		int userInput = 0;
		// !=3 exit condition
		// check invalid input at getNavigateOption 
		while((userInput = this.getNavigateOption()) != 3){
			// this.navigateMenu(userInput);
			this.navigateOption(userInput);
		}	
	}
	
	private int getNavigateOption() {
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		try {
			System.out.println("\n");
			System.out.println("Please enter your choice");
			option = input.nextInt();
		
		} catch (InputMismatchException ex) {
			System.out.println("Please enter integer value");
		
		} catch (IllegalArgumentException ex) {
			System.out.println("Please enter valid input");
		}		
		return option;		
	}
	
	public void showFiles() {
        
		System.out.println("List of Files: ");
        DirectoryFunctions.displayFiles();
	}    
	
}
