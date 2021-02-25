package com.student;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.student.dto.StudentDetailDTO;


import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class StudentPDFExporter {


            private List<StudentDetailDTO> studentDetailDTOS;

        public StudentPDFExporter(List<StudentDetailDTO> studentDetailDTOS) {
            this.studentDetailDTOS = studentDetailDTOS;
        }

        private void writeTableHeader(PdfPTable table) {
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(Color.BLUE);
            cell.setPadding(5);

            com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
            font.setColor(Color.WHITE);

            cell.setPhrase(new Phrase("Email", font));

            table.addCell(cell);

            cell.setPhrase(new Phrase("FullName", font));
            table.addCell(cell);


        }

        private void writeTableData(PdfPTable table) {
            for (StudentDetailDTO studentDetailDTO : studentDetailDTOS) {

                table.addCell(studentDetailDTO.getEmail());
                table.addCell(studentDetailDTO.getFullName());


            }
        }

        public void export(HttpServletResponse response) throws IOException, DocumentException {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            font.setSize(18);
            font.setColor(Color.BLUE);

            Paragraph p = new Paragraph("List of Students", font);
            p.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p);

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100f);
            table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
            table.setSpacingBefore(10);

            writeTableHeader(table);
            writeTableData(table);

            document.add(table);

            document.close();

        }




}
