package textfactoryplugin;

import editorframeworkinterfaces.IDocumentEditor;
import editorframeworkinterfaces.IDocumentFactory;
import editorframeworkinterfaces.IDocumentSerializer;
import editorframeworkinterfaces.IDocumentValidator;
import editorframeworkinterfaces.IPlugin;

public class TextFactoryPlugin implements IPlugin, IDocumentFactory {

	public static TextFactoryPlugin getInstance(){
		if(instance == null)
			instance = new TextFactoryPlugin();
		return instance;
	}

	@Override
	public boolean initialize() {
		return true;
	}

	@Override
	public IDocumentEditor getDocumentEditor() {
		return new TextEditor();
	}

	@Override
	public IDocumentSerializer getDocumentSerializer() {
		return new TextSerializer();
	}

	@Override
	public IDocumentValidator getDocumentValidator() {
		return new TextValidator();
	}

	@Override
	public String getSupportedExtensions() {
		return "txt";
	}

	private TextFactoryPlugin(){}

	private static TextFactoryPlugin instance = null;

}
