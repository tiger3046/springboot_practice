package jp.co.sss.training.contoroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jp.co.sss.training.Form.SerchForm;
import jp.co.sss.training.entity.TrainingUser;
import jp.co.sss.training.repository.UserRepository;

@Controller
public class TrainingUserContoroller {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping(path="/lesson04_01/index")
	public String showIndex(Model model) {
		model.addAttribute("users",repository.findAll());
		return "lesson04_01/index";
	}
	
	@Autowired
	EntityManager entitymanager;
	
	@GetMapping(path="/lesson04_01/serchByUserIdNamedQuery")
	public String serchByUserIdNamedQuery(Model model,SerchForm form) {
		TypedQuery<TrainingUser> query = entitymanager.createNamedQuery("findByUserIdNamedQuery", TrainingUser.class);
		query.setParameter("keyword", form.getWord());
		List<TrainingUser> results = query.getResultList();
		model.addAttribute("users",results);
		return"lesson04_01/index";
	}
	
	
}
