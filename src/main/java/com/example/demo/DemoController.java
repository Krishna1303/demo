package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/api")
public class DemoController {

	    private final CustomRepository customRepository;

    @Autowired
    public DemoController(CustomRepository customRepository) {
        this.customRepository = customRepository;
    }

	@GetMapping("/index")
	public String getIndex(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name,Model model) {
		model.addAttribute("name", name);
		return "index";
	}

	@PostMapping(path = "/uploadData")
	public ResponseEntity<String> uploadData(@ModelAttribute SurveyModel model) {
		System.out.println(model.getFirstName());
		customRepository.save(model);
				return ResponseEntity.ok("Survey data created successfully.");
	}

	@GetMapping(path = "/deleteData/{id}")
	public ResponseEntity<String> uploadData(@PathVariable long id) {
		customRepository.deleteById(id);
		return ResponseEntity.ok("Survey data deleted successfully.");
	}

	@GetMapping(path = "/getDataById/{id}")
	public ResponseEntity<SurveyModel> getDataById(@PathVariable long id) {
		SurveyModel model = customRepository.findById(id).orElse(null);
		return new ResponseEntity<>(model,HttpStatus.OK);
	}


	@PostMapping(path = "/updateData/{id}")
	public ResponseEntity<String> updateData(@PathVariable long id,@ModelAttribute SurveyModel surveyModel) {
		        SurveyModel model = customRepository.findById(id).orElse(null);
				if(model!=null){
					customRepository.save(surveyModel);
		return ResponseEntity.ok("Survey data updated successfully.");
				}
				else{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Survey with id " + id + " not found.");
				}
	}

	@GetMapping("/getData")
	public ResponseEntity<List<SurveyModel>> getData(){
		return new ResponseEntity<>(customRepository.findAll(),HttpStatus.OK);
		// List<SurveyModel> surveyList = customRepository.findAll();
        // model.addAttribute("surveys", surveyList);
		// return surveyList;
	}

	
}

