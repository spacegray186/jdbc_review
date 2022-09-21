package jdbc0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02_insert {

	public static void main(String[] args) {
		//sungjuk 테이블 행 추가 연습
		
		try {
			
			String url		="jdbc:oracle:thin:@localhost:1521:xe";
			String user		="system";
			String password	="1234";
			String driver	="oracle.jdbc.driver.OracleDriver";	//ojdbc8.jar
			Class.forName(driver);
			Connection con	=DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");
			
			
			//4)SQL작성
			// → 주의사항)SQL 종결문자 ; 를 쓰면 오류남
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO sungjuk(sno, uname, kor, eng, mat, addr, wdate)");
			sql.append(" VALUES (sungjuk_seq.nextval, '손길동', 99, 98, 97, 'Seoul', sysdate)");
			//System.out.println(sql.toString());
			
			
			//5)SQL형식으로 변환
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			
			//6)SQL문 실행
			int cnt=pstmt.executeUpdate();	//INSERT, UPDATE, DELETE문 실행
			
			System.out.println("실행 결과 : " + cnt);
			
		}catch (Exception e) {
			System.out.println("실패 : " + e);
		}//end
		
		System.out.println("END");

	}//main() end

}//class end
