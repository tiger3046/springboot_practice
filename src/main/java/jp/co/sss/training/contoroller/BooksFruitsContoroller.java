package jp.co.sss.training.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.training.repository.BooksFruitsRepository;

@Controller
public class BooksFruitsContoroller {
	@Autowired
	BooksFruitsRepository repository;
	
	
	@GetMapping(path="/lesson03_03/index")
	public String serchForGenreOne(Model model) {
		model.addAttribute("books_fruits",repository.findByPriceAndGenreId(200, 1));
		return"lesson03_03/index";
	}
	
	@GetMapping(path="/lesson03_04/index")
	public String serchOr(Model model) {
		model.addAttribute("books_fruits",repository.findByPriceOrGenreId(200,2));
		return"lesson03_04/index";
	}
	
	@GetMapping(path="/lesson03_05/index")
	public String serchAsc(Model model) {
		model.addAttribute("books_fruits",repository.findByOrederByPriceAsc());
		return"lesson03_05/index";
	}
	
	@GetMapping(path="/lesson03_06/index")
	public String serchTopFiveDesc(Model model) {
		model.addAttribute("books_fruits",repository.findByTop5ByOrderByDesc());
		return"lesson03_06/index";
	}
	
	@GetMapping(path="/lesson03_07/index")
	public String serchLike(Model model) {
		model.addAttribute("books_fruits",repository.findByNameStartingWithKind("やさしい"));
		return "lesson03_07/index";
	}
}
