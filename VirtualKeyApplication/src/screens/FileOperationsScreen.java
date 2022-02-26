package screens;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import functions.FileDirectory;
import functions.ScreenFunctions;

public class FileOperationsScreen implements VirtualKeyScreen{

	FileDirectory fileDirectory = new FileDirectory();
	
	private ArrayList<String> operations = new ArrayList<>();

    public FileOperationsScreen() {    	
    	operations.add("1. Add a File");
    	operations.add("2. Delete a File");
    	operations.add("3. Search a File");
    	operations.add("4. Navigate to Main Menu");       
    }
	
	@Override
	public void showMenu() {
		System.out.println("**********File Operations Menu**********");
        for (var s : operations)  {
            System.out.println(s);
        }
	}

	@Override
	public void navigateOption(int option) {
		switch (option) {
		
		case 1: {
			this.addFile();
			this.showMenu();
			break;
		}	
		case 2: {
			this.deleteFile();            
            this.showMenu();	
			break;
		}
		case 3: {
			this.searchFile();
			this.showMenu();
			break;
		}
		case 4: {
			System.out.println("Going back to Main Menu");
			System.out.println("\n");
			ScreenFunctions.setCurrentScreen(ScreenFunctions.WelcomeScreen);
			ScreenFunctions.getCurrentScreen().showMenu();			
			ScreenFunctions.getCurrentScreen().getInputFromUser();
			break;
		}
		default:
			 System.out.println("Please enter correct option");
             break;		
		}		
	}

	@Override
	public void getInputFromUser() {
		int userInput = 0;
		// !=5 exit condition
		// check invalid input getNavigateOption 
		while((userInput = this.getNavigateOption()) != 5){
			// this.navigateMenu(userInput);
			this.navigateOption(userInput);
		}		
	}
	
	private int getNavigateOption() {
		Scanner input = new Scanner(System.in);
		int option = 0;
		
		try {
			System.out.println("\n");
			System.out.println("Enter File Operation");
			option = input.nextInt();
		
		} catch (InputMismatchException ex) {
			System.out.println("Please enter integer value");
		
		} catch (IllegalArgumentException ex) {
			System.out.println("Please enter valid input");
		}		
		return option;		
	}
	
	public void deleteFile () {
		
		System.out.println("Enter Filename with extension to be delete");
		String fileName = this.getFileNameFromUser();
		System.out.println("You are deleting file " + fileName);
		
	    Path filepath = FileSystems.getDefault().getPath(FileDirectory.filepath + fileName).toAbsolutePath();
	    File file = filepath.toFile();
	    
	    if (file.delete()) {
			System.out.println("Deleted File: " + file.getName());
			System.out.println("\n");
			fileDirectory.getFiles().remove(file);		
	    }
	    else {
	        System.out.println("Failed to delete file:" + fileName + ", file was not found.");
	    }		
	}
	
	public void addFile () {
		
		System.out.println("Please Enter the Filename with extension to be add:");
		String fileName = this.getFileNameFromUser();
        System.out.println("You are adding a file named: " + fileName);
        System.out.println("\n");
        
        try {
        	// Path filepath = FileSystems.getDefault().getPath(FileDirectory.filepath + fileName).toAbsolutePath();
        	File file = new File(FileDirectory.getName() + fileName);
    	    if (file.createNewFile()) {
    	    	System.out.println("File created: " + file.getName());
    	    	System.out.println("\n");
    	    	fileDirectory.getFiles().add(file);
    	    }
    	    else
    		    System.out.println("This File Already Exits, no need to add another");	   	    		
        } catch (IOException e) {
			System.out.println(e);
		}		
	}
	
	public void searchFile() {
		
		Boolean found = false;
		System.out.println("Enter Filename with extension to be search");
		String fileName = this.getFileNameFromUser();
		System.out.println("You are searching for a file " + fileName);
		
		ArrayList<File> files = fileDirectory.getFiles();
		
		for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				//System.out.println("Found " + fileName);
				found = true;								
			}								
		}		
		if (found == false) {
			System.out.println("File not found");
		System.out.println("\n");
		}
		else {
			System.out.println("File found");
		}
	}
	
	public String getFileNameFromUser() {
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();
		//return(filename.nextLine());
		
		return filename;
	}
}
