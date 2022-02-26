package functions;

import java.io.File;

public class DirectoryFunctions {

	private static FileDirectory FileDir = new FileDirectory();
	
	public static void displayFiles() {
		
		//fileDirectory.getFiles();
		
		for (File file : DirectoryFunctions.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
	}
	// getter
	public static FileDirectory getFileDirectory() {
        return FileDir;
    }
	/*
	public static void setFileDirectory(FileDirectory fileDirectory) {
		DirectoryFunctions.fileDirectory = fileDirectory;
    }
    */
}
