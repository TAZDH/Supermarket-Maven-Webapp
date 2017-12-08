package com.hs.convertor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConvertor implements Converter<String, Date> {
	private SimpleDateFormat sdf;
	
	public StringToDateConvertor(String format) {
		sdf = new SimpleDateFormat(format);
	}

	public Date convert(String str) {
		// TODO Auto-generated method stub
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
