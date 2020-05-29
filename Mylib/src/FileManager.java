
public class FileManager {

	//파일의 확장자 구하기
	public String getExt(String path) {
		String pathImg = "C:/Users/suyou/Desktop/images/enemy/e...png";
		
		//1단계 : 파일명만 추출하기
		//			마지막 슬래시 다음부터, 끝까지가 파일명
		int lastIndex = path.lastIndexOf("/"); // escape 시짐
		
		String filename = path.substring(lastIndex+1, path.length());
		
		//2단계 : 파일명을 대상으로 확장자만 가져오기
		//			제일마지막 점부터 끝까지 추출!!
		lastIndex = filename.lastIndexOf(".");
		String ext = filename.substring(lastIndex+1, filename.length());
		
		return ext; // 호출자에게 결과 전달!!
	}
}
