package pl.com.przemek.EditorView;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditorView extends JFrame {

	private JTextArea textArea;
	private Font font;
	private JScrollPane pane;
	private JMenuBar bar;

	private JMenu file;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsItem;
	private JMenuItem exitItem;

	private JMenu edit;
	private JMenuItem replaceItem;
	private JMenuItem timeItem;

	private JMenu options;
	private JMenu fontMenu;
	private JMenuItem fontSerif;
	private JMenuItem fontArial;
	private JMenuItem fontVerdana;
	private JMenu backgroundMenu;
	private JMenuItem backgroundWhite;
	private JMenuItem backgroundGrey;
	private JMenuItem backgroundBrown;

	public TextEditorView() {

		this.setTitle("Jpad");
		this.setSize(600, 450);
		textArea = new JTextArea();
		font = new Font("Serif", Font.PLAIN, 16);
		textArea.setFont(font);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		pane = new JScrollPane(textArea);
		bar = new JMenuBar();

		file = new JMenu("File");
		openItem = new JMenuItem("Open...");
		saveItem = new JMenuItem("Save");
		saveAsItem = new JMenuItem("Save as...");
		exitItem = new JMenuItem("Exit");
		file.add(openItem);
		file.add(saveItem);
		file.add(saveAsItem);
		file.addSeparator();
		file.add(exitItem);

		edit = new JMenu("Edit");
		replaceItem = new JMenuItem("Replace");
		timeItem = new JMenuItem("Date");
		edit.add(replaceItem);
		edit.add(timeItem);

		options = new JMenu("Options");
		fontMenu = new JMenu("Font");
		fontSerif = new JMenuItem("Serif");
		fontArial = new JMenuItem("Arial");
		fontVerdana = new JMenuItem("Verdana");
		backgroundMenu = new JMenu("Background");
		backgroundWhite = new JMenuItem("White");
		backgroundGrey = new JMenuItem("Grey");
		backgroundBrown = new JMenuItem("Brown");
		fontMenu.add(fontSerif);
		fontMenu.add(fontArial);
		fontMenu.add(fontVerdana);
		backgroundMenu.add(backgroundWhite);
		backgroundMenu.add(backgroundGrey);
		backgroundMenu.add(backgroundBrown);
		options.add(fontMenu);
		options.add(backgroundMenu);

		bar.add(file);
		bar.add(edit);
		bar.add(options);
		this.add(pane, BorderLayout.CENTER);
		this.add(bar, BorderLayout.NORTH);

	}

	public JTextArea getTextArea() {
		return this.textArea;
	}

	public void addListenerOpenItem(ActionListener actionListener) {
		this.openItem.addActionListener(actionListener);
	}

	public void addListenerSaveItem(ActionListener actionListener) {
		this.saveItem.addActionListener(actionListener);
	}

	public void addListenerSaveAsItem(ActionListener actionListener) {
		this.saveAsItem.addActionListener(actionListener);
	}

	public void addListenerCloseItem(ActionListener actionListener) {
		this.exitItem.addActionListener(actionListener);
	}

	public void addListenerReplaceItem(ActionListener actionListener) {
		this.replaceItem.addActionListener(actionListener);
	}

	public void addListenertimeItem(ActionListener actionListener) {
		this.timeItem.addActionListener(actionListener);
	}

	public void addListenerSerifItem(ActionListener actionListener) {
		this.fontSerif.addActionListener(actionListener);
	}

	public void addListenerArialItem(ActionListener actionListener) {
		this.fontArial.addActionListener(actionListener);
	}

	public void addListenerVerdanaItem(ActionListener actionListener) {
		this.fontVerdana.addActionListener(actionListener);
	}

	public void addListenerWhiteItem(ActionListener actionListener) {
		this.backgroundWhite.addActionListener(actionListener);
	}

	public void addListenerGreyItem(ActionListener actionListener) {
		this.backgroundGrey.addActionListener(actionListener);
	}

	public void addListenerBrownItem(ActionListener actionListener) {
		this.backgroundBrown.addActionListener(actionListener);
	}

}