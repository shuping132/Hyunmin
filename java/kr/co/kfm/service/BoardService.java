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

	private static volatile int writerCount = 0;// 작성자 번호
	// 아마도 파일 처리

	@SuppressWarnings("unused")
	private String saveUploadFile(MultipartFile upload_file) {

		String file_name = System.currentTimeMillis() + "_"
				+ FilenameUtils.getBaseName(upload_file.getOriginalFilename()) + "."
				+ FilenameUtils.getExtension(upload_file.getOriginalFilename());

		try {// 경로와 파일네임
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file_name;
	}// saveUploadFile

	// QnA 글쓰기
	public void adduserContentInfo(PostBean writeContentBean) {

		MultipartFile upload_file = writeContentBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			System.out.println(file_name);
			writeContentBean.setImage(file_name);// 오라클에 파일 이름 저장
		}

		writeContentBean.setUser_idx(loginUserBean.getUser_idx());
		writeContentBean.setPost_type("QnA");
		writerCount++;
		String writer = "작성자" + writerCount;
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

	// 공지사항 글목록
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

	// QnA 글목록
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

	// 상세정보
	public PostBean getContentInfo(String Post_id) {
		System.out.println(Post_id);
		return boardMapper.getContentInfo(Post_id);
	}

	// 글수정
	public void modifyContentInfo(PostBean modifyContentBean) {

		MultipartFile upload_file = modifyContentBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			modifyContentBean.setImage(file_name);// 오라클에 파일 이름 저장
		}

		if (modifyContentBean.getSecret_message() == false) {
			modifyContentBean.setSecret_messagetext("N");
		} else if (modifyContentBean.getSecret_message() == true) {
			modifyContentBean.setSecret_messagetext("Y");
		}
		boardMapper.modifyContentInfo(modifyContentBean);
	}

	// 글삭제
	public void deleteContentInfo(String post_id) {
		System.out.println(post_id);
		boardMapper.deleteContentInfo(post_id);
	}

	// 해당게시판의 전체글의 수 가져오기
	public PageBean getContentCnt(String post_type, int currentPage) {
		int content_cnt = boardMapper.getContentCnt(post_type);

		PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		return pageBean;
	}

	// 댓글입력
	public void addComments(CommentsBean CommentsWritingBean) {
		
		CommentsWritingBean.setManager_id(loginUserBean.getCompanyid());
		//매니저 아이디를 끌어오는법을 모르겠음(낼 승찬쓰 한테 ㄲ)
		boardMapper.addComments(CommentsWritingBean);

	}
	
	//댓글끌고오기
	public List<CommentsBean> getComments(String Post_id) {
		return boardMapper.getComments(Post_id);
	}


}
