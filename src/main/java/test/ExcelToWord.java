package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ExcelToWord {
    public static void main(String[] args) {
        // Excel文件路径和工作表名称
        String excelFilePath = "C:\\Users\\王强\\IdeaProjects\\JavaProject\\src\\main\\java\\test\\1.xlsx";
        String sheetName = "Sheet1";

        // Word文件路径
        String wordFilePath = "C:\\Users\\王强\\IdeaProjects\\JavaProject\\src\\main\\java\\test\\1.docx";

        try {
            // 读取Excel文件
            FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(excelFile);
            Sheet sheet = workbook.getSheet(sheetName);

            // 创建Word文档
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            // 遍历Excel工作表的行和单元格，并将数据写入Word文档
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    cell.getCellStyle().getFontIndex();
                    String cellValue = cell.getStringCellValue();
                    run.setText(cellValue + " ");
                }
                run.addBreak(); // 换行
            }

            // 保存Word文档
            FileOutputStream out = new FileOutputStream(wordFilePath);
            document.write(out);
            out.close();
            System.out.println("Word文档已创建成功！");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
