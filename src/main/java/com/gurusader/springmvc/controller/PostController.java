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
	public void showPostList(Model model) {
		model.addAttribute("postList", postService.getPostList());
	}

	@RequestMapping(value = "writePost", method = RequestMethod.GET)
	public void writePost() {
	}

	@RequestMapping(value = "writePost", method = RequestMethod.POST)
	public String writePost(PostVo postVo, RedirectAttributes redirectAttributes) {
		postService.writePost(postVo);
		return "redirect:showPostList";
	}
}
