package jdbc0921;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test06_quiz {

	public static void main(String[] args) {
		//문제) sno=41 행의 데이터를 아래의 내용으로 수정하시오
		int sno=41;
		String uname="JSPark";
		int kor=90, eng=85, mat=100;
		int tot=(kor+eng+mat);
		int aver=tot/3;
		String addr="Suwon";
		
		try {
			
			String url		="jdbc:oracle:thin:@localhost:1521:xe";
			String user		="system";
			String password	="1234";
			String driver	="oracle.jdbc.driver.OracleDriver";	//ojdbc8.jar
			Class.forName(driver);
			Connection con	=DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");
			
			
//			StringBuilder sql=new StringBuilder();
//			sql.append(" UPDATE sungjuk ");			
//			sql.append(" SET uname='JSPark' ");
//			sql.append(" , kor=90, eng=85, mat=100 ");
//			sql.append(" , addr='Suwon' ");
//			sql.append(" , tot=(kor+eng+mat) ");
//			sql.append(" , aver=(kor+eng+mat)/3 ");
//			sql.append(" WHERE sno=41 ");
			
			
			//풀이
			StringBuilder sql=new StringBuilder();
			sql.append(" UPDATE sungjuk ");
			sql.append(" SET uname=? ");
			sql.append(" ,kor=? ");
			sql.append(" ,eng=? ");
			sql.append(" ,mat=? ");
			sql.append(" ,tot=? ");
			sql.append(" ,aver=? ");
			sql.append(" ,addr=? ");
			sql.append(" ,wdate=sysdate ");
			sql.append(" WHERE sno=? ");
			
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, uname);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setInt(5, tot);
			pstmt.setInt(6, aver);
			pstmt.setString(7, addr);
			pstmt.setInt(8, sno);
			
			int cnt=pstmt.executeUpdate();
			if(cnt==0) {
				System.out.println("행 추가 실패");
			}else {
				System.out.println("행 추가 성공");
			}//if end
			
			pstmt.close();
			con.close();
					
		}catch (Exception e) {
			System.out.println("실패 : " + e);
		}//end
		
		System.out.println("END");

	}//main() end

}//class end
