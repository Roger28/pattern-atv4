package editorframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import editorframeworkinterfaces.Creator;
import editorframeworkinterfaces.IAuthenticationController;

public class AuthenticationController implements IAuthenticationController {

	@Override
	public boolean initialize() {
		setup();
		return true;
	}

	@Override
	public void setBackendAuthenticator(Creator creator) {
		this.creator = creator;
	}

	private void setup() {
		try {
			List<String> pluginsNames = getPluginsNames();
			List<Creator> creators = Core.getInstance().getPluginController().getLoadedPluginsByType(Creator.class);
			if (!creators.isEmpty() && !pluginsNames.isEmpty()) {
				for (Creator creator : creators) {
					for (String plugin : pluginsNames) {
						if (creator.getClass().getName().contains(plugin)) {
							this.setBackendAuthenticator(creator);
							this.creator.getInstance().authentication();
							return;
						}
					}
				}
				JOptionPane.showMessageDialog(null, AuthenticationController.MESSAGE);
			}

		} catch (NullPointerException e) {
			e.getStackTrace();
		}
	}

	private List<String> getPluginsNames() {
		String path = "./auth/";
		File currentDir = new File(path);
		String[] plugins = currentDir.list();
		List<String> pluginsNames = new ArrayList<String>();
		String plugin = "";

		try {
			InputStream fileInputStream = new FileInputStream(path + plugins[0]);
			Scanner scanner = new Scanner(fileInputStream);
			while (scanner.hasNextLine()) {
				plugin = scanner.nextLine();
				if (plugin.startsWith("<element>") && plugin.endsWith("</element>")) {
					plugin = plugin.substring(plugin.indexOf(">") + 1, plugin.indexOf("</"));
					pluginsNames.add(plugin);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, e);
		}

		return pluginsNames;
	}

	private Creator creator;
	private static String MESSAGE = "Nenhum plugin encontrado.";

}
