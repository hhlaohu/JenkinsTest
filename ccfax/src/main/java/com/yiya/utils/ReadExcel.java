package com.yiya.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yiya.action.BaseAction;
import com.yiya.bean.PzGood;



/**
 * @author Hongten
 * @created 2014-5-20
 */
public class ReadExcel extends BaseAction{
    
    /**
     * read the Excel file
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
/*    public List<PzGood> readExcel(String path) throws IOException {
        if (path == null || Common.EMPTY.equals(path)) {
            return null;
        } else {
            String postfix = ReadExcel.getPostfix(path);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(path);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(path);
                }
            } else {
                System.out.println(path + Common.NOT_EXCEL_FILE);
            }
        }
        return null;
    }*/

    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
  /*  public List<PzGood> readXlsx(String path) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        PzGood pzGood = null;
        List<PzGood> list = new ArrayList<PzGood>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                	pzGood = new PzGood();
                    XSSFCell pz_good_name = xssfRow.getCell(0);
                    XSSFCell pz_good_place = xssfRow.getCell(1);
                    XSSFCell pz_good_level = xssfRow.getCell(2);
                    XSSFCell pz_good_size = xssfRow.getCell(3);
                    XSSFCell market_prices = xssfRow.getCell(4);
                    XSSFCell unit = xssfRow.getCell(5);
                    XSSFCell pledge_multiplier = xssfRow.getCell(6);
                    pzGood.setPz_good_name(getValue(pz_good_name));
                    pzGood.setPz_good_place(getValue(pz_good_place));
                    pzGood.setPz_good_level(new BigDecimal(getValue(pz_good_level)).intValue());
                    pzGood.setPz_good_size(getValue(pz_good_size));
                    pzGood.setMarket_prices((new BigDecimal(getValue(market_prices))));
                    pzGood.setUnit(getValue(unit));
                    pzGood.setPledge_multiplier((new BigDecimal(getValue(pledge_multiplier))));
                    list.add(pzGood);
                }
            }
        }
        return list;
    }*/

    /**
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @return
     * @throws IOException
     */
    public List<PzGood> readXls(String path,HttpServletResponse response) throws IOException {
    	List<PzGood> list = null;
    	try {
    		 /**只读取Excel文件**/
    		  if(path.lastIndexOf(".xls")>0 || path.lastIndexOf(".xlsx")>0){
    		  InputStream is = new FileInputStream(path);
    		  XSSFWorkbook xSSFWorkbook =  null;
    		  HSSFWorkbook hssfWorkbook = null;
    		  PzGood  pzGoods = new PzGood();
    		  
    		  if(path.lastIndexOf(".xls")>0 && path.lastIndexOf(".xlsx")>0){
    			  list = new ArrayList<PzGood>();
    		            XSSFWorkbook wb = new XSSFWorkbook(is);  
    		            XSSFCell cell = null;  
    		            for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {  
    		                XSSFSheet st = wb.getSheetAt(sheetIndex);  
    		                for (int rowIndex = 1; rowIndex <= st.getLastRowNum(); rowIndex++) {  
    		                    XSSFRow row = st.getRow(rowIndex);  
    		                    cell = row.getCell(0);  
    		                    cell.setCellType(XSSFCell.CELL_TYPE_STRING);  
    		                  	
    		                    XSSFCell pz_good_name = row.getCell(0);
    		                  	XSSFCell pz_good_place = row.getCell(1);
    		                  	XSSFCell pz_good_level = row.getCell(2);
    		                  	XSSFCell pz_good_size = row.getCell(3);
    		                  	XSSFCell market_prices = row.getCell(4);
    		                  	XSSFCell unit = row.getCell(5);
    		                  	XSSFCell pledge_multiplier = row.getCell(6);
	    	                    pzGoods.setPz_good_name(pz_good_name.toString());
	    	                    pzGoods.setPz_good_place(pz_good_place.toString());
	    	                    if(pz_good_level.toString().equals("顶级")){
	    	                    	pzGoods.setPz_good_level(1);
	    	                    }
	    	                    else if(pz_good_level.toString().equals("普一")){
	    	                    	pzGoods.setPz_good_level(2);
	    	                    }
	    	                    else if(pz_good_level.toString().equals("普二")){
	    	                    	pzGoods.setPz_good_level(3);
	    	                    }
	    	                    else if(pz_good_level.toString().equals("统材")){
	    	                    	pzGoods.setPz_good_level(4);
	    	                    }
	    	                    else{
	    	                    	pzGoods.setPz_good_level(new BigDecimal(getValue(pz_good_level)).intValue());
	    	                    }
	    	                    pzGoods.setPz_good_size(Integer.getInteger(getValue(pz_good_size)));
	    	                    pzGoods.setMarket_prices((new BigDecimal(getValue(market_prices))));
	    	                    pzGoods.setUnit(getValue(unit));
	    	                    pzGoods.setPledge_multiplier((new BigDecimal(getValue(pledge_multiplier))));
	    	                    list.add(pzGoods);
	    	                    pzGoods= new PzGood();
    		             
    		                      
    		                   
    		                }  
    		            }  
    		  }
    		  
    		  /**读取后缀名.xls文件**/
    		   if (path.lastIndexOf(".xls")>0 && path.lastIndexOf(".xlsx")<0 ) {  
    			   hssfWorkbook =  new HSSFWorkbook(is);
    			   PzGood pzGood = null;
    	    	      list = new ArrayList<PzGood>();
    	    	      for (int numSheet = 0; numSheet <= hssfWorkbook.getNumberOfSheets(); numSheet++) {
    	    	    	  
    	    	            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
    	    	            if (hssfSheet == null) {
    	    	                continue;
    	    	            }
    	    	            for (int rowNum = 1; rowNum <hssfSheet.getLastRowNum(); rowNum++) {
    	    	                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
    	    	                if (hssfRow != null) {
    	    	                	pzGood = new PzGood();
    	    	                	HSSFCell pz_good_name = hssfRow.getCell(0);
    	    	                	HSSFCell pz_good_place = hssfRow.getCell(1);
    	    	                	HSSFCell pz_good_level = hssfRow.getCell(2);
    	    	                	HSSFCell pz_good_size = hssfRow.getCell(3);
    	    	                	HSSFCell market_prices = hssfRow.getCell(4);
    	    	                	HSSFCell unit = hssfRow.getCell(5);
    	    	                	HSSFCell pledge_multiplier = hssfRow.getCell(6);
    	    	                    pzGood.setPz_good_name(getValue(pz_good_name).toString());
    	    	                    pzGood.setPz_good_place(getValue(pz_good_place));
    	    	                    if(pz_good_level.toString().equals("顶级")){
    	    	                    	pzGood.setPz_good_level(1);
    	    	                    }
    	    	                    else if(pz_good_level.toString().equals("普一")){
    	    	                    	pzGood.setPz_good_level(2);
    	    	                    }
    	    	                    else if(pz_good_level.toString().equals("普二")){
    	    	                    	pzGood.setPz_good_level(3);
    	    	                    }
    	    	                    else if(pz_good_level.toString().equals("统材")){
    	    	                    	pzGood.setPz_good_level(4);
    	    	                    }
    	    	                    else{
    	    	                    	pzGood.setPz_good_level(new BigDecimal(getValue(pz_good_level)).intValue());
    	    	                    }
    	    	                    pzGood.setPz_good_size(Integer.getInteger(getValue(pz_good_size)));
    	    	                    pzGood.setMarket_prices((new BigDecimal(getValue(market_prices))));
    	    	                    pzGood.setUnit(getValue(unit));
    	    	                    pzGood.setPledge_multiplier((new BigDecimal(getValue(pledge_multiplier))));
    	    	                    list.add(pzGood); 
    	    	                }
    	    	            }
    	    	        }
    	        }  
    		   
    		   /**读取后缀名.xlsx文件**/
    	       /* else if (path.lastIndexOf(".xlsx")>0) {  
    	        	// sendFailureMessage(response, "4");
    	        	 return null;
    	        	xSSFWorkbook = new XSSFWorkbook(is);  
    	        	  PzGood pzGood = null;
    	    	      list = new ArrayList<PzGood>();
    	    	      for (int numSheet = 0; numSheet < xSSFWorkbook.getNumberOfSheets(); numSheet++) {
    	    	    	  
    	    	            XSSFSheet hssfSheet = xSSFWorkbook.getSheetAt(numSheet);
    	    	            if (hssfSheet == null) {
    	    	                continue;
    	    	            }
    	    	            // Read the Row   // HSSFCell no = hssfRow.getCell(0);
    	    	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
    	    	                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
    	    	                if (hssfRow != null) {
    	    	                	pzGood = new PzGood();
    	    	                	XSSFCell pz_good_name = hssfRow.getCell(0);
    	    	                	XSSFCell pz_good_place = hssfRow.getCell(1);
    	    	                	XSSFCell pz_good_level = hssfRow.getCell(2);
    	    	                	XSSFCell pz_good_size = hssfRow.getCell(3);
    	    	                	XSSFCell market_prices = hssfRow.getCell(4);
    	    	                	XSSFCell unit = hssfRow.getCell(5);
    	    	                	XSSFCell pledge_multiplier = hssfRow.getCell(6);
    	    	                    pzGood.setPz_good_name(getValue(pz_good_name).toString());
    	    	                    pzGood.setPz_good_place(getValue(pz_good_place));
    	    	                    pzGood.setPz_good_level(new BigDecimal(getValue(pz_good_level)).intValue());
    	    	                    pzGood.setPz_good_size(getValue(pz_good_size));
    	    	                    pzGood.setMarket_prices((new BigDecimal(getValue(market_prices))));
    	    	                    pzGood.setUnit(getValue(unit));
    	    	                    pzGood.setPledge_multiplier((new BigDecimal(getValue(pledge_multiplier))));
    	    	                    list.add(pzGood); 
    	    	                }
    	    	            }
    	    	        }
    	        }  */
    		  }else{
    			  sendFailureMessage(response, "3");//返回不是Excel格式的文件
    			  return null;
    		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return list;
    }

    
    
    @SuppressWarnings({ "static-access", "unused" })
    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
    
   /* public static String getPostfix(String path) {
        if (path == null || Common.EMPTY.equals(path.trim())) {
            return Common.EMPTY;
        }
        if (path.contains(Common.POINT)) {
            return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
        }
        return Common.EMPTY;
    }*/
}