package cn.com.asadal.daoinf;

import java.util.List;

import org.vo.TContest;
import org.vo.TStudent;
import org.vo.TTeacher;

/**
 * admin���ܽӿ�
 * Inf ���巽��
 * 
 * @author Asadal
 *2019��4��22�� 10:10:16
 */
public abstract interface AdminDAOInf {
	public TTeacher managerLogin(String managerAccount , String managerPasswd);
	/*��*/
	public boolean addContest(TContest contest);
	public boolean addStudent(TStudent student);
	public boolean addTeacher(TTeacher teacher);
	public boolean batchLoadContestInfo(String filePath);
	public boolean batchLoadStudentInfo(String filePath);
	public boolean batchLoadTeacherInfo(String filePath);

	/*ɾ*/
	public boolean deleteContestInfoByID(int ID);
	public boolean deleteStudentInfoByID(int ID);
	public boolean deleteTeacherInfoByID(int ID);
	
	/*�� ��ҳ��δʵ��*/
	public boolean alterContestInfo(TContest contest);
	public boolean alterStudentInfo(TStudent student);
	public boolean alterTeacherInfo(TTeacher teacher);
	
	/*�� ��ѯ���ܿ���Ҫ���Ӷ���*/
	public List<TContest> getAllContestInfo();
	public List<TStudent> getAllStudentInfo();
	public List<TTeacher> getAllTeacherInfo();
	
	
	/*������Ϣ��1.��ʾȫ������2.��ѯͨ����˵Ķ��� 3.��ѯδͨ���Ķ���*/
	/*ָ����ʦ�����ݱ����� ���ҳ����� �� ָ����ʦ��Ϣ*/
	public List getTeamInfoByContestName(String contestName);
	public List getCheckedTeamInfoByContestName(String contestName);
	public List getUnCheckedTeamInfoByContestName(String contestName);
	
	/*����Ա��˶���*/
	public boolean throughCheckedTeamByWorkId(int workId); 
	public boolean unthroughCheckedTeamByWorkId(int workId); 
	
	
	
	/*�Ŷӳ�Ա ����ѯĳ������ ȫ������ĳ�Ա ͬʱ����ͳ��ѧ������*/
    public List getAllPersonInTeamOfContestByContestName(String contestName);
    public List getAllAwardContestInfo();
    
	public List getPersonOfTeamByContestNameAndTeamName(String contestName,String teamName);
	
	
	

	
	
	
	
}
