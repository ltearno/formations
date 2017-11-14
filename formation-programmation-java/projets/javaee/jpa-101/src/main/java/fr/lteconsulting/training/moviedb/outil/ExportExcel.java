package fr.lteconsulting.training.moviedb.outil;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.Date;

public class ExportExcel {
    private Workbook workbook;
    private Sheet sheet;

    private final CellStyle intCellStyle;
    private final CellStyle doubleCellStyle;
    private final CellStyle textCellStyle;

    private int currentLine = 0;

    public ExportExcel() {
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet();

        workbook.setSheetName(0, "Movie Database export " + new Date());

        DataFormat df = workbook.createDataFormat();
        doubleCellStyle = workbook.createCellStyle();
        doubleCellStyle.setDataFormat(df.getFormat("#,##0.0"));

        intCellStyle = workbook.createCellStyle();
        intCellStyle.setDataFormat(df.getFormat("#"));

        textCellStyle = workbook.createCellStyle();
        textCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("text"));
    }

    public void line(Object... cellValues) {
        Row row = sheet.createRow(currentLine++);

        for (int c = 0; c < cellValues.length; c++) {
            Object cellValue = cellValues[c];

            Cell cell = row.createCell(c);
            cell.setCellValue(cellValue.toString());

            if (cellValue instanceof String)
                cell.setCellStyle(textCellStyle);
            else if (cellValue instanceof Integer)
                cell.setCellStyle(intCellStyle);
            else if (cellValue instanceof Double)
                cell.setCellStyle(doubleCellStyle);
        }
    }

    public void write(ServletOutputStream outputStream) throws IOException {
        workbook.write(outputStream);
    }
}