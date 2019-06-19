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
		adminDAOImpl.getPersonOfTeamByContestNameAndTeamName("第十五届湖南省大学生计算机程序设计竞赛","1");
//		List<TStudent> temp = adminDAOImpl.getAllStudentInfo();
//		for(TStudent single : temp){
//			System.out.println(single.getCName());
//			
//		}
		
		//adminDAOImpl.deleteStudentInfoByID(116);
		//adminDAOImpl.deleteContestInfoByID(30);
		
		
		//adminDAOImpl.getPersonOfTeamByContestName("湖南");
		
//		 
//		List<TWorks> list = adminDAOImpl.getUnCheckedTeamInfoByContestName("湖南");
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
//		System.out.println("指导老师");
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
//		adminDAOImpl.getAllPersonInTeamOfContestByContestName("湖南");
//		adminDAOImpl.unthroughCheckedTeamByWorkId(1);
//		
//		adminDAOImpl.managerLogin("123456789", "ed083b35cd7576e320ac65e2dc98c9a8");

		//adminDAOImpl.getAllAwardContestInfo();
//		for (int i = 0; i < list.size(); i++){
//			Object[] arr = (Object[])list.get(i);
//		   //一条记录有 2个对象组成 所以用对象数组来获得 list.get(i); 进行拆封
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
				
				System.out.println("manager登录成功");
				return temp;
				
			}else{
				System.out.println("manager登录失败");
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
			System.out.println("single竞赛信息增加成功");
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
			System.out.println("single学生信息增加成功");
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
			System.out.println("single教师信息增加成功");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			closeSession();
			
		}
		
	}
	/*管理员批量上传学生信息  Start*/
	public boolean batchLoadStudentInfo(String filePath) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query=session.createSQLQuery("load data local infile ? into table  t_student");
			query.setParameter(0, filePath);
			query.executeUpdate();
			t.commit();
			System.out.println("批量上传学生信息成功！");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false ;
		}finally{
			closeSession();
		}
	}/*管理员批量上传学生信息  End*/
	
	
	/*管理员批量上传竞赛信息  Start*/
	public boolean batchLoadContestInfo(String filePath) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query=session.createSQLQuery("load data local infile ? into table  t_contest");
			query.setParameter(0, filePath);
			query.executeUpdate();
			t.commit();
			System.out.println("批量上传竞赛信息成功！");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false ;
		}finally{
			closeSession();
		}
	}/*管理员批量上传竞赛信息  End*/
	
	
	/*管理员批量上传教师信息  End*/
	@Override
	public boolean batchLoadTeacherInfo(String filePath) {
		getSession();
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query=session.createSQLQuery("load data local infile ? into table  t_teacher");
			query.setParameter(0, filePath);
			query.executeUpdate();
			t.commit();
			System.out.println("批量上传教师信息成功！");
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false ;
		}finally{
			closeSession();
		}
	}/*管理员批量上传教师信息  End*/
	
	
	
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
			System.out.println("竞赛信息修改成功");
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
			System.out.println("学生信息修改成功");
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
			System.out.println("教师信息修改成功");
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
				System.out.println("Admin 查找全部省级比赛信息成功");
				return  query.list();
			}else{
				System.out.println("Admin 查找全部省级比赛信息失败");
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
				System.out.println("Admin 查找全部学生信息成功");
				return  query.list();
			}else{
				System.out.println("Admin 查找全部学生信息失败");
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
				System.out.println("Admin 查找全部教师信息成功");
				return  query.list();
			}else{
				System.out.println("Admin 查找全部教师信息失败");
				return null;
			}
		}catch(Exception e ){
			e.printStackTrace();
			return null;
		}finally{
		closeSession();	
		}
		
	}
	
	
	
	
	/*队伍信息：1.显示全部队伍(同时具备统计队伍数量功能)  2.查询通过审核的队伍 3.查询未通过的队伍*/
	@Override
	public List getTeamInfoByContestName(String contestName) {
		getSession();
		
		try{
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_works w where c_contest_name like ?");
			query.addEntity(TWorks.class);
			System.out.println("单表查询: 参加*** "+contestName+"***比赛的队伍信息");
			query.setParameter(0, "%"+contestName+"%");
			
			System.out.println("比赛的队伍数量"+query.list().size());
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
			SQLQuery query = session.createSQLQuery("select * from t_works w where c_contest_name like ? and w.c_checked='通过审核'");
			query.addEntity(TWorks.class);
			System.out.println("单表查询: 参加*** "+contestName+"***比赛 审核通过的队伍信息");
			query.setParameter(0, "%"+contestName+"%");
			
			System.out.println(contestName+"比赛审核通过的队伍数量"+query.list().size());
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
			SQLQuery query = session.createSQLQuery("select * from t_works w where c_contest_name like ? and w.c_checked='未通过'");
			query.addEntity(TWorks.class);
			System.out.println("单表查询: 参加*** "+contestName+"***比赛 未通过的队伍信息");
			query.setParameter(0, "%"+contestName+"%");
			
			System.out.println(contestName+"比赛未通过的队伍数量"+query.list().size());
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
			SQLQuery query = session.createSQLQuery("update t_works  set c_checked ='通过审核',c_checked_time=? WHERE c_id=?");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		    query.setParameter(0,df.format(new Date()));
			query.setParameter(1, workId);
			
			if(query.executeUpdate()==1){
				System.out.println("审核通过 work c_id 为"+workId+"队伍 成功");
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
			SQLQuery query = session.createSQLQuery("update t_works  set c_checked ='未通过' WHERE c_id=?");
			query.setParameter(0, workId);
			
			if(query.executeUpdate()==1){
				System.out.println("审核 未通过  work c_id 为"+workId+"队伍 成功");
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
		
	}/*队伍信息：1.显示全部队伍(同时具备统计队伍数量功能)  2.查询通过审核的队伍 3.查询未通过的队伍*/
	
	
	
	
	
	
	/*团队成员 ：查询某个比赛 全部队伍的成员*/
	@Override
	public List getAllPersonInTeamOfContestByContestName(String contestName) {
		
		getConnection();
		System.out.println("非Hibernate框架处理");
	    PreparedStatement pre = null;
		ResultSet rs=null;
	    List combineResult = new ArrayList();
		String sql="select  w.c_id , w.c_contest_name, w.c_team_name ,a.c_stu_name ,w.c_checked,w.c_checked_time from t_works w ,t_attend a where c_contest_name like ? and w.c_id = a.c_works_id";
		System.out.println("两表查询：参加***"+contestName+"**比赛的 队伍内   学生信息");
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
		    System.out.println("参加***"+contestName+"***比赛的全部人数"+combineResult.size());
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
		System.out.println("非Hibernate框架处理");
	    PreparedStatement pre = null;
		ResultSet rs=null;
	    List combineResult = new ArrayList();
		String sql="select w.c_id , w.c_contest_name, w.c_team_name ,w.c_stu_name,group_concat(a.c_stu_name) as '团队成员',w.c_prize from  t_works w ,t_attend a where  w.c_id = a.c_works_id and w.c_prize!='' group by  w.c_id";
	    try {
			pre=con.prepareStatement(sql);

			rs=pre.executeQuery();
		    while(rs.next()){
		    	AttendWithWorks  a = new AttendWithWorks();
		    	a.setCId(rs.getInt("c_id"));
		    	a.setCContestName(rs.getString("c_contest_name"));
		    	a.setCTeamName(rs.getString("c_team_name"));
		    	a.setCLeaderStuName(rs.getString("c_stu_name"));
		    	a.setCStuName(rs.getString("团队成员"));
		    	a.setCPrize(rs.getString("c_prize"));
		    	
		         System.out.println(rs.getString("团队成员"));
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


	/*团队成员 ：查询某个比赛 某个队伍的成员*/
	public List getPersonOfTeamByContestNameAndTeamName(String contestName,String teamName){
		
		getConnection();
		System.out.println("非Hibernate框架处理");
	    PreparedStatement pre = null;
		ResultSet rs=null;
	    List combineResult = new ArrayList();
		String sql="select  w.c_id , w.c_contest_name, w.c_team_name ,a.c_stu_name ,w.c_checked ,w.c_checked_time from t_works w ,t_attend a where c_contest_name = ? and w.c_id = a.c_works_id and w.c_team_name= ?";
		System.out.println("两表查询：参加***"+contestName+"**比赛的 队伍内   学生信息");
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
