package edu.ait.repserver.usecase;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.ait.repserver.rest.dto.PropertyPageDTO;
import edu.ait.repserver.usecase.entity.Property;
import edu.ait.repserver.usecase.entity.SaleOrRent;
import edu.ait.repserver.usecase.persistence.PropertyRepository;
 
@Service
public class PropertySearchService implements SearchPropertyUseCase {
 
	PropertyRepository propertyRepository;
 
	public PropertySearchService(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}
 
	@Override
	public Optional<Property> findById(Long id) {
		return propertyRepository.findById(id);
	}

	@Override
	public Page<Property> findAll(Pageable pageable) {
		return propertyRepository.findAll(pageable);
	}

	@Override
	public Page<Property> findByCity(String city, Pageable pageable) {
		return  propertyRepository.findByCityOrderById(city, pageable);
	}
 
}
