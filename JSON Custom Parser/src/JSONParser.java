import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import javax.swing.JOptionPane;

public class JSONParser {

	private String fileList;
	
	public JSONParser(File file, String identifier) throws ZipException, IOException {
		String fileName = file.getName();
		fileList = "";
		Scanner copy = new Scanner(file);
		Scanner copy2 = new Scanner(file);
		
		if (fileName.endsWith(".json")) {
			parseJson(copy,copy2,identifier);
		}
		else if (fileName.endsWith(".zip")){
			batchExtraction(file,identifier);
		}
		else{
			JOptionPane.showMessageDialog(null, "Unable to Parse File Format. Please ensure this is a *.json, or a .zip filled only with .json", "InfoBox: Failure to Load File", JOptionPane.INFORMATION_MESSAGE);
		}
		copy.close();
		copy2.close();
	}

	//Method:			"folderExtraction(String)"
	//Purpose:		This will allow the user to import not just a single file, but a .zip batch
	// 				and parse through all of them.
	public void batchExtraction(File file, String identifier) throws ZipException, IOException{
		// File Name for later output
		String zipFileName = file.getName().substring(file.getName().lastIndexOf("\\") + 1);
		// badFile will contain all the files not in correct format.
		String badFile = "";
		
		// Progress tracking
		int numParsed = 0;

		// Opening the .zip
		ZipFile zip = new ZipFile(file);
		Enumeration<? extends ZipEntry> entries = zip.entries();
		
		// Enumerating the .Zip and all files
		while (entries.hasMoreElements()){
			// Selecting a file
			ZipEntry entry = (ZipEntry) entries.nextElement();
			// Storing file name
			String entryName = entry.getName().substring(entry.getName().length() - 10);

		}
		zip.close();
		File folder = new File("your/path");
		File[] listOfFiles = folder.listFiles();
		parseAllFromFolder(listOfFiles);
	}
	
	private void parseAllFromFolder(File[] lostOfFiles){
		
	}
	
	private void parseJson(Scanner copy, Scanner copy2, String identifier){
		
	}
	
	
	// Zip Folder Extraction Method credit given to @NeilMonday
	// http://stackoverflow.com/users/308843/neilmonday
	// Slight modifications made.
	static public String extractFolder(String zipFile) throws ZipException, IOException 
	{
	    System.out.println(zipFile);
	    int BUFFER = 2048;
	    File file = new File(zipFile);

	    ZipFile zip = new ZipFile(file);
	    String newPath = zipFile.substring(0, zipFile.length() - 4);

	    new File(newPath).mkdir();
	    Enumeration zipFileEntries = zip.entries();

	    // Process each entry
	    while (zipFileEntries.hasMoreElements())
	    {
	        // grab a zip file entry
	        ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
	        String currentEntry = entry.getName();
	        File destFile = new File(newPath, currentEntry);
	        //destFile = new File(newPath, destFile.getName());
	        File destinationParent = destFile.getParentFile();

	        // create the parent directory structure if needed
	        destinationParent.mkdirs();

	        if (!entry.isDirectory())
	        {
	            BufferedInputStream is = new BufferedInputStream(zip
	            .getInputStream(entry));
	            int currentByte;
	            // establish buffer for writing file
	            byte data[] = new byte[BUFFER];

	            // write the current file to disk
	            FileOutputStream fos = new FileOutputStream(destFile);
	            BufferedOutputStream dest = new BufferedOutputStream(fos,
	            BUFFER);

	            // read and write until last byte is encountered
	            while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
	                dest.write(data, 0, currentByte);
	            }
	            dest.flush();
	            dest.close();
	            is.close();
	        }

	        if (currentEntry.endsWith(".zip"))
	        {
	            // found a zip file, try to open
	            extractFolder(destFile.getAbsolutePath());
	        }
	    }
	    return newPath;
	}
	
	
	

}
