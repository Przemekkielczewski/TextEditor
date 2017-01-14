package pl.com.przemek.TextEditor;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pl.com.przemek.EditorController.TextEditorController;
import pl.com.przemek.EditorModel.TextEditorModel;
import pl.com.przemek.EditorView.ReplaceView;
import pl.com.przemek.EditorView.TextEditorView;

public class TextEditor {

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
			TextEditorView view = new TextEditorView();
			TextEditorModel model = new TextEditorModel();
			TextEditorController controller = new TextEditorController (model, view);
			view.setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

	}
