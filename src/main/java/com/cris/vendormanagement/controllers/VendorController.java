package com.cris.vendormanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cris.vendormanagement.entities.Vendor;
import com.cris.vendormanagement.repos.VendorRepository;



@RestController
@RequestMapping("/vendors")
@CrossOrigin("*")
public class VendorController {
	
	@Autowired
	private VendorRepository vendorRepo;
	
	@GetMapping("/vendordetails")
	public List<Vendor> getAllVendors()
	{
		return (List<Vendor>) vendorRepo.findAllByOrderByIdAsc();
	}
	
	@GetMapping("/vendoridexists/{vendorid}")
	public Boolean checkIfVendorExists(@PathVariable long vendorid)
	{
		List<Vendor> allVendors = (List<Vendor>) vendorRepo.findAll();
		
	//	ArrayList<Vendor> vendorArrList = new ArrayList<Vendor>(allVendors);
		for(Vendor v: allVendors)
		{
			if(v.getVendorId() == vendorid)
			{
				return true;
			}
		}
		return false;
	}

}
