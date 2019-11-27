package edu.ait.repserver.usecase.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.ait.repserver.usecase.entity.Property;
import edu.ait.repserver.usecase.entity.SaleOrRent;

public interface PropertyRepository extends JpaRepository<Property, Long>{

	Page<Property> findByCityOrderById(String city, Pageable pageable);

	
	
}
