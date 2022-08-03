package com.slk.synkmanagement.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slk.synkmanagement.customexception.ResourceNotFoundException;
import com.slk.synkmanagement.model.ProductInformation;
import com.slk.synkmanagement.payload.ProductInformationDto;
import com.slk.synkmanagement.repository.ProductInformationRepo;
import com.slk.synkmanagement.service.ProductInformationService;

@Service
public class ProductServiceImpl implements ProductInformationService {

	@Autowired
	private ProductInformationRepo productInformationRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductInformationDto createRecord(ProductInformationDto prodDto) {
		ProductInformation productInformation = modelMapper.map(prodDto, ProductInformation.class);
		ProductInformation saved = productInformationRepo.save(productInformation);

		return modelMapper.map(saved, ProductInformationDto.class);
	}

	@Override
	public ProductInformationDto updateRecord(Integer recordId, ProductInformationDto prodDto) {
		ProductInformation productInformation = productInformationRepo.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Record", recordId, "RecordId"));
		productInformation.setIntent(prodDto.getIntent());
		productInformation.setMerchantType(prodDto.getMerchantType());
		productInformation.setCallReason(prodDto.getCallReason());
		productInformation.setModifiedBy(prodDto.getModifiedBy());
		productInformation.setModifiedDate(prodDto.getModifiedDate());
		productInformation.setDestination(prodDto.getDestination());
		ProductInformation updated = productInformationRepo.save(productInformation);

		return modelMapper.map(updated, ProductInformationDto.class);
	}

	@Override
	public ProductInformationDto getRecordById(Integer recordId) {
		ProductInformation productInformation = productInformationRepo.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Record", recordId, "RecordId"));

		return modelMapper.map(productInformation, ProductInformationDto.class);
	}

	@Override
	public List<ProductInformationDto> getAllRecords() {
		List<ProductInformation> allRecords = productInformationRepo.findAll();
		List<ProductInformationDto> allRecordsDtos = allRecords.stream()
				.map((records) -> modelMapper.map(records, ProductInformationDto.class)).collect(Collectors.toList());

		return allRecordsDtos;

	}

	@Override
	public void deleteRecordById(Integer recordId) {
		ProductInformation record = productInformationRepo.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Record", recordId, "RecordId"));
		productInformationRepo.delete(record);

	}

	@Override
	public void deleteAllRecords() {
		productInformationRepo.deleteAll();

	}

}
