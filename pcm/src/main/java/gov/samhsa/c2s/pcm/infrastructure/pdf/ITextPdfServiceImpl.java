package gov.samhsa.c2s.pcm.infrastructure.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import gov.samhsa.c2s.pcm.domain.Consent;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Service
public class ITextPdfServiceImpl implements ITextPdfService {
    //Create document title
    @Override
    public Paragraph createParagraphWithContent(String title, Font font) {
        Paragraph titleParagraph = null;

        if (font != null) {
            titleParagraph = new Paragraph(title, font);
        } else {
            titleParagraph = new Paragraph(title);
        }

        return titleParagraph;
    }

    // Create borderless table
    @Override
    public PdfPTable createBorderlessTable(int column) {
        PdfPTable table = new PdfPTable(column);
        table.setWidthPercentage(100);
        table.getDefaultCell().setBorder(0);
        return table;
    }

    @Override
    public PdfPCell createBorderlessCell(String content, Font font) {
        PdfPCell cell = null;

        if (font != null) {
            cell = new PdfPCell(new Paragraph(content, font));
        } else {
            cell = new PdfPCell(new Paragraph(content));
        }
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPaddingLeft(0);

        return cell;
    }

    @Override
    public Chunk createChunkWithFont(String text, Font textFont) {
        Chunk labelChunk = null;
        if (text != null && textFont != null) {
            labelChunk = new Chunk(text, textFont);
        } else if (text != null) {
            labelChunk = new Chunk(text);
        }
        return labelChunk;
    }

    @Override
    public Paragraph createCellContent(String label, Font labelFont, String value, Font valueFont) {
        Paragraph content = new Paragraph();
        content.add(createChunkWithFont(label, labelFont));
        content.add(createChunkWithFont(value, valueFont));
        return content;
    }

    @Override
    public PdfPTable createSectionTitle(String title) {
        PdfPTable sectionTitle = createBorderlessTable(1);

        Font cellFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
        cellFont.setColor(BaseColor.WHITE);

        PdfPCell cell = createBorderlessCell(title, cellFont);
        cell.setBackgroundColor(new BaseColor(73, 89, 105));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPaddingBottom(5);
        sectionTitle.addCell(cell);

        return sectionTitle;
    }

    @Override
    public Chunk createUnderlineText(String text) {
        Chunk underlineText = new Chunk(text);
        underlineText.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
        return underlineText;
    }

    @Override
    public PdfPCell createEmptyBorderlessCell() {
        PdfPCell aCell = new PdfPCell();
        aCell.setBorder(0);
        return aCell;
    }

    @Override
    public PdfPCell createCellWithUnderlineContent(String text) {
        PdfPCell aCell = createEmptyBorderlessCell();
        aCell.addElement(createUnderlineText(text));
        return aCell;
    }

    @Override
    public List createUnorderList(java.util.List<String> items) {
        List unorderedList = new List(List.UNORDERED);
        for (String item : items) {
            unorderedList.add(new ListItem(item));
        }
        return unorderedList;
    }

    @Override
    public String formatDate(Date aDate) {
        String dateFormat = "MMM dd, yyyy";
        return new SimpleDateFormat(dateFormat).format(aDate);
    }

    @Override
    public String formatLocalDate(LocalDate aDate) {
        String dateFormat = "MMM dd, yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return aDate.format(formatter);
    }

    @Override
    public PdfPTable createConsentReferenceNumberTable(Consent consent) {
        PdfPTable consentReferenceNumberTable = createBorderlessTable(1);

        if (consent != null && consent.getConsentReferenceId() != null) {
            consentReferenceNumberTable.addCell(createBorderlessCell("Consent Reference Number:", null));
            Font consentRefNumberFont = new Font(Font.FontFamily.TIMES_ROMAN, 11);
            consentReferenceNumberTable.addCell(createBorderlessCell(consent.getConsentReferenceId(), consentRefNumberFont));
        }

        return consentReferenceNumberTable;
    }

    @Override
    public PdfPTable createSigningDetailsTable(String firstName, String lastName, String email, boolean isSigned, Date attestedOn) {
        PdfPTable signingDetailsTable = createBorderlessTable(1);

        if (isSigned && StringUtils.hasText(firstName) && StringUtils.hasText(lastName) && StringUtils.hasText(email) && Objects.nonNull(attestedOn)) {
            Font patientInfoFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);

            PdfPCell attesterName = new PdfPCell(createCellContent("Signed by: ", patientInfoFont, getFullName(firstName, lastName), null));
            attesterName.setBorder(Rectangle.NO_BORDER);
            signingDetailsTable.addCell(attesterName);

            PdfPCell attesterEmailCell = new PdfPCell(createCellContent("Email: ", patientInfoFont, email, null));
            attesterEmailCell.setBorder(Rectangle.NO_BORDER);
            signingDetailsTable.addCell(attesterEmailCell);

            PdfPCell attesterSignDateCell = new PdfPCell(createCellContent("Signed on: ", patientInfoFont, formatDate(attestedOn), null));
            attesterSignDateCell.setBorder(Rectangle.NO_BORDER);
            signingDetailsTable.addCell(attesterSignDateCell);
        }
        return signingDetailsTable;
    }

    @Override
    public String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    @Override
    public PdfPTable createPatientNameAndDOBTable(String firstName, String lastName, Date birthDate) {
        PdfPTable consentReferenceNumberTable = createBorderlessTable(2);

        if (StringUtils.hasText(firstName) && StringUtils.hasText(lastName) && Objects.nonNull(birthDate)) {
            Font patientInfoFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
            PdfPCell patientNameCell = new PdfPCell(createCellContent("Patient Name: ", null, getFullName(firstName, lastName), patientInfoFont));
            patientNameCell.setBorder(Rectangle.NO_BORDER);

            PdfPCell patientDOBCell = new PdfPCell(createCellContent("Patient DOB: ", null, formatDate(birthDate), patientInfoFont));
            patientDOBCell.setBorder(Rectangle.NO_BORDER);

            consentReferenceNumberTable.addCell(patientNameCell);
            consentReferenceNumberTable.addCell(patientDOBCell);
        }

        return consentReferenceNumberTable;
    }
}
