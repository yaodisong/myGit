package com.how2java.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于日期的格式化
 * @author Administrator
 *
 */
public class DateFormatUtil {
		
		private static SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
		private static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		private static SimpleDateFormat dateFormat3 = new SimpleDateFormat("yyyy年MM月dd日");
		private static SimpleDateFormat dateFormat4 = new SimpleDateFormat("yyyyMMddHHmmss");
		private static SimpleDateFormat dateFormat5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		private static SimpleDateFormat dateFormat6 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		
		/**
		 * 时间格式化, 默认格式:yyyy-MM-dd HH:mm:ss
		 * 
		 * @param date 时间
		 * @param format 格式
		 * @return
		 */
		public static String format(Date date, String format){
			if(format.equals("yyyyMMdd")){
				// yyyyMMdd
				return dateFormat1.format(date);
			}else if(format.equals("yyyy-MM-dd")){
				// yyyy-MM-dd
				return dateFormat2.format(date);
			}else if(format.equals("yyyy年MM月dd日")){
				// yyyy年MM月dd日
				return dateFormat3.format(date);
			}else if(format.equals("yyyyMMddHHmmss")){
				// yyyyMMddHHmmss
				return dateFormat4.format(date);
			}else if(format.equals("yyyy-MM-dd HH:mm:ss")){
				// yyyy-MM-dd HH:mm:ss
				return dateFormat5.format(date);
			}else if(format.equals("yyyy年MM月dd日 HH时mm分ss秒")){
				// yyyy年MM月dd日 HH时mm分ss秒
				return dateFormat6.format(date);
			}else{
				// yyyy-MM-dd HH:mm:ss
				return dateFormat5.format(date);
			}
		}
		
	}

