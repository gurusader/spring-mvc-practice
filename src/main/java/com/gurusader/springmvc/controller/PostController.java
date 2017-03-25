package com.gurusader.springmvc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gurusader.springmvc.domain.PageMaker;
import com.gurusader.springmvc.domain.PostPageCriteria;
import com.gurusader.springmvc.domain.PostVo;
import com.gurusader.springmvc.service.PostService;

@Controller
@RequestMapping("post/")
public class PostController {
	@Inject
	private PostService postService;

	@RequestMapping(value = "showPostList", method = RequestMethod.GET)
	public String showPostList(PostPageCriteria postPageCriteria, Model model) {
		if (postPageCriteria.getSearchType() == null) {
			model.addAttribute("postVoList", postService.getAllPostList(postPageCriteria));
			model.addAttribute("pageMaker", new PageMaker(postPageCriteria, postService.countAllPosts()));
		} else {
			model.addAttribute("postVoList", postService.getSearchPostList(postPageCriteria));
			model.addAttribute("pageMaker", new PageMaker(postPageCriteria, postService.countSearchPosts(postPageCriteria)));
		}

		return "post/post-list";
	}

	@RequestMapping(value = "showPostDetail", method = RequestMethod.GET)
	public String showPostDetail(int postNo, @ModelAttribute PostPageCriteria postPageCriteria, Model model) {
		model.addAttribute("postVo", postService.getPost(postNo));
		return "post/post-detail";
	}

	@RequestMapping(value = "showPostWritingForm", method = RequestMethod.GET)
	public String showPostWritingForm(@ModelAttribute PostPageCriteria postPageCriteria) {
		return "post/post-writing-form";
	}

	@RequestMapping(value = "writePost", method = RequestMethod.POST)
	public String writePost(PostVo postVo) {
		postService.writePost(postVo);
		return "redirect:showPostList";
	}

	@RequestMapping(value = "showPostRevisingForm", method = RequestMethod.GET)
	public String showPostRevisingForm(int postNo, @ModelAttribute PostPageCriteria postPageCriteria, Model model) {
		model.addAttribute("postVo", postService.getPost(postNo));
		return "post/post-revising-form";
	}

	@RequestMapping(value = "revisePost", method = RequestMethod.POST)
	public String revisePost(PostVo postVo, PostPageCriteria postPageCriteria, Model model) {
		postService.revisePost(postVo);
		model.addAttribute("postNo", postVo.getPostNo());
		model.addAttribute("currentPageNo", postPageCriteria.getCurrentPageNo());
		model.addAttribute("contentsPerPage", postPageCriteria.getContentsPerPage());
		model.addAttribute("searchType", postPageCriteria.getSearchType());
		model.addAttribute("searchKeyword", postPageCriteria.getSearchKeyword());
		return "redirect:showPostDetail";
	}

	@RequestMapping(value = "deletePost", method = RequestMethod.POST)
	public String deletePost(int postNo, PostPageCriteria postPageCriteria, Model model) {
		postService.deletePost(postNo);
		model.addAttribute("currentPageNo", postPageCriteria.getCurrentPageNo());
		model.addAttribute("contentsPerPage", postPageCriteria.getContentsPerPage());
		model.addAttribute("searchType", postPageCriteria.getSearchType());
		model.addAttribute("searchKeyword", postPageCriteria.getSearchKeyword());
		return "redirect:showPostList";
	}
}
