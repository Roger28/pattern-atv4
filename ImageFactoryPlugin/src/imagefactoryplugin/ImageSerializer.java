package imagefactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentSerializer;

public class ImageSerializer implements IDocumentSerializer{

	@Override
	public boolean load(File file) {
		System.out.println("ImageFactoryPlugin: " + file.getName() + " loaded successfully...!");
		return true;
	}

	@Override
	public boolean save(File file) {
		System.out.println("ImageFactoryPlugin: " + file.getName() + " saved successfully...!");
		return true;
	}

}
