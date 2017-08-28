package gov.samhsa.c2s.pcm.infrastructure.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface PdfBoxService {
    PDPage generatePage(String typeOfPdf, PDDocument generatedPdDocument);

    void addTextAtOffset(String text, PDFont font, float fontSize, Color textColor, float xCoordinate, float yCoordinate,
                         PDPageContentStream contentStream) throws IOException;

    void addCenteredTextAtOffset(String text, PDFont font, float fontSize, Color textColor, float yCoordinate,
                                 PDPage page, PDPageContentStream contentStream) throws IOException;

    void addAutoWrapParagraphByPageWidth(String content, PDFont font, float fontSize, Color textColor, float yCoordinate, float leftRightMargin,
                                         PDPage page, PDPageContentStream contentStream) throws IOException;

    void addColorBox(Color color, float xCoordinate, float yCoordinate, float width, float height, PDPage page, PDPageContentStream contents) throws IOException;

    void addTableContent(PDPageContentStream contentStream, TableAttribute tableAttribute,
                         List<List<String>> content) throws IOException;

    PDFont getConfiguredPdfFont(String typeOfPdf);

    PDRectangle getConfiguredPdfPageSize(String typeOfPdf);
}
