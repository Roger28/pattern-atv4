package textfactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentValidator;

public class TextValidator implements IDocumentValidator {

	@Override
	public boolean validate(File file) {
		System.out.println("TextFactoryPlugin: " + file.getName() + " successfully validated!");
		return true;
	}

}
