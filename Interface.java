
package mutagen;

/**
 *
 * @author dusan.mateirc@gmail.com
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Interface extends JFrame implements ActionListener{

JTextField s1 = new JTextField(30);
JTextField s2 = new JTextField(30);
JTextField s3 = new JTextField(30);
JTextField s3a= new JTextField(30);

JButton b1 = new JButton ("START");
JLabel l1 = new JLabel ("Sequence 1:",SwingConstants.LEFT); 
JLabel l2 = new JLabel ("Sequence 2:",SwingConstants.LEFT); 
JLabel l3 = new JLabel ("Synonym sq:",SwingConstants.LEFT);
JLabel l3a= new JLabel ("Mutated sq:",SwingConstants.LEFT);
JLabel l4 = new JLabel ("Attempts:\t",SwingConstants.LEFT);
JLabel l5 = new JLabel ("Needed mut:\t",SwingConstants.LEFT);//treba i broj potrebnih
JLabel l6 = new JLabel ("Progres:\t",SwingConstants.LEFT);
JLabel l7 = new JLabel ("STOP kodon:\t",SwingConstants.LEFT);
JLabel l8 = new JLabel ("Synonym mut:\t",SwingConstants.LEFT);

private String SEQ1,SEQ2;
private boolean bul;

private randmut randObj = new randmut();
private mutiranjeBaza mutObj = new mutiranjeBaza();


public Interface (){
super ("Mutagen");
setBounds (250,225,500,300);//(x,y , w, h)
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel panel = new JPanel ();
//panel.setLayout(new BorderLayout());

b1.addActionListener(this);
s3.setEditable(false);
s3a.setEditable(false);

panel.add(l1);
panel.add(s1);
panel.add(l2);
panel.add(s2);
panel.add(l3);
panel.add(s3);
panel.add(l3a);
panel.add(s3a);

panel.add(b1);

panel.add(l4);
panel.add(l5);
panel.add(l6);
panel.add(l7);
panel.add(l8);

setContentPane(panel);


setVisible(true);

}

public void doMutagen(){
  
	
	SEQ1=s1.getText();
	SEQ2=s2.getText();
	SEQ1=SEQ1.toUpperCase();
	SEQ2=SEQ2.toUpperCase();
	nukleotid n = new nukleotid();
	
	if (SEQ1.length()==0 || SEQ2.length()==0){//SEQ1 == null || SEQ2 == null || 
		JOptionPane.showMessageDialog(null,"Edit or copy the sequences!");
	}
	else if (SEQ1.equals(SEQ2)){
		JOptionPane.showMessageDialog(null,"The sequeces are identical!");
	}
	else if (true){//n.isDNA(SEQ1) &&  n.isDNA(SEQ2)
			if 	(SEQ1.length() == SEQ2.length() && (SEQ1.length()%3)==0 ){
			
				vrednovanje vrObj = new vrednovanje(SEQ1,SEQ2);
				//System.out.println (String.valueOf(vrObj.seq1)+" <");
				
				vrObj.setSeq2(SEQ2.toCharArray());//pozvati na pocetku
				vrObj.ukupnoPromjena();//pozvati na pocetku
				
				do{
					//System.out.print ("* ");
					/*do {
						
						randObj.nextmut(SEQ2.length());
						mutObj.setSeq (SEQ2);
						bul = mutObj.mutSeq(randObj.getPozition(),randObj.getBase());
					}while (! bul);*/
					
					// OVO RADI ZA NEUSPJESNO MUTIRANJE
					randObj.nextmut(SEQ2.length());
					mutObj.setSeq (SEQ2);
					mutObj.mutSeq(randObj.getPozition(),randObj.getBase());
					
					vrObj.vrednuj(mutObj.getSeqString(), randObj.getPozition());
				
					l4.setText ("Attempts:\t" + vrObj.getBrPokusaja());
					l5.setText ("Needed mut:\t" + vrObj.getPotrebnihPromjena());
					l6.setText ("Progres:\t" + ( ((vrObj.getPotrebnihPromjena()-vrObj.ostaloPromjena())*100)/vrObj.getPotrebnihPromjena()) + "%" );
					l7.setText ("STOP kodon:\t" + vrObj.getBrSTOP());
					l8.setText ("Synonym mut:\t" + vrObj.getBrSinonims());
					s3.setText (vrObj.getSeqSinonim());
					s3a.setText (vrObj.getSeqMut());
					SEQ2 = vrObj.getSeqMut();
					//System.out.println (String.valueOf(vrObj.seq1)+" <");
					repaint();
				}while (!SEQ2.equals(SEQ1));
			}
			else if (SEQ1.length() != SEQ2.length()){
				JOptionPane.showMessageDialog(null,"Sequences must be the same in length!");
			}	
			else if (SEQ1.length() % 3 != 0){
				JOptionPane.showMessageDialog(null,"Sequences length must be consist of triplets! (devidable by 3)");
			}
	}
	
	else {
		JOptionPane.showMessageDialog(null,"Something is wring with the sequences");
	}
}

public void actionPerformed(ActionEvent evt){
	/// code for click action here
	//System.out.println("kliknuo :)");
	//b1.setEnabled(false);
	
	doMutagen();
	repaint();//potrebno radi promjena interface
}

public static void main (String args[]){
	Interface tf = new Interface();
}

}
