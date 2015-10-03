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

	public String fileList;
	
	public JSONParser(File file, String identifier) throws ZipException, IOException {
		fileList = "";
		String fileName = file.getName();
		
		if (fileName.endsWith(".json")) {
			Scanner copy = new Scanner(file);
			Scanner copy2 = new Scanner(file);
			parseJson(copy,copy2,identifier,file.toString().substring(file.toString().length() - 10));
			copy.close();
			copy2.close();
		}
		else if (fileName.endsWith(".zip")){
			batchExtraction(file,identifier);
		}
		else{
			JOptionPane.showMessageDialog(null, "Unable to Parse File Format. Please ensure this is a *.json, or a .zip filled only with .json", "InfoBox: Failure to Load File", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	//Method:			"batchExtraction(String)"
	//Purpose:		This will allow the user to import not just a single file, but a .zip batch
	// 				and parse through all of them.
	private void batchExtraction(File file, String identifier) throws ZipException, IOException{
		// Extracts all files and places them in a folder
		String folderLocation = extractFolder(file.getPath());
				
		File folder = new File(folderLocation);
		File[] listOfFiles = folder.listFiles();
		parseAllFromFolder(listOfFiles,identifier);
	}
	
	private void parseAllFromFolder(File[] listOfFiles, String identifier) throws FileNotFoundException{
		// Parsing through each file name, then converting filename into usable string for each folder in file
		for (int i = 0; i < listOfFiles.length; i ++) {
			//Setting up next method inputs
		    File file = new File(listOfFiles[i].toString());
			Scanner copy = new Scanner(file);
			Scanner copy2 = new Scanner(file);
			parseJson(copy,copy2,identifier, listOfFiles[i].toString().substring(listOfFiles[i].toString().length() - 10));
			copy.close();
			copy2.close();
		}
	}
	
	private void parseJson(Scanner copy, Scanner copy2, String identifier, String fileName){
		String temp = "";
		
		int count = 1;
		while (copy.hasNextLine()){
			temp = copy.nextLine();
			if (temp.indexOf(identifier) != -1) {
				fileList += ("Quest Template: " + fileName + "\nLine#: " + count + "\n" + temp + "\n\n");
			}
			count++;
		}
	}
	
	
	// Zip Folder Extraction Method credit given to @NeilMonday
	// http://stackoverflow.com/users/308843/neilmonday
	// Slight modifications made.
	private static String extractFolder(String zipFile) throws ZipException, IOException 
	{
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
	    // My personal Lines added here...
	    zip.close();
	    newPath += "\\" + newPath.substring(newPath.lastIndexOf("\\") +1).trim();
	    return newPath;
	}
	
	public void toFile() throws IOException {
		PrintWriter output = new PrintWriter(new FileWriter("All_Lua_Finds.txt"));
		output.println(fileList);
		output.close();
	}
	
	
	

}
