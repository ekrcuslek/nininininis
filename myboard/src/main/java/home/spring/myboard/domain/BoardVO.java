package home.spring.myboard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hihi_board")
public class BoardVO {
	@Id
	@GeneratedValue
	@Column
	private Long bbsno;
	
	@Column
	private String title;
	
	@Column
	private Long grpno; // 글의 그룹 번호, 어떤 게시판에 속해 있는지, 원글일 경우 자신의 bbsno
	
	@Column
	private Long grpord; // 그룹내 순서, 즉 부모 게시글에 소속된 게시글의 순서
	
	@Column
	private Long depth; // 답글의 답글일 수록 커짐
	
	@Column
	private String content;
	
	@Column
	private String userId;
	
	@Column 
	private String writedDate;
	
	@Column
	private Long viewcnt;
	
	@Column
	private Long likecnt;
	
	@Column
	private String fileName;

	@Column
	private String updatedDate;
	
	
	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getBbsno() {
		return bbsno;
	}

	public void setBbsno(Long bbsno) {
		this.bbsno = bbsno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getGrpno() {
		return grpno;
	}

	public void setGrpno(Long grpno) {
		this.grpno = grpno;
	}

	public Long getGrpord() {
		return grpord;
	}

	public void setGrpord(Long grpord) {
		this.grpord = grpord;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getWritedDate() {
		return writedDate;
	}

	public void setWritedDate(String writedDate) {
		this.writedDate = writedDate;
	}

	public Long getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(Long viewcnt) {
		this.viewcnt = viewcnt;
	}

	public Long getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(Long likecnt) {
		this.likecnt = likecnt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
