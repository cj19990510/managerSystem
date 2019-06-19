package cn.com.asadal.daoinf;

import java.util.ArrayList;
import java.util.List;

import org.vo.AttendWithWorks;
import org.vo.TAttend;
import org.vo.TContest;
import org.vo.TNews;
import org.vo.TStudent;
import org.vo.TTeacher;
import org.vo.TWorks;




/**
 * user���ܽӿ�
 * Inf ���巽��
 * 
 * @author Asadal
 *2019��4��8�� 12:31:40
 */

public abstract interface StudentDAOInf {
	//ѧ����¼
	public TStudent StudentLogin(String userAccount , String userPasswd);
	public boolean StudentAlterSelfInfo(TStudent student);
	public boolean StudentAlterPasswd(String userAccount , String userPasswd,String newPasswd);
	//������ҳ�����ݿ�ȡ�����µ���Ϣ
	public List<TContest> MainDemoGetNationalContestInfo();
	public List<TContest> MainDemoGetProvincinalContestInfo();
	public List<TNews> MainDemoGetNewsInfo();
	
	public TContest StudentGetSingleContestByConName(String contestName);
	
	//����ǰ �����ݿ������������Ϣ  ָ����ʦ��Ϣ
	public List<TContest> StudentGetCurrentContestInfo();
	public List<TTeacher> StudentGetTeacherInfo();
	
	

	public boolean StudentAttendContest(TWorks workMessage);
	public boolean StudentAddAttendInfo(TAttend attend);
	
	//�鿴����������
	public List<AttendWithWorks> StudentGetSelfAttendContestByStuName(String studentName);
	
	/*��Ʒ�б�  չʾ  �ӳ��޸Ĺ���*/
	public List<TWorks> StudentGetAllWorkInfo();
    public List<TWorks> Student_Leader_GetAllWorkInfo(String studentName);
    public TWorks StudentGetWorkSingleMessage(int contestId , String studentName);
	public boolean StudentAlterWorkMessage(TWorks work);
	
	//ͨѶ¼����
	public List<TStudent> StudentGetAllFormalStudentMessage();
	
	
	public TStudent GetStudentInfoByID(String studentID);
	
	
	/*echarts ȫ������ʾ�������*/
	public ArrayList getContest_NodesByContestName(String contestName);
	public ArrayList getContest_TeamNodesByContestName(String contestName);
	public ArrayList getContest_TeamPeopleNodesByContestName(String contestName);
	public ArrayList getContest_Team_linksByContestName(String contestName);
	public ArrayList getTeam_People_linksByContestName(String contestName);
	//������������Ϣ
	public List getSeriesContestName(String contestName);
	public List<TContest> StudentGetAllContestInfo();
	
	
	
	

}
