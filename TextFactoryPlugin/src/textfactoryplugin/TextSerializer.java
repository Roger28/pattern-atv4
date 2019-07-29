package textfactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentSerializer;

public class TextSerializer implements IDocumentSerializer {

	@Override
	public boolean load(File file) {
		System.out.println("TextFactoryPlugin: " + file.getName() + " loaded successfully!");
		return true;
	}

	@Override
	public boolean save(File file) {
		System.out.println("TextFactoryPlugin: " + file.getName() + " saved successfully!");
		return true;
	}

}
