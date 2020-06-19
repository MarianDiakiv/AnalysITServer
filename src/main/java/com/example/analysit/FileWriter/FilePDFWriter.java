package com.example.analysit.FileWriter;

import com.example.analysit.JsonModel.CompanyCountVacancy;
import com.example.analysit.JsonModel.LanguageStatistics.ConteinerLanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageCount;
import com.example.analysit.JsonModel.LanguageStatistics.LanguageStatistics;
import com.example.analysit.ServiceIml.StatisticsServiceImpl;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.text.Position;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FilePDFWriter {
    public Font chapterFont = FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLACK);
    public Font sectionFont = FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLACK);
    public Font fontHeaderTable = FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.NORMAL,BaseColor.BLACK);
    public void writePdf(){

        Document document = new Document();
//        Font chapterFont = FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.BLACK);
//        Font sectionFont = FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLACK);
//        Font fontHeaderTable = FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLACK);
        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream("src/main/resources/static/StatisticsFilePDF.pdf"));
            document.open();
            //create Chapter
//            Paragraph paragraphChapterTitle = new Paragraph("Statisc from Site",chapterFont);
            Chapter chapter1 = new Chapter(new Paragraph("Count of Vacancy "),1);
            chapter1.setNumberDepth(0);

            // create sections
            Paragraph paragraphSectionTitle = new Paragraph("Number of vacancies from the current sample in each programming language",sectionFont);
            Section section1 = chapter1.addSection(paragraphSectionTitle);

//            Paragraph paragraphSectionContent = new Paragraph("SectionContent");
            PdfPTable table = createLangTableOne();
            section1.add(new Paragraph("",sectionFont));
            addEmptyLine(section1,5);
            section1.add(table);

            Paragraph paragraphSectionTwo = new Paragraph("Number of vacancies in the last 5 samples in each programming language",sectionFont);
            Section section2 = chapter1.addSection(paragraphSectionTwo);

            PdfPTable table1 = createLangTableTwo();
            section2.add(new Paragraph("",sectionFont));
            addEmptyLine(section2,5);
            section2.add(table1);

            Paragraph paragraphSectionThree = new Paragraph("Number of subscriptions for each programming language",sectionFont);
            Section section3 = chapter1.addSection(paragraphSectionThree);
            PdfPTable table3 = createTable3();
            addEmptyLine(section3,5);
            section3.add(table3);


            Paragraph paragraphSectionFour = new Paragraph("Top 10 companies by number of vacancies in all positions and programming languages",sectionFont);
            Section section4 = chapter1.addSection(paragraphSectionFour);
            PdfPTable table4 = createTable4();
            addEmptyLine(section4,5);
            section4.add(table4);



            document.add(chapter1);
            document.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("WRITEDPDF");
    }
    public PdfPTable createLangTableOne(){
        PdfPTable table = new PdfPTable(13);
        // add cols
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();
        LanguageStatistics languageStatistics =  statisticsService.getStatisticsByNowTime();
        ArrayList<LanguageCount> languageCounts = languageStatistics.getCountArrayList();
        languageCounts.stream().forEach(columnTitle->{
            PdfPCell header = new PdfPCell();
//
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(columnTitle.getLanguage(),fontHeaderTable));
            table.addCell(header);
        });
        table.setHeaderRows(1);

        LanguageStatistics languageStatistics2 =  statisticsService.getStatisticsByNowTime();
        ArrayList<LanguageCount> languageCounts2 = languageStatistics2.getCountArrayList();
        languageCounts2.stream().forEach(columnTitle->{
            table.addCell(""+columnTitle.getCount());
        });

        return table;
    }

    public PdfPTable createLangTableTwo(){
        PdfPTable table  = new PdfPTable(14);
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();
        ConteinerLanguageCount languageCount = statisticsService.getStatisticsAll();
        ArrayList<LanguageStatistics> templist = languageCount.getCountArrayList();
        // потрібні лише мови
        LanguageStatistics languageStatistics = templist.get(0);
        ArrayList<LanguageCount> languageCounts = languageStatistics.getCountArrayList();
        PdfPCell headerData = new PdfPCell();
        headerData.setPhrase(new Phrase("Date",fontHeaderTable));
        headerData.setBorderWidth(1);
        table.addCell(headerData);
        languageCounts.stream().forEach(columnTitle->{
            PdfPCell header = new PdfPCell();
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(columnTitle.getLanguage(),fontHeaderTable));
            table.addCell(header);
        });
        table.setHeaderRows(1);

        // заповнення рядків.
        for (LanguageStatistics ls:templist){
            ArrayList<LanguageCount> temp = ls.getCountArrayList();
            table.addCell(""+ls.getData());
            temp.stream().forEach(columnTitle->{
                table.addCell(""+columnTitle.getCount());
            });
        }

        return  table;
    }
    public PdfPTable createTable3(){
        PdfPTable table = new PdfPTable(13);
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();
        LanguageStatistics languageStatistics = statisticsService.getUserInterestings();
        ArrayList<LanguageCount> languageCounts = languageStatistics.getCountArrayList();
        // cols
        languageCounts.stream().forEach(columnTitle->{
            PdfPCell header = new PdfPCell();
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(columnTitle.getLanguage(),fontHeaderTable));
            table.addCell(header);
        });
        //rows
        languageCounts.stream().forEach(columnTitle->{
            table.addCell(""+columnTitle.getCount());
        });
        return table;

    }
    public PdfPTable createTable4(){
        PdfPTable table = new PdfPTable(2);
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();
        ArrayList<CompanyCountVacancy>  companyCountVacancies = statisticsService.getCountVacancyByCompany();
        PdfPCell header1 = new PdfPCell();
        header1.setPhrase(new Phrase("Company",fontHeaderTable));
        PdfPCell header2 = new PdfPCell();
        header2.setPhrase(new Phrase("Count",fontHeaderTable));
        table.addCell(header1);
        table.addCell(header2);
        table.setHeaderRows(1);


        companyCountVacancies.stream().forEach(columnTitle->{
            table.addCell(""+columnTitle.getCompany());
            table.addCell(""+columnTitle.getCount());
        });

        return table;
    }
    public void addEmptyLine(Section section,int count){
        for (int i=0;i<count;i++);
        section.add(new Paragraph("                                                                                "));
    }





    private void addTableHeader(PdfPTable table){
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();
        LanguageStatistics languageStatistics =  statisticsService.getStatisticsByNowTime();
        ArrayList<LanguageCount> languageCounts = languageStatistics.getCountArrayList();
        languageCounts.stream().forEach(columnTitle->{
            PdfPCell header = new PdfPCell();
//                    header.setBackgroundColor(BaseColor.GREEN);
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(columnTitle.getLanguage()));
            table.addCell(header);
        });

    }
    private void addRows(PdfPTable table) {
        table.setHeaderRows(1);
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();
        LanguageStatistics languageStatistics =  statisticsService.getStatisticsByNowTime();
        ArrayList<LanguageCount> languageCounts = languageStatistics.getCountArrayList();
        languageCounts.stream().forEach(columnTitle->{
            table.addCell(""+columnTitle.getCount());
        });
    }

    private void addTableHEader2(PdfPTable table){
        StatisticsServiceImpl statisticsService = new StatisticsServiceImpl();

    }
    private void addCustomRows(PdfPTable table){
        try {
//            Path path = Paths.get(ClassLoader.getSystemResource("JavaC.png").toURI());
//            Image image = Image.getInstance(path.toAbsolutePath().toString());
//            image.scalePercent(10);
//            PdfPCell imageCell = new PdfPCell(image);
//            table.addCell(imageCell);
            PdfPCell horizontalAlignCell1 = new PdfPCell(new Phrase("row 2, col 1 "));
            horizontalAlignCell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(horizontalAlignCell1);


            PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2 "));
            horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(horizontalAlignCell);

            PdfPCell verticalAlighentCell = new PdfPCell(new Phrase("row 2 col 3"));
            verticalAlighentCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
            table.addCell(verticalAlighentCell);
        }catch (Exception e){
            System.out.println("ERROR " + e.getMessage());
        }
    }
    public void addEmptyLine( Paragraph paragraph, int number ){
//        Paragraph paragraph = new Paragraph();
        for (int i=0;i<number;i++){
            paragraph.add(new Paragraph(""));
        }
//        return paragraph;

    }
}
