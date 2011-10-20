 /*
 *  Copyright 2009 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Report module.
 *
 *  Report module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Report module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Report module.  If not, see <http://www.gnu.org/licenses/>.
 *
*/ 
/**
 * <p> File: com.mss.cms.utils.StringUtils.java </p>
 * <p> Project: MssContentCms </p>
 * <p> Copyright (c) 2007 MSS Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Jan 12, 2009 5:41:03 PM </p>
 * <p> Update date: Jan 12, 2009 5:41:03 PM </p>
 **/

package org.openmrs.module.report.util;

import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * <p> Class: StringUtils </p>
 * <p> Package: com.mss.cms.utils </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Jan 12, 2009 5:41:03 PM </p>
 * <p> Update date: Jan 12, 2009 5:41:03 PM </p>
 **/
public class StringUtils {
	private static  final String TOKENS =" ()'`:[]@{}_=$%^&~!|+-?,.*#;/";
	/**
	 * 
		 * <p> Method: checkNumber() </p>
		 * <p> Objective: checkNumber's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: boolean </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 12, 2009 5:41:15 PM </p>
		 * <p> Update date: Jan 12, 2009 5:41:15 PM </p>
	*
	 */
	
	public static boolean checkNumber(String message){
		if(message == null )
			return false;
		 for (int i = message.length() - 1; i >= 0; i--) {
           char ch = message.charAt(i);
           if ( (ch < '0') ||ch > '9') {
               return false;
           }
           }
		return true;
	}

	/**
	 * 
		 * <p> Method: checkNumberCharater() </p>
		 * <p> Objective: checkNumberCharater's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: boolean </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 12, 2009 5:42:44 PM </p>
		 * <p> Update date: Jan 12, 2009 5:42:44 PM </p>
	*
	 */
	public static boolean checkNumberCharater(String message){
		if(message == null )
			return false;
		 for (int i = message.length() - 1; i >= 0; i--) {
           char ch = message.charAt(i);
           if ( (ch < '0') ||
                   (ch > '9' && ch < 'A') ||
                   (ch > 'Z' && ch < 'a') ||
                   (ch > 'z')) {
               return false;
           }
           }
		return true;
}
	/**
	 * 
		 * <p> Method: checkNumberChar() </p>
		 * <p> Objective: checkNumberChar's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: boolean </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 13, 2009 4:15:21 PM </p>
		 * <p> Update date: Jan 13, 2009 4:15:21 PM </p>
	*
	 */
	public static boolean checkNumberChar(char ch){
		 if ( (ch < '0') ||
                 (ch > '9' && ch < 'A') ||
                 (ch > 'Z' && ch < 'a') ||
                 (ch > 'z')) {
             return false;
         }
		 return true;
	}
	/**
	 * 
		 * <p> Method: replaceFirstCharacter() </p>
		 * <p> Objective: replaceFirstCharacter's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: String </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 13, 2009 4:15:17 PM </p>
		 * <p> Update date: Jan 13, 2009 4:15:17 PM </p>
	*
	 */
	public static String replaceFirstCharacter(String input){
		if(input == null || "".equals(input))
			return "";
		Vector<String> split = splitCharacter(input);
		if(split != null && split.size() > 0 ){
			return input.substring(input.indexOf(split.get(0)));
		}
		
		return input;
	}
	/**
	 * 
		 * <p> Method: main() </p>
		 * <p> Objective: main's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: void </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 13, 2009 4:15:13 PM </p>
		 * <p> Update date: Jan 13, 2009 4:15:13 PM </p>
	*
	 */
	public static void main(String[] args) {
		/*String abc = "--++$#@%^&%)(-------------dd";
		String temp = "---";
		for (int i = 0; i< abc.length();  i++) {
			if(checkNumberChar(abc.charAt(i))== false){
				temp = abc.substring(i++);
			}else{
				break;
			}
		}
		
		System.out.println(getNameUnderScore("dam vinh hung",false));*/

		//System.out.println("temp: "+replaceFirstCharacter(",,@#$%^&*()_,đàm+vĩnh"));
		/*try {
	         Enumeration e = NetworkInterface.getNetworkInterfaces();

	         while(e.hasMoreElements()) {
	            NetworkInterface ni = (NetworkInterface) e.nextElement();
	            System.out.println("Net interface: "+ni.getName());

	            Enumeration e2 = ni.getInetAddresses();

	            while (e2.hasMoreElements()){
	               InetAddress ip = (InetAddress) e2.nextElement();
	               System.out.println("IP address: "+ ip.toString());
	            }
	         }
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }*/

			

	}
	/**
	 * 
		 * <p> Method: replaceSpecialCharacter() </p>
		 * <p> Objective: replaceSpecialCharacter's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: String </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 13, 2009 10:53:41 AM </p>
		 * <p> Update date: Jan 13, 2009 10:53:41 AM </p>
	*
	 */
	public static String replaceSpecialCharacter(String sInput) {
		StringTokenizer tokenizer = new StringTokenizer(sInput,TOKENS );
		String temp = "";
		if(tokenizer.hasMoreElements()){
		while(tokenizer.hasMoreElements()){
			temp += tokenizer.nextToken();
		}
		
	}
		return temp;
    }
	public static String replaceSpecialWithWhiteSpaceCharacter(String sInput) {
		StringTokenizer tokenizer = new StringTokenizer(sInput,TOKENS );
		String temp = "";
		if(tokenizer.hasMoreElements()){
		while(tokenizer.hasMoreElements()){
			temp += tokenizer.nextToken();
			temp +="-"; 
		}
		
		temp = temp.substring(0,temp.length()-1);
	}
		return temp;
    }
	public static String replaceSpecialWithUnderLineCharacter(String sInput) {
		
		StringTokenizer tokenizer = new StringTokenizer(sInput,TOKENS );
		String temp = "";
		if(tokenizer.hasMoreElements()){
		while(tokenizer.hasMoreElements()){
			temp += tokenizer.nextToken();
			temp +="_"; 
		}
		
		temp = temp.substring(0,temp.length()-1);
	}
		return temp;
    }
	/**
	 * 
		 * <p> Method: splitCharacter() </p>
		 * <p> Objective: splitCharacter's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: Vector<String> </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 13, 2009 4:15:00 PM </p>
		 * <p> Update date: Jan 13, 2009 4:15:00 PM </p>
	*
	 */
	public static Vector<String> splitCharacter(String sInput) {
		StringTokenizer tokenizer = new StringTokenizer(sInput, TOKENS);
		Vector<String> vector= null;
		if(tokenizer.hasMoreElements()){
			vector = new Vector<String>();
			while(tokenizer.hasMoreElements()){
				vector.add(tokenizer.nextToken());
			}
		}
		return vector;
    }
	public static Vector<String> splitCharacterExt(String sInput) {
		StringTokenizer tokenizer = new StringTokenizer(sInput, "/");
		Vector<String> vector= null;
		if(tokenizer.hasMoreElements()){
			vector = new Vector<String>();
			while(tokenizer.hasMoreElements()){
				vector.add(tokenizer.nextToken());
			}
		}
		return vector;
    }
	/**
	 * 
		 * <p> Method: getNameUnderScore() </p>
		 * <p> Objective: getNameUnderScore's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: String </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 14, 2009 10:21:17 AM </p>
		 * <p> Update date: Jan 14, 2009 10:21:17 AM </p>
	*
	 */
	public static String getNameUnderScore(String input,boolean isUpperCase){
		if(input == null || "".equals(input))
			return null;
		Vector<String> split = splitCharacter(input);
		String temp = "";
		if(split != null && split.size() > 0){
			for(int i = 0; i< split.size() ; i++){
				temp +=split.get(i);
				if(i < split.size()-1){
					temp +="_";
				}
			}
			if(isUpperCase){
				temp = temp.toUpperCase();
			}
			return temp;
		}
		return null;
	}
	/**
	 * 
		 * <p> Method: getFixLengthOfNumber() </p>
		 * <p> Objective: getFixLengthOfNumber's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: String </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Jan 13, 2009 4:15:04 PM </p>
		 * <p> Update date: Jan 13, 2009 4:15:04 PM </p>
	*
	 */
	public static String getFixLengthOfNumber(long number, int length){
		int i = 0;
		String pattern = "";
		if(length == 0)
			pattern = "000000";
		while(i < length && length > 0){
			pattern += "0";
			i++;
		}
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(number).length() > length?df.format(number).substring(0,length) : df.format(number);
	}
	public static String getIpInternal(){
		return null;
	}
	public static String removeAllHtmlTag(String input){
		return input.replaceAll("\\<.*?\\>", "");
	}
	
	public static String upperCaseFristLetter(String input){
		String in = input.toLowerCase();
		String rs = null;
		char[] arr = in.toCharArray();
		rs = ""+arr[0];
		rs = rs.toUpperCase();
		for( int i=1; i< arr.length; i++ ){
				rs = rs + arr[i];
		}
		return rs;
	}
	public static Long[] ConvetStringArrayToLongArray(String[] stringArray){
		Long[] longList = null;
		if(stringArray != null && stringArray.length > 0 ){
			longList = new Long[stringArray.length];
		for(int i = 0;i <stringArray.length;i++){
			longList[i] = NumberUtils.toLong(stringArray[i], 0);
		}
		}
		return longList;
		}
	

	public static String setDefaultIfEmptyString(String tmpString, String defaultString){
		if(tmpString.equals("")) {
			if(defaultString.equals("")) defaultString = "n/a";
			return (defaultString.equals("")?"n/a":defaultString); 
		}
		return tmpString; 		
	}

}
