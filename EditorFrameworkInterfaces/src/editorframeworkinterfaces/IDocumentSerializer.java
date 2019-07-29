package editorframeworkinterfaces;

import java.io.File;

public interface IDocumentSerializer {
	  public boolean load(File file);
	  public boolean save(File file);
}
