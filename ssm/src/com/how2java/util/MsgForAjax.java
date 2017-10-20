package com.how2java.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用于对ajax请求返回数据的格式封装
 * @author Administrator
 *
 */
public class MsgForAjax {
	/**
	 * {"success":true}
	 * @param msg
	 * @return
	 */
	public static Map<String, Object> sendSucc(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}

	/**
	 * {"success":true,"msg":msg}
	 * @param msg
	 * @return
	 */
	public static Map<String, Object> sendSuccMsg(String msg){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("msg", msg);
		return result;
	}

	/**
	 * {"success":true,"flag":flag}
	 * @param msg
	 * @return
	 */
	public static Map<String, Object> sendSuccFlag(int flag){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("flag", flag);
		return result;
	}
	
	/**
	 * {"success":true,"msg":msg,"flag":flag}
	 * @param msg
	 * @param flag
	 * @return
	 */
	public static Map<String, Object> sendSuccMsgFlag(String msg, int flag){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("msg", msg);
		result.put("flag", flag);
		return result;
	}

	/**
	 * {"success":true,"data":data,"totalCount":totalCount}
	 * @param msg
	 * @return
	 */
	public static Map<String, Object> sendSuccData(Object data, int totalCount,int iTotalDisplayRecords,String sEcho){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("aaData", data);
		result.put("iTotalRecords", totalCount);
		result.put("iTotalDisplayRecords", iTotalDisplayRecords);
		result.put("sEcho", sEcho);
		
		return result;
	}
	
	/**
	 * {"success":true,"data":data}
	 * @param data
	 * @return
	 */
	public static Map<String, Object> sendSuccData(Object data){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("data", data);

		return result;
	}
	
	/**
	 * {"success":true,"data":data}
	 * @param data
	 * @return
	 */
	public static Map<String, Object> sendData(Object data){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("data", data);

		return result;
	}


	/**
	 * {"success":false}
	 * @return
	 */
	public static Map<String, Object> sendFail(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		return result;
	}

	/**
	 * {"success":false,"msg":msg}
	 * @return
	 */
	public static Map<String, Object> sendFailMsg(String msg){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("msg", msg);
		return result;
	}

	/**
	 * {"success":false,"data":data}
	 * @return
	 */
	public static Map<String, Object> sendFailMsg(Object data){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("data", data);
		return result;
	}
	
	/**
	 * {"success":false,"msg":msg,"flag":flag}
	 * @param msg
	 * @param flag
	 * @return
	 */
	public static Map<String, Object> sendFailMsgFlag(String msg, int flag){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("msg", msg);
		result.put("flag", flag);
		return result;
	}
	
	/**
	 * 返回json字符串
	 * @param map
	 * @return
	 */
	public static String sendAsJson(Object param){
		return MsgForAjax.buildJson(param);
	}
	
	public static String buildJson(Object param){
		StringBuffer buf = new StringBuffer();
		if(param instanceof Map){
			buf.append("{");
			Map map = (Map)param;
			Set keys = map.keySet();
			Iterator iter = keys.iterator();
			Object tempKey = "";
			int count = 0;
			while(iter.hasNext()){
				tempKey = iter.next();
				Object obj = map.get(tempKey);
				buf.append("\"").append(tempKey).append("\":");
				buf.append(buildJson(obj));
				if(count < keys.size() - 1){
					buf.append(",");
				}
				count++;
			}
			buf.append("}");
		}else if(param instanceof List){
			buf.append("[");
			List list = (List)param;
			for(int i = 0; i < list.size(); i++){
				buf.append(buildJson(list.get(i)));
				if(i < list.size() - 1){
					buf.append(",");
				}
			}
			buf.append("]");
		}else if(param instanceof Integer || 
				param instanceof Double || 
				param instanceof Float || 
				param instanceof Boolean || 
				param instanceof Long || 
				param instanceof Byte || 
				param instanceof Short){
			buf.append(param);
		}else if(param instanceof String || 
				param instanceof Date || 
				param instanceof Character){
			buf.append("\"").append(param).append("\"");
		}
		return buf.toString();
	}
}
