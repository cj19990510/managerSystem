package cn.com.asadal.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.DBUtil;
import org.util.HibernateSessionFactory;
import org.vo.AttendWithWorks;
import org.vo.TAttend;
import org.vo.TContest;
import org.vo.TStudent;
import org.vo.TTeacher;
import org.vo.TWorks;

import cn.com.asadal.daoinf.AdminDAOInf;

public class AdminDAOImpl implements AdminDAOInf{
	public static Connection con;
	  public static void getConnection(){
			con=DBUtil.getConnection();
			}
	public static Session session;
	public static void getSession(){
		session = HibernateSessionFactory.getSession();
	}
	public static void closeSession(){
		if(session!=null){
			HibernateSessionFactory.closeSession();
		}
	}
	
	public static void main(String args[]){
		AdminDAOImpl adminDAOImpl= new AdminDAOImpl();
		System.out.println("main ");
		adminDAOImpl.getPersonOfTeamByContestNameAndTeamName("��ʮ������ʡ��ѧ�������������ƾ���","1");
//		List<TStudent> temp = adminDAOImpl.getAllStudentInfo();
//		for(TStudent single : temp){
//			System.out.println(single.getCName());
//			
//		}
		
		//adminDAOImpl.deleteStudentInfoByID(116);
		//adminDAOImpl.deleteContestInfoByID(30);
		
		
		//adminDAOImpl.getPersonOfTeamByContestName("����");
		
//		 
//		List<TWorks> list = adminDAOImpl.getUnCheckedTeamInfoByContestName("����");
//		
//		for(TWorks single : list){
//			System.out.print(single.getCId()+" ");
//			System.out.print(single.getCContestName()+" ");
//			System.out.print(single.getCTeamName()+" ");
//			System.out.print(single.getCStuName()+" ");
//			System.out.print(single.getCChecked()+" ");
//			
//			System.out.println(single.getCCheckedTime());
//			
//		}
//		
//		System.out.println("");
//		System.out.println("ָ����ʦ");
//		
//		for(TWorks single : list){
//			System.out.print(single.getCId()+" ");
//			System.out.print(single.getCContestName()+" ");
//			System.out.print(single.getCTeamName()+" ");
//			System.out.print(single.getCStuName()+" ");
//			System.out.print(single.getCAttendTeacherName()+" ");
//			System.out.print(single.getCChecked()+" ");
//			System.out.println(single.getCCheckedTime());
//			
//		}
//	    System.out.println();
//		adminDAOImpl.getAllPersonInTeamOfContestByContestName("����");
//		adminDAOImpl.unthroughCheckedTeamByWorkId(1);
//		
//		adminDAOImpl.managerLogin("123456789", "ed083b35cd7576e320ac65e2dc98c9a8");

		//adminDAOImpl.getAllAwardContestInfo();
//		for (int i = 0; i < list.size(); i++){
//			Object[] arr = (Object[])list.get(i);
//		   //һ����¼�� 2��������� �����ö������������ list.get(i); ���в��
//			AttendWithWorks temp = new AttendWithWorks();
//			TWorks works = (TWorks)arr[0];
//			temp.setCId(works.getCId());
//			System.out.println(temp.getCId());
//			a.add(temp);
//			}
	
	}

	@Override
	public TTeacher managerLogin(String managerAccount, String managerPasswd) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_teacher where c_teacher_id = ? and c_passwd=?");
			query.setParameter(0,managerAccount);
			query.setParameter(1,managerPasswd);
			query.addEntity(TTeacher.class); 
			TTeacher temp = (TTeacher) query.list().get(0);
			if(temp!=null){
				
				System.out.println("manager��¼�ɹ�");
				return temp;
				
			}else{
				System.out.println("manager��¼ʧ��");
				return null;
			}
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}
	@Override
	public boolean addContest(TContest contest) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			session.save(contest);
			t.commit();
			System.out.println("single������Ϣ���ӳɹ�");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	public  boolean addStudent(TStudent student){
		getSession();
		try{
			Transaction t = session.beginTransaction();
			session.save(student);
			t.commit();
			System.out.println("singleѧ����Ϣ���ӳɹ�");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	
	
	public  boolean addTeacher(TTeacher teacher){
		getSession();
		try{
			Transaction t = session.beginTransaction();
			session.save(teacher);
			t.commit();
			System.out.println("single��ʦ��Ϣ���ӳɹ�");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	/*����Ա�����ϴ�ѧ����Ϣ  Start*/
	public boolean batchLoadStudentInfo(String filePath) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query=session.createSQLQuery("load data local infile ? into table  t_student");
			query.setParameter(0, filePath);
			query.executeUpdate();
			t.commit();
			System.out.println("�����ϴ�ѧ����Ϣ�ɹ���");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false ;
		}finally{
			closeSession();
		}
	}/*����Ա�����ϴ�ѧ����Ϣ  End*/
	
	
	/*����Ա�����ϴ�������Ϣ  Start*/
	public boolean batchLoadContestInfo(String filePath) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query=session.createSQLQuery("load data local infile ? into table  t_contest");
			query.setParameter(0, filePath);
			query.executeUpdate();
			t.commit();
			System.out.println("�����ϴ�������Ϣ�ɹ���");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false ;
		}finally{
			closeSession();
		}
	}/*����Ա�����ϴ�������Ϣ  End*/
	
	
	/*����Ա�����ϴ���ʦ��Ϣ  End*/
	@Override
	public boolean batchLoadTeacherInfo(String filePath) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query=session.createSQLQuery("load data local infile ? into table  t_teacher");
			query.setParameter(0, filePath);
			query.executeUpdate();
			t.commit();
			System.out.println("�����ϴ���ʦ��Ϣ�ɹ���");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false ;
		}finally{
			closeSession();
		}
	}/*����Ա�����ϴ���ʦ��Ϣ  End*/
	
	
	
	@Override
	public boolean deleteContestInfoByID(int ID) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
		    TContest contesttobedeleted = (TContest) session.get(TContest.class, ID);
		    System.out.println("to be deleted teacher is "+contesttobedeleted.getCName() );
		    session.delete(contesttobedeleted);
		    t.commit();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	@Override
	public boolean deleteStudentInfoByID(int ID) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
		    TStudent studenttobedeleted = (TStudent) session.get(TStudent.class, ID);
		    System.out.println("to be deleted teacher is "+studenttobedeleted.getCName() );
		    session.delete(studenttobedeleted);
		    t.commit();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	@Override
	public boolean deleteTeacherInfoByID(int ID) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
		    TTeacher teachertobedeleted = (TTeacher) session.get(TTeacher.class, ID);
		    System.out.println("to be deleted teacher is "+teachertobedeleted.getCName() );
		    session.delete(teachertobedeleted);
		    t.commit();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	@Override
	public boolean alterContestInfo(TContest contest) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			session.update(contest);
			t.commit();
			System.out.println("������Ϣ�޸ĳɹ�");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	@Override
	public boolean alterStudentInfo(TStudent student) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			session.update(student);
			t.commit();
			System.out.println("ѧ����Ϣ�޸ĳɹ�");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	@Override
	public boolean alterTeacherInfo(TTeacher teacher) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			session.update(teacher);
			t.commit();
			System.out.println("��ʦ��Ϣ�޸ĳɹ�");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	@Override
	public List<TContest> getAllContestInfo() {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_contest");
			query.addEntity(TContest.class); 
			if(!query.list().isEmpty()){
				System.out.println("Admin ����ȫ��ʡ��������Ϣ�ɹ�");
				return  query.list();
			}else{
				System.out.println("Admin ����ȫ��ʡ��������Ϣʧ��");
				return null;
			}
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}
	@Override
	public List<TStudent> getAllStudentInfo() {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_student");
			query.addEntity(TStudent.class); 
			if(!query.list().isEmpty()){
				System.out.println("Admin ����ȫ��ѧ����Ϣ�ɹ�");
				return  query.list();
			}else{
				System.out.println("Admin ����ȫ��ѧ����Ϣʧ��");
				return null;
			}
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}
	@Override
	public List<TTeacher> getAllTeacherInfo() {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_teacher");
			query.addEntity(TTeacher.class); 
			if(!query.list().isEmpty()){
				System.out.println("Admin ����ȫ����ʦ��Ϣ�ɹ�");
				return  query.list();
			}else{
				System.out.println("Admin ����ȫ����ʦ��Ϣʧ��");
				return null;
			}
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}
	
	
	
	
	/*������Ϣ��1.��ʾȫ������(ͬʱ�߱�ͳ�ƶ�����������)  2.��ѯͨ����˵Ķ��� 3.��ѯδͨ���Ķ���*/
	@Override
	public List getTeamInfoByContestName(String contestName) {
		getSession();
		
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_works w where c_contest_name like ?");
			query.addEntity(TWorks.class);
			System.out.println("�����ѯ: �μ�*** "+contestName+"***�����Ķ�����Ϣ");
			query.setParameter(0, "%"+contestName+"%");
			
			System.out.println("�����Ķ�������"+query.list().size());
			return query.list();
			
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}

	@Override
	public List getCheckedTeamInfoByContestName(String contestName) {
		getSession();
		
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_works w where c_contest_name like ? and w.c_checked='ͨ�����'");
			query.addEntity(TWorks.class);
			System.out.println("�����ѯ: �μ�*** "+contestName+"***���� ���ͨ���Ķ�����Ϣ");
			query.setParameter(0, "%"+contestName+"%");
			
			System.out.println(contestName+"�������ͨ���Ķ�������"+query.list().size());
			return query.list();
			
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}
	@Override
	public List getUnCheckedTeamInfoByContestName(String contestName) {
		getSession();
		
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_works w where c_contest_name like ? and w.c_checked='δͨ��'");
			query.addEntity(TWorks.class);
			System.out.println("�����ѯ: �μ�*** "+contestName+"***���� δͨ���Ķ�����Ϣ");
			query.setParameter(0, "%"+contestName+"%");
			
			System.out.println(contestName+"����δͨ���Ķ�������"+query.list().size());
			return query.list();
			
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}
	
	@Override
	public boolean throughCheckedTeamByWorkId(int workId) {
		getSession();
		
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("update t_works  set c_checked ='ͨ�����',c_checked_time=? WHERE c_id=?");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		    query.setParameter(0,df.format(new Date()));
			query.setParameter(1, workId);
			
			if(query.executeUpdate()==1){
				System.out.println("���ͨ�� work c_id Ϊ"+workId+"���� �ɹ�");
				t.commit();
				return true;
				
			}else{
				return false;
			}
			
		}catch(Exception e ){
			e.printStackTrace();
			return false;
		}finally{
		closeSession();	
		}
		
	}
	@Override
	public boolean unthroughCheckedTeamByWorkId(int workId) {
		getSession();
		
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("update t_works  set c_checked ='δͨ��' WHERE c_id=?");
			query.setParameter(0, workId);
			
			if(query.executeUpdate()==1){
				System.out.println("��� δͨ��  work c_id Ϊ"+workId+"���� �ɹ�");
				t.commit();
				return true;
				
			}else{
				return false;
			}
			
		}catch(Exception e ){
			e.printStackTrace();
			return false;
		}finally{
		closeSession();	
		}
		
	}/*������Ϣ��1.��ʾȫ������(ͬʱ�߱�ͳ�ƶ�����������)  2.��ѯͨ����˵Ķ��� 3.��ѯδͨ���Ķ���*/
	
	
	
	
	
	
	/*�Ŷӳ�Ա ����ѯĳ������ ȫ������ĳ�Ա*/
	@Override
	public List getAllPersonInTeamOfContestByContestName(String contestName) {
		
		getConnection();
		System.out.println("��Hibernate��ܴ���");
	    PreparedStatement pre = null;
		ResultSet rs=null;
	    List combineResult = new ArrayList();
		String sql="select  w.c_id , w.c_contest_name, w.c_team_name ,a.c_stu_name ,w.c_checked,w.c_checked_time from t_works w ,t_attend a where c_contest_name like ? and w.c_id = a.c_works_id";
		System.out.println("�����ѯ���μ�***"+contestName+"**������ ������   ѧ����Ϣ");
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1,"%"+contestName+"%");
			rs=pre.executeQuery();
		    while(rs.next()){
		    	AttendWithWorks  a = new AttendWithWorks();
		    	a.setCId(rs.getInt("c_id"));
		    	a.setCContestName(rs.getString("c_contest_name"));
		    	a.setCTeamName(rs.getString("c_team_name"));
		    	a.setCStuName(rs.getString("c_stu_name"));
		    	a.setCChecked(rs.getString("c_checked"));
		    	
		    	System.out.print(rs.getString("c_team_name")+"  ");
		    	System.out.print(rs.getString("c_stu_name"));
		    	System.out.println(rs.getString("c_checked_time"));
			    combineResult.add(a);
				}
		    System.out.println("�μ�***"+contestName+"***������ȫ������"+combineResult.size());
			return  combineResult;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			  DBUtil.free(con, pre,rs);
		}
		
	}
	
	@Override
	public List getAllAwardContestInfo() {
		
		getConnection();
		System.out.println("��Hibernate��ܴ���");
	    PreparedStatement pre = null;
		ResultSet rs=null;
	    List combineResult = new ArrayList();
		String sql="select w.c_id , w.c_contest_name, w.c_team_name ,w.c_stu_name,group_concat(a.c_stu_name) as '�Ŷӳ�Ա',w.c_prize from  t_works w ,t_attend a where  w.c_id = a.c_works_id and w.c_prize!='' group by  w.c_id";
	    try {
			pre=con.prepareStatement(sql);

			rs=pre.executeQuery();
		    while(rs.next()){
		    	AttendWithWorks  a = new AttendWithWorks();
		    	a.setCId(rs.getInt("c_id"));
		    	a.setCContestName(rs.getString("c_contest_name"));
		    	a.setCTeamName(rs.getString("c_team_name"));
		    	a.setCLeaderStuName(rs.getString("c_stu_name"));
		    	a.setCStuName(rs.getString("�Ŷӳ�Ա"));
		    	a.setCPrize(rs.getString("c_prize"));
		    	
		         System.out.println(rs.getString("�Ŷӳ�Ա"));
			    combineResult.add(a);
				}
			return  combineResult;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			  DBUtil.free(con, pre,rs);
		}
		
	}


	/*�Ŷӳ�Ա ����ѯĳ������ ĳ������ĳ�Ա*/
	public List getPersonOfTeamByContestNameAndTeamName(String contestName,String teamName){
		
		getConnection();
		System.out.println("��Hibernate��ܴ���");
	    PreparedStatement pre = null;
		ResultSet rs=null;
	    List combineResult = new ArrayList();
		String sql="select  w.c_id , w.c_contest_name, w.c_team_name ,a.c_stu_name ,w.c_checked ,w.c_checked_time from t_works w ,t_attend a where c_contest_name = ? and w.c_id = a.c_works_id and w.c_team_name= ?";
		System.out.println("�����ѯ���μ�***"+contestName+"**������ ������   ѧ����Ϣ");
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1,contestName);
			pre.setString(2,teamName);
			rs=pre.executeQuery();
		    while(rs.next()){
		    	AttendWithWorks  a = new AttendWithWorks();
		    	a.setCId(rs.getInt("c_id"));
		    	a.setCContestName(rs.getString("c_contest_name"));
		    	a.setCTeamName(rs.getString("c_team_name"));
		    
		    	a.setCStuName(rs.getString("c_stu_name"));
		    	a.setCChecked(rs.getString("c_checked"));
		    	a.setCCheckedTime(rs.getDate("c_checked_time"));
		    
			    combineResult.add(a);
				}
			return  combineResult;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			  DBUtil.free(con, pre,rs);
		}
		
	}
	
}
