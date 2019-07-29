/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import editorframeworkinterfaces.IAuthenticationController;
import editorframeworkinterfaces.ICore;
import editorframeworkinterfaces.IPluginController;
import editorframeworkinterfaces.IUIController;

/**
 *
 * @author aluno
 */
public class Core implements ICore {

	public static Core getInstance() {
    	if(instance == null) {
    		instance = new Core();
    		init();
    	}
    	return instance;   
    }
    
    @Override
    public IUIController getUIController() {
        return uiController;
    }

    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    @Override
    public IAuthenticationController getAuthenticationController() {
    	return authenticationController;
    }

	private static void init() {
    	uiController = new UIController();
        pluginController = new PluginController();
        authenticationController = new AuthenticationController();
        uiController.initialize();
        pluginController.initialize();
        authenticationController.initialize();
    }

	private Core() {}
    
    	private static IUIController uiController;
    	private static IPluginController pluginController;
	private static IAuthenticationController authenticationController;
	private static Core instance = null;
    
}
