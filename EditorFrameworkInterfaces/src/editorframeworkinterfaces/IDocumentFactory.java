package editorframeworkinterfaces;

public interface IDocumentFactory {
	public IDocumentEditor getDocumentEditor();
	public IDocumentSerializer getDocumentSerializer();
	public IDocumentValidator getDocumentValidator();
	public String getSupportedExtensions();
}
