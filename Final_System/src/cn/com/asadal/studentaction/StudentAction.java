package cn.com.asadal.studentaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.Validate;
import org.apache.struts2.ServletActionContext;
import org.util.InputData;
import org.util.MD5;
import org.util.alter;
import org.vo.AttendWithWorks;
import org.vo.TAttend;
import org.vo.TContest;
import org.vo.TStudent;
import org.vo.TTeacher;
import org.vo.TWorks;

import cn.com.asadal.beans.ItemStyle;
import cn.com.asadal.beans.Links;
import cn.com.asadal.beans.Nodes;
import cn.com.asadal.beans.Normal;
import cn.com.asadal.daoimpl.StudentDAOImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result;
	private StudentDAOImpl studnetDAOImpl = new StudentDAOImpl();
	private MD5 md5 = new MD5();
	private TStudent student = new TStudent();
	private String newPasswd;
	private TContest contest = new TContest();
	private TWorks workMessage = new TWorks();
	private String partner1;
	private String partner2;
	private String partner3;
	private String partner4;
	private String contest_choose;
	private String teacher_id;
	private File upload;
	private File uploadTeam;
	private String uploadTeamFileName;
	private String uploadFileName;
	private String randCode;

	public String getRandCode() {
		return randCode;
	}

	public void setRandCode(String randCode) {
		this.randCode = randCode;
	}

	public String getEchartsParameter() {
		return echartsParameter;
	}

	public void setEchartsParameter(String echartsParameter) {
		this.echartsParameter = echartsParameter;
	}

	private String echartsParameter;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNewPasswd() {
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}

	public TContest getContest() {
		return contest;
	}

	public void setContest(TContest contest) {
		this.contest = contest;
	}

	public String getUploadTeamFileName() {
		return uploadTeamFileName;
	}

	public void setUploadTeamFileName(String uploadTeamFileName) {
		this.uploadTeamFileName = uploadTeamFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUploadTeam() {
		return uploadTeam;
	}

	public void setUploadTeam(File uploadTeam) {
		this.uploadTeam = uploadTeam;
	}

	public String getPartner2() {
		return partner2;
	}

	public void setPartner2(String partner2) {
		this.partner2 = partner2;
	}

	public String getPartner3() {
		return partner3;
	}

	public void setPartner3(String partner3) {
		this.partner3 = partner3;
	}

	public String getPartner4() {
		return partner4;
	}

	public void setPartner4(String partner4) {
		this.partner4 = partner4;
	}

	public TWorks getWorkMessage() {
		return workMessage;
	}

	public void setWorkMessage(TWorks workMessage) {
		this.workMessage = workMessage;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getPartner1() {
		return partner1;
	}

	public void setPartner1(String partner1) {
		this.partner1 = partner1;
	}

	public String getContest_choose() {
		return contest_choose;
	}

	public void setContest_choose(String contest_choose) {
		this.contest_choose = contest_choose;
	}

	public TStudent getStudent() {
		return student;
	}

	public void setStudent(TStudent student) {
		this.student = student;
	}

	public static void main(String args[]) {
		StudentAction studentAction = new StudentAction();
		try {
			studentAction.EchartsShowSeriesOfContest_Team_Person_MakeLocalJSONFile();
			// studentAction.EchartsShowSingleContest_Team_Person_MakeLocalJSONFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void validate() {
	// String randcode1=(String)
	// ActionContext.getContext().getSession().get("CHECKCODE");
	// System.out.println(randcode1);
	// if(randCode!=randcode1){
	// addFieldError("randCode","��֤�����");
	// }
	//
	// }
	/**
	 * ���ܣ���������ʾ���� ������������ session��������
	 * 
	 * @return
	 * @throws Exception
	 *             2019��4��17�� 10:57:20
	 */
	public String MainDemoShow() throws Exception {
		System.out.println("��ȡ����");
		try {
			List<TContest> MainDemoNationalContestInfo = studnetDAOImpl.MainDemoGetNationalContestInfo();
			List<TContest> MainDemoProvincinalContestInfo = studnetDAOImpl.MainDemoGetProvincinalContestInfo();
			List MainDemoNewsInfo = studnetDAOImpl.MainDemoGetNewsInfo();
			if (MainDemoNationalContestInfo != null && MainDemoProvincinalContestInfo != null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("MainDemoNationalContestInfo", MainDemoNationalContestInfo);
				session.setAttribute("MainDemoProvincinalContestInfo", MainDemoProvincinalContestInfo);
				session.setAttribute("MainDemoNewsInfo", MainDemoNewsInfo);
				return SUCCESS;
			} else {

				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ��û���¼ ��¼���ѯ��ĳ���û���������Ϣ studentMessage��Ϊ��������ҳ�б���
	 * 
	 * @throws Exception
	 * @author Asadal 2019��4��8�� 12:38:08
	 */
	public String StudentLogin() throws Exception {

		try {
			String md5Passwd = md5.makeMD5(student.getCPasswd());
			TStudent studentMessage = studnetDAOImpl.StudentLogin(student.getCStuId(), md5Passwd);

			if (studentMessage != null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("studentMessage", studentMessage);
				this.MainDemoShow();
				return SUCCESS;
			} else {
				alter al = new alter();
				al.put(ServletActionContext.getResponse(), "�˺Ż��������");
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	public void validate() {
		String randcode1 = (String) ActionContext.getContext().getSession().get("CHECKCODE");
		if(randcode1.isEmpty()){
			if (!randCode.equalsIgnoreCase(randcode1)) {
				alter al = new alter();
				try {
					al.put(ServletActionContext.getResponse(), "��֤�����");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public String StudentExit() throws Exception {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.invalidate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	public String StudentGetSingleContest() throws Exception {
		try {

			if (student.getCName().equals("")) {
				return LOGIN;
			}
			System.out.println(contest.getCName());
			TContest StudentGetSingleContest = studnetDAOImpl.StudentGetSingleContestByConName(contest.getCName());
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("StudentGetSingleContest", StudentGetSingleContest);
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	public String StudentAlterPasswd() throws Exception {
		try {
			System.out.println(student.getCStuId());
			String oldPasswdMD5 = md5.makeMD5(student.getCPasswd());
			System.out.println("ԭ����md5" + oldPasswdMD5);

			String newPasswdMD5 = md5.makeMD5(newPasswd);
			System.out.println("������md5" + newPasswdMD5);
			if (studnetDAOImpl.StudentAlterPasswd(student.getCStuId(), oldPasswdMD5, newPasswdMD5)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	public String StudentAlterSelfInfo() throws Exception {
		try {
			String directory = "/img/stu_identity_card";// ����Ŀ�����Լ������� uploadfile
														// �ļ���
			String uploaddirectory = ServletActionContext.getServletContext().getRealPath(directory);
			// ͨ�������������ҵ� Tomcat uploadfile�� �ļ��е�λ��
			System.out.println("This is a temp file. Tomcat will delete it after upload success. " + getUpload());

			// �������ļ� ����
			if (getUpload() == null) {
				System.out.println("û���ļ���");
				studnetDAOImpl.StudentAlterSelfInfo(student);
				TStudent studentMessage = studnetDAOImpl.GetStudentInfoByID(student.getCStuId());
				if (studentMessage != null) {
					HttpServletRequest request = ServletActionContext.getRequest();
					HttpSession session = request.getSession();
					session.setAttribute("studentMessage", studentMessage);
					return SUCCESS;
				} else {
					return ERROR;
				}

			} else {
				InputStream is = new FileInputStream(getUpload());// upload������jspҳ���еĶ�Ӧ
				OutputStream os = new FileOutputStream(uploaddirectory + "\\" + uploadFileName);
				// ·�� + �ļ����� ȷ��λ��
				System.out.println(uploaddirectory);
				System.out.println(uploadFileName);
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					os.write(buffer, 0, count);

				}
				os.close();
				is.close();

				student.setCIdentityCard("img/stu_identity_card/" + uploadFileName);
				studnetDAOImpl.StudentAlterSelfInfo(student);
				TStudent studentMessage = studnetDAOImpl.GetStudentInfoByID(student.getCStuId());
				if (studentMessage != null) {
					HttpServletRequest request = ServletActionContext.getRequest();
					HttpSession session = request.getSession();
					session.setAttribute("studentMessage", studentMessage);
					return SUCCESS;
				} else {
					return ERROR;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ������μӱ���ǰ �����ݿ�ȡ����ӡ��Ϣ ��� "�����μ�"�Ȱ�ť�� �����ݿ��в�����Ӧ��������Ϣ��ָ����ʦ��Ϣ
	 * 
	 * @throws Exception
	 * @author Asadal 2019��4��15�� 15:29:10
	 */
	public String StudentGetCurrentContestAndTeacherInfo() throws Exception {
		try {

			if (student.getCName().equals("")) {
				return LOGIN;
			}
			// contestInfo
			List<TContest> currentContestInfo = studnetDAOImpl.StudentGetCurrentContestInfo();
			// teacherInfo
			List<TTeacher> teacherInfo = studnetDAOImpl.StudentGetTeacherInfo();
			if (currentContestInfo != null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("currentContestInfo", currentContestInfo);
				session.setAttribute("teacherInfo", teacherInfo);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ�ѧ�������μӱ��� ���������,�����ű������޸ģ�������������һ�����ݣ�ĳЩ��Ҫ�ȱ�������������У������֤����������Ʒ��
	 * 
	 * @throws Exception
	 * @author Asadal 2019��4��16�� 15:29:48
	 */
	public String StudentAttendContest() throws Exception {
		try {
			List<String> partnerList = new ArrayList();
			if (!partner1.equals("")) {
				partnerList.add(partner1);
			}
			if (!partner2.equals("")) {
				partnerList.add(partner2);
			}
			if (!partner3.equals("")) {
				partnerList.add(partner3);
			}
			if (!partner4.equals("")) {
				partnerList.add(partner4);
			}

			workMessage.setCContestName(contest_choose);
			workMessage.setCAttendTeacherName(teacher_id);
			workMessage.setCTeamPicture("ȱ��");
			workMessage.setCAttendLetter("ȱ��");
			workMessage.setCCheckedTeacherName("ȱ��");

			workMessage.setCAwardCertificate("���ϴ�");
			workMessage.setCWorksShow("������");
			workMessage.setCWorksAddress("������");
			workMessage.setCWorksPasswd("������");
			workMessage.setCExperience("������");

			workMessage.setCChecked("δͨ��");

			if (studnetDAOImpl.StudentAttendContest(workMessage)) {
				// ������һ�������� �õ� �ող��� work ��� c_id �������attend��ʹ��
				int work_id = studnetDAOImpl.StudentGetWorksID(workMessage);

				// attend����ӳ���Ϣ
				TAttend leaderAttend = new TAttend();
				leaderAttend.setCWorksId(work_id);
				leaderAttend.setCStuName(workMessage.getCStuName());
				leaderAttend.setCIsTeamWork("��");
				leaderAttend.setCIsTeamLeader("��");
				leaderAttend.setCLeaderStuName(workMessage.getCStuName());
				studnetDAOImpl.StudentAddAttendInfo(leaderAttend);

				// attend�����Ա��Ϣ
				for (String temp : partnerList) {
					TAttend attend = new TAttend();
					attend.setCWorksId(work_id);
					attend.setCStuName(temp);
					attend.setCIsTeamWork("��");
					attend.setCIsTeamLeader("��");
					attend.setCLeaderStuName(workMessage.getCStuName());
					studnetDAOImpl.StudentAddAttendInfo(attend);
				}
				Student_Leader_GetAllWorkInfo();
				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ�ѧ���ο��Լ��Ĳ�����Ϣ ����ѧ������ ��attend���в�ѯ
	 * 
	 * @throws Exception
	 * @author Asadal 2019��4��16�� 15:29:48
	 */
	public String StudentGetSelfAttendContest() throws Exception {
		try {
			System.out.println("�鿴" + student.getCName() + "�Ĳ�����Ϣ");
			List<AttendWithWorks> studentGetSelfAttendInfo = studnetDAOImpl
					.StudentGetSelfAttendContestByStuName(student.getCName());
			if (studentGetSelfAttendInfo != null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("studentGetSelfAttendInfo", studentGetSelfAttendInfo);

				return SUCCESS;
			} else {
				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * all work list part 1
	 * 
	 * @return
	 * @throws Exception
	 *             2019��4��21�� 12:31:45
	 */
	public String StudentGetAllWorkInfo() throws Exception {
		try {

			if (student.getCName().equals("")) {
				return LOGIN;
			}
			List<TWorks> studentAllWorks = studnetDAOImpl.StudentGetAllWorkInfo();

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("studentAllWorks", studentAllWorks);
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ��ӳ�����ֻ�����Լ��Ĳ�����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 *             2019��4��21�� 12:31:45
	 */
	public String Student_Leader_GetAllWorkInfo() throws Exception {
		try {
			System.out.println(workMessage.getCStuName());
			List<TWorks> studentLeaderWorks = studnetDAOImpl.Student_Leader_GetAllWorkInfo(workMessage.getCStuName());

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("studentLeaderWorks", studentLeaderWorks);
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ�ѧ�����list���е�������Բ鿴�������Ϣ �����ļ����� �ӳ��鿴��Ʒ��ϢLeaderGetWorkMessage Ҳ�ǵ����������
	 * ��ת����Ϣ��ʾ�ҿ����޸ĵ�ҳ��
	 * 
	 * @return
	 * @throws Exception
	 *             2019��4��21�� 12:31:45
	 */
	public String StudentGetWorkMessage() throws Exception {
		try {
			TWorks studentSingleWork = studnetDAOImpl.StudentGetWorkSingleMessage(workMessage.getCId(),
					workMessage.getCStuName());

			if (studentSingleWork != null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("studentSingleWork", studentSingleWork);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ�ѧ��(�ӳ����е�Ȩ��)�޸�work����Ϣ alter
	 * 
	 * @return
	 * @throws Exception
	 */
	public String StudentAlterWorkMessage() throws Exception {
		try {
			System.out.println("check Info" + workMessage.getCStuName());

			String directory = "/img/award_certificate";
			String uploaddirectory = ServletActionContext.getServletContext().getRealPath(directory);

			String teamdirectory = "/img/team_picture";
			String uploadteamdirectory = ServletActionContext.getServletContext().getRealPath(teamdirectory);

			// û���ļ�
			if (getUpload() == null && getUploadTeam() == null) {
				System.out.println("û���κ��ļ��ϴ�--��������");
				if (studnetDAOImpl.StudentAlterWorkMessage(workMessage)) {
					Student_Leader_GetAllWorkInfo();
				} else {
					return ERROR;
				}

			}

			if (getUpload() != null && getUploadTeam() == null) {// �л�֤���ļ�

				InputStream is = new FileInputStream(getUpload());
				OutputStream os = new FileOutputStream(uploaddirectory + "\\" + uploadFileName);

				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					os.write(buffer, 0, count);
				}
				os.close();
				is.close();
				workMessage.setCAwardCertificate("img/award_certificate/" + uploadFileName);
				if (studnetDAOImpl.StudentAlterWorkMessage(workMessage)) {
					Student_Leader_GetAllWorkInfo();
				} else {
					return ERROR;
				}
			}

			if (getUpload() == null && getUploadTeam() != null) {// ��team_picture�ļ�

				InputStream is = new FileInputStream(getUploadTeam());// upload������jspҳ���еĶ�Ӧ
				OutputStream os = new FileOutputStream(uploadteamdirectory + "\\" + uploadTeamFileName);
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					os.write(buffer, 0, count);
				}
				os.close();
				is.close();
				workMessage.setCTeamPicture("img/team_picture/" + uploadTeamFileName);
				if (studnetDAOImpl.StudentAlterWorkMessage(workMessage)) {
					Student_Leader_GetAllWorkInfo();
				} else {
					return ERROR;
				}
			}

			if (getUpload() != null && getUploadTeam() != null) {// �������ļ�

				InputStream isteam = new FileInputStream(getUploadTeam());
				OutputStream osteam = new FileOutputStream(uploadteamdirectory + "\\" + uploadTeamFileName);

				byte[] bufferteam = new byte[1024];
				int countteam = 0;
				while ((countteam = isteam.read(bufferteam)) > 0) {
					osteam.write(bufferteam, 0, countteam);
				}
				osteam.close();
				isteam.close();

				InputStream is = new FileInputStream(getUpload());
				OutputStream os = new FileOutputStream(uploaddirectory + "\\" + uploadFileName);
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					os.write(buffer, 0, count);
				}
				os.close();
				is.close();

				workMessage.setCAwardCertificate("img/award_certificate/" + uploadFileName);
				workMessage.setCTeamPicture("img/team_picture/" + uploadTeamFileName);

				if (studnetDAOImpl.StudentAlterWorkMessage(workMessage)) {
					Student_Leader_GetAllWorkInfo();
				} else {
					return ERROR;
				}
			}

			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	/**
	 * ���ܣ�ѧ����Ϣ���٣�ͨѶ¼��
	 * 
	 * @return
	 * @throws Exception
	 *             2019��4��21�� 16:04:40
	 */
	public String StudentGetAllFormalStudentMessage() throws Exception {
		try {
			if (student.getCName().equals("")) {
				return LOGIN;
			}
			List<TStudent> allStudentMessage = studnetDAOImpl.StudentGetAllFormalStudentMessage();

			if (allStudentMessage != null) {
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("allStudentMessage", allStudentMessage);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		} finally {

		}
	}

	public String EchartsGetContestName() throws Exception {
		System.out.println("Echarts ����" + echartsParameter);
		if (!echartsParameter.equals("")) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("echartsParameter", echartsParameter);
			return SUCCESS;

		} else {
			return ERROR;
		}
	}

	public String EchartsShowSingleContest_Team_Person() throws Exception {

		String realPath = ServletActionContext.getServletContext()
				.getRealPath("/SingleContestShowEchartsData/" + echartsParameter + ".txt");
		InputData analysisJson = new InputData();
		result = analysisJson.readToString(realPath);
		return SUCCESS;

	}

	public String EchartsShowSingleContest_Team_Person_MakeLocalJSONFile() throws Exception {

		List<TContest> list = studnetDAOImpl.StudentGetAllContestInfo();
		for (TContest a : list) {
			System.out.println("����¼��" + a.getCName() + "������Ϣ");
			ArrayList<Nodes> nodes = new ArrayList<Nodes>();
			nodes.addAll(studnetDAOImpl.getContest_NodesByContestName(a.getCName()));
			nodes.addAll(studnetDAOImpl.getContest_TeamNodesByContestName(a.getCName()));
			nodes.addAll(studnetDAOImpl.getContest_TeamPeopleNodesByContestName(a.getCName()));

			ArrayList<Links> links = new ArrayList<Links>();
			links.addAll(studnetDAOImpl.getContest_Team_linksByContestName(a.getCName()));
			links.addAll(studnetDAOImpl.getTeam_People_linksByContestName(a.getCName()));

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("nodes", nodes);
			data.put("links", links);
			JSONObject listArray = JSONObject.fromObject(data);
			String strArray = listArray.toString();

			OutputStreamWriter outStream = null;
			outStream = new OutputStreamWriter(new FileOutputStream("./SingleContest/" + a.getCName() + ".txt"),
					"UTF-8");
			BufferedWriter writer = new BufferedWriter(outStream);
			writer.write(strArray);
			writer.close();
		}
		return SUCCESS;
	}

	public String EchartsShowSeriesOfContest_Team_Person() throws Exception {

		String realPath = ServletActionContext.getServletContext()
				.getRealPath("/SeriesContestShowEchartsData/" + echartsParameter + ".txt");

		InputData analysisJson = new InputData();

		result = analysisJson.readToString(realPath);

		System.out.println("Ӧ�÷��صĽ����" + result);
		return SUCCESS;

	}

	public String EchartsShowSeriesOfContest_Team_Person_MakeLocalJSONFile() throws Exception {

		String[] SeriesContestName = { "ACM-ICPC", "�й���ѧ������������´�ҵ����", "���й����������ѧ�������ƴ���", "�й���ѧ���������ƴ���", "�й���ѧ��������ƾ���",
				"���ű�ȫ���������Ϣ����רҵ�˲Ŵ���", "�й���У���������-����������������", "����ʡ��ѧ�������������ƾ���", "ȫ����ҽҩԺУ������ƾ���" };
		for (String temp : SeriesContestName) {
			List<TContest> list = studnetDAOImpl.getSeriesContestName(temp);

			ArrayList<Nodes> nodes = new ArrayList<Nodes>();
			ArrayList<Links> links = new ArrayList<Links>();
			Map<String, Object> data = new HashMap<String, Object>();

			for (TContest a : list) {
				System.out.println("ϵ����" + a.getCName());
				nodes.addAll(studnetDAOImpl.getContest_NodesByContestName(a.getCName()));
				nodes.addAll(studnetDAOImpl.getContest_TeamNodesByContestName(a.getCName()));
				nodes.addAll(studnetDAOImpl.getContest_TeamPeopleNodesByContestName(a.getCName()));

				links.addAll(studnetDAOImpl.getContest_Team_linksByContestName(a.getCName()));
				links.addAll(studnetDAOImpl.getTeam_People_linksByContestName(a.getCName()));
				data.put("nodes", nodes);
				data.put("links", links);
			}
			JSONObject listArray = JSONObject.fromObject(data);
			String strArray = listArray.toString();
			System.out.println("һ�ֽ���");

			OutputStreamWriter outStream = null;
			outStream = new OutputStreamWriter(new FileOutputStream("./SeriesContest/" + temp + ".txt"), "UTF-8");
			BufferedWriter writer = new BufferedWriter(outStream);
			writer.write(strArray);
			writer.close();

		}

		return SUCCESS;
	}

}
