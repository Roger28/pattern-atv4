/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework;

import java.io.File;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import editorframeworkinterfaces.IDocumentFactory;
import editorframeworkinterfaces.IUIController;

/**
 *
 * @author aluno
 */
public class UIController implements IUIController {

	@Override
	public boolean initialize() {
		mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		initializeFileNew();
		return true;
	}

	@Override
	public JMenuItem addMenuItem(String menuName, String menuItemName) {
		JMenu myMenu = null;
		JMenuBar myMenuBar = mainWindow.getJMenuBar();
		for (int i = 0; i < myMenuBar.getMenuCount(); ++i) {
			if (myMenuBar.getMenu(i).getText().equals(menuName))
				myMenu = myMenuBar.getMenu(i);
		}

		if (myMenu == null) {
			myMenu = new JMenu(menuName);
			myMenuBar.add(myMenu);
		} else {
			for (int i = 0; i < myMenu.getItemCount(); ++i)
				if (myMenu.getItem(i).getText().equals(menuItemName))
					return null;
		}

		JMenuItem myMenuItem = new JMenuItem(menuItemName);
		myMenu.add(myMenuItem);

		mainWindow.pack();

		return myMenuItem;
	}

	private void initializeFileNew() {
		JMenuItem fileNewItem = addMenuItem("File", "New");
		fileNewItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				JFileChooser jFileChooser = new JFileChooser();
				int returnDialog = jFileChooser.showDialog(jFileChooser, "Open");
				if (returnDialog == JFileChooser.APPROVE_OPTION) {
					File fileChoosed = jFileChooser.getSelectedFile();
					String fileExtension = fileChoosed.getName();
					if (fileExtension.contains(".")) {
						fileExtension = fileExtension.split("\\.")[1];
						List<IDocumentFactory> listDocumentFactories = Core.getInstance().getPluginController()
								.getLoadedPluginsByType(IDocumentFactory.class);

						if (!listDocumentFactories.isEmpty()) {
							for (IDocumentFactory documentFactory : listDocumentFactories) {
								String[] supportedExtensions = documentFactory.getSupportedExtensions().split("\\|");
								if (isSupportedByDocumentFactory(fileExtension, supportedExtensions, documentFactory)) {
									initializeProducts(documentFactory, fileChoosed);
									return;
								}
							}
						}
					}
					JOptionPane.showMessageDialog(null, UIController.MESSAGE);
				}
			}
		});
	}

	private boolean isSupportedByDocumentFactory(String fileExtensionOpened, String[] supportedExtensions,
			IDocumentFactory documentFactory) {
		for (String extension : supportedExtensions)
			if (extension.equals(fileExtensionOpened))
				return true;
		return false;
	}

	private void initializeProducts(IDocumentFactory documentFactory, File file) {
		documentFactory.getDocumentEditor().open(file);
		documentFactory.getDocumentSerializer().load(file);
		documentFactory.getDocumentSerializer().save(file);
		documentFactory.getDocumentValidator().validate(file);
	}

	private MainWindow mainWindow;
	private static String MESSAGE = "The file could not be opened.";
}
