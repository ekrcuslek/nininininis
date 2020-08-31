package domain;

public class Student {
	
	private String name;
	private int stuID;
	private int korPT;
	private int engPT;
	private int matPT;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public int getKorPT() {
		return korPT;
	}
	public void setKorPT(int korPT) {
		this.korPT = korPT;
	}
	public int getEngPT() {
		return engPT;
	}
	public void setEngPT(int engPT) {
		this.engPT = engPT;
	}
	public int getMatPT() {
		return matPT;
	}
	public void setMatPT(int matPT) {
		this.matPT = matPT;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", stuID=" + stuID + ", korPT=" + korPT + ", engPT=" + engPT + ", matPT="
				+ matPT + "]";
	}
	
	
}
