package za.co.eoh.assessment.factory;

import java.text.SimpleDateFormat;

import za.co.eoh.assessment.dto.BaseDto;
import za.co.eoh.assessment.repository.domain.BaseDomain;

public abstract class AbstractFactory <D extends BaseDto, M extends BaseDomain> {
	protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public abstract D convertEntityToDto (M m);
	
	public abstract M convertDtoToEntity (D d);
}
