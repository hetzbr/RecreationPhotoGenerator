package ben.rec.uwec.edu;





import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Image_HTML {

	public static void main(String[] args) {
		
		String photoInputValue = JOptionPane.showInputDialog(null, "Enter the amount of photos to generate");
		
		
		int number = (Integer.parseInt(photoInputValue));
		
		String[] HTML = new String[number];
		String photoNames = "";
		int reply = JOptionPane.showConfirmDialog(null, "Are the picture names numbered sequentially? For example: photo1, photo2, etc", "Picture", JOptionPane.YES_NO_OPTION);
	    if (reply == JOptionPane.NO_OPTION){
	    	
	    	for(int i = 0; i < number; i++) {
				photoNames = JOptionPane.showInputDialog(null, "Enter Photo Name " + (i+1));
				
					HTML[i] = photoNames;
				}
		
		
		
		
    }	else if (reply == JOptionPane.YES_OPTION){
    	String FirstName = JOptionPane.showInputDialog(null, "Enter the name of the first photo without numbers");
    	String numbers = JOptionPane.showInputDialog(null, "Enter the starting number");
    	int numberphoto = (Integer.parseInt(numbers));
    	
    	for(int i= 0; i < number; i++) {
    		numberphoto += 1;
    		photoNames = FirstName + numberphoto;
    		HTML[i] = photoNames;
    	}
    }
	
		for(int i = 0; i < HTML.length; i++){
			System.out.println(HTML[i]);
		}
	
		
		String addressInput = JOptionPane.showInputDialog(null, "Enter the address after Recreation and before images. For example: /events/wirsa");
		int photoType = JOptionPane.showConfirmDialog(null, "Are the picture png? (if no, the output will be jpg)", "Picture", JOptionPane.YES_NO_OPTION);
		String photoTypes = "";
		if (reply == JOptionPane.NO_OPTION){
			photoTypes = ".jpg";
		} else if (reply == JOptionPane.YES_OPTION){
			photoTypes = ".png";
		}
		
		
		String paragraph = "<p>";
		String endpar = "</p>";
		PrintWriter writer;
		
		
		
		
		
			
				try {
					writer = new PrintWriter("Photos.txt", "UTF-8");
					for (int i = 0; i < number; i++) {						
					String Output ="<a id=\"CP___PAGEID=+pageID+\"\"class=\"imageOverlay\" onmouseover=\"return self.status='/Recreation" + addressInput + "/images/" + HTML[i]+photoTypes+"'\" href=\"/Recreation" + addressInput + "/images/" + HTML[i] +photoTypes+ "\"><img id=\"CP___PAGEID=1245534||CPIMAGE:1705612|\" title=\"" + HTML[i] + "\" border=\"0\" hspace=\"5\" alt=\""+HTML[i]+"\" vspace=\"10\" src=\"/Recreation"+addressInput+"/images/"+HTML[i]+photoTypes+"\" width=\"150\" height=\"100\" /></a>";
					
					if(i == 0) {
					writer.println(paragraph+Output);
				} else if(i != 0 && i < number-1) {
					writer.println(Output);
				} else {
					writer.println(Output+endpar);
				}
				
					
					
					}
					writer.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
		
				}
				
	}
	
	

}
