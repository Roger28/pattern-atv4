package textfactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentEditor;

public class TextEditor implements IDocumentEditor {

	@Override
	public boolean open(File file) {
		System.out.println("TextFactoryPlugin: " + file.getName() + "opened successfully!");
		return true;
	}

}
