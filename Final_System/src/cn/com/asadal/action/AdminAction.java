package cn.com.asadal.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.util.MD5;
import org.vo.TContest;
import org.vo.TStudent;
import org.vo.TTeacher;
import org.vo.TWorks;

import com.opensymphony.xwork2.ActionSupport;

import cn.com.asadal.daoimpl.AdminDAOImpl;

public class AdminAction extends ActionSupport{

	private File upload;
	private String uploadFileName;
	private MD5 md5 = new MD5();
	private AdminDAOImpl  adminDAOImpl = new AdminDAOImpl();
	private TStudent student = new TStudent();
	private TTeacher teacher = new TTeacher();
	private TContest contest = new TContest();
	private TWorks works = new TWorks();
	
	public TWorks getWorks() {
		return works;
	}
	public void setWorks(TWorks works) {
		this.works = works;
	}
	public TContest getContest() {
		return contest;
	}
	public void setContest(TContest contest) {
		this.contest = contest;
	}

	public TStudent getStudent() {
		return student;
	}
	public void setStudent(TStudent student) {
		this.student = student;
	}
	public TTeacher getTeacher() {
		return teacher;
	}
	public void setTeacher(TTeacher teacher) {
		this.teacher = teacher;
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
	public String ManagerLogin() throws Exception{
		try{
			String md5Passwd = md5.makeMD5(teacher.getCPasswd());
			TTeacher manageMessage = adminDAOImpl.managerLogin(teacher.getCTeacherId(), md5Passwd);
			
			if(manageMessage!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("manageMessage", manageMessage);
	 			//判断manager身份  是指导老师or普通管理员
	 			if(manageMessage.getCIsAttend().equals("是")){
	 				System.out.println("指导老师");
	 				return LOGIN;
	 			}
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}

    /*批量上传 学生信息*/
	public String 	BatchLoadStudentInformation() throws Exception{
		try{
			String directory="/uploadfile/studentInfo";//在项目中中自己创建了 uploadfile 文件夹
            String uploaddirectory=ServletActionContext.getServletContext().getRealPath(directory);
			//通过这条语句可以找到 Tomcat uploadfile下 文件夹的位置
            System.out.println("This is a temp file. Tomcat will delete it after upload success. "+getUpload());
			 InputStream is= new FileInputStream(getUpload());// upload属性与jsp页面中的对应
			OutputStream os =new FileOutputStream(uploaddirectory+"\\"+uploadFileName);
			//路径 + 文件名称 确定位置
			System.out.println(uploaddirectory);
			System.out.println(uploadFileName);
			byte[] buffer=new byte[1024];
			int count=0;
			while((count=is.read(buffer))>0){
				os.write(buffer, 0, count);
			
			}
			adminDAOImpl.batchLoadStudentInfo(uploaddirectory+"\\"+uploadFileName);
		    os.close();
			is.close();
			
			AdminGetAllStudentInfo();
			return SUCCESS;
			
		}catch(Exception e ){
		    e.printStackTrace();
            return ERROR;	
		}
		
	}
	
	/*批量上传 竞赛信息*/
	public String 	BatchLoadContestInformation() throws Exception{
		try{
			String directory="/uploadfile/contestInfo";//在项目中中自己创建了 uploadfile 文件夹
			
			String uploaddirectory=ServletActionContext.getServletContext().getRealPath(directory);
			//通过这条语句可以找到 Tomcat uploadfile下 文件夹的位置
            System.out.println("This is a temp file. Tomcat will delete it after upload success. "+getUpload());
			
			
            InputStream is= new FileInputStream(getUpload());// upload属性与jsp页面中的对应
			OutputStream os =new FileOutputStream(uploaddirectory+"\\"+uploadFileName);
			//路径 + 文件名称 确定位置
			
			System.out.println(uploaddirectory);
			System.out.println(uploadFileName);
			
			byte[] buffer=new byte[1024];
			int count=0;
			while((count=is.read(buffer))>0){
				os.write(buffer, 0, count);
			
			}
			
			adminDAOImpl.batchLoadContestInfo(uploaddirectory+"\\"+uploadFileName);
		    os.close();
			is.close();

			AdminGetAllContestInfo();
		    return SUCCESS;
		}catch(Exception e ){
		    e.printStackTrace();
            return ERROR;	
		}
		
	}
	
	 /*批量上传 教师信息*/
		public String 	BatchLoadTeacherInformation() throws Exception{
			try{
				String directory="/uploadfile/teacherInfo";//在项目中中自己创建了 uploadfile 文件夹
				
				String uploaddirectory=ServletActionContext.getServletContext().getRealPath(directory);
				//通过这条语句可以找到 Tomcat uploadfile下 文件夹的位置
	            System.out.println("This is a temp file. Tomcat will delete it after upload success. "+getUpload());
				
				
	            InputStream is= new FileInputStream(getUpload());// upload属性与jsp页面中的对应
				OutputStream os =new FileOutputStream(uploaddirectory+"\\"+uploadFileName);
				//路径 + 文件名称 确定位置
				
				System.out.println(uploaddirectory);
				System.out.println(uploadFileName);
				
				byte[] buffer=new byte[1024];
				int count=0;
				while((count=is.read(buffer))>0){
					os.write(buffer, 0, count);
				
				}
				
				adminDAOImpl.batchLoadTeacherInfo(uploaddirectory+"\\"+uploadFileName);
			    os.close();
				is.close();

				AdminGetAllTeacherInfo();
        		return SUCCESS;
			
			}catch(Exception e ){
			    e.printStackTrace();
	            return ERROR;	
			}
			
		}
		
		
		/**
		 * 管理员添加单个竞赛信息
		 * @return
		 * @throws Exception
		 * 2019年4月22日 13:05:35
		 */
		public String AdminAddSingleContestInfo() throws Exception{
			try{
				String directory="/img/contest_picture";
	            String uploaddirectory=ServletActionContext.getServletContext().getRealPath(directory);
	            //不包含文件  不对
	            if(getUpload()==null){
	            	if(adminDAOImpl.addContest(contest)){
	            		AdminGetAllContestInfo();
	        		    return SUCCESS;          		
	            	}else{
						return ERROR;
					}
	            }else{
					InputStream is= new FileInputStream(getUpload());
					OutputStream os =new FileOutputStream(uploaddirectory+"\\"+uploadFileName);
					byte[] buffer=new byte[1024];
					int count=0;
					while((count=is.read(buffer))>0){
						os.write(buffer, 0, count);
					}
					os.close();
					is.close();
					contest.setCPicture("img/contest_picture/"+uploadFileName);
					if(adminDAOImpl.addContest(contest)){
						AdminGetAllContestInfo();
	        		    return SUCCESS;
					}else{
						return ERROR;
					}
						
				}
	         }catch(Exception e){
				e.printStackTrace();
				return ERROR;
			}finally{
				
			}
		}
	
	
	/**
	 * 管理员添加单个学生信息
	 * @return
	 * @throws Exception
	 * 2019年4月22日 13:05:35
	 */
	public String AdminAddSingleStudentInfo() throws Exception{
		try{
			student.setCPasswd("ed083b35cd7576e320ac65e2dc98c9a8");

			String directory="/img/stu_identity_card";
            String uploaddirectory=ServletActionContext.getServletContext().getRealPath(directory);
			
            //不包含文件  不对
            if(getUpload()==null){
            	
            	if(adminDAOImpl.addStudent(student)){
            		AdminGetAllStudentInfo();
            		return SUCCESS;
    				}else{
					return ERROR;
				}
            }else{
				InputStream is= new FileInputStream(getUpload());
				OutputStream os =new FileOutputStream(uploaddirectory+"\\"+uploadFileName);
				byte[] buffer=new byte[1024];
				int count=0;
				while((count=is.read(buffer))>0){
					os.write(buffer, 0, count);
				}
				os.close();
				is.close();
				student.setCIdentityCard("img/stu_identity_card/"+uploadFileName);
				if(adminDAOImpl.addStudent(student)){
					
			    List<TStudent> AdminGetAllStudentInfo = adminDAOImpl.getAllStudentInfo();
			    AdminGetAllStudentInfo();
        		return SUCCESS;
				}else{
					return ERROR;
				}
					
			}
         
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	/**
	 * 管理员添加单个教师信息
	 * @return
	 * @throws Exception
	 * 2019年4月22日 13:06:10
	 */
	public String AdminAddSingleTeacherInfo() throws Exception{
		try{
			teacher.setCPasswd("ed083b35cd7576e320ac65e2dc98c9a8");
			if(adminDAOImpl.addTeacher(teacher)){
				AdminGetAllTeacherInfo();
        		return SUCCESS;
				
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	/*删*/
	public String AdminDeleteContestInfo() throws Exception{
		System.out.println(contest.getCId());
		try{
			if(adminDAOImpl.deleteContestInfoByID(contest.getCId())){
				AdminGetAllContestInfo();
    		    return SUCCESS;
				
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	public String AdminDeleteStudentInfo() throws Exception{
		try{
			if(adminDAOImpl.deleteStudentInfoByID(student.getCId())){
				AdminGetAllStudentInfo();
    		    return SUCCESS;
				
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	public String AdminDeleteTeacherInfo() throws Exception{
		try{
			if(adminDAOImpl.deleteTeacherInfoByID(teacher.getId())){
				AdminGetAllTeacherInfo();
    		    return SUCCESS;
    		
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	
	
	
	/*查*/
	
	public String AdminGetAllContestInfo() throws Exception{
		try{
			//contestInfo
			List<TContest> AdminGetAllContestInfo = adminDAOImpl.getAllContestInfo();

			if(AdminGetAllContestInfo!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("AdminGetAllContestInfo", AdminGetAllContestInfo);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	public String AdminGetAllStudentInfo() throws Exception{
		try{
			//contestInfo
			List<TStudent> AdminGetAllStudentInfo = adminDAOImpl.getAllStudentInfo();

			if(AdminGetAllStudentInfo!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("AdminGetAllStudentInfo", AdminGetAllStudentInfo);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	public String AdminGetAllTeacherInfo() throws Exception{
		try{
			//contestInfo
			List<TTeacher> AdminGetAllTeacherInfo = adminDAOImpl.getAllTeacherInfo();

			if(AdminGetAllTeacherInfo!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("AdminGetAllTeacherInfo", AdminGetAllTeacherInfo);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	
	
	/*系统核心  对work表和attend表的处理*/
	
	
	public String AdminGetTeamInfoByContestName() throws Exception{
		try{
			//根据比赛名称 查出队伍信息
			List<TWorks> AdminGetTeamInfoByContestName = adminDAOImpl.getTeamInfoByContestName(works.getCContestName());
            String contestNameprocess = works.getCContestName();
			if(AdminGetTeamInfoByContestName!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("AdminGetTeamInfoByContestName", AdminGetTeamInfoByContestName);
	 			session.setAttribute("contestNameprocess", contestNameprocess);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	
	public String AdminGetCheckedTeamInfoByContestName() throws Exception{
		try{
		
			List<TWorks> CheckedTeamInfo = adminDAOImpl.getCheckedTeamInfoByContestName(works.getCContestName());

			if(CheckedTeamInfo!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("CheckedTeamInfo", CheckedTeamInfo);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	
	
	public String AdminGetUnCheckedTeamInfoByContestName() throws Exception{
		try{
			
			List<TWorks> UnCheckedTeamInfo = adminDAOImpl.getUnCheckedTeamInfoByContestName(works.getCContestName());

			if(UnCheckedTeamInfo!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("UnCheckedTeamInfo", UnCheckedTeamInfo);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	/*通过审核队伍*/
	public String AdminThroughCheckedTeamByWorkId() throws Exception{
		try{
			System.out.println("审核老师姓名:"+works.getCCheckedTeacherName());
			if(adminDAOImpl.throughCheckedTeamByWorkId(works.getCId())){
				//执行修改之后 要进行一次查询工作  通过/不通过审核 界面在personofteam界面  
				//原因 审核需要看到所有的学生  而 teamofcontest只是一个预览
				AdminGetPersonOfTeamByContestName();
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	/*不通过审核队伍*/
	public String AdminUnThroughCheckedTeamByWorkId() throws Exception{
		try{
			
			if(adminDAOImpl.unthroughCheckedTeamByWorkId(works.getCId())){
				AdminGetPersonOfTeamByContestName();
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	/*某个比赛 参加的所有队员信息*/
	public String AdminGetAllPersonOfContestByContestName() throws Exception{
		try{
			List<TWorks> AllPersonInTeamOfContest = adminDAOImpl.getAllPersonInTeamOfContestByContestName(works.getCContestName());

			if(AllPersonInTeamOfContest!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("AllPersonInTeamOfContest", AllPersonInTeamOfContest);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	public String AdminGetAllAwardContestInfo() throws Exception{
		try{
			
			List<TWorks> AdminGetAllAwardContestInfo = adminDAOImpl.getAllAwardContestInfo();

			if(AdminGetAllAwardContestInfo!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("AdminGetAllAwardContestInfo", AdminGetAllAwardContestInfo);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	/*某个队伍 所有队员信息*/
	public String AdminGetPersonOfTeamByContestName() throws Exception{
		try{
			List<TWorks> PersonOfTeamInfo = adminDAOImpl.getPersonOfTeamByContestNameAndTeamName(works.getCContestName(),works.getCTeamName());

			if(PersonOfTeamInfo!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
	 			HttpSession session = request.getSession();
	 			session.setAttribute("PersonOfTeamInfo", PersonOfTeamInfo);
				return SUCCESS;
			}else{
				return ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally{
			
		}
	}
	
	
	
	
	
	
	
	
}
