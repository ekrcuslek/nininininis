package home.spring.myboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment_table")
public class CommentVO {
	
	@Id
	@GeneratedValue
	@Column
	private Long comno;
	
	@Column
	private Long bbsno;
	
	@Column
	private String comment;
	
	@Column
	private String writedDate;
	
	@Column
	private String userId;

	public Long getComno() {
		return comno;
	}

	public void setComno(Long comno) {
		this.comno = comno;
	}

	public Long getBbsno() {
		return bbsno;
	}

	public void setBbsno(Long bbsno) {
		this.bbsno = bbsno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getWritedDate() {
		return writedDate;
	}

	public void setWritedDate(String writedDate) {
		this.writedDate = writedDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
