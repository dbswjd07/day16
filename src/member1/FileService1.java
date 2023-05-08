package member1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileService1 implements CommonService1{
	private File path;
	private FileOutputStream fos;
	private BufferedOutputStream bos;
	private ObjectOutputStream oos;
	
	private FileInputStream fis;
	private BufferedInputStream bis;
	private ObjectInputStream ois;
	
	public void inputData(Member1DTO dto) {
		//File path = new File(PATH+dto.getName()+".txt");
		try {
			fos = new FileOutputStream(path);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(oos != null) oos.close();
					if(bos != null) bos.close();
					if(fos != null) fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	public boolean checkuser(String name) {
		path = new File(PATH+name+".txt");
		return path.exists();
	}
	
	
	public Member1DTO readData(String name) {
		Member1DTO dto = null;
		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			dto=(Member1DTO)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(ois != null) ois.close();
					if(bis != null) bis.close();
					if(fis != null) fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return dto;
	}
}
