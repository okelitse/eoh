package za.co.eoh.assessment.dto;

import javax.xml.bind.annotation.XmlElement;

public abstract class BaseDto {
	
	private Long Id;

	public Long getId() {
		return Id;
	}

	@XmlElement
	public void setId(Long id) {
		Id = id;
	}
	
	
}
