package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.kfm.beans.CommentsBean;
import kr.co.kfm.beans.PostBean;

@Mapper
public interface BoardMapper {
	// 유저 글쓰기 + 자동 글번호 증가
	@SelectKey(statement = "select 'PO' || LPAD(content_seq.nextval, 5, '0') from dual", keyProperty = "post_id", before = true, resultType = String.class)
	@Insert("insert into Post (post_id, writer, user_idx, post_type, title, post_content, image, date_created, secret_message) values (#{post_id}, #{writer},#{user_idx}, #{post_type}, #{title}, #{post_content}, #{image, jdbcType=VARCHAR}, sysdate, #{secret_messagetext})")
	void adduserContentInfo(PostBean writeContentBean);

	// Q&A글목록
	@Select("select post_id, title, writer, to_char(date_created, 'YYYY-MM-DD') as date_created from Post where secret_message='N' and post_type = #{post_type} order by post_id desc")
	List<PostBean> getQnAContentList(String post_type, RowBounds rowBounds);

	// 공지사항목록
	@Select("select post_id, title, writer, to_char(date_created, 'YYYY-MM-DD') as date_created from Post where secret_message='N' and post_type = #{post_type} order by post_id desc")
	List<PostBean> getNoticeContentList(String post_type, RowBounds rowBounds);

	// 상세정보
	@Select("select user_idx, to_char(date_created, 'YYYY-MM-DD') as date_created, title, post_content, image from Post where post_id = #{post_id}")
	PostBean getContentInfo(String post_id);

	// 수정하기
	@Update("update Post set title = #{title}, post_content = #{post_content}, "
			+ "image = #{image, jdbcType=VARCHAR}, secret_message = #{secret_message} where post_id = #{post_id}")
	void modifyContentInfo(PostBean modifyContentBean);

	// 삭제하기
	@Delete("delete post where post.post_id = #{post_id}")
	void deleteContentInfo(String post_id);

	// 해당게시판의 전체글의 수 가져오기
	@Select("select count(*) from Post where post_type = #{post_type}")
	int getContentCnt(String post_type);

	// 댓글달기
	@SelectKey(statement = "select 'PO' || LPAD(comments_seq.nextval, 5, '0') from dual", keyProperty = "Comments_id", before = true, resultType = String.class)
	@Insert("insert into Comments (Comments_id, manager_id, Comments_content, Comments_date, post_id) values (#{Comments_id}, #{manager_id}, #{Comments_content}, sysdate, #{post_id})")
	void addComments(CommentsBean post_Comments);


	// 댓글보기
	@Select("SELECT DISTINCT comments_id, comments_content, manager_id, TO_CHAR(comments_date, 'YYYY-MM-DD') AS comments_date FROM comments WHERE post_id = #{post_id}")
	List<CommentsBean> getComments(String post_id);

}
