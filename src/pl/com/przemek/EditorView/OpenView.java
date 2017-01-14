package pl.com.przemek.EditorView;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenView extends JFrame {

	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private JButton open;
	private JPanel panel;

	public OpenView() {
		this.setTitle("Open file");
		this.setSize(400, 300);
		this.setAlwaysOnTop(true);
		chooser = new JFileChooser(".");
		filter = new FileNameExtensionFilter("txt file", "txt");
		chooser.setFileFilter(filter);
		chooser.setControlButtonsAreShown(false);
		open = new JButton("Open");
		panel = new JPanel();
		panel.add(open);
		this.add(chooser, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}

	public void addListenerForOpen(ActionListener actionListener) {
		open.addActionListener(actionListener);
	}
	
	public File getChooserFile () {
		return chooser.getSelectedFile();
	}
}
