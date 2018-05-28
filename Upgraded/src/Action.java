import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Action extends Mainjava {

	 Logger logger = Logger.getLogger("MyLog");
	Log l=new Log();
	 
	
	 public String jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		 
		 JFileChooser fc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		    int returnValue  = fc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			String filepath=selectedFile.getAbsolutePath();
		    return filepath;
		}
		return "";
		
	 }
public org.w3c.dom.Document jButton2ActionPerformed(java.awt.event.ActionEvent evt,String oldssccno, String newssccno,org.w3c.dom.Document document)  {
		 
	
	 int count=0;
		
			NodeList nodelist=document.getElementsByTagName("*");
			for (int i = 0; i < nodelist.getLength(); i++)
			{
				Node node = nodelist.item(i);
				if(node.getNodeName().equals("epc") || node.getNodeName().equals("parentID"))
				{
					if( node.getTextContent().contains("sscc") && node.getTextContent().equals(oldssccno))
					{
					node.setTextContent(newssccno);
					count=count+1;
					l.tagUpdation(logger,oldssccno,newssccno);
					}
				}
			}
			
			l.countUpdation(logger, "sscc", count);
	return document;		 
}

public org.w3c.dom.Document jButton3ActionPerformed(java.awt.event.ActionEvent evt,String oldcaseno, String newcaseno,org.w3c.dom.Document document) {
	 
	
	 int count=0;
		
			NodeList nodelist=document.getElementsByTagName("*");
			for (int i = 0; i < nodelist.getLength(); i++)
			{
				Node node = nodelist.item(i);
				if(node.getNodeName().equals("parentID")||node.getNodeName().equals("epc") )
				{
					if( node.getTextContent().contains("sgtin") && node.getTextContent().equals(oldcaseno))
					{
					node.setTextContent(newcaseno);
					count=count+1;
					l.tagUpdation(logger,oldcaseno,newcaseno);
					
					}
				}
			}
			
			l.countUpdation(logger, "cases", count);
	return document;		 
}


public org.w3c.dom.Document jButton4ActionPerformed(java.awt.event.ActionEvent evt,String oldeachesno, String neweachesno,org.w3c.dom.Document document) {
	
	int count=0;
	
	NodeList nodelist=document.getElementsByTagName("*");
	for (int i = 0; i < nodelist.getLength(); i++)
	{
		Node node = nodelist.item(i);
		if(node.getNodeName().equals("parentID")||node.getNodeName().equals("epc") )
		{
			if( node.getTextContent().contains("sgtin") && node.getTextContent().equals(oldeachesno))
			{
			node.setTextContent(neweachesno);
			count=count+1;
			l.tagUpdation(logger,oldeachesno,neweachesno);
			}
		}
	}
	
	l.countUpdation(logger, "eaches", count);
return document;		  	 
}

public org.w3c.dom.Document jButton5ActionPerformed(java.awt.event.ActionEvent evt, String newlotno,org.w3c.dom.Document document) {
	 
	
	 int count=0;
		
			NodeList nodelist=document.getElementsByTagName("*");
			for (int i = 0; i < nodelist.getLength(); i++)
			{
				Node node = nodelist.item(i);
				if(node.getNodeName().equals("gs1ushc:lotNumber"))
				{
					String oldlotno=node.getTextContent();
					node.setTextContent(newlotno);
					count=count+1;
					l.tagUpdation(logger,oldlotno,newlotno);
					}
					}
	
			l.countUpdation(logger, "lot", count);	
			
	return document;		 
}

public org.w3c.dom.Document jButton6ActionPerformed(java.awt.event.ActionEvent evt, String asnno,org.w3c.dom.Document document) {
	 
	
	 int count=0;
		
			NodeList nodelist=document.getElementsByTagName("*");
			for (int i = 0; i < nodelist.getLength(); i++)
			{
				Node node = nodelist.item(i);
				if(node.getNodeName().equals("bizTransaction"))
				{
					String oldasnno=node.getTextContent();
					String[] b=oldasnno.split(":");
					node.setTextContent(b[0]+":"+b[1]+":"+b[2]+":"+b[3]+":"+b[4]+":"+asnno);
					String newdesadv=b[0]+":"+b[1]+":"+b[2]+":"+b[3]+":"+b[4]+":"+asnno ;
					count=count+1;
					l.tagUpdation(logger,oldasnno,newdesadv);
					}
					}
	
			l.countUpdation(logger, "asn", count);	
			
	return document;		 
}
public void jButton7ActionPerformed(ActionEvent evt, JTextArea textArea, String str) {
	// TODO Auto-generated method stub
	Highlighter h = textArea.getHighlighter();
	h.removeAllHighlights();
	Document doc=textArea.getDocument();
	String text;
	try {
		text = doc.getText(0, doc.getLength());
		int pos=0;
    	while((pos=text.indexOf(str,pos))>=0) {
    		h.addHighlight(pos, pos+str.length(),DefaultHighlighter.DefaultPainter);
    		pos+=str.length();
    	}
	} catch (BadLocationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	l.tagHighlight(logger,str);
}

}
		
	 

