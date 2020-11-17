package swd20.IDDB.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.IDDB.domain.Disc;
import swd20.IDDB.domain.Manufacturer;
import swd20.IDDB.domain.ManufacturerRepository;

@Controller
@CrossOrigin
public class ManufacturerController {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	// Raturns manufacturers
	@RequestMapping(value = "/manufacturerlist", method = RequestMethod.GET)
	public String getManufacturers(Model model) {
		model.addAttribute("manufacturers", manufacturerRepository.findAll());

		return "manufacturerlist";
	}

	// REST method to return list of manufacturers
	@RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
	public @ResponseBody List<Manufacturer> getManufacturerRest() {
		return (List<Manufacturer>) manufacturerRepository.findAll();
	}

	// REST method to get manufacturer by id
	@RequestMapping(value = "/manufacturers/{manufacturerId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Manufacturer> findManufacturerRest(
			@PathVariable("manufacturerId") Long manufacturerId) {
		return manufacturerRepository.findById(manufacturerId);
	}

	// REST method to save a manufacturer
	@RequestMapping(value = "/manufacturers", method = RequestMethod.POST)
	public @ResponseBody Manufacturer saveDiscRest(@RequestBody Manufacturer manufacturer) {
		return manufacturerRepository.save(manufacturer);
	}

	// Adding a manufacturer
	@RequestMapping(value="/newmanufacturer")
	public String newManufacturer(Model model) {
		model.addAttribute("manufacturer", new Manufacturer());
		return "newmanufacturer";
	}
	
	//Saving a manufacturer
	@RequestMapping(value="/savemanufacturer")
	public String save(@Valid Manufacturer manufacturer, BindingResult bindingResult, Model model) {
		//If form has errors redirects back to form
		if(bindingResult.hasErrors()) {
			model.addAttribute("manufacturers", manufacturerRepository.findAll());
			return "newmanufacturer";
		}
		else {
			manufacturerRepository.save(manufacturer);
		}
		return "redirect:manufacturerlist";
	}
}
