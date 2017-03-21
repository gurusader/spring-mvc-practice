package com.gurusader.springmvc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gurusader.springmvc.domain.PostVo;
import com.gurusader.springmvc.service.PostService;

@Controller
@RequestMapping("/post/")
public class PostController {
	@Inject
	private PostService postService;

	@RequestMapping(value = "showPostList", method = RequestMethod.GET)
	public String showPostList(Model model) {
		model.addAttribute("postList", postService.getPostList());
		return "post/post-list";
	}

	@RequestMapping(value = "showWritePostForm", method = RequestMethod.GET)
	public String showWritePostForm() {
		return "post/write-post-form";
	}

	@RequestMapping(value = "writePost", method = RequestMethod.POST)
	public String writePost(PostVo postVo, RedirectAttributes redirectAttributes) {
		postService.writePost(postVo);
		return "redirect:showPostList";
	}

	@RequestMapping(value = "showPost", method = RequestMethod.GET)
	public String showPost(int postNo, Model model) {
		model.addAttribute(postService.getPost(postNo));
		return "post/post-detail";
	}

	@RequestMapping(value = "deletePost", method = RequestMethod.POST)
	public String deletePost(int postNo) {
		postService.deletePost(postNo);
		return "redirect:showPostList";
	}
}
