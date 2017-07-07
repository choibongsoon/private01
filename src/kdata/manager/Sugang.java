package kdata.manager;

public class Sugang {
	//조인할꺼 생각해서 , doc생성
	
	private String snum;
	private String sname;
	private String subjectcode;
	private String subjectname;
	private String grade;
	private String applydate;
	
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	@Override
	public String toString() {
		return "Sugang [snum=" + snum + ", sname=" + sname + ", subjectcode=" + subjectcode + ", subjectname="
				+ subjectname + ", grade=" + grade + ", applydate=" + applydate + "]";
	}
	
}
