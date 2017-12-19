package com.oristartech.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.oristartech.mapper.ConversionMapper;
import com.oristartech.pojo.Conversion;
import com.oristartech.service.ConversionMessageProvide;

@Service(loadbalance="roundrobin")
public class ConversionMessageProvideImpl implements ConversionMessageProvide {

	@Autowired
	private ConversionMapper mapper;
	
	
	@Override
	public Conversion checkByConvertCode(String convertCode) {
		Conversion convert = this.mapper.checkByConvertCode(convertCode);
		//判断兑换券真假
		if(convert == null){
			return null;
		}
		//判断兑换券是否使用
		if(convert.getStatus() == 2){
			return convert;
		}
		Date today = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String td = df.format(today);
		String ed = df.format(convert.getExpiration_date());
		try {
			today = df.parse(td);
			Date expiration = df.parse(ed);
			//判断兑换券是否过期
			if(today.getTime() > expiration.getTime()){
				convert.setStatus(3);
				this.mapper.updateStatus(convertCode, 3);
				return convert;
			}
			return convert;
		} catch (Exception e) {
			convert.setStatus(5);
			return convert;
		}
	}

	@Override
	public int updateStatus(String convertCode) {
		int status = this.mapper.updateStatusByDate(convertCode,new Date());
		return status;
	}
}
