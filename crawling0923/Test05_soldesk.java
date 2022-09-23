package crawling0923;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test05_soldesk {

	public static void main(String[] args) {
		//연습) 솔데스크 웹페이지에서 공지사항 제목만 크롤링해서
        //     soldesk.txt파일에 저장하기
		try {
			
			String fileName="I:/java202207/soldesk.txt";
			FileWriter fw=new FileWriter(fileName, true);	//추가모드
			PrintWriter out=new PrintWriter(fw, true);
			
			String URL="https://soldesk.com/board/board_bagic/board_list.asp?scrID=0000000173&pageNum=8&subNum=1&ssubNum=1";
			
			for(int p=1; p<=8; p++) {
				String params="&page=" + p + "&bd_num=&act=list&s_string=";
				Document doc=Jsoup.connect(URL+params).get();
				Elements elements=doc.select("tr .td_left");
				for(Element element : elements) {
					System.out.println(element.text());
					out.println(element.text());	//soldesk.txt 출력하기
				}//for end
			}//for end
			
			out.close();
			fw.close();
			
			System.out.println("---------soldesk.txt 공지사항 제목 저장 완성!!");
		
		}catch (Exception e) {
			System.out.println("크롤링 실패 : " + e);
		}//end
		
	}//main() end

}//class end
