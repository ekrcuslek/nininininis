package home.spring.myboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ip_check")
public class IpCheckVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column 
	private Long ipindex;
	
	@Column
	private Long bbsno;
	@Column
	private String userip;
	@Column
	private String viewtime;
	public Long getIpindex() {
		return ipindex;
	}
	public void setIpindex(Long ipindex) {
		this.ipindex = ipindex;
	}
	public Long getBbsno() {
		return bbsno;
	}
	public void setBbsno(Long bbsno) {
		this.bbsno = bbsno;
	}
	public String getUserip() {
		return userip;
	}
	public void setUserip(String userip) {
		this.userip = userip;
	}
	public String getViewtime() {
		return viewtime;
	}
	public void setViewtime(String viewtime) {
		this.viewtime = viewtime;
	}
	
	
	
	
	
	
}
