package pdffactoryplugin;

import editorframeworkinterfaces.IDocumentEditor;
import editorframeworkinterfaces.IDocumentFactory;
import editorframeworkinterfaces.IDocumentSerializer;
import editorframeworkinterfaces.IDocumentValidator;
import editorframeworkinterfaces.IPlugin;

public class PdfFactoryPlugin implements IPlugin, IDocumentFactory{
	
	public static PdfFactoryPlugin getInstance() {
		if(instance == null)
			instance = new PdfFactoryPlugin();
		return instance;
	}
	
	@Override
	public boolean initialize() {
		return true;
	}

	@Override
	public IDocumentEditor getDocumentEditor() {
		return new PdfEditor();
	}

	@Override
	public IDocumentSerializer getDocumentSerializer() {		
		return new PdfSerializer();
	}

	@Override
	public IDocumentValidator getDocumentValidator() {		
		return new PdfValidator();
	}

	@Override
	public String getSupportedExtensions() {		
		return "pdf";
	}
	
	private PdfFactoryPlugin() {}
	
	private static PdfFactoryPlugin instance = null;

}
