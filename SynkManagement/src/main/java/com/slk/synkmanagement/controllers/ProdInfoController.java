package com.slk.synkmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slk.synkmanagement.payload.ProductInformationDto;
import com.slk.synkmanagement.serviceimpl.ProductServiceImpl;

@RestController
@RequestMapping("/api/")
public class ProdInfoController {
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@PostMapping("/productinformation")
	public ResponseEntity<ProductInformationDto> createRecord(@RequestBody ProductInformationDto prodDto) {
		ProductInformationDto record = this.productServiceImpl.createRecord(prodDto);
		return new ResponseEntity<ProductInformationDto>(record, HttpStatus.CREATED);

	}

	@PutMapping("productinformation/{recordId}")
	public ResponseEntity<ProductInformationDto> updateRecord(@RequestBody ProductInformationDto prodDto,
			@PathVariable Integer recordId) {
		ProductInformationDto updatedRecord = this.productServiceImpl.updateRecord(recordId, prodDto);
		return new ResponseEntity<ProductInformationDto>(updatedRecord, HttpStatus.OK);

	}

	@GetMapping("productinformation/{recordId}")
	private ResponseEntity<ProductInformationDto> getRecord(@PathVariable Integer recordId) {
		ProductInformationDto record = this.productServiceImpl.getRecordById(recordId);
		return new ResponseEntity<ProductInformationDto>(record, HttpStatus.OK);

	}

}
