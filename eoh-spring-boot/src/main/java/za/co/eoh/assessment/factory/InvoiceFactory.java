package za.co.eoh.assessment.factory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.eoh.assessment.dto.InvoiceDto;
import za.co.eoh.assessment.dto.ItemLineDto;
import za.co.eoh.assessment.repository.domain.Invoice;
import za.co.eoh.assessment.repository.domain.ItemLine;

@Component
public class InvoiceFactory extends AbstractFactory<InvoiceDto, Invoice> {

	@Autowired
	private ItemLineFactory itemLineFactory;
	
	@Override
	public InvoiceDto convertEntityToDto(Invoice m) {
		InvoiceDto dto = new InvoiceDto();
		dto.setClient(m.getClient());
		dto.setInvoiceDate(sdf.format(m.getInvoiceDate()));
		dto.setVatRate(m.getVatRate());
		dto.setId(m.getId());
		List<ItemLineDto> itemLines = new ArrayList<>();
		for(Iterator<ItemLine> it = m.getLineItems().iterator(); it.hasNext();) {
			ItemLine il = it.next();
			itemLines.add(itemLineFactory.convertEntityToDto(il));
		}
		dto.setItemLines(itemLines);
		dto.setId(m.getId());
		return dto;
	}

	@Override
	public Invoice convertDtoToEntity(InvoiceDto dto) {
		Invoice invoice = new Invoice();
		invoice.setClient(dto.getClient());
		try {
			invoice.setInvoiceDate(sdf.parse(dto.getInvoiceDate()));
		} catch (ParseException e) {
			invoice.setInvoiceDate(new Date());
		}
		invoice.setVatRate(dto.getVatRate());
		invoice.setId(dto.getId());
		List<ItemLine> itemLines = new ArrayList<>();
		for(Iterator<ItemLineDto> it = dto.getItemLines().iterator(); it.hasNext();) {
			ItemLineDto il = it.next();
			itemLines.add(itemLineFactory.convertDtoToEntity(il));
		}
		invoice.setLineItems(itemLines);
		invoice.setId(dto.getId());
		return invoice;
	}

}
