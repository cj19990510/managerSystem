package cn.com.asadal.daoinf;

import java.util.List;

import org.vo.TContest;
import org.vo.TStudent;
import org.vo.TTeacher;

/**
 * admin功能接口
 * Inf 定义方法
 * 
 * @author Asadal
 *2019年4月22日 10:10:16
 */
public abstract interface AdminDAOInf {
	public TTeacher managerLogin(String managerAccount , String managerPasswd);
	/*增*/
	public boolean addContest(TContest contest);
	public boolean addStudent(TStudent student);
	public boolean addTeacher(TTeacher teacher);
	public boolean batchLoadContestInfo(String filePath);
	public boolean batchLoadStudentInfo(String filePath);
	public boolean batchLoadTeacherInfo(String filePath);

	/*删*/
	public boolean deleteContestInfoByID(int ID);
	public boolean deleteStudentInfoByID(int ID);
	public boolean deleteTeacherInfoByID(int ID);
	
	/*改 网页还未实现*/
	public boolean alterContestInfo(TContest contest);
	public boolean alterStudentInfo(TStudent student);
	public boolean alterTeacherInfo(TTeacher teacher);
	
	/*查 查询功能可能要更加多样*/
	public List<TContest> getAllContestInfo();
	public List<TStudent> getAllStudentInfo();
	public List<TTeacher> getAllTeacherInfo();
	
	
	/*队伍信息：1.显示全部队伍2.查询通过审核的队伍 3.查询未通过的队伍*/
	/*指导老师：根据比赛名 查找出队伍 和 指导老师信息*/
	public List getTeamInfoByContestName(String contestName);
	public List getCheckedTeamInfoByContestName(String contestName);
	public List getUnCheckedTeamInfoByContestName(String contestName);
	
	/*管理员审核队伍*/
	public boolean throughCheckedTeamByWorkId(int workId); 
	public boolean unthroughCheckedTeamByWorkId(int workId); 
	
	
	
	/*团队成员 ：查询某个比赛 全部队伍的成员 同时附带统计学生数量*/
    public List getAllPersonInTeamOfContestByContestName(String contestName);
    public List getAllAwardContestInfo();
    
	public List getPersonOfTeamByContestNameAndTeamName(String contestName,String teamName);
	
	
	

	
	
	
	
}
