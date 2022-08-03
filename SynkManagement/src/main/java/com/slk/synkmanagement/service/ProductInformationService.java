package com.slk.synkmanagement.service;

import java.util.List;

import com.slk.synkmanagement.payload.ProductInformationDto;

public interface ProductInformationService {
	ProductInformationDto createRecord(ProductInformationDto prodDto);

	ProductInformationDto updateRecord(Integer recordId, ProductInformationDto prodDto);

	ProductInformationDto getRecordById(Integer recordId);

	List<ProductInformationDto> getAllRecords();

	void deleteRecordById(Integer id);

	void deleteAllRecords();

}
