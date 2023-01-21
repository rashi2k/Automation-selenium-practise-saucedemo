package utility;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataUtils {

	private static Logger Log = LogManager.getLogger(DataUtils.class.getName());
	
	static String filePath = System.getProperty("user.dir") + "\\resources\\" + "TestData.xlsx";
	
	public static String getTestData(String sheetname, String id, String field) {
		String value = null;
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(filePath);
			String strQuery = "Select * from " + sheetname + " " + "where ID='" + id + "'";
			Recordset recordset = null;
			recordset = connection.executeQuery(strQuery);
			while (recordset.next()) {
				value = recordset.getField(field);
			}
			recordset.close();
			connection.close();
		}
		catch (Exception e) {
			e.getMessage();
			Log.error("unable to read data from file");
		}
		return value;
	}
	
}
