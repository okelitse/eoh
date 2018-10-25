package za.co.eoh.assessment.factory;

import org.springframework.stereotype.Component;

import za.co.eoh.assessment.dto.ItemLineDto;
import za.co.eoh.assessment.repository.domain.ItemLine;

@Component
public class ItemLineFactory extends AbstractFactory<ItemLineDto, ItemLine> {

	@Override
	public ItemLineDto convertEntityToDto(ItemLine e) {
		ItemLineDto dto = new ItemLineDto();
		dto.setDescription(e.getDescription());
		dto.setUnitPrice(e.getUnitPrice());
		dto.setQuantity(e.getQuantity());
		dto.setId(e.getId());
		return dto;
	}

	@Override
	public ItemLine convertDtoToEntity(ItemLineDto dto) {
		ItemLine e = new ItemLine();
		e.setDescription(dto.getDescription());
		e.setUnitPrice(dto.getUnitPrice());
		e.setQuantity(dto.getQuantity());
		e.setId(dto.getId());
		return e;
	}

}
