import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TempTest {

	public TempTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ZipFile zip = new ZipFile("C:\\Users\\toppi\\Desktop\\QuestTemplates.zip");
		Enumeration<? extends ZipEntry> entries = zip.entries();

//		 Enumerating the .Zip and all files
		int count = 0;
		while (entries.hasMoreElements()){
			// Selecting a file
			ZipEntry entry = (ZipEntry) entries.nextElement();
			if (entry.getName().endsWith(".json")) {
				System.out.println(entry.
			}
		}
		System.out.println(count);
		zip.close();
	}
}
