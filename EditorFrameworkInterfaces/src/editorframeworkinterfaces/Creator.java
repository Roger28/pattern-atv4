package editorframeworkinterfaces;

public abstract class Creator {

	public abstract IAuthenticationBackend createBackendAuthenticator();

	public IAuthenticationBackend getInstance() {
		return createBackendAuthenticator();
	}

}
