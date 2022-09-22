package jdbc0922;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test02_selectOne {

	public static void main(String[] args) {
		//sungjuk 테이블에서 한 행 가져오기
		int sno=41;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		try {			
			String url		="jdbc:oracle:thin:@localhost:1521:xe";
			String user		="system";
			String password	="1234";
			String driver	="oracle.jdbc.driver.OracleDriver";	//ojdbc8.jar
			Class.forName(driver);
			con	=DriverManager.getConnection(url, user, password);
			System.out.println("오라클DB 서버 연결 성공!!");
			

			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT sno, uname, kor, eng, mat, tot, aver, addr, wdate ");
			sql.append(" FROM sungjuk ");
			sql.append(" WHERE sno=? ");
			
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, sno);
			
			rs=pstmt.executeQuery();			
			if(rs.next()) {
				System.out.println("자료있음");
				//1)칼럼순서 접근
				System.out.println(rs.getInt(1));		//1번칼럼. sno칼럼
				System.out.println(rs.getString(2));	//2번칼럼. uname칼럼
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getInt(5));
				System.out.println(rs.getInt(6));
				System.out.println(rs.getInt(7));
				System.out.println(rs.getString(8));
				System.out.println(rs.getString(9));
				
				//2)칼럼명 접근
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("uname"));
				System.out.println(rs.getInt("kor"));
				System.out.println(rs.getInt("eng"));
				System.out.println(rs.getInt("mat"));
				System.out.println(rs.getInt("tot"));
				System.out.println(rs.getInt("aver"));
				System.out.println(rs.getString("addr"));
				System.out.println(rs.getString("wdate"));
				
			}else {
				System.out.println("자료없음!!");
			}//if end
			
		}catch (Exception e) {
			System.out.println("실패 : " + e);
		}finally{	//자원반납(순서주의)
			try {
				if(rs!=null) {rs.close();}
			}catch (Exception e) {}
			
			try {
				if(pstmt!=null) {pstmt.close();}
			}catch (Exception e) {}
			
			try {
				if(con!=null) {con.close();}
			}catch (Exception e) {}
		}//end
		
		System.out.println("END");		

	}//main() end

}//class end
