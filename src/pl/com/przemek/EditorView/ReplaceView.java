package pl.com.przemek.EditorView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReplaceView extends JFrame {

	private Label targetLabel;
	private Label replacementLabel;
	private JTextField target;
	private JTextField replacement;
	private JPanel panel;
	private GridLayout layout;
	private JButton replaceButton;
	
	public ReplaceView(){
		this.setTitle("Replace");
		this.setAlwaysOnTop(true);
		this.setSize(250,120);
		
		targetLabel = new Label ("Target: ");
		target = new JTextField(12);
		replacementLabel = new Label ("Replace with: ");
		replacement = new JTextField(12);
		replaceButton = new JButton("Replace");
		
		layout = new GridLayout(2,2);
		panel = new JPanel(layout);
		
		panel.add(targetLabel);
		panel.add(target);
		panel.add(replacementLabel);
		panel.add(replacement);
		
		this.add(panel, BorderLayout.CENTER);
		this.add(replaceButton, BorderLayout.SOUTH);
	}
	
	public String getTarget() {
		return this.target.getText();
	}
	
	public String getReplacement() {
		return this.replacement.getText();
	} 
	
	public void addReplacementListener (ActionListener actionListener) {
		this.replaceButton.addActionListener(actionListener);
	}
}
