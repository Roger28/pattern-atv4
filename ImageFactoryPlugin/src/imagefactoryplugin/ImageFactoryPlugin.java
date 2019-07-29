package imagefactoryplugin;

import editorframeworkinterfaces.IDocumentEditor;
import editorframeworkinterfaces.IDocumentFactory;
import editorframeworkinterfaces.IDocumentSerializer;
import editorframeworkinterfaces.IDocumentValidator;
import editorframeworkinterfaces.IPlugin;

public class ImageFactoryPlugin implements IPlugin, IDocumentFactory{
	
	public static ImageFactoryPlugin getInstance() {
		if(instance == null)
			instance = new ImageFactoryPlugin();
		return instance;
	}

	@Override
	public boolean initialize() {
		return true;
	}
	
	@Override
	public IDocumentEditor getDocumentEditor() {
		return new ImageEditor();
	}

	@Override
	public IDocumentSerializer getDocumentSerializer() {
		return new ImageSerializer();
	}

	@Override
	public IDocumentValidator getDocumentValidator() {
		return new ImageValidator();
	}

	@Override
	public String getSupportedExtensions() {
		return "jpg|png|jpeg";
	}
	
	private ImageFactoryPlugin() {}
	
	private static ImageFactoryPlugin instance = null;

}
