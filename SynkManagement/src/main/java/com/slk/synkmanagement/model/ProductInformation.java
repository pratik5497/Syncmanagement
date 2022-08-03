package com.slk.synkmanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@Table(name = "exitpoint_by_questiontoask")
@Data
@EntityListeners(AuditingEntityListener.class)
public class ProductInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recordId;
	private String intent;
	private String merchantType;
	private String callReason;
	private String createdBy;
	@CreatedDate
	private Date createdDate;
	private String destination;
	private String modifiedBy;
	@LastModifiedDate
	private Date modifiedDate;

}
