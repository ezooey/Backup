package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int ranNum = (int)(Math.random()*100000);
		
		String name = originFile.getName();
		String ext = null;
		
		int dot = name.lastIndexOf(".");
		// this.is.my.dog.image.png -> 가장 마지막에 있는 . 위치 추출
		if(dot != -1) {
			ext = name.substring(dot); // 이것을 이용해 확장자 추출
		} else {
			ext = "";
		}
		
		String fileName = sdf.format(new Date(currentTime)) + ranNum + ext;
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}

}
