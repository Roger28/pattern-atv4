package pdfdocumentadapter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import editorframeworkinterfaces.IDocumentEditor;

public class PdfDocumentAdapter implements IDocumentEditor {

	private PDDocument document;

	@Override
	public boolean open(File file) {
		try {
			document = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(document);
			BufferedImage image = renderer.renderImage(0);
			showImage(image);
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private void showImage(BufferedImage image) {
		JFrame frame = new JFrame();
		ImageIcon icon = new ImageIcon(image);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}

}
