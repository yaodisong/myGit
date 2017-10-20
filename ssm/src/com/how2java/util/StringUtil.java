package com.how2java.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字串工具类
 * 
 * @author Administrator
 */
public class StringUtil {

	private StringUtil() {
	}
	
	private static String[] chars = new String[]{
		"a","b","c","d","e","f","g","h", 
		"i","j","k","l","m","n","o","p", 
		"q","r","s","t","u","v","w","x", 
		"y","z","0","1","2","3","4","5", 
		"6","7","8","9","A","B","C","D", 
		"E","F","G","H","I","J","K","L", 
		"M","N","O","P","Q","R","S","T", 
		"U","V","W","X","Y","Z" 
		}; 

	/**
	 * 检查浮点数
	 * 
	 * @param num
	 * @param type
	 *            "0+":非负浮点数 "+":正浮点数 "-0":非正浮点数 "-":负浮点数 "":浮点数
	 * @return
	 */
	public static boolean checkFloat(String num, String type) {
		String eL = "";
		if (type.equals("0+"))
			eL = "^\\d+(\\.\\d+)?$";// 非负浮点数
		else if (type.equals("+"))
			eL = "^((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*))$";// 正浮点数
		else if (type.equals("-0"))
			eL = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";// 非正浮点数
		else if (type.equals("-"))
			eL = "^(-((\\d+\\.\\d*[1-9]\\d*)|(\\d*[1-9]\\d*\\.\\d+)|(\\d*[1-9]\\d*)))$";// 负浮点数
		else
			eL = "^(-?\\d+)(\\.\\d+)?$";// 浮点数
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(num);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 检测某字串是否存在某数组中
	 * 
	 * @param value
	 * @param array
	 * @return 存在返回真，不存在返回假
	 */
	public static boolean isInArray(String value, String[] array) {
		if (array == null)
			return false;
		for (String v : array) {
			if (v.equals(value))
				return true;
		}
		return false;

	}

	public static boolean isInArray(int value, String[] array) {
		if (array == null)
			return false;
		for (String v : array) {
			if (Integer.valueOf(v).intValue() == value)
				return true;
		}
		return false;

	}

	/**
	 * 将数组成str连接成字符串
	 * 
	 * @param str
	 * @param array
	 * @return
	 */
	public static String implode(String str, Object[] array) {
		if (str == null || array == null) {
			return "";
		}
		String result = "";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				result += array[i].toString();
			} else {
				result += array[i].toString() + str;
			}
		}
		return result;
	}

	public static String implodeValue(String str, Object[] array) {
		if (str == null || array == null) {
			return "";
		}
		String result = "";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				result += "?";
			} else {
				result += "?" + str;
			}
		}
		return result;
	}

	/**
	 * MD5加密方法
	 * 
	 * @param str
	 *            String
	 * @return String
	 */
	public static String md5(String s) {
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

	/**
	 * 验证Email地址是否有效
	 * 
	 * @param sEmail
	 * @return
	 */
	public static boolean validEmail(String sEmail) {
		String pattern = "^([a-z0-9A-Z]+[-|\\.|_]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return sEmail.matches(pattern);
	}

	/**
	 * 验证字符最大长度
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validMaxLen(String str, int length) {
		if (str == null && str.equals("")) {
			return false;
		}
		if (str.length() > length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 验证字符最小长度
	 * 
	 * @param str
	 * @return
	 */
	public static boolean validMinLen(String str, int length) {
		if (str == null && str.equals("")) {
			return false;
		}
		if (str.length() < length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 验证一个字符串是否为空
	 * 
	 * @param str
	 * @return 如果为空返回真，如果不为空返回假
	 */

	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str))
			return true;

		String pattern = "\\S";
		Pattern p = Pattern.compile(pattern, 2 | Pattern.DOTALL);
		Matcher m = p.matcher(str);
		return !m.find();

	}
	

	/**
	 * 验证两个字符串是否相等且不能为空
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals(String str1, String str2) {
		if (str1 == null || str1.equals("") || str2 == null || str2.equals("")) {
			return false;
		}
		return str1.equals(str2);
	}
	
	public static Integer toInteger(Object str){
		Integer value = 0;
		if (str == null || str.equals("")) {
			return null;
		}
		try {
			value = Integer.parseInt(str.toString());
		} catch (Exception ex) {
			value = null;
		}
		return value;
	}

	/**
	 * 将字串转为数字
	 * 
	 * @param str
	 * @param checked如果为treu格式不正确抛出异常
	 * @return
	 */
	public static int toInt(String str, boolean checked) {
		int value = 0;
		if (str == null || str.equals("")) {
			return 0;
		}
		try {
			value = Integer.parseInt(str);
		} catch (Exception ex) {
			if (checked) {
				throw new RuntimeException("整型数字格式不正确");
			} else {
				return 0;
			}
		}
		return value;
	}

	/**
	 * 将字符型转为Int型
	 * 
	 * @param str
	 * @return
	 */
	@Deprecated
	public static int toInt(String str) {
		int value = 0;
		if (str == null || str.equals("")) {
			return 0;
		}
		try {
			value = Integer.parseInt(str);
		} catch (Exception ex) {
			value = 0;
			ex.printStackTrace();
		}
		return value;
	}

	@Deprecated
	public static Double toDouble(String str) {
		Double value = 0d;
		if (str == null || str.equals("")) {
			return 0d;
		}
		try {
			value = Double.valueOf(str);
		} catch (Exception ex) {
			value = 0d;
			// ex.printStackTrace();
		}
		return value;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Double toDoubleOrNull(Object str){
		Double value = 0d;
		if (str == null || str.equals("")) {
			return null;
		}
		try {
			value = Double.valueOf(str.toString());
		} catch (Exception ex) {
			value = null;
			// ex.printStackTrace();
		}
		return value;
	}
	
	/**
	 * 将一个字串转为double
	 * 
	 * @param str
	 * @param checked如果为treu格式不正确抛出异常
	 * @return
	 */
	public static Double toDouble(String str, boolean checked) {
		Double value = 0d;
		if (str == null || str.equals("")) {
			return 0d;
		}
		try {
			value = Double.valueOf(str);
		} catch (Exception ex) {
			if (checked)
				throw new RuntimeException("数字格式不正确");
			else
				return 0D;
		}
		return value;
	}
	

	/**
	 * 把数组转换成String
	 * 
	 * @param array
	 * @return
	 */
	public static String arrayToString(Object[] array, String split) {
		if (array == null) {
			return "";
		}
		String str = "";
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				str += array[i].toString() + split;
			} else {
				str += array[i].toString();
			}
		}
		return str;
	}

	/**
	 * 将一个list转为以split分隔的string
	 * 
	 * @param list
	 * @param split
	 * @return
	 */
	public static String listToString(List list, String split) {
		if (list == null || list.isEmpty())
			return "";
		StringBuffer sb = new StringBuffer();
		for (Object obj : list) {
			if (sb.length() != 0) {
				sb.append(split);
			}
			sb.append(obj.toString());

		}
		return sb.toString();
	}

	/**
	 * 得到WEB-INF的绝对路径
	 * 
	 * @return
	 */
	public static String getWebInfPath() {
		String filePath = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		if (filePath.toLowerCase().indexOf("file:") > -1) {
			filePath = filePath.substring(6, filePath.length());
		}
		if (filePath.toLowerCase().indexOf("classes") > -1) {
			filePath = filePath.replaceAll("/classes", "");
		}
		if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
			filePath = "/" + filePath;
		}
		if (!filePath.endsWith("/"))
			filePath += "/";
		return filePath;
	}

	/**
	 * 得到根目录绝对路径(不包含WEB-INF)
	 * 
	 * @return
	 */
	public static String getRootPath() {
		// return "E:/javatool/apache-tomcat-6.0.18/webapps/user_test";
		String filePath = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		if (filePath.toLowerCase().indexOf("file:") > -1) {
			filePath = filePath.substring(6, filePath.length());
		}
		if (filePath.toLowerCase().indexOf("classes") > -1) {
			filePath = filePath.replaceAll("/classes", "");
		}
		if (filePath.toLowerCase().indexOf("web-inf") > -1) {
			filePath = filePath.substring(0, filePath.length() - 9);
		}
		if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
			filePath = "/" + filePath;
		}

		if (filePath.endsWith("/"))
			filePath = filePath.substring(0, filePath.length() - 1);

		return filePath;
	}

	public static String getRootPath(String resource) {
		String filePath = Thread.currentThread().getContextClassLoader()
				.getResource(resource).toString();
		if (filePath.toLowerCase().indexOf("file:") > -1) {
			filePath = filePath.substring(6, filePath.length());
		}
		// if (filePath.toLowerCase().indexOf("classes") > -1) {
		// filePath = filePath.replaceAll("/classes", "");
		// }
		// if (filePath.toLowerCase().indexOf("web-inf") > -1) {
		// filePath = filePath.substring(0, filePath.length() - 9);
		// }
		if (System.getProperty("os.name").toLowerCase().indexOf("window") < 0) {
			filePath = "/" + filePath;
		}

		if (!filePath.endsWith("/"))
			filePath += "/";

		return filePath;
	}

	/**
	 * 格式化页码
	 * 
	 * @param page
	 * @return
	 */
	public static int formatPage(String page) {
		int iPage = 1;
		if (page == null || page.equals("")) {
			return iPage;
		}
		try {
			iPage = Integer.parseInt(page);
		} catch (Exception ex) {
			iPage = 1;
		}
		return iPage;
	}

	/**
	 * 将计量单位字节转换为相应单位
	 * 
	 * @param size
	 * @return
	 */
	public static String getFileSize(String fileSize) {
		String temp = "";
		DecimalFormat df = new DecimalFormat("0.00");
		double dbFileSize = Double.parseDouble(fileSize);
		if (dbFileSize >= 1024) {
			if (dbFileSize >= 1048576) {
				if (dbFileSize >= 1073741824) {
					temp = df.format(dbFileSize / 1024 / 1024 / 1024) + " GB";
				} else {
					temp = df.format(dbFileSize / 1024 / 1024) + " MB";
				}
			} else {
				temp = df.format(dbFileSize / 1024) + " KB";
			}
		} else {
			temp = df.format(dbFileSize / 1024) + " KB";
		}
		return temp;
	}

	/**
	 * 得到一个32位随机字符
	 * 
	 * @return
	 */
	public static String getEntry() {
		Random random = new Random(100);
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(new String(
				"yyyyMMddHHmmssS"));
		return md5(formatter.format(now) + random.nextDouble());
	}

	/**
	 * 将中文汉字转成UTF8编码
	 * 
	 * @param str
	 * @return
	 */
	public static String toUTF8(String str) {
		if (str == null || str.equals("")) {
			return "";
		}
		try {
			return new String(str.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static String to(String str, String charset) {
		if (str == null || str.equals("")) {
			return "";
		}
		try {
			return new String(str.getBytes("ISO8859-1"), charset);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public static String getRandStr(int n) {
		Random random = new Random();
		String sRand = "";
		for (int i = 0; i < n; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
		}
		return sRand;
	}

	/**
	 * 得到一个数字的大写(零到十之内)
	 * 
	 * @param num
	 * @return
	 */
	public static String getChineseNum(int num) {
		String[] chineseNum = new String[] { "零","一", "二", "三", "四", "五", "六", "七",
				"八", "九", "十" };
		return chineseNum[num];
	}

	public static String replaceEnter(String str) {
		if (str == null)
			return null;
		return str.replaceAll("\r", "").replaceAll("\n", "");
	}

	public static String replaceAll(String source, String target, String content) {
		StringBuffer buffer = new StringBuffer(source);
		int start = buffer.indexOf(target);
		if (start > 0) {
			source = buffer.replace(start, start + target.length(), content)
					.toString();
		}
		return source;
	}

	/**
	 * 去除HTML 元素
	 * 
	 * @param element
	 * @return
	 */
	public static String getTxtWithoutHTMLElement(String element) {

		if (null == element || "".equals(element.trim())) {
			return element;
		}

		Pattern pattern = Pattern.compile("<[^<|^>]*>");
		Matcher matcher = pattern.matcher(element);
		StringBuffer txt = new StringBuffer();
		while (matcher.find()) {
			String group = matcher.group();
			if (group.matches("<[\\s]*>")) {
				matcher.appendReplacement(txt, group);
			} else {
				matcher.appendReplacement(txt, "");
			}
		}
		matcher.appendTail(txt);
		String temp = txt.toString().replaceAll("\n", "");
		temp = temp.replaceAll(" ", "");
		//文本都一个字符如果是以下符号就过滤掉
		String [] arr = {",","，","：","＝","?","！"," ","&bsp;"};
		for (String string : arr) {
			for (int i = 0; i < 10; i++) {
				if(temp.startsWith(string)){
					temp = temp.substring(1);
				}else{
					break;
				}
			}
		}
		return temp;
	}

	/**
	 * clear trim to String
	 * 
	 * @return
	 */
	public static String toTrim(String strtrim) {
		if (null != strtrim && !strtrim.equals("")) {
			return strtrim.trim();
		}
		return "";
	}

	/**
	 * 转义字串的$
	 * 
	 * @param str
	 * @return
	 */
	public static String filterDollarStr(String str) {

		String sReturn = "";
		if (!toTrim(str).equals("")) {

			if (str.indexOf('$', 0) > -1) {
				while (str.length() > 0) {
					if (str.indexOf('$', 0) > -1) {
						sReturn += str.subSequence(0, str.indexOf('$', 0));
						sReturn += "\\$";
						str = str.substring(str.indexOf('$', 0) + 1,
								str.length());
					} else {
						sReturn += str;
						str = "";
					}

				}

			} else {

				sReturn = str;
			}

		}
		return sReturn;
	}

	public static String compressHtml(String html) {
		if (html == null)
			return null;

		html = html.replaceAll("[\\t\\n\\f\\r]", "");
		return html;
	}

	public static String toCurrency(Double d) {
		if (d != null) {
			DecimalFormat df = new DecimalFormat("￥#,###.00");
			return df.format(d);
		}
		return "";
	}

	public static String toString(Integer i) {
		if (i != null) {
			return String.valueOf(i);
		}
		return "";
	}

	public static String toString(Double d) {
		if (null != d) {
			return String.valueOf(d);
		}
		return "";
	}

	public static String getRandom() {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i < 6; i++)
			result = result * 10 + array[i];

		return "" + result;
	}

	/**
	 * 处理树型码 获取本级别最大的code 如:301000 返回301999
	 * 
	 * @param code
	 * @return
	 */
	public static int getMaxLevelCode(int code) {
		String codeStr = "" + code;
		StringBuffer str = new StringBuffer();
		boolean flag = true;
		for (int i = codeStr.length() - 1; i >= 0; i--) {
			char c = codeStr.charAt(i);
			if (c == '0' && flag) {
				str.insert(0, '9');

			} else {
				str.insert(0, c);
				flag = false;

			}

		}
		return Integer.valueOf(str.toString());
	}

	/**
	 * 去掉sql的注释
	 */
	public static String delSqlComment(String content) {
		String pattern = "/\\*(.|[\r\n])*?\\*/";
		Pattern p = Pattern.compile(pattern, 2 | Pattern.DOTALL);
		Matcher m = p.matcher(content);
		if (m.find()) {
			content = m.replaceAll("");
		}

		return content;
	}

	public static String inputStream2String(InputStream is) {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static String decode(String keyword) {
		try {
			keyword = URLDecoder.decode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return keyword;
	}

	/**
	 * 进行解析
	 * 
	 * @param regex
	 * @param rpstr
	 * @param source
	 * @return
	 */
	public static String doFilter(String regex, String rpstr, String source) {
		Pattern p = Pattern.compile(regex, 2 | Pattern.DOTALL);
		Matcher m = p.matcher(source);
		return m.replaceAll(rpstr);
	}

	/**
	 * 脚本过滤
	 * 
	 * @param source
	 * @return
	 */
	public static String formatScript(String source) {
		source = source.replaceAll("javascript", "&#106avascript");
		source = source.replaceAll("jscript:", "&#106script:");
		source = source.replaceAll("js:", "&#106s:");
		source = source.replaceAll("value", "&#118alue");
		source = source.replaceAll("about:", "about&#58");
		source = source.replaceAll("file:", "file&#58");
		source = source.replaceAll("document.cookie", "documents&#46cookie");
		source = source.replaceAll("vbscript:", "&#118bscript:");
		source = source.replaceAll("vbs:", "&#118bs:");
		source = doFilter("(on(mouse|exit|error|click|key))", "&#111n$2",
				source);
		return source;
	}

	/**
	 * 格式化HTML代码
	 * 
	 * @param htmlContent
	 * @return
	 */
	public static String htmlDecode(String htmlContent) {
		htmlContent = formatScript(htmlContent);
		htmlContent = htmlContent.replaceAll(" ", "&nbsp;")
				.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
				.replaceAll("\n\r", "<br>").replaceAll("\r\n", "<br>")
				.replaceAll("\r", "<br>");
		return htmlContent;
	}
	
	/**
	 * 获取六位字符串 
	 * @return
	 */
	public static String toSexStr(){
		UUID uuid=UUID.randomUUID();
		String result = "";
		String subHex = uuid.toString().substring(0,8).toUpperCase(); 
		long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);
		for (int k = 0; k < 6; k++) {
			int index = (int) (Long.valueOf("0000003D", 16) & idx);
			result += chars[index];
			idx = idx >> 5;
		}
		return result.toUpperCase();
	}
	

	/**
	 * 创建度数集合
	 * @param max 最大度数
	 * @param min 最小度数
	 * @param upscope 大分界值
	 * @param downscope 小分界值
	 * @param outleap 范围以外跳跃值
	 * @param inleap  范围以内跳跃值
	 * @return
	 */
	public static ArrayList<Double> createDegreeByScope(double max, double min,
			double upscope, double downscope, double outleap, double inleap) {
		ArrayList<Double> degrees = new ArrayList<Double>();
		double step;
		if (min < downscope) {
			step = outleap;
		} else {
			step = inleap;
		}
		for (double i = min; i <= max; i += step) {
			if (i >= downscope && i < upscope) {
				step = inleap;
			} else {
				step = outleap;
			}
			degrees.add(i);
		}
		return degrees;
	}
	
	public static ArrayList<Double> createDegreeByScope(String[] temp) {
		ArrayList<Double> degrees = new ArrayList<Double>();
		for(int i = 0; i < temp.length; i++){
			if(temp[i].isEmpty())
				continue;
			degrees.add(Double.parseDouble(temp[i])); 
		}
		return degrees;
	}
	/**
	 * 创建隐形度数集合
	 * @param max
	 * @param min
	 * @return
	 */
	public static List<Double> createConactlensDegree(double max, double min){
		List<Double> list = StringUtil.createDegreeByScope(max, min, 6, -6, 0.5, 0.25);
		list.remove(-0.25);
		list.remove(-0.5);
		list.remove(-0.75);
		return list;
	}
	/**
	 * 创建散光集合
	 * @param max
	 * @param min
	 * @return
	 */
	public static List<Double> createCylinderScope(double max, double min){
		List<Double> list = new ArrayList<Double>();
		if(min>max){
			return list;
		}
		for (double i = min; i <= max; i+=0.25) {
			list.add(i);
		}
		return list;
	}
	/**
	 * xml 节点文本特殊字符替换
	 * @param str
	 * @return
	 */
	public static String xmlReplace(String str){
		if(str==null) return "";
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("'", "&apos;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	
	/**
	 * 获取套餐中商品重复次数
	 */
	public static Map<String,Integer> getCountByGid(String msort){
		Map<String,Integer> map = new HashMap<String, Integer>();
		String[] arr = msort.split(",");
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])){
				Integer count = map.get(arr[i]);
				map.put(arr[i], count+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		return map;
	}
	/**
	 * 还原安全过滤字符串
	 * @param value
	 * @return
	 */
	public static String restoreSageFilter(String value){
		if (value == null || "".equals(value))
			return value;
		value=value.replaceAll("‘","\\'");
	 	value=value.replaceAll("－－", "--");
	 	value=value.replaceAll("×", "\\*");
	 	value=value.replaceAll("＝", "\\=");
		return value;
	}
	public static String reSafeFilter(String value) 
	{
		if(value==null) return null;
		//防止sql注入的过滤
	 	value=value.replaceAll("‘","\\'");
	 	value=value.replaceAll("－－","--");
	 	value=value.replaceAll( "×","\\*");
	 	value=value.replaceAll( "＝","\\=");
	 	
	 	//防止跨站点脚本攻击的过滤
	 	value=value.replaceAll( "&lt;","<");
		return value;
	}
	
	public static String getLink(String catid,String goodsid){
		String link="";
		if(catid.equals("1") ||  catid.equals("2")){
			link="yxgoods-"+ goodsid+".html";
		}else if(catid.equals("3") ||catid.equals("4") || catid.equals("12")  ){
			link="jkgoods-"+ goodsid+".html";
		}else if(catid.equals("6") ){
			link="jpgoods-"+ goodsid+".html";
		}else if(catid.equals("7") ||catid.equals("8")   ||  catid.equals("9")){
			link="goods-"+ goodsid+".html";
		}else if( catid.equals("19")){
			link="gngoods-"+ goodsid+".html";
		}
		link = "http://www.meijing.com/"+link;
		return link;
	}
	
	/**
	 * 查找在字符串中指定字符出现的次数
	 * @param str字符串
	 * @param appointStr指定字符
	 * @return
	 */
	public static int containsNum(String str,String appointStr){
		int index = -1;//位置
		int count = 0;//统计数量
		while((index = str.indexOf(appointStr,index))>-1){
			++count;
			++index;//查找下一个
		}
		return count ;
	}
	
	/**
	 * 不能全是相同的数字或者字母（如：000000、111111、aaaaaa） 全部相同返回true
	 * @param numOrStr
	 * @return
	 */
	public static boolean equalStr(String numOrStr) {
		boolean flag = true;
		char str = numOrStr.charAt(0);
		for (int i = 0; i < numOrStr.length(); i++) {
			if (str != numOrStr.charAt(i)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * 不能是连续的数字--递增（如：123456、12345678）连续数字返回true
	 * @param numOrStr
	 * @return
	 */
	public static boolean isNumericAsc(String numOrStr) {
		boolean flag = true;// 如果全是连续数字返回true
		boolean isNumeric = true;// 如果全是数字返回true
		for (int i = 0; i < numOrStr.length(); i++) {
			if (!Character.isDigit(numOrStr.charAt(i))) {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric) {// 如果全是数字则执行是否连续数字判断
			for (int i = 0; i < numOrStr.length(); i++) {
				if (i > 0) {// 判断如123456
					int num = Integer.parseInt(numOrStr.charAt(i) + "");
					int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") + 1;
					if (num != num_) {
						flag = false;
						break;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}

	/**
	 * 不能是连续的数字--递减（如：987654、876543）连续数字返回true
	 * @param numOrStr
	 * @return
	 */
	public static boolean isNumericDesc(String numOrStr) {
		boolean flag = true;// 如果全是连续数字返回true
		boolean isNumeric = true;// 如果全是数字返回true
		for (int i = 0; i < numOrStr.length(); i++) {
			if (!Character.isDigit(numOrStr.charAt(i))) {
				isNumeric = false;
				break;
			}
		}
		if (isNumeric) {// 如果全是数字则执行是否连续数字判断
			for (int i = 0; i < numOrStr.length(); i++) {
				if (i > 0) {// 判断如654321
					int num = Integer.parseInt(numOrStr.charAt(i) + "");
					int num_ = Integer.parseInt(numOrStr.charAt(i - 1) + "") - 1;
					if (num != num_) {
						flag = false;
						break;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 检测商品是否属于美睛优品
	 * @param brandId
	 * @return
	 */
	public static boolean checkIsMeijingYouPin(Integer brandId)
	{
		if(brandId==197 || brandId==198 || brandId==199 || brandId==200 || brandId==201)return true;
		return false;
	}
	
	/**
	 * 检测是否为网站订单号
	 * @param sn
	 * @return
	 */
	public static boolean checkSnIsSelf(String sn){
		if(sn.startsWith("2011") || sn.startsWith("2012") || sn.startsWith("2013")  || sn.startsWith("2014")  || sn.startsWith("2015")){
			if(sn.length()==14||sn.length()==15)return true;
		}
		return false;
	}
	
	
	/**
	 * php md5
	 */
	 public static String PHPMD5(String s) {
    	 String newstr="";
    	 try{
    	    if(s != null) {
    	        MessageDigest md = MessageDigest.getInstance("MD5");
    	        md.update(s.getBytes());
    	        BigInteger hash = new BigInteger(1, md.digest());
    	        newstr = hash.toString(16);
    	        if((newstr.length() % 2) != 0) {
    	        	newstr = "0" + newstr;
    	        }
    	    }}catch(Exception e){
    	    	e.printStackTrace();
    	    	
    	    }
    	    return newstr;
	 }
	 
	 public static String base64(String s){
		 if(s != null){
			 return new sun.misc.BASE64Encoder().encode(s.getBytes()).toString();
		 }else{
			 return "";
		 }
	 }

	public static String validateNullString(String str){
		if(null!=str && !"".equals(str.trim())){
			str = str.trim();
		}else
			str = null;		
		return str;		
	}
	public static String validateNullString(String str,String defaultVal){
		if(null!=str && !"".equals(str.trim())){
			str = str.trim();
		}else
			str = defaultVal;		
		return str;		
	}
	
}
