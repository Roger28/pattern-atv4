package editorframeworkinterfaces;

public interface ICore {
	public IUIController getUIController();
    public IPluginController getPluginController();
    public IAuthenticationController getAuthenticationController();
}
