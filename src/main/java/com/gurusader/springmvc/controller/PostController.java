package com.gurusader.springmvc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.addAttribute("postVoList", postService.getPostList(pageCriteria));
		model.addAttribute("pageMaker", new PageMaker(pageCriteria, postService.countTotalPosts()));
		return "post/post-list";
	}

	@RequestMapping(value = "showPostWritingForm", method = RequestMethod.GET)
	public String showPostWritingForm(@ModelAttribute PageCriteria pageCriteria) {
		return "post/post-writing-form";
	}

	@RequestMapping(value = "writePost", method = RequestMethod.POST)
	public String writePost(PostVo postVo) {
		postService.writePost(postVo);
		return "redirect:showPostList";
	}

	@RequestMapping(value = "showPostDetail", method = RequestMethod.GET)
	public String showPostDetail(int postNo, @ModelAttribute PageCriteria pageCriteria, Model model) {
		model.addAttribute("postVo", postService.getPost(postNo));
		return "post/post-detail";
	}

	@RequestMapping(value = "showPostRevisingForm", method = RequestMethod.GET)
	public String showPostRevisingForm(int postNo, @ModelAttribute PageCriteria pageCriteria, Model model) {
		model.addAttribute("postVo", postService.getPost(postNo));
		return "post/post-revising-form";
	}

	@RequestMapping(value = "revisePost", method = RequestMethod.POST)
	public String revisePost(PostVo postVo, PageCriteria pageCriteria, Model model) {
		postService.revisePost(postVo);
		model.addAttribute("postNo", postVo.getPostNo());
		model.addAttribute("currentPageNo", pageCriteria.getCurrentPageNo());
		model.addAttribute("contentsPerPage", pageCriteria.getContentsPerPage());
		return "redirect:showPostDetail";
	}

	@RequestMapping(value = "deletePost", method = RequestMethod.POST)
	public String deletePost(int postNo, PageCriteria pageCriteria, Model model) {
		postService.deletePost(postNo);
		model.addAttribute("currentPageNo", pageCriteria.getCurrentPageNo());
		model.addAttribute("contentsPerPage", pageCriteria.getContentsPerPage());
		return "redirect:showPostList";
	}
}
