package com.sn.utilities;

import java.util.ArrayList;

public class TestUtil
{
	
	static Xls_Reader reader;
	public static ArrayList<Object[]> getDataFromExcel(String Sheetname)
	{
		ArrayList<Object[]> myData=new ArrayList<Object[]>();
		try 
		{
			
			reader=new Xls_Reader("C:\\Users\\GT\\Desktop\\AFT ServiceNow Project\\SN-POC\\src\\main\\java\\com\\sn\\resources\\TestData1.xlsx");
			//reader=new Xls_Reader("C:\\Users\\GT\\Desktop\\AFT ServiceNow Project\\SN-POC\\src\\main\\java\\com\\sn\\resources\\TestData2.xlsx");
			reader.addColumn("IncidentData","status");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int rowNum=2;rowNum<=reader.getRowCount(Sheetname);rowNum++)
		{
			if(Sheetname.equals("IncidentData") )
			{
			String Caller=reader.getCellData("IncidentData","Caller",rowNum);
			System.out.println(Caller);
			String Shortdiscription=reader.getCellData("IncidentData","Shortdiscription",rowNum);
			System.out.println(Shortdiscription);
			reader.setCellData("IncidentData","status", rowNum, "Pass");
			
			Object ob[]= {Caller, Shortdiscription};
			myData.add(ob);
			}
			else
			{
			String Caller=reader.getCellData("ChildIncidentData","Caller",rowNum);
			System.out.println(Caller);
			String Shortdiscription=reader.getCellData("ChildIncidentData","Shortdiscription",rowNum);
			System.out.println(Shortdiscription);
			String Childcaller=reader.getCellData("ChildIncidentData","Childcaller",rowNum);
			System.out.println(Childcaller);
			String ChildShortdescription=reader.getCellData("IncidentData","childshortdescr",rowNum);
			System.out.println(ChildShortdescription);
			//reader.setCellData("ChildIncidentData","status", rowNum, "Pass");
			
			Object ob2[]= {Caller,Shortdiscription,Childcaller, ChildShortdescription};
			myData.add(ob2);
			}
		}
		return myData;
		
	}
	

}