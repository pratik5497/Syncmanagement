package com.slk.synkmanagement.payload;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProductInformationDto {
	private Integer recordId;
	@NotEmpty
	@Size(min = 25, max = 250)
	private String intent;
	private String merchantType;
	private String callReason;
	private String createdBy;
	private Date createdDate;
	private String destination;
	private String modifiedBy;
	private Date modifiedDate;

}
