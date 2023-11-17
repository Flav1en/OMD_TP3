package fr.esir.omd.ci;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfReader;  // Assurez-vous d'ajouter cette ligne
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

public class FirstPdfTest {
    @Test
    public void testAddMetaData() throws IOException {
        Document document = new Document();
        FirstPdf.addMetaData(document);

        // Créer un lecteur PDF pour extraire les métadonnées
        PdfReader pdfReader = new PdfReader("/home/flavien/Documents/GitHub/OMD_TP3/FirstPdf.pdf");

        // Vérifie que le titre du document a été correctement ajouté
        assertEquals("My first PDF", pdfReader.getInfo().get("Title"));

        // Vérifie que l'auteur du document a été correctement ajouté
        assertEquals("Olivier Barais", pdfReader.getInfo().get("Author"));
        
        assertEquals("Using iText", pdfReader.getInfo().get("Subject"));

        // Fermer le lecteur PDF
        pdfReader.close();
    }
}