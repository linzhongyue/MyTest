package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**blog控制器
 * @author yudy
 *
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
	@GetMapping
	public String blogs(@RequestParam(value="order",required=false,defaultValue="new")String order,
			@RequestParam(value="keyword",required=false,defaultValue="")String keyword
			) {
		return "redirect:/index?order="+order+"&keyword="+keyword;
	}
}
