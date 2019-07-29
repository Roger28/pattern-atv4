package pdffactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentEditor;
import pdfdocumentadapter.PdfDocumentAdapter;

public class PdfEditor implements IDocumentEditor {

	private PdfDocumentAdapter adapter;
	
	public PdfEditor() {
		this.adapter = new PdfDocumentAdapter();
	}
	
	@Override
	public boolean open(File file) {	
		adapter.open(file);
		return true;
	}

}
