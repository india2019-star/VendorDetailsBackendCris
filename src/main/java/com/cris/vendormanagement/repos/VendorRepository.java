package com.cris.vendormanagement.repos;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cris.vendormanagement.entities.Vendor;

@CrossOrigin("*")
public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long> {

	
	List<Vendor> findAllByOrderByIdAsc();

}
