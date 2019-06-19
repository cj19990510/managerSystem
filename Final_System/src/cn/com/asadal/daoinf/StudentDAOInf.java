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
 * user功能接口
 * Inf 定义方法
 * 
 * @author Asadal
 *2019年4月8日 12:31:40
 */

public abstract interface StudentDAOInf {
	//学生登录
	public TStudent StudentLogin(String userAccount , String userPasswd);
	public boolean StudentAlterSelfInfo(TStudent student);
	public boolean StudentAlterPasswd(String userAccount , String userPasswd,String newPasswd);
	//访问首页从数据库取出最新的信息
	public List<TContest> MainDemoGetNationalContestInfo();
	public List<TContest> MainDemoGetProvincinalContestInfo();
	public List<TNews> MainDemoGetNewsInfo();
	
	public TContest StudentGetSingleContestByConName(String contestName);
	
	//参赛前 从数据库查出最近比赛信息  指导老师信息
	public List<TContest> StudentGetCurrentContestInfo();
	public List<TTeacher> StudentGetTeacherInfo();
	
	

	public boolean StudentAttendContest(TWorks workMessage);
	public boolean StudentAddAttendInfo(TAttend attend);
	
	//查看自身参赛情况
	public List<AttendWithWorks> StudentGetSelfAttendContestByStuName(String studentName);
	
	/*作品列表  展示  队长修改功能*/
	public List<TWorks> StudentGetAllWorkInfo();
    public List<TWorks> Student_Leader_GetAllWorkInfo(String studentName);
    public TWorks StudentGetWorkSingleMessage(int contestId , String studentName);
	public boolean StudentAlterWorkMessage(TWorks work);
	
	//通讯录功能
	public List<TStudent> StudentGetAllFormalStudentMessage();
	
	
	public TStudent GetStudentInfoByID(String studentID);
	
	
	/*echarts 全流程显示参数情况*/
	public ArrayList getContest_NodesByContestName(String contestName);
	public ArrayList getContest_TeamNodesByContestName(String contestName);
	public ArrayList getContest_TeamPeopleNodesByContestName(String contestName);
	public ArrayList getContest_Team_linksByContestName(String contestName);
	public ArrayList getTeam_People_linksByContestName(String contestName);
	//获得往届参赛信息
	public List getSeriesContestName(String contestName);
	public List<TContest> StudentGetAllContestInfo();
	
	
	
	

}
