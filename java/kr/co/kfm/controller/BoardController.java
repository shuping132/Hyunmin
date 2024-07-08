package kr.co.kfm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kfm.beans.CommentsBean;
import kr.co.kfm.beans.PageBean;
import kr.co.kfm.beans.PostBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/noticeList")
	public String noticeList(@RequestParam(value = "post_type", defaultValue = "notice") String post_type,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		model.addAttribute("post_type", post_type);

		List<PostBean> NoticeList = boardService.getNoticeContentList(post_type, page);
		model.addAttribute("NoticeList", NoticeList);

		System.out.println("NoticeList" + NoticeList);

		PageBean pageBean = boardService.getContentCnt(post_type, page);

		model.addAttribute("pageBean", pageBean);
		model.addAttribute("page", page);

		return "board/noticeList"; // jsp
	}

	@GetMapping("/qnaList")
	public String qnaList(@RequestParam(value = "post_type", defaultValue = "QnA") String post_type,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
		model.addAttribute("post_type", post_type);
		System.out.println("post_type" + post_type);
		List<PostBean> QnAList = boardService.getQnAContentList(post_type, page);
		System.out.println("QnAList" + QnAList);
		model.addAttribute("QnAList", QnAList);

		PageBean pageBean = boardService.getContentCnt(post_type, page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("page", page);

		return "board/qnaList"; // jsp
	}

	@GetMapping("/read")
	public String read(@RequestParam(value = "post_type", defaultValue = "") String post_type,
			@RequestParam(value = "post_id", defaultValue = "") String post_id,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		model.addAttribute("post_type", post_type);
		model.addAttribute("post_id", post_id);
		String typetext = null;
		if (post_type.equals("notice")) {
			typetext = "noticeList";
		} else if (post_type.equals("QnA")) {
			typetext = "qnaList";
		}
		System.out.println(typetext);
		model.addAttribute("typetext", typetext);
		model.addAttribute("loginUserBean", loginUserBean);

		PostBean readContentBean = boardService.getContentInfo(post_id);
		model.addAttribute("readContentBean", readContentBean);
		if (post_type.equals("QnA")) {
			List<CommentsBean> CommentList = boardService.getComments(post_id);
			System.out.println("CommentList size: " + CommentList.size());
			model.addAttribute("CommentList", CommentList);
		}
		model.addAttribute("page", page);

		// ��� �ۼ� ���� ���� �� �ʱ�ȭ
		model.addAttribute("CommentsWritingBean", new CommentsBean());

		return "board/read";
	}

	@GetMapping("/write")
	public String write(@ModelAttribute("writeContentBean") PostBean writeContentBean,
			@RequestParam(value = "post_type", defaultValue = "") String post_type) {

		writeContentBean.setPost_type(post_type);

		return "board/write";
	}

	@PostMapping("/writer_pro")
	public String writer_pro(@Valid @ModelAttribute("writeContentBean") PostBean writeContentBean,
			BindingResult result) {

		if (result.hasErrors()) {
			return "board/write";
		}

		boardService.adduserContentInfo(writeContentBean);

		return "board/write_success";
	}

	@GetMapping("/not_writer")
	public String not_writer() {
		return "board/not_writer";
	}

	@GetMapping("/modify")
	public String modify(@RequestParam(value = "post_type", defaultValue = "") String post_type,
			@RequestParam(value = "post_id", defaultValue = "") String post_id,
			@ModelAttribute("modifyContentBean") PostBean modifyContentBean, @RequestParam("page") int page,
			Model model) {

		model.addAttribute("post_type", post_type);
		model.addAttribute("post_id", post_id);
		model.addAttribute("page", page);

		// �Խñ� �ϳ��� �� ���� ��������
		PostBean tempContentBean = boardService.getContentInfo(post_id);

		modifyContentBean.setPost_type(tempContentBean.getPost_type());
		modifyContentBean.setTitle(tempContentBean.getTitle());
		modifyContentBean.setPost_content(tempContentBean.getPost_content());
		modifyContentBean.setImage(tempContentBean.getImage());
		modifyContentBean.setSecret_message(tempContentBean.getSecret_message());
		modifyContentBean.setPost_id(tempContentBean.getPost_id());

		return "board/modify";
	}

	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyContentBean") PostBean modifyContentBean,
			@RequestParam("page") int page, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "board/modify";
		}

		model.addAttribute("page", page);
		// ������Ʈ
		boardService.modifyContentInfo(modifyContentBean);

		return "board/modify_success";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam(value = "post_type", defaultValue = "") String post_type,
			@RequestParam(value = "post_id", defaultValue = "") String post_id, Model model) {

		boardService.deleteContentInfo(post_id);
		// �ش��ϴ� �Խñ۷� �̵��Ͽ� �������� Ȯ��
		model.addAttribute("post_type", post_type);

		return "board/delete";
	}

	@GetMapping("/list")
	public String list(@RequestParam("post_type") String post_type,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		List<PostBean> NoticecontentList = boardService.getNoticeContentList(post_type, page);
		model.addAttribute("NoticecontentList", NoticecontentList);

		List<PostBean> QnacontentList = boardService.getNoticeContentList(post_type, page);
		model.addAttribute("QnacontentList", QnacontentList);

		PageBean pageBean = boardService.getContentCnt(post_type, page);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("page", page);
		model.addAttribute("post_type", post_type);

		if (post_type.equals("notice")) {
			return "board/noticeList";
		} else if (post_type.equals("qna")) {
			return "board/qnaList";
		} else {
			return "board/board_main";
		}
	}

	@PostMapping("/Comments_pro")
	public String Comments_pro(@Valid @ModelAttribute("CommentsWritingBean") CommentsBean CommentsWritingBean,
			@RequestParam(value = "post_id", defaultValue = "") String post_id,
			@RequestParam(value = "page", defaultValue = "1") int page, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("post_id", post_id); // post_id 占쌩곤옙
			model.addAttribute("readContentBean", boardService.getContentInfo(post_id)); // 占쏙옙占쏙옙 占쌉시뱄옙 占쏙옙占쏙옙 占쌩곤옙
			model.addAttribute("CommentsWritingBean", CommentsWritingBean); // 占쏙옙占쏙옙 占쏙옙占쏙옙 占쌩삼옙 占쏙옙 占쏙옙占� 占쏙옙 占쌕쏙옙
																			// 占쌩곤옙
			return "board/read";
		}
		model.addAttribute("page", page);
		System.out.println("Before setting post_id: " + CommentsWritingBean.getComments_id());
		CommentsWritingBean.setPost_id(post_id);
		boardService.addComments(CommentsWritingBean);
		System.out.println("After setting post_id: " + CommentsWritingBean.getComments_id());

		return "board/Comments_success";
	}

}
