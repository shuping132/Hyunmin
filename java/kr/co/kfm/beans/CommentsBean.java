package kr.co.kfm.beans;

public class CommentsBean {
	private String comments_id;
	private String post_id;
	private String manager_id;
	private String comments_content;
	private String comments_date;
	

	public String getComments_id() {
		return comments_id;
	}
	public void setComments_id(String comments_id) {
		this.comments_id = comments_id;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public String getComments_date() {
		return comments_date;
	}
	public void setComments_date(String comments_date) {
		this.comments_date = comments_date;
	}

	
}
