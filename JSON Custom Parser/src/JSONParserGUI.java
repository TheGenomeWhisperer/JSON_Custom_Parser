import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JSONParserGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Creating GUI
		final JFrame frame = new JFrame("json Custom Parser");
			
		final JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(false);
		fc.setCurrentDirectory(new File("c:\\"));
		
		// First Button of the Window
		JButton btn1 = new JButton("Please Choose a File to Parse");
		btn1.addActionListener(new ActionListener() {
			
        		public void actionPerformed(ActionEvent e) {
        			fc.showDialog(frame, "Choose File to Parse");
        		}
		});
		
    	// Second Button of the Window
    	JButton btn2 = new JButton("Parse the File");
        	btn2.addActionListener(new ActionListener() {
 
        	public void actionPerformed(ActionEvent e) {
            		File selectedFile = fc.getSelectedFile();
            		JSONParser jp;
			try {
				jp = new JSONParser(selectedFile, "Lua");
			jp.toFile();
		} catch (IOException e2) {
			System.out.println("Unable to Find File");
		}
		JOptionPane.showMessageDialog(frame, "File Successfully Parsed!");
    	}
    });
	// Running the GUI
    Container pane = frame.getContentPane();
    pane.setLayout(new GridLayout(2, 1, 15, 15));
    pane.add(btn1);
    pane.add(btn2);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null); // Middle of the screen
    frame.setVisible(true);	
			
			
	}
}
