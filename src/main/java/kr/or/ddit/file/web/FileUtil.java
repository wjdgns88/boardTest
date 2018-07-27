package kr.or.ddit.file.web;

public class FileUtil {
	
	//파일 업로드 경로
	public final static String fileUploadPath = "D:\\";
	
	/**
	* Method : getFileName
	* 최초작성일 : 2018. 7. 16.
	* 작성자 : PC01
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part의 Content-Disposition header로 부터
	* 				업로드 파일명을 리턴한다.
	* 
	* ex : form-data; name="uploadFile"; filename="james.png"
	* return james.png
	*/
	public static String getFileName(String contentDisposition){
		
		String[] contentDispositions = contentDisposition.split("; ");
		String contentDispositionResult = "";
		
		for(String contentDispositionStr : contentDispositions){
			String[] fileNameStr =  contentDispositionStr.split("=");
			
			if(fileNameStr[0].equals("filename")){
				String fileName = fileNameStr[1].replace("\"", "");
				contentDispositionResult = fileName;
			}
		}
		
		return contentDispositionResult;
	}
}
