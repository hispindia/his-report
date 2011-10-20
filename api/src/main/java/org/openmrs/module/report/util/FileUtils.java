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
 * <p> File: com.mss.cms.utils.FileUtils.java </p>
 * <p> Project: MssContentCms </p>
 * <p> Copyright (c) 2007 MSS Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Dec 16, 2008 10:42:18 AM </p>
 * <p> Update date: Dec 16, 2008 10:42:18 AM </p>
 **/

package org.openmrs.module.report.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.FileCopyUtils;

/**
 * <p> Class: FileUtils </p>
 * <p> Package: com.mss.cms.utils </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Dec 16, 2008 10:42:18 AM </p>
 * <p> Update date: Dec 16, 2008 10:42:18 AM </p>
 **/
public class FileUtils {
	private static Log log = LogFactory.getLog(FileUtils.class);
	/**
	 * 
		 * <p> Method: saveFile() </p>
		 * <p> Objective: saveFile's objective </p>
		 * <p> Params:  </p> 
		 * <p> Return: void </p>
		 * <p> Author: Nguyen manh chuyen </p>
		 * <p> Update by: Nguyen manh chuyen </p>
		 * <p> Version: $1.0 </p>
		 * <p> Create date: Dec 16, 2008 10:46:43 AM </p>
		 * <p> Update date: Dec 16, 2008 10:46:43 AM </p>
	*
	 */
	public static void saveFile(final InputStream inputStream, final String fileName) {
//path full to file name =fileName
        final File file = new File(fileName);
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(file);
            IOUtils.copy(inputStream, fileOut);
        } catch (FileNotFoundException e) {
        	log.error("saveFile() - File Not Found." + e);
        } catch (IOException e) {
        	log.error("saveFile() - Error while saving file."  + e);
        } finally {
            try {
                inputStream.close();
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
            	log.error(e);
            }
        }
    }
	public static boolean checkExistFile(String uploadDir, String  fileName){
		File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            return false;
        }
        String sep = System.getProperty("file.separator");
        File uploadedFile = new File(uploadDir + sep + fileName);
        if(uploadedFile.exists())
        	return true;
        return false;
	}
	public static void deleteFile(String filePath) throws Exception{
		 File dirPath = new File(filePath);
		 if(dirPath.exists() && dirPath.isFile()){
			 dirPath.delete();
		 }
	}
	public static void deleteDir(String dirPath) throws Exception{
		 File dirEPath = new File(dirPath);
		 if(dirEPath.exists() && dirEPath.isDirectory()){
			org.apache.commons.io.FileUtils.deleteDirectory(dirEPath);
		 }
	}
	public static String  copyFile(String uploadDir,byte[] bytes, String  fileName){
        File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        String sep = System.getProperty("file.separator");
        File uploadedFile = new File(uploadDir + sep + fileName);
        try {
//        		if(!uploadedFile.exists())
        		FileCopyUtils.copy(bytes, uploadedFile);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("copyFile: "+e.toString());
			return "";
		}
        
        return fileName;
        // set success message
       // String url = request.getContextPath() + ConfigurationService.get(MyConst.VN_MUSIC_PATH_PICTURE,"/upload/vn_music/picture/")+ filename;
	}
	public static void renameFile(File file , String newName){
		file.renameTo(new File(newName));
	}
	public static void renameFile(String fileOlder, String newName){
		File file = new File(fileOlder);
		File newFile = new File(newName);
		if(file != null && file.isFile() ){
			file.renameTo(newFile);
		}
	}
	public static void main(String[] args) throws Exception{
		//WriteStringToFile("nLxJXeq9+sADRE5aGhrrGPYHZPEvhCAHgX1DnlJbJdY+hdRcq3Rdy3WF9AsdxfiEF/sKptIxDr3TdIIH", "D:/HISP/report/birt_report_temp.rptdesign");
		
	}
	public static String readInput(String path) {
	    StringBuffer buffer = new StringBuffer();
	    try {
		//FileInputStream fis = new FileInputStream(path);
		//InputStreamReader isr = new InputStreamReader(fis, "UTF8");
		 BufferedReader input = new BufferedReader(new FileReader(path));  
         String str = "";  
         while ((str = input.readLine()) != null ) {  
             buffer.append(str).append("\n");  
          }  
         input.close();
		return buffer.toString();
	    } catch (IOException e) {
		e.printStackTrace();
		return null;
	    }
	}
	public static String getExtensionFile(String fileName){
		if(fileName ==null || "".equals(fileName))
			return null;
		if(fileName.lastIndexOf(".") > 0)
		return fileName.substring(fileName.lastIndexOf("."));
		return null;
	}
	static void writeOutput(String str) {

	    try {
		FileOutputStream fos = new FileOutputStream("test.txt");
		Writer out = new OutputStreamWriter(fos, "UTF8");
		out.write(str);
		out.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	public static void WriteStringToFile(String str, String file) {

	    try {
	    	 BufferedWriter output = new BufferedWriter(new FileWriter(file));  
	         output.write(str);  
	         output.flush(); 
	         output.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	public synchronized static File createFileTemp(byte[] bytes){
		File tempFile = null;
		try {
			tempFile = File.createTempFile("cms_graphic.gr", ".tmp" );
			tempFile.deleteOnExit();
			FileCopyUtils.copy(bytes, tempFile);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tempFile;
	}
	
	public synchronized static File createFileTemp(String fileName, String ext, byte[] bytes, File dir){
		File tempFile = null;
		try {
			tempFile = File.createTempFile(fileName, ext , dir);
			tempFile.deleteOnExit();
			FileCopyUtils.copy(bytes, tempFile);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tempFile;
	}


	public static boolean copyFile(File source, File dest){
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] data = new byte[2*1024];
			int count;
            while((count = in.read(data,0,data.length)) != -1)
            {
                 out.write(data, 0, count);
            }
            out.flush();
            out.close();
            in.close();
            return true;
		} catch (FileNotFoundException e) {
			 return false;
		} catch (IOException e) {
			 return false;
		}
	}
	public static void copyFile(String fileSource, String folderDest) throws Exception{
		File file = new File(fileSource);
		File destDir = new File(folderDest);
		if(!destDir.exists()){
			destDir.mkdirs();
		}
		if(file.exists() && file.isFile()){
			org.apache.commons.io.FileUtils.copyFileToDirectory(file, destDir);
		}
	}
	public static void copyFile(InputStream in, File dest) throws Exception{
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] data = new byte[2*1024];
			int count;
            while((count = in.read(data,0,data.length)) != -1)
            {
                 out.write(data, 0, count);
            }
            out.flush();
            out.close();
            in.close();
	}
	
	public static boolean deleteDir(File  dir) {
//		System.out.println(dir);
		if (dir != null && dir.exists() && dir.isDirectory()) {
	        String[] children = dir.list();
	        for (int i=0; i<children.length; i++) {
	        	children[i] = dir.getAbsolutePath()+"/"+children[i].toString();
	            boolean success = deleteDir(new File(children[i].toString()));
	            if (!success) {
	                return false;
	            }
	        }
	    }
	    // The directory is now empty so delete it
	    return dir.delete();
	}
	public static List<String> listFile(String path){
		path.replaceAll("//", "/");
		File file = new File(path);
		List<String> list = null;
		if(file != null && file.isDirectory()){
			String []temp = file.list();
			if(temp != null && temp.length > 0){
				list = new ArrayList<String>();
				for(String t : temp){
					String newPath = path+t;
					newPath.replaceAll("//", "/");
					File fileTemp = new File(newPath);
					if(fileTemp != null && fileTemp.isFile())
						list.add(newPath);
				}
				return list;
			}
			
		}
		return null;
	}
	public static List<String> listFileByExtension(String path,String extension){
		List<String> listResult = new ArrayList<String>();
		List<String> list = listFile(path);
		if(list != null && list.size() > 0){
			System.out.println("list: : : "+list);
			for(int i=0;i< list.size(); i++){
				
				if(list.get(i).indexOf(".") > 0 ){

					String temp = list.get(i);
					if(temp.substring(temp.lastIndexOf(".")+1).equalsIgnoreCase(extension))
					{
						listResult.add(temp);
					}
					
				}
				
			} 
		}
		list = null;
		return listResult;
	}
	
		
	
}
