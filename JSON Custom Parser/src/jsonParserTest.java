import java.io.File;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.zip.ZipException;
import org.junit.Test;

public class jsonParserTest {

	public jsonParserTest() {}
	
	@Test
	public void jsonParserTestZIP() throws ZipException, IOException {
		
		File testFile = new File("C:\\Users\\toppi\\Desktop\\QuestTemplates.zip");
		JSONParser test = new JSONParser(testFile,"");
		
//		assertTrue(name.equals("C:\\Users\\toppi\\Desktop\\QuestTemplates\\QuestTemplates"));
	}
	
	@Test
	public void batchExtractionTest() throws ZipException, IOException {
		File testFile = new File("C:\\Users\\toppi\\Desktop\\QuestTemplates.zip");
		JSONParser test = new JSONParser(testFile,"");
	}

}
//for (int i = 0; i < newPath.length(); i++) {
//	if (newPath.charAt(i) == '\\' && newPath.charAt(i - 1) != '\\' && newPath.charAt(i + 1) != '\\') {
//		newPath = newPath.substring(0,i) + "\\" + newPath.substring(i);
//	}
//		
//}