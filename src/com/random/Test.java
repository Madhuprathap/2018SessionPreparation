package com.random;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	private static String input = "{\"items\":[{\"referenceKey\":\"TENANT\",\"recordId\":\"FBA17E28CAAB4A7387A44BEE77240E33\",\"referenceKey\":\"TENANT\",\"name\":\"Knowledge\",\"links\":[{\"rel\":\"canonical\",\"href\":\"http://localhost:7202/km/api/latest/views/FBA17E28CAAB4A7387A44BEE77240E33\",\"mediaType\":\"application/json, application/xml\",\"method\":\"GET\"},{\"rel\":\"collection\",\"href\":\"http://localhost:7202/km/api/latest/views\",\"mediaType\":\"application/json, application/xml\",\"method\":\"GET\",\"profile\":\"http://localhost:7202/km/api/latest/metadata-catalog/views\"}],\"dateAdded\":\"1970-01-01T23:11:11-0800\",\"dateModified\":\"2019-04-15T15:27:07-0700\",\"objectId\":\"001\"}],\"hasMore\":false,\"limit\":20,\"offset\":0,\"links\":[{\"rel\":\"canonical\",\"href\":\"http://localhost:7202/km/api/latest/views?limit=20&offset=0&q=referenceKey eq 'TENANT'\",\"mediaType\":\"application/json, application/xml\",\"method\":\"GET\"}],\"count\":1}";

	public static void main(String[] args) {
		Pattern p = Pattern.compile("\"recordId\":\"([A-Z0-9]+)\",\"referenceKey\":\"TENANT\"", Pattern.CASE_INSENSITIVE); 
		Matcher m = p.matcher(input);
		if (m.find()) {
			System.out.println( m.start());
		}
		
		int startIndex = input.indexOf("\"recordId");
        int endIndex = input.indexOf(",\"links\":");
        String viewJson = "[{" + input.substring(startIndex, endIndex) + "}]";
        System.err.println("View JSON: " + viewJson);
        
        Long t = new Date().getTime();
        System.out.println(t);
        Date d = new Date(t.longValue());
        System.out.println(new java.sql.Timestamp(d.getTime()));
        
	}

}
