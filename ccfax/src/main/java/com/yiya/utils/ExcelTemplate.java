package com.yiya.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.yiya.bean.GoodsStock;

/**
 * 用于处理Excel写操作
 */
public class ExcelTemplate {
	// 开始位置
	public final static String TEMPLATE_NAME = "datastart";
	// 样式,用于要标志自定义的样式的列.
	public final static String STYLE = "style";
	// 默认样式
	public final static String DEFALULT_STYLE = "defaultStyle";
	// 序号,确定Excel是否需要样式.
	public final static String SERNUMS = "sernums";
	private int initRowIndex; // 初始行
	private int initColIndex; // 初始列
	private int curRowIndex; // 当前行
	private int curColIndex; // 当前列
	private int lastRowInex; // 最后一行
	private float defaultHeight; // 默认行高
	private int serColIndex; // 序号行.
	private Workbook workbook = null;
	private Sheet sheet = null;
	private Row curRow = null; // 当前行
	// 样式
	private Map<Integer, CellStyle> styles = null;
	// 默认样式
	private CellStyle defaultStyle = null;
	// 使用单例
	private static ExcelTemplate excel = new ExcelTemplate();

	private ExcelTemplate() {
	}

	public static ExcelTemplate getInstance() {
		return excel;
	}

	/**
	 * 读取模板(从classpath中)
	 * 
	 * @param path
	 *            模板路径
	 * @return ExcelTemplate
	 */
	public ExcelTemplate readTemplateClassPath(String calsspath) {
		try {
			workbook = WorkbookFactory.create(ExcelTemplate.class
					.getResourceAsStream(calsspath));
			initTemplate();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板格式有错!请检查.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板文件不存在!请检查.");
		}
		return this;
	}

	/**
	 * 读取模板(从指定路径)
	 * 
	 * @param path
	 *            模板路径
	 * @return ExcelTemplate
	 */
	public ExcelTemplate readTemplatePath(String path) {
		try {
			workbook = WorkbookFactory.create(new File(path));
			initTemplate();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板格式有错!请检查.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取模板文件不存在!请检查.");
		}
		return this;
	}

	/**
	 * 创建新的一行
	 */
	public void creatNewRow() {
		// curRowIndex != initRowIndxe : 当前行本身是存在的,所以下移多余.
		if (lastRowInex > curRowIndex && curRowIndex != initRowIndex) {
			sheet.shiftRows(curRowIndex, lastRowInex, 1, true, true); // 有的模板最后可能是日期或者姓名之类的非数据.所以要移动行.
			lastRowInex++;
		}
		curRow = sheet.createRow(curRowIndex);
		curRow.setHeightInPoints(defaultHeight);
		curRowIndex++;
		curColIndex = initColIndex;
	}

	public void createNewCol(String value) {
		Cell cell = curRow.createCell(curColIndex);
		setStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}

	public void createNewCol(double value) {
		Cell cell = curRow.createCell(curColIndex);
		setStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}

	public void createNewCol(boolean value) {
		Cell cell = curRow.createCell(curColIndex);
		setStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}

	public void createNewCol(Date value) {
		Cell cell = curRow.createCell(curColIndex);
		setStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}

	public void createNewCol(Calendar value) {
		Cell cell = curRow.createCell(curColIndex);
		setStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}

	public void createNewCol(RichTextString value) {
		Cell cell = curRow.createCell(curColIndex);
		setStyle(cell);
		cell.setCellValue(value);
		curColIndex++;
	}

	/**
	 * 根据#xxx替换模板中的其它样式.
	 * 
	 * @param datas
	 *            要替换的数据
	 */
	public void replaceFind(Map<String, String> datas) {
		if (datas == null)
			return;
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() != Cell.CELL_TYPE_STRING)
					continue;
				String value = cell.getStringCellValue().trim();
				if (value.startsWith("#")) {
					if (datas.containsKey(value.substring(1))) {
						cell.setCellValue(datas.get(value.substring(1)));
					}
				}
			}
		}
	}

	/**
	 * 插入序号
	 */
	public void insertSer() {
		int index = 1;
		Row row = null;
		Cell cell = null;
		for (int i = initRowIndex; i < curRowIndex; i++) {
			row = sheet.getRow(i);
			cell = row.createCell(serColIndex);
			setStyle(cell);
			cell.setCellValue(index++);
		}
	}

	/**
	 * 输出文件,根据路径
	 * 
	 * @param path
	 *            路径
	 */
	public void writeToFile(String path) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到文件!请检查.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("文件输出异常!请检查.");
		} finally {
			try {
				if (fos != null) {
					fos.close();
					fos = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 输出文件,根据流输出
	 * 
	 * @param stream
	 *            OutputStream
	 */
	public void writeToStream(OutputStream stream) {
		try {
			workbook.write(stream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("文件输出异常!请检查.");
		} finally {
			try {
				if (stream != null) {
					stream.close();
					stream = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 初始化模板
	 */
	private void initTemplate() {
		sheet = workbook.getSheetAt(0);
		styles = new HashMap<Integer, CellStyle>();
		initConfigData();
		lastRowInex = sheet.getLastRowNum();
	}

	/**
	 * defaultStyles:获得默认样式(如果默认样式没有则使用开始样式) styles:获取自定义样式
	 * 
	 */
	private void initConfigData() {
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() != Cell.CELL_TYPE_STRING)
					continue;
				String value = cell.getStringCellValue().trim();
				// 获取开始位置,初始化数据
				if (TEMPLATE_NAME.equals(value)) {
					initRowIndex = cell.getRowIndex();
					initColIndex = cell.getColumnIndex();
					curRowIndex = initRowIndex;
					curColIndex = initColIndex;
					defaultHeight = row.getHeightInPoints();
					if (defaultStyle == null)
						defaultStyle = cell.getCellStyle();
				}
				// 获取defaultStyles,无论如何,当有设置defaultStyles都设置为defaultStyles
				if (DEFALULT_STYLE.equals(value))
					defaultStyle = cell.getCellStyle();
				// 获取自定义样式的列
				if (STYLE.equals(value)) {
					styles.put(cell.getColumnIndex(), cell.getCellStyle());
				}
				// 获取样式所在的列
				if (SERNUMS.equals(value))
					serColIndex = cell.getColumnIndex();
			}
		}
	}

	/**
	 * 设置样式
	 * 
	 * @param cell
	 *            Cell
	 */
	private void setStyle(Cell cell) {
		// 当前列存在自定义样式时使用自定义样式,否则使用默认样式.
		if (styles.containsKey(curColIndex)) {
			cell.setCellStyle(styles.get(curColIndex));
		} else {
			cell.setCellStyle(defaultStyle);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void exportExcel(String title, String[] headers,
			Collection<GoodsStock> dataset, OutputStream out, String pattern) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
		// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
		comment.setAuthor("lijiaming");
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		// 遍历集合数据，产生数据行
		Iterator<GoodsStock> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			GoodsStock t = (GoodsStock) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				try {
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
							new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					// if (value instanceof Integer) {
					// int intValue = (Integer) value;
					// cell.setCellValue(intValue);
					// } else if (value instanceof Float) {
					// float fValue = (Float) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(fValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Double) {
					// double dValue = (Double) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(dValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Long) {
					// long longValue = (Long) value;
					// cell.setCellValue(longValue);
					// }
					if(value ==null){
						textValue = "";
					}else if (value instanceof Boolean) {
						boolean bValue = (Boolean) value;
						textValue = "0";
						if (!bValue) {
							textValue = "-1";
						}
					} else if (value instanceof Date) {
						Date date = (Date) value;
						SimpleDateFormat sdf = new SimpleDateFormat(pattern);
						textValue = sdf.format(date);
					} else if (value instanceof byte[]) {
						// 有图片时，设置行高为60px;
						row.setHeightInPoints(60);
						// 设置图片所在列宽度为80px,注意这里单位的一个换算
						sheet.setColumnWidth(i, (short) (35.7 * 80));
						// sheet.autoSizeColumn(i);
						byte[] bsValue = (byte[]) value;
						HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
								1023, 255, (short) 6, index, (short) 6, index);
//						anchor.setAnchorType(2);  //写入图片
						patriarch.createPicture(anchor, workbook.addPicture(
								bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
					} else {
						// 其它数据类型都当作字符串简单处理
						textValue = value.toString();
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != null) {
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches()) {
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						} else {
							HSSFRichTextString richString = new HSSFRichTextString(
									textValue);
							HSSFFont font3 = workbook.createFont();
							font3.setColor(HSSFColor.BLUE.index);
							richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} finally {
					// 清理资源
				}
			}
		}
		try {
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
