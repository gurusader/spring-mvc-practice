package com.gurusader.springmvc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gurusader.springmvc.domain.PageCriteria;
import com.gurusader.springmvc.domain.PageMaker;
import com.gurusader.springmvc.domain.PostVo;
import com.gurusader.springmvc.service.PostService;

@Controller
@RequestMapping("/post/")
public class PostController {
	@Inject
	private PostService postService;

	@RequestMapping(value = "showPostList", method = RequestMethod.GET)
	public String showPostList(PageCriteria pageCriteria, Model model) {
		model.addAttribute("postList", postService.getPostList(pageCriteria));
		model.addAttribute("pageMaker", new PageMaker(pageCriteria, postService.countTotalPosts()));
		return "post/post-list";
	}

	@RequestMapping(value = "showPostWritingForm", method = RequestMethod.GET)
	public String showWritePostForm() {
		return "post/post-writing-form";
	}

	@RequestMapping(value = "writePost", method = RequestMethod.POST)
	public String writePost(PostVo postVo, RedirectAttributes redirectAttributes) {
		postService.writePost(postVo);
		return "redirect:showPostList";
	}

	@RequestMapping(value = "showPostDetail", method = RequestMethod.GET)
	public String showPostDetail(int postNo, Model model) {
		model.addAttribute("postVo", postService.getPost(postNo));
		return "post/post-detail";
	}

	@RequestMapping(value = "showPostRevisingForm", method = RequestMethod.GET)
	public String showRevisePostForm(int postNo, Model model) {
		model.addAttribute("postVo", postService.getPost(postNo));
		return "post/post-revising-form";
	}

	@RequestMapping(value = "revisePost", method = RequestMethod.POST)
	public String revisePost(PostVo postVo, Model model) {
		postService.revisePost(postVo);
		model.addAttribute("postNo", postVo.getPostNo());
		return "redirect:showPostDetail";
	}

	@RequestMapping(value = "deletePost", method = RequestMethod.POST)
	public String deletePost(int postNo) {
		postService.deletePost(postNo);
		return "redirect:showPostList";
	}
}
