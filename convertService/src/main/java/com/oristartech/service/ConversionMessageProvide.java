package com.oristartech.service;

import java.util.Date;

import com.oristartech.pojo.Conversion;

public interface ConversionMessageProvide {
	/**
	 * 根据兑换码查询兑换券信息
	 * @param convertCode 兑换码
 	 * @return 兑换券信息
	 */
	public Conversion checkByConvertCode(String convertCode);
	
	/**
	 * 根据兑换码更改兑换券状态
	 * @param convertCode 兑换码
	 * @return
	 */
	public int updateStatus(String convertCode);
}
