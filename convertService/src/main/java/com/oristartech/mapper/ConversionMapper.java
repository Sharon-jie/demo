package com.oristartech.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

import com.oristartech.pojo.Conversion;

@Mapper
public interface ConversionMapper {
    
	/**
	 * 根据兑换码查询兑换券信息
	 * @param convertCode 兑换码
 	 * @return 兑换券信息
	 */
	public Conversion checkByConvertCode(String convertCode);
	
	/**
	 * 根据兑换码和日期查询兑换券状态
	 * @param convertCode
	 * @param date
	 * @return
	 */
	//public Conversion checkByConvertCode(String convertCode,Date date);
	
	
	/**
	 * 根据兑换码和状态值更改兑换券状态
	 * @param convertCode 兑换码
	 * @param statusCode 状态
	 * @return 1：表示成功 0：表示失败
	 */
	public int updateStatus(String convertCode,int statusCode);
	
	/**
	 * 根据兑换码更改兑换券状态
	 * @param convertCode 兑换码
	 * @return
	 */
	public int updateStatusByDate(String convertCode,Date date);
	
	
}
