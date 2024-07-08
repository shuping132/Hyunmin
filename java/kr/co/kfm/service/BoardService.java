package kr.co.kfm.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kfm.beans.CommentsBean;
import kr.co.kfm.beans.PageBean;
import kr.co.kfm.beans.PostBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.mapper.BoardMapper;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;

	@Value("${page.listcnt}")
	private int page_listcnt;

	@Value("${page.paginationcnt}")
	private int page_paginationcnt;

	@Autowired
	private BoardMapper boardMapper;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	private static volatile int writerCount = 0;// �ۼ��� ��ȣ
	// �Ƹ��� ���� ó��

	@SuppressWarnings("unused")
	private String saveUploadFile(MultipartFile upload_file) {

		String file_name = System.currentTimeMillis() + "_"
				+ FilenameUtils.getBaseName(upload_file.getOriginalFilename()) + "."
				+ FilenameUtils.getExtension(upload_file.getOriginalFilename());

		try {// ��ο� ���ϳ���
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file_name;
	}// saveUploadFile

	// QnA �۾���
	public void adduserContentInfo(PostBean writeContentBean) {

		MultipartFile upload_file = writeContentBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			System.out.println(file_name);
			writeContentBean.setImage(file_name);// ����Ŭ�� ���� �̸� ����
		}

		writeContentBean.setUser_idx(loginUserBean.getUser_idx());
		writeContentBean.setPost_type("QnA");
		writerCount++;
		String writer = "�ۼ���" + writerCount;
		writeContentBean.setWriter(writer);
		if (writerCount == 999)
			writerCount = 1;
		if (writeContentBean.getSecret_message() == false) {
			writeContentBean.setSecret_messagetext("N");
		} else if (writeContentBean.getSecret_message() == true) {
			writeContentBean.setSecret_messagetext("Y");
		}
		boardMapper.adduserContentInfo(writeContentBean);

	}

	// �������� �۸��
	public List<PostBean> getNoticeContentList(String post_type, int page) {
		/*
		 * 1->10 2->20 3->30
		 */

		int start = (page - 1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		System.out.println(post_type);
		System.out.println(page);
		return boardMapper.getNoticeContentList(post_type, rowBounds);
	}

	// QnA �۸��
	public List<PostBean> getQnAContentList(String post_type, int page) {
		/*
		 * 1->10 2->20 3->30
		 */

		int start = (page - 1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		System.out.println(post_type);
		System.out.println(page);
		return boardMapper.getQnAContentList(post_type, rowBounds);
	}

	// ������
	public PostBean getContentInfo(String Post_id) {
		System.out.println(Post_id);
		return boardMapper.getContentInfo(Post_id);
	}

	// �ۼ���
	public void modifyContentInfo(PostBean modifyContentBean) {

		MultipartFile upload_file = modifyContentBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			modifyContentBean.setImage(file_name);// ����Ŭ�� ���� �̸� ����
		}

		if (modifyContentBean.getSecret_message() == false) {
			modifyContentBean.setSecret_messagetext("N");
		} else if (modifyContentBean.getSecret_message() == true) {
			modifyContentBean.setSecret_messagetext("Y");
		}
		boardMapper.modifyContentInfo(modifyContentBean);
	}

	// �ۻ���
	public void deleteContentInfo(String post_id) {
		System.out.println(post_id);
		boardMapper.deleteContentInfo(post_id);
	}

	// �ش�Խ����� ��ü���� �� ��������
	public PageBean getContentCnt(String post_type, int currentPage) {
		int content_cnt = boardMapper.getContentCnt(post_type);

		PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		return pageBean;
	}

	// ����Է�
	public void addComments(CommentsBean CommentsWritingBean) {
		
		CommentsWritingBean.setManager_id(loginUserBean.getCompanyid());
		//�Ŵ��� ���̵� ������¹��� �𸣰���(�� ������ ���� ��)
		boardMapper.addComments(CommentsWritingBean);

	}
	
	//��۲������
	public List<CommentsBean> getComments(String Post_id) {
		return boardMapper.getComments(Post_id);
	}


}
