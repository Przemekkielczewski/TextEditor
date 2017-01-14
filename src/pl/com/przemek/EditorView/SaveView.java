package pl.com.przemek.EditorView;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveView extends JFrame {
	
	private JLabel saveLabel;
	private JTextField saveName;
	private JPanel panel;
	private JButton saveAs;
	
	public SaveView () {
		this.setTitle("Save as...");
		this.setSize(260,100);
		this.setAlwaysOnTop(true);
		
		saveLabel = new JLabel("file name: ");
		saveName = new JTextField(12);
		panel = new JPanel();
		saveAs = new JButton("save as...");
		
		panel.add(saveLabel);
		panel.add(saveName);
		this.add(panel, BorderLayout.CENTER);
		this.add(saveAs, BorderLayout.SOUTH);
	}
	
	public String getName(){
		return this.saveName.getText();
	}
	
	public void addSaveAsListener (ActionListener actionListener) {
		this.saveAs.addActionListener(actionListener);
	}
}
