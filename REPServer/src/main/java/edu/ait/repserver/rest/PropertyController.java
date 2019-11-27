package edu.ait.repserver.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ait.repserver.rest.dto.NewPropertyDTO;
import edu.ait.repserver.rest.dto.PropertyMapper;
import edu.ait.repserver.rest.dto.PropertyPageDTO;
import edu.ait.repserver.usecase.CreatePropertyUseCase;
import edu.ait.repserver.usecase.SearchPropertyUseCase;
import edu.ait.repserver.usecase.entity.Property;
import edu.ait.repserver.usecase.entity.PropertyType;
import edu.ait.repserver.usecase.entity.SaleOrRent;
 
@RestController
@RequestMapping("/api/v1/properties")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {
	
	CreatePropertyUseCase createPropertyUseCase;
	private SearchPropertyUseCase searchPropertyUseCase;
 
	public PropertyController(CreatePropertyUseCase createPropertyUseCase, SearchPropertyUseCase searchPropertyUseCase) {
		this.createPropertyUseCase = createPropertyUseCase;
		this.searchPropertyUseCase = searchPropertyUseCase;
	}
 
	@PostMapping
	public Property createProperty(@ModelAttribute NewPropertyDTO newPropertyDTO) {
		Property propertyToBeAdded = PropertyMapper.INSTANCE.newPropertyDTOToProperty(newPropertyDTO);
		return createPropertyUseCase.create(propertyToBeAdded);
	}
	
	@GetMapping("/{id}")
	public Property getById(@PathVariable Long id) {
		return searchPropertyUseCase.findById(id).get();
	}
	
	@GetMapping
	public PropertyPageDTO findAll(@RequestParam(required = false) String city, Pageable pageable) {
		if(city  == null) {
			Page<Property> page = searchPropertyUseCase.findAll(pageable);
			return new PropertyPageDTO(page.getTotalPages(), page.getContent());
		}
		else  {
			Page<Property> page = searchPropertyUseCase.findByCity(city, pageable);
			return new PropertyPageDTO(page.getTotalPages(), page.getContent());
		}
	}
}