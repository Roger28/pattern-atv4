package imagefactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentEditor;

public class ImageEditor implements IDocumentEditor{

	@Override
	public boolean open(File file) {
		System.out.println("ImageFactoryPlugin: " + file.getName() + " opened successfully...!");
		return true;
	}

}
