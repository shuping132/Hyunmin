package kr.co.kfm.beans;

import org.springframework.web.multipart.MultipartFile;

public class PostBean {
	private String manager_id;
	private String user_idx;
	private String post_id;
	private String post_type;
	private String title;
	private String writer;
	private String post_content;
	private String image;
	private String date_created;
	private Boolean secret_message;
	private MultipartFile upload_file; // 브라우저가 보낸 파일 데이터
	private String secret_messagetext;

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public Boolean getSecret_message() {
		return secret_message;
	}

	public void setSecret_message(Boolean secret_message) {
		this.secret_message = secret_message;
	}

	public MultipartFile getUpload_file() {
		return upload_file;
	}

	public void setUpload_file(MultipartFile upload_file) {
		this.upload_file = upload_file;
	}

	public String getSecret_messagetext() {
		return secret_messagetext;
	}

	public void setSecret_messagetext(String secret_messagetext) {
		this.secret_messagetext = secret_messagetext;
	}

	@Override
	public String toString() {
		return "PostBean [manager_id=" + manager_id + ", user_idx=" + user_idx + ", post_id=" + post_id + ", post_type="
				+ post_type + ", title=" + title + ", writer=" + writer + ", post_content=" + post_content + ", image="
				+ image + ", date_created=" + date_created + ", secret_message=" + secret_message + ", upload_file="
				+ upload_file + ", secret_messagetext=" + secret_messagetext + "]";
	}

}
