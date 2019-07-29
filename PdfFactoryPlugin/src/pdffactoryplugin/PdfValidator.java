package pdffactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentValidator;

public class PdfValidator implements IDocumentValidator {

	@Override
	public boolean validate(File file) {
		return true;
	}

}
