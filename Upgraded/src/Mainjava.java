import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Mainjava {

	public static void main(String[] args) throws IOException {
		
		 JFrame f=new JFrame("Easy use"); 
		    JLabel g=new JLabel("Select .xml file");
		    g.setBounds(50,50, 95, 30);
		    final JTextField tf=new JTextField();  
		    tf.setBounds(145,55, 150,20);  
		   JButton b=new JButton("Browse");  
		    b.setBounds(300,50,95,30); 
		  
		    JLabel g1=new JLabel("Enter sscc value");
		    g1.setBounds(50,100, 95, 30);
		    final JTextField of1=new JTextField("old no");  
		    of1.setBounds(50,150, 150,20); 
		    final JTextField tf1=new JTextField("new no");
		    tf1.setBounds(230,150,150,20);
		    JButton b1=new JButton("Update");
		    b1.setBounds(400,145,95,30);
		    
		    JLabel g2=new JLabel("Enter case value");
		    g2.setBounds(50,200,95,30);
		    final JTextField of2=new JTextField("old no");  
		    of2.setBounds(50,250, 150,20); 
		    final JTextField tf2=new JTextField("new no");  
		    tf2.setBounds(230,250, 150,20); 
		    JButton b2=new JButton("Update");
		    b2.setBounds(400,245,95,30);
		    
		    JLabel g3=new JLabel("Enter each value");
		    g3.setBounds(50,300,95,30);
		    final JTextField of3=new JTextField("old eaches no");  
		    of3.setBounds(50,350, 150,20);
		    final JTextField tf3=new JTextField("new eaches no");  
		    tf3.setBounds(230,350, 150,20); 
		    JButton b3=new JButton("Update");
		    b3.setBounds(400,345,95,30);
		    
		    JLabel g4=new JLabel("Enter lot value");
		    g4.setBounds(50,400,95,30);
		    final JTextField of4=new JTextField("new lotno");  
		    of4.setBounds(50,450, 150,20);
		    JButton b4=new JButton("Update");
		    b4.setBounds(230,445,95,30);
		    
		    JLabel g5=new JLabel("Enter asn value");
		    g5.setBounds(50,500,95,30);
		    final JTextField of5=new JTextField("new asn no");  
		    of5.setBounds(50,550, 150,20);
		    JButton b5=new JButton("Update");
		    b5.setBounds(230,545,95,30);
		    
		    JButton button=new JButton("Search");
		    button.setBounds(50,600, 95, 30);
		    
		    
		   
		   
		      
		    f.add(g);
		    f.add(tf); 
		    f.add(b);
		    
		    f.add(g1);
		    f.add(tf1);
		    f.add(of1);
		    f.add(b1);
		    
		    f.add(g2);
		    f.add(of2);
		    f.add(tf2);
		    f.add(b2);
		   
		    f.add(g3);
		    f.add(of3);
		    f.add(tf3);
		    f.add(b3);
		    
		    f.add(g4);
		    f.add(of4);
		    f.add(b4);
		    
		    f.add(g5);
		    f.add(of5);
		    f.add(b5);
		    
		   
		    f.add(button);
		    
		    f.setSize(1000,1000);  
		    f.setLayout(null);  
		    f.setVisible(true);   
		    
		    f.getContentPane().setLayout(new FlowLayout());  
		    JTextArea textArea = new JTextArea(40,40);  
	        JScrollPane sArea = new JScrollPane(textArea); 
	        sArea.setBounds(500,50,95,30);
	       
	  
	        sArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	        sArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
	  
	        f.getContentPane().add(sArea);  
	        
		    
		    
		    Action a =new Action();
		    ReadandTransform rt=new ReadandTransform();
		    SettingTextpane st=new SettingTextpane();
		   Log l=new Log();
		   Logger logger = Logger.getLogger("MyLog");
		   l.mainInvocation(logger);
		    
		    b.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            String filepath = a.jButton1ActionPerformed(evt);
	            tf.setText(filepath);
	            String sbnew=st.setTextPane(filepath);
		    	textArea.setText(sbnew);
	            }
	           
	        });
		    
		   
		    
		    b1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	org.w3c.dom.Document 	 document = rt.readXML(tf.getText());
	            	try {
						document = rt.readXml(document, tf.getText());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            	String oldssccno=of1.getText();
	            	String newssccno=tf1.getText();
	            	org.w3c.dom.Document 	 document1= a.jButton2ActionPerformed(evt,oldssccno, newssccno,document);
	            	 rt.transformXML(document1, tf.getText()); 
	            	 String sbnew=st.setTextPane(tf.getText());
	 		    	textArea.setText(sbnew);
	            }
	        });
		    
		    b2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	org.w3c.dom.Document 	 document = rt.readXML(tf.getText());
	            	try {
						document = rt.readXml(document, tf.getText());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            	String oldcaseno=of2.getText();
	            	String newcaseno=tf2.getText();
	            	org.w3c.dom.Document 	 document1= a.jButton3ActionPerformed(evt,oldcaseno, newcaseno,document);
	            	 rt.transformXML(document1, tf.getText()); 
	            	 String sbnew=st.setTextPane(tf.getText());
	 		    	textArea.setText(sbnew);
	            }
	        });
		    
		    b3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	org.w3c.dom.Document 	 document = rt.readXML(tf.getText());
	            	try {
						document = rt.readXml(document, tf.getText());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            	String oldeachesno=of3.getText();
	            	String neweachesno=tf3.getText();
	            	org.w3c.dom.Document 	 document1= a.jButton4ActionPerformed(evt, oldeachesno,neweachesno,document);
	            	 rt.transformXML(document1, tf.getText()); 
	            	 String sbnew=st.setTextPane(tf.getText());
	 		    	textArea.setText(sbnew);
	            }
	        });
		    
		    b4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	org.w3c.dom.Document 	 document = rt.readXML(tf.getText());
	            	try {
						document = rt.readXml(document, tf.getText());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            	String lotno=of4.getText();
	            	org.w3c.dom.Document 	 document1= a.jButton5ActionPerformed(evt,lotno,document);
	            	 rt.transformXML(document1, tf.getText()); 
	            	 String sbnew=st.setTextPane(tf.getText());
	 		    	textArea.setText(sbnew);
	            }
	        });
		    
		    b5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	org.w3c.dom.Document 	 document = rt.readXML(tf.getText());
	            	try {
						document = rt.readXml(document, tf.getText());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
	            	String asnno=of5.getText();
	            	org.w3c.dom.Document 	 document1= a.jButton6ActionPerformed(evt,asnno,document);
	            	 rt.transformXML(document1, tf.getText()); 
	            	 String sbnew=st.setTextPane(tf.getText());
	 		    	textArea.setText(sbnew);
	            }
	        });
		    
		
		    button.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	 JDialog frDialog = new JDialog(f);

	     		    frDialog.setLayout(new GridLayout(3,4));

	     		    JTextField txtFind = new JTextField();
	     		    JButton btnFind = new JButton("Find");
	     		    frDialog.add(new JLabel("Find: "));
	     		    frDialog.add(txtFind);
	     		    frDialog.add(new JLabel(""));
	     		    frDialog.add(btnFind);
	     		    frDialog.add(new JLabel(""));
	     		    frDialog.add(new JLabel(""));
	     		    frDialog.add(new JLabel(""));
	     		 

	     		    frDialog.pack();
	     		    frDialog.setVisible(true);	
	     		  
	     		    
	     		   btnFind.addActionListener(new java.awt.event.ActionListener() {
	   	        	public void actionPerformed(java.awt.event.ActionEvent evt) {	
	   	        		a.jButton7ActionPerformed(evt,textArea,txtFind.getText());	        	
	   	        }
	   	        
	   	        });
	            }
		    });
		    
		    
	}

	
	
}
