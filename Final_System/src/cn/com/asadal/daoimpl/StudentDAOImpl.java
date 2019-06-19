package cn.com.asadal.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.AddEnter;
import org.util.DBUtil;
import org.util.HibernateSessionFactory;
import org.vo.AttendWithWorks;
import org.vo.TAttend;
import org.vo.TContest;
import org.vo.TNews;
import org.vo.TStudent;
import org.vo.TTeacher;
import org.vo.TWorks;

import cn.com.asadal.beans.ItemStyle;
import cn.com.asadal.beans.Links;
import cn.com.asadal.beans.Nodes;
import cn.com.asadal.beans.Normal;
import cn.com.asadal.daoinf.StudentDAOInf;

/**
 * user����ʵ��
 * 
 * @author Asadal 2019��4��8�� 12:38:49
 */
public class StudentDAOImpl implements StudentDAOInf {

	public static Connection con;

	public static void getConnection() {
		con = DBUtil.getConnection();
	}

	/* Hibernate ���� Start */
	public static Session session;

	public static void getSession() {
		session = HibernateSessionFactory.getSession();
	}

	public static void closeSession() {
		if (session != null) {
			HibernateSessionFactory.closeSession();
		}
	}
	/* Hibernate ���� End */

	/* ����main���� Start */
	public static void main(String args[]) {
		StudentDAOImpl student = new StudentDAOImpl();
		List<TWorks> list = student.StudentGetAwareNews();
		System.out.println(list.size());
		// StudentDAOImpl studentDAOImpl= new StudentDAOImpl();
		// studentDAOImpl.StudentLogin("201501020122","123");
		// studentDAOImpl.GetStudentInfoByID("201501020122");
		/*
		 * List<TContest> temp = studentDAOImpl.StudentGetCurrentContestInfo();
		 * for(TContest t:temp){ System.out.println(t.getCName());
		 * System.out.println(t.getCLevel()); System.out.println(t.getCTime());
		 * }
		 */

		// TWorks work = new TWorks();
		// work.setCTeamName("");
		// work.setCStuName("");
		// work.setCContestName("");
		// studentDAOImpl.StudentGetWorksID(work);
		// studentDAOImpl.StudentGetSingleContestByConName("�׽�ȫ����ҽҩԺУ��ѧ��������ƾ���");
		// studentDAOImpl.getSeriesContestName("�й���ѧ������������´�ҵ����");
		// for(TWorks t:temp){
		// System.out.println(t.getCTeamName());
		//
		// }

		/*
		 * TStudent student = new TStudent(); student.setCName("����");
		 * studentDAOImpl.addStudent(student); TTeacher teacher= new TTeacher();
		 * teacher.setCName("����"); studentDAOImpl.addTeacher(teacher);
		 */

		/*
		 * TWorks work = studentDAOImpl.StudentGetWorkMessage("24", "��Ԫ��");
		 * System.out.println(work.getCWorksAddress());
		 * 
		 * TWorks workalter = new TWorks(); workalter.setCContestId(23);
		 */
		// studentDAOImpl.StudentAlterWorkMessage(workalter);

	}
	/* ����main���� End */

	/* �û�(ѧ��) ��¼ Start */
	public TStudent StudentLogin(String userAccount, String userPasswd) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_student where c_stu_id = ? and c_passwd=?");
			query.setParameter(0, userAccount);
			query.setParameter(1, userPasswd);
			query.addEntity(TStudent.class);

			TStudent temp = (TStudent) query.list().get(0);
			if (temp != null) {
				System.out.println("ѧ����¼�ɹ�");
				return temp;

			} else {
				System.out.println("ѧ����¼ʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	@Override
	public boolean StudentAlterPasswd(String userAccount, String userPasswd, String newPasswd) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_student where c_stu_id = ? and c_passwd=?");
			query.setParameter(0, userAccount);
			query.setParameter(1, userPasswd);
			query.addEntity(TStudent.class);
			TStudent temp = (TStudent) query.list().get(0);
			if (temp != null) {
				System.out.println("ѧ�����ԭʼ����ɹ�");
				query = session.createSQLQuery("update t_student set c_passwd=? where c_stu_id=?");
				query.setParameter(0, newPasswd);
				query.setParameter(1, userAccount);
				System.out.println(query.executeUpdate());
				System.out.println("�޸�����ɹ�");
				t.commit();
				return true;

			} else {
				System.out.println("ѧ����¼ʧ��");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeSession();
		}

	}

	/* �û�(ѧ��) ��¼ End */

	@Override
	public boolean StudentAlterSelfInfo(TStudent student) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			session.update(student);
			t.commit();
			System.out.println("ѧ���޸ĸ�����Ϣ�ɹ�");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeSession();

		}

	}

	/* �����û�(ѧ��) ID ����ѧ����Ϣ Start */
	@Override
	public TStudent GetStudentInfoByID(String studentID) {
		getSession();
		try {
			Query query = session.createQuery("from TStudent where CStuId =:CStuId");
			query.setParameter("CStuId", studentID);

			TStudent temp = (TStudent) query.list().get(0);
			System.out.println("����ѧ����Ϣ�ɹ�");
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}
	/* �����û�(ѧ��) ID ����ѧ����Ϣ End */

	/* ��ҳ��ȡ���Ҽ�������Ϣ Start */
	public List<TContest> MainDemoGetNationalContestInfo() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(
					"select *  from t_contest where c_level='���Ҽ�' AND c_time > CURDATE() ORDER BY c_time ASC");
			query.addEntity(TContest.class);
			if (!query.list().isEmpty()) {
				System.out.println("main.jsp ���ҹ��Ҽ�������Ϣ_ʱ����������  �ɹ�");
				return query.list();
			} else {
				System.out.println("main.jsp ����ʡ��������Ϣ_ʱ���������� ʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}
	/* ��ҳ��ȡ���Ҽ�������Ϣ End */

	/* ��ҳ��ȡʡ��������Ϣ Start */
	public List<TContest> MainDemoGetProvincinalContestInfo() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(
					"select *  from t_contest where c_level='ʡ����' AND c_time > CURDATE() ORDER BY c_time ASC");
			query.addEntity(TContest.class);
			if (!query.list().isEmpty()) {
				System.out.println("main.jsp ����ʡ��������Ϣ_ʱ���������� �ɹ�");
				return query.list();
			} else {
				System.out.println("main.jsp ����ʡ��������Ϣ_ʱ���������� ʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}
	/* ��ҳ��ȡʡ��������Ϣ End */

	@Override
	public List<TNews> MainDemoGetNewsInfo() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select *  from t_news   ORDER BY c_news_time ASC limit 0,5");
			query.addEntity(TNews.class);
			if (!query.list().isEmpty()) {
				System.out.println("main.jsp �������� ��Ϣ�ɹ�");
				return query.list();
			} else {
				System.out.println("main.jsp �������� ��Ϣʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	/* ѧ����ȡ���ڱ�����Ϣ Start */
	@Override
	public List<TContest> StudentGetCurrentContestInfo() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("select *  from t_contest where c_time > CURDATE() ORDER BY c_time ASC");
			query.addEntity(TContest.class);
			if (!query.list().isEmpty()) {
				System.out.println("�������ڻ�δ��ֹ��ѧ�ƾ�����Ϣ_ʱ���������� ���ҳɹ�");
				return query.list();
			} else {
				System.out.println("�������ڻ�δ��ֹ��ѧ�ƾ�����Ϣ_ʱ���������� ����ʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}
	/* ѧ����ȡ���ڱ�����Ϣ End */

	/* ѧ����ȡָ����ʦ��Ϣ Start */
	@Override
	public List<TTeacher> StudentGetTeacherInfo() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_teacher where c_is_attend='��'");
			query.addEntity(TTeacher.class);
			if (!query.list().isEmpty()) {
				return query.list();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}
	/* ѧ����ȡָ����ʦ��Ϣ End */

	/* ѧ���μӱ��� �������ű�Ĳ��� ���ж��ѵ�ͬ�� ָ����ʦ��ͬ�� �ͽ�����ʦ����� ������̱������� */
	@Override
	public boolean StudentAttendContest(TWorks workMessage) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			session.save(workMessage);
			t.commit();
			System.out.println("ѧ��add work��Ϣ�ɹ�");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeSession();

		}

	}

	public int StudentGetWorksID(TWorks workMessage) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session
					.createSQLQuery("select * from t_works where c_contest_name=? and c_stu_name=? and c_team_name=?");
			query.setParameter(0, workMessage.getCContestName());
			query.setParameter(1, workMessage.getCStuName());
			query.setParameter(2, workMessage.getCTeamName());
			query.addEntity(TWorks.class);
			TWorks work = (TWorks) query.list().get(0);
			System.out.println(work.getCId());
			return work.getCId();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			closeSession();

		}

	}

	/**/

	public boolean StudentAddAttendInfo(TAttend attend) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			session.save(attend);
			t.commit();
			System.out.println("ѧ��add attend��Ϣ�ɹ�");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeSession();

		}

	}

	public List<AttendWithWorks> StudentGetSelfAttendContestByStuName(String studentName) {

		getConnection();
		System.out.println("��Hibernate��ܴ���");
		PreparedStatement pre = null;
		ResultSet rs = null;
		List combineResult = new ArrayList();
		String sql = "select w.c_id , w.c_contest_name, w.c_team_name ,a.c_stu_name, a.c_is_team_leader,a.c_leader_stu_name,w.c_checked,w.c_prize from  t_works w ,t_attend a where a.c_stu_name =? and w.c_id = a.c_works_id";
		System.out.println("�����ѯ���鿴" + studentName + "�Ĳ������");
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, studentName);

			rs = pre.executeQuery();
			while (rs.next()) {
				AttendWithWorks a = new AttendWithWorks();
				a.setCId(rs.getInt("c_id"));
				a.setCContestName(rs.getString("c_contest_name"));
				a.setCTeamName(rs.getString("c_team_name"));
				a.setCChecked(rs.getString("c_checked"));
				a.setCStuName(rs.getString("c_stu_name"));
				a.setCIsTeamLeader(rs.getString("c_is_team_leader"));
				a.setCLeaderStuName(rs.getString("c_leader_stu_name"));
				a.setCPrize(rs.getString("c_prize"));
				System.out.println(a.getCChecked());
				combineResult.add(a);

			}
			return combineResult;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.free(con, pre, rs);
		}

	}

	/* ������Ʒչʾ���� ����ѧ�����ܿ���������Ʒ���б� Start */
	@Override
	public List<TWorks> StudentGetAllWorkInfo() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select *  from t_works ");
			query.addEntity(TWorks.class);
			if (!query.list().isEmpty()) {
				System.out.println("����t_work��Ϣ�ɹ�");
				return query.list();
			} else {
				System.out.println("����t_work��Ϣʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}
	/* ������Ʒչʾ���� ����ѧ�����ܿ���������Ʒ���б� Start */

	@Override
	public List<TWorks> Student_Leader_GetAllWorkInfo(String studentName) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select *  from t_works where c_stu_name=:studentName");
			query.setParameter("studentName", studentName);
			query.addEntity(TWorks.class);
			if (!query.list().isEmpty()) {
				System.out.println("����t_work��Ϣ�ɹ�");
				return query.list();
			} else {
				System.out.println("����t_work��Ϣʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	/* ѧ�����ݲ���ID �� �������� ��ȡ TWork ����Ϣ */
	@Override
	public TWorks StudentGetWorkSingleMessage(int contestId, String studentName) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_works where c_id = ? and c_stu_name = ?");
			query.setParameter(0, contestId);
			query.setParameter(1, studentName);
			query.addEntity(TWorks.class);

			TWorks temp = (TWorks) query.list().get(0);
			if (temp != null) {
				System.out.println("��ѯwork ��ϸ��Ϣ�ɹ�");
				return temp;

			} else {
				System.out.println("��ѯwork ��ϸ��Ϣʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	@Override
	public boolean StudentAlterWorkMessage(TWorks work) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			session.update(work);
			t.commit();
			System.out.println("ѧ���޸�TWorks����Ϣ�ɹ�");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeSession();

		}

	}

	@Override
	public List<TStudent> StudentGetAllFormalStudentMessage() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select *  from t_student ");
			query.addEntity(TStudent.class);
			if (!query.list().isEmpty()) {
				System.out.println("����t_student ��Ϣ�ɹ�");
				return query.list();
			} else {
				System.out.println("����t_student ��Ϣʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	@Override
	public TContest StudentGetSingleContestByConName(String contestName) {
		getSession();
		try {
			Query query = session.createQuery("from TContest where CName =:CName");
			query.setParameter("CName", contestName);

			TContest temp = (TContest) query.list().get(0);

			System.out.println(temp.getCTime());
			System.out.println("ѧ������ ����������Ϣ�ɹ�");
			return temp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	/**
	 * echarts ��ʾ��
	 */
	@Override
	public ArrayList getContest_NodesByContestName(String contestName) {
		getSession();
		ArrayList<Nodes> result = new ArrayList();
		Normal normal = new Normal("red");
		ItemStyle itemStyle = new ItemStyle();
		AddEnter addEnter = new AddEnter();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_contest where c_name = ?;");
			query.setParameter(0, contestName);
			query.addEntity(TContest.class);
			TContest temp = (TContest) query.list().get(0);
			Nodes a = new Nodes();
			System.out.println(temp.getCName());
			a.setId(temp.getCName());
			a.setName(addEnter.AddAnEnter(temp.getCName()));
			a.setDes(temp.getCLevel());
			a.setSymbolSize("120");
			a.setCategory("��������");
			result.add(a);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	@Override
	public ArrayList getContest_TeamNodesByContestName(String contestName) {
		getSession();
		ArrayList<Nodes> result = new ArrayList();
		Normal normal = new Normal("red");
		ItemStyle itemStyle = new ItemStyle();
		AddEnter addEnter = new AddEnter();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_works where c_contest_name = ?;");
			query.setParameter(0, contestName);
			query.addEntity(TWorks.class);
			List<TWorks> list = query.list();

			for (TWorks temp : list) {
				Nodes a = new Nodes();
				a.setId(temp.getCTeamName() + temp.getCId());
				a.setName(addEnter.AddAnEnter(temp.getCTeamName()));
				a.setDes(temp.getCAttendTeacherName() + "\n" + temp.getCPrize());
				a.setSymbolSize("100");
				a.setCategory("��������");
				result.add(a);

			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	@Override
	public ArrayList getContest_Team_linksByContestName(String contestName) {

		getSession();
		ArrayList<Links> result = new ArrayList();
		Normal normal = new Normal("red");
		ItemStyle itemStyle = new ItemStyle();
		AddEnter addEnter = new AddEnter();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_works where c_contest_name = ?;");
			query.setParameter(0, contestName);
			query.addEntity(TWorks.class);
			List<TWorks> list = query.list();

			for (TWorks temp : list) {
				Links a = new Links();
				a.setTarget(temp.getCContestName());
				a.setName("");
				a.setSource(temp.getCTeamName() + temp.getCId());
				a.setValue("100");

				System.out.print(a.getTarget());
				System.out.print(a.getName());
				System.out.println(a.getSource());
				result.add(a);

			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	@Override
	public ArrayList getContest_TeamPeopleNodesByContestName(String contestName) {

		getConnection();
		System.out.println("��Hibernate��ܴ���");
		ArrayList<Nodes> result = new ArrayList();
		Normal normal = new Normal("red");
		ItemStyle itemStyle = new ItemStyle();
		PreparedStatement pre = null;
		ResultSet rs = null;
		List combineResult = new ArrayList();
		String sql = "select  w.c_id , w.c_contest_name, w.c_team_name ,a.c_stu_name ,w.c_checked,w.c_checked_time,a.c_is_team_leader from t_works w ,t_attend a where c_contest_name = ? and w.c_id = a.c_works_id";
		System.out.println("�����ѯ���μ�***" + contestName + "**������ ������   ѧ����Ϣ");
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, contestName);
			rs = pre.executeQuery();
			while (rs.next()) {
				Nodes a = new Nodes();
				a.setId(rs.getString("c_stu_name") + rs.getString("c_id"));
				a.setName(rs.getString("c_stu_name") + rs.getString("c_id"));
				a.setDes(rs.getString("c_is_team_leader"));
				a.setSymbolSize("80");
				a.setCategory("��Ա����");
				result.add(a);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.free(con, pre, rs);
		}

	}

	@Override
	public ArrayList getTeam_People_linksByContestName(String contestName) {

		getConnection();
		System.out.println("��Hibernate��ܴ���");
		ArrayList<Links> result = new ArrayList();
		Normal normal = new Normal("red");
		ItemStyle itemStyle = new ItemStyle();
		PreparedStatement pre = null;
		ResultSet rs = null;
		List combineResult = new ArrayList();
		String sql = "select  w.c_id , w.c_contest_name, w.c_team_name ,a.c_stu_name ,w.c_checked,w.c_checked_time,a.c_is_team_leader from t_works w ,t_attend a where c_contest_name = ? and w.c_id = a.c_works_id";

		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, contestName);
			rs = pre.executeQuery();
			while (rs.next()) {
				Links a = new Links();
				a.setTarget(rs.getString("c_team_name") + rs.getString("w.c_id"));
				a.setName("");
				a.setSource(rs.getString("c_stu_name") + rs.getString("c_id"));
				a.setValue("80");

				System.out.print(rs.getString("c_team_name") + "<---");
				System.out.println(rs.getString("c_stu_name") + rs.getString("c_id"));

				result.add(a);
			}
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.free(con, pre, rs);
		}

	}

	@Override
	public List getSeriesContestName(String contestName) {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select * from t_contest where c_name like ? ");
			query.setParameter(0, "%" + contestName + "%");
			query.addEntity(TContest.class);
			if (!query.list().isEmpty()) {
				System.out.println("ϵ�б�����ѯ  �ɹ�");
				return query.list();

			} else {
				System.out.println("ϵ�б�����ѯ  ʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	public List<TContest> StudentGetAllContestInfo() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select *  from t_contest ");
			query.addEntity(TContest.class);
			if (!query.list().isEmpty()) {
				System.out.println("����ȫ������ ��Ϣ�ɹ�");
				return query.list();
			} else {
				System.out.println("����ȫ������ ��Ϣʧ��");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}

	}

	// ��ȡ�������Ϣ
	public List<TWorks> StudentGetAwareNews() {
		getSession();
		try {
			Transaction t = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("select *  from t_works order by c_checked_time desc limit 0,5 ");
			query.addEntity(TWorks.class);
			return query.list();

		} finally {
			// TODO: handle finally clause
			closeSession();
		}

	}

}
/* StudentDAOImpl End */
