package domain;

public class File1 {
	private int id;
	private String filename1;
	private String filename2;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename1() {
		return filename1;
	}
	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}
	public String getFilename2() {
		return filename2;
	}
	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}
	public int count() {
		int count=0;
		if (filename1 !=null) {
			count+=1;
		}
		return count;
	}
	
}
