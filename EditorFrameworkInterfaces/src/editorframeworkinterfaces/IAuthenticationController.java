package editorframeworkinterfaces;

public interface IAuthenticationController {
	public boolean initialize();
	public void setBackendAuthenticator(Creator creator);
}
