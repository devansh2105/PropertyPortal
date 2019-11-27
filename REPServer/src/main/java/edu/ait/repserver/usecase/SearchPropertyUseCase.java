package edu.ait.repserver.usecase;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.ait.repserver.rest.dto.PropertyPageDTO;
import edu.ait.repserver.usecase.entity.Property;
import edu.ait.repserver.usecase.entity.SaleOrRent;

public interface SearchPropertyUseCase {
	 
	Optional<Property> findById(Long id);

	Page<Property> findAll(Pageable pageable);

	Page<Property> findByCity(String city, Pageable pageable);

 
}
