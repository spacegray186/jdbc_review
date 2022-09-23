package crawling0923;

import java.io.FileWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test08_itwill {

	public static void main(String[] args) {
		//연습) 학원 공지사항으로 크롤링 해보기
        //     itwill.txt파일에 저장하기
		try {
			
			String fileName="I:/java202207/itwill.txt";
			FileWriter fw=new FileWriter(fileName, true);	//추가모드
			PrintWriter out=new PrintWriter(fw, true);
			
			String URL="https://www.itwill.co.kr/cmn/board/BBSMSTR_000000000071/bbsList.do";
			
			for(int p=1; p<=8; p++) {
				String params="&page=" + p + "&bd_num=&act=list&s_string=";
				Document doc=Jsoup.connect(URL+params).get();
				Elements elements=doc.select("tr .td_left");
				for(Element element : elements) {
					System.out.println(element.text());
					out.println(element.text());	//itwill.txt 출력하기
				}//for end
			}//for end
			
			out.close();
			fw.close();
			
			System.out.println("---------itwill.txt 공지사항 제목 저장 완성!!");
		
		}catch (Exception e) {
			System.out.println("크롤링 실패 : " + e);
		}//end
		
	}//main() end

}//class end
