package imagefactoryplugin;

import java.io.File;

import editorframeworkinterfaces.IDocumentValidator;

public class ImageValidator implements IDocumentValidator{

	@Override
	public boolean validate(File file) {
		System.out.println("ImageFactoryPlugin: " + file.getName() + " successfully validated...!");
		return true;
	}

}
