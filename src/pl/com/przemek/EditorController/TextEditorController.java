package pl.com.przemek.EditorController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import pl.com.przemek.EditorModel.TextEditorModel;
import pl.com.przemek.EditorView.OpenView;
import pl.com.przemek.EditorView.ReplaceView;
import pl.com.przemek.EditorView.SaveView;
import pl.com.przemek.EditorView.TextEditorView;

public class TextEditorController {

	private TextEditorModel model;
	private TextEditorView view;
	private ReplaceView replaceView;
	private OpenView openView;
	private SaveView saveView;
	private File file;

	public TextEditorController(TextEditorModel model, TextEditorView view) {
		this.model = model;
		this.view = view;
		replaceView = new ReplaceView();
		openView = new OpenView();
		saveView = new SaveView();

		view.addListenerOpenItem(new ListenerForOpenAction());
		openView.addListenerForOpen(new ListenerForOpen());
		view.addListenerSaveItem(new ListenerForSave());
		view.addListenerSaveAsItem(new ListenerForSaveAsAction());
		saveView.addSaveAsListener(new ListenerForSaveAs());
		view.addListenerCloseItem(new ListenerForClose());

		view.addListenerReplaceItem(new ListenerForReplace());
		replaceView.addReplacementListener(new ListenerForReplacementAction());
		view.addListenertimeItem(new ListenerForDate());

		view.addListenerArialItem(new ListenerForArial());
		view.addListenerSerifItem(new ListenerForSerif());
		view.addListenerVerdanaItem(new ListenerForVerdana());

		view.addListenerWhiteItem(new ListenerForWhite());
		view.addListenerGreyItem(new ListenerForGrey());
		view.addListenerBrownItem(new ListenerForBrown());
	}

	class ListenerForOpenAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			openView.setVisible(true);
		}
	}

	class ListenerForOpen implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			file = openView.getChooserFile();
			model.openFile(view.getTextArea(), openView.getChooserFile());
			openView.setVisible(false);
		}
	}

	class ListenerForSave implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (file != null) {
				try {
					model.save(view.getTextArea(), file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				saveView.setVisible(true);
			}
		}
	}

	class ListenerForSaveAsAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			saveView.setVisible(true);
		}
	}

	class ListenerForSaveAs implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				model.saveAs(view.getTextArea(), saveView.getName());
				saveView.setVisible(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ListenerForClose implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.close();
		}
	}

	class ListenerForReplace implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			replaceView.setVisible(true);
		}
	}

	class ListenerForReplacementAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.replaceText(view.getTextArea(), replaceView.getTarget(),
					replaceView.getReplacement());
			replaceView.setVisible(false);
		}
	}

	class ListenerForDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.insertDate(view.getTextArea());
		}
	}

	class ListenerForArial implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.setFontArial(view.getTextArea());
		}
	}

	class ListenerForSerif implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.setFontSerif(view.getTextArea());
		}
	}

	class ListenerForVerdana implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.setFontVerdana(view.getTextArea());
		}
	}

	class ListenerForWhite implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.setBackgroundWhite(view.getTextArea());
		}
	}

	class ListenerForGrey implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.setBackgroundGrey(view.getTextArea());
		}
	}

	class ListenerForBrown implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.setBackgroundBrown(view.getTextArea());
		}
	}
}