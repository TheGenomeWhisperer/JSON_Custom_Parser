import java.io.File;
import java.io.FileNotFoundException;
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
	
	public JSONParser(File file) throws ZipException, IOException {
		String fileName = file.getName();
		fileList = "";
		if (fileName.endsWith(".json")) {
			// default Json
		}
		else if (fileName.endsWith(".zip")){
			folderExtraction(file);
		}
		else{
			JOptionPane.showMessageDialog(null, "Unable to Parse File Format. Please ensure this is a *.json, or a .zip filled only with .json", "InfoBox: Failure to Load File", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	//Method:			"folderExtraction(String)"
	//Purpose:		This will allow the user to import not just a single file, but a .zip batch
	// 				and parse through all of them.
	public static void folderExtraction(File file) throws ZipException, IOException{
		// File Name for later output
		File outputFile = new File(file.getName());
		// Opening and enumerating the .zip
		ZipFile zip = new ZipFile(file);
		Enumeration entries = zip.entries();
		
		while (entries.hasMoreElements()){
			// Selecting a file
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String entryName = entry.getName();
			String badFile = "";
			if (entryName.endsWith(".json")){
				
			}
			else{
				badFile += "FileName: " + entryName + "\n";
			}
		}
	}
	
}
