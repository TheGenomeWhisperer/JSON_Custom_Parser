import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;
import org.junit.Test;

public class jsonParserTest {

	public jsonParserTest() {}
	
	@Test
	public void jsonParserTestZIP() throws ZipException, IOException {
		
		File testFile = new File("C:\\Users\\toppi\\Desktop\\QuestTemplates.zip");
		JSONParser test = new JSONParser(testFile,"");
		String name = test.extractFolder(testFile.toString());
		name += "\\" + name.substring(name.lastIndexOf("\\") +1);
		
		System.out.println(name);
	}

}
