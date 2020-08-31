package hotel.domain;

public class Booking {
	private String name;
	private String date;
	private String room;
	private String addr;
	private String telnum;
	private String in_name;
	private String comment;
	private String write_date;
	private String processing;
	
	
	public Booking() {
		super();
	}
	
	
	public Booking(String name, String date, String room, String addr, String telnum, String in_name, String comment,
			String write_date, String processing) {
		super();
		this.name = name;
		this.date = date;
		this.room = room;
		this.addr = addr;
		this.telnum = telnum;
		this.in_name = in_name;
		this.comment = comment;
		this.write_date = write_date;
		this.processing = processing;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getIn_name() {
		return in_name;
	}
	public void setIn_name(String in_name) {
		this.in_name = in_name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getProcessing() {
		return processing;
	}
	public void setProcessing(String processing) {
		this.processing = processing;
	}


}
