package com.dbuntensil.root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dbuntensil.bean.DboConfig;

public class Application {
	
	public static void main (String [] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.114.129:3306/Heda", "root", "final1234!");
		System.out.println(connection);
		
		
		String sqlStr = "select watermeter,station,flow_front,flow_reverse,flow_moment,electricity,voltage,station_tag,comment_ "
				+ "from hdfinecomm_dbo_config20220331 where watermeter = ''";
		PreparedStatement prepareStatement = connection.prepareStatement(sqlStr);
		ResultSet executeQuery = prepareStatement.executeQuery();
		List<DboConfig> confList = new ArrayList<DboConfig>(executeQuery.getFetchSize());
		
		while(executeQuery.next())
		{
			 DboConfig dbo = new DboConfig();
			 dbo.setWatermeter(executeQuery.getString("watermeter"));
			 dbo.setStation(executeQuery.getString("station"));
			 dbo.setFlow_front(executeQuery.getString("flow_front"));
			 dbo.setFlow_reverse(executeQuery.getString("flow_reverse"));
			 dbo.setFlow_moment(executeQuery.getString("flow_moment"));
			 dbo.setElectricity(executeQuery.getString("electricity"));
			 dbo.setVoltage(executeQuery.getString("voltage"));
			 dbo.setStation_tag(executeQuery.getString("station_tag"));
			 dbo.setComment_(executeQuery.getString("comment_"));
			 confList.add(dbo);
		}
		
//		Map<String,String> kv = new HashMap<String,String>();
//		kv.put("prefix", "PTAD");
//		kv.put("P1", "P1");
//		kv.put("P2", "P2");
//		kv.put("A1", "A1");
//		kv.put("A2", "A2");
//		kv.put("A4", "A4");
//		kv.put("A7", "A7");
//		kv.put("V1", "V");
//		kv.put("dash", "_");
		
		String prefix = "PTAD";
	    String P1 = "P1";
	    String P2 = "P2";
	    String A1 = "A1";
	    String A2 = "A2";
	    String A4 = "A4";
	    String A7 = "A7";
	    String V1 =  "V";
		String dash = "_";
		String v_flow_front;
		String v_flow_reverse;
		String v_flow_moment ;
		String v_electricity;
		String statemInsert ="INSERT INTO HDfinecomm.dbo.config (Watermeter, StationNo, ZXLJ, FXLJ, SSLL, DCDY) VALUES ";
		String statemValue = "";
		for( int i = 0; i < confList.size(); i++)
		{
			DboConfig dboConfig = confList.get(i);
			String station = dboConfig.getStation();
			String watermeter = dboConfig.getWatermeter();

			if (station.startsWith("HD86Q"))
			{
				v_flow_front = prefix + dash + station + dash + P1;
				v_flow_reverse = prefix + dash + station + dash + P2;
				v_flow_moment = prefix + dash + station + dash + A7;
				v_electricity = prefix + dash + station + dash + A4;
			}else
			{
				v_flow_front = prefix + dash + station + dash + P1;
				v_flow_reverse = prefix + dash + station + dash + P2;
				v_flow_moment = prefix + dash + station + dash + A1;
				v_electricity = prefix + dash + station + dash + A2;
			}

			statemValue = "("+ appendBeforAndAfter(watermeter,"'") + ", " + appendBeforAndAfter(station,"'") + ", " 
			+ appendBeforAndAfter(v_flow_front,"'") +  ", " + 
			appendBeforAndAfter(v_flow_reverse,"'") + ", " + 
			appendBeforAndAfter(v_flow_moment,"'") + ", " + 
			appendBeforAndAfter(v_electricity,"'") +")";
			System.out.println(statemInsert + statemValue);
		}
		
	}


	 static String appendBeforAndAfter(String str,String apStr)
	{
		String rv = apStr + str +apStr;
			
		return rv;
	}
}

