package swd20.IDDB.web;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import swd20.IDDB.domain.Disc;
import swd20.IDDB.domain.DiscRepository;
import swd20.IDDB.domain.ManufacturerRepository;

@Controller
@CrossOrigin
public class DiscController {
	


	@Autowired
	private DiscRepository discRepository;

	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	
	
	//Login page
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}

	// http://localhost:8080/index
	@RequestMapping(value = "/index")
	public String IDDB() {
		return "index";
	}

	//returns list of all discs
	@RequestMapping(value = "/disclist", method = RequestMethod.GET)
	public String getDiscs(Model model) {
		model.addAttribute("discs", discRepository.findAll());
		
		return "disclist";
	}
	
	// REST method that returns all discs as a list (JSON)
	@RequestMapping(value="discs", method = RequestMethod.GET)
	public @ResponseBody List<Disc> discListRest(){
		return (List<Disc>) discRepository.findAll();
	}
	
	// REST method that returns a disc using its ID
	@RequestMapping(value="/discs/{modelId}")
	public @ResponseBody Optional<Disc> findDiscRest(@PathVariable("modelId") Long modelId){
		return discRepository.findById(modelId);
	}
	
	// REST method to save a new disc
	@RequestMapping(value="discs", method = RequestMethod.POST)
	public @ResponseBody Disc saveDiscRest (@RequestBody Disc disc) {
		return discRepository.save(disc);
	}
	
	// DELETE Disc
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{modelId}", method = RequestMethod.GET)
	public String deleteDisc(@PathVariable("modelId") Long modelId, Model model) {
		discRepository.deleteById(modelId);
		return "redirect:../disclist";
	}
	
	//Adding a new disc
	@RequestMapping(value="/newdisc")
	public String newDisc(Model model) {
		model.addAttribute("disc", new Disc());
		model.addAttribute("manufacturers", manufacturerRepository.findAll());
		return "newdisc";
	}
	
	//Saving a disc
	@RequestMapping(value="/save")
	public String save(Disc disc) {
		discRepository.save(disc);
		return "redirect:disclist";
	}
	
	//Editing a disc
	@RequestMapping(value="/edit/{modelId}")
	public String editDisc(@PathVariable("modelId") Long modelId, Model model) {
		model.addAttribute("disc", discRepository.findById(modelId));
		model.addAttribute("manufacturers", manufacturerRepository.findAll());
		return "editdisc";
	}
}
