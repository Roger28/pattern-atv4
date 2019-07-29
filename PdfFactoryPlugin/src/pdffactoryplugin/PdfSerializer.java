package pdffactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentSerializer;

public class PdfSerializer implements IDocumentSerializer {

	@Override
	public boolean load(File file) {
		return true;
	}

	@Override
	public boolean save(File file) {	
		return true;
	}

}
