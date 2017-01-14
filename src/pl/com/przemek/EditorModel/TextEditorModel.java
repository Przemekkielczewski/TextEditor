package pl.com.przemek.EditorModel;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JTextArea;

public class TextEditorModel {

	private Date date;

	private Font arial;
	private Font serif;
	private Font verdana;

	private Color white;
	private Color grey;
	private Color brown;

	public TextEditorModel() {

		arial = new Font("Arial", Font.PLAIN, 16);
		serif = new Font("Serif", Font.PLAIN, 16);
		verdana = new Font("Verdana", Font.PLAIN, 16);

		white = new Color(255, 255, 255);
		grey = new Color(240, 240, 240);
		brown = new Color(237, 220, 211);
	}

	public void openFile(JTextArea textArea, File file) {
		try {
			textArea.setText(null);
			String text = new String();
			Scanner reader = new Scanner(file);
			int c = 0;
			while (reader.hasNext() == true) {
				if (c == 0) {
					textArea.setText(reader.nextLine());
					c = c + 1;
				} else {
				text = textArea.getText();
				textArea.setText(text + "\n" + reader.nextLine());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		System.exit(0);
	}

	public void save(JTextArea textArea, File currentFile) throws IOException {
		PrintWriter writer = new PrintWriter(currentFile);
		writer.println(textArea.getText());
		writer.close();
	}
	
	public void saveAs(JTextArea textArea, String filename) throws IOException {
		File saveAsfile = new File(filename + ".txt");
		PrintWriter writer = new PrintWriter(saveAsfile);
		writer.println(textArea.getText());
		writer.close();
	}

	public void replaceText(JTextArea textArea, String target,
			String replacement) {
		String text = textArea.getText();
		textArea.setText(null);
		String line = new String();
		Scanner reader = new Scanner(text);
		boolean match = false;
		while (reader.hasNext() == true) {
			line = reader.nextLine();
			String[] parsedLine = this.parseLine(line, " ");
			for (int i = 0; i < parsedLine.length; i++) {
				if (parsedLine[i].equals(target)) {
					parsedLine[i] = replacement;
					match = true;
				}
			}

			if (match == true) {
				line = null;
				for (int i = 0; i < parsedLine.length; i++) {
					if (line == null) {
						line = parsedLine[i] + " ";
					} else {
						line = line + parsedLine[i] + " ";
					}
				}
			}
			textArea.setText(textArea.getText() + line + "\n");
		}
	}

	public void insertDate(JTextArea textArea) {
		date = new Date();
		String text = textArea.getText();
		textArea.setText(text + "\n" + date.toString());
	}

	public void setFontArial(JTextArea textArea) {
		textArea.setFont(arial);
	}

	public void setFontSerif(JTextArea textArea) {
		textArea.setFont(serif);
	}

	public void setFontVerdana(JTextArea textArea) {
		textArea.setFont(verdana);
	}

	public void setBackgroundWhite(JTextArea textArea) {
		textArea.setBackground(white);
	}

	public void setBackgroundGrey(JTextArea textArea) {
		textArea.setBackground(grey);
	}

	public void setBackgroundBrown(JTextArea textArea) {
		textArea.setBackground(brown);
	}

	public String[] parseLine(String line, String regEx) {
		String[] list = line.split(regEx);
		return list;
	}
}
