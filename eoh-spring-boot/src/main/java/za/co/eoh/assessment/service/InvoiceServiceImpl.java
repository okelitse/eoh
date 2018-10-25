package za.co.eoh.assessment.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.eoh.assessment.dto.InvoiceDto;
import za.co.eoh.assessment.factory.InvoiceFactory;
import za.co.eoh.assessment.repository.InvoiceRepository;
import za.co.eoh.assessment.repository.ItemLineRepository;
import za.co.eoh.assessment.repository.domain.Invoice;
import za.co.eoh.assessment.repository.domain.ItemLine;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private static Logger logger = Logger.getLogger(InvoiceServiceImpl.class.getCanonicalName());

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private ItemLineRepository itemLineRepository;
	
	@Autowired
	private InvoiceFactory invoiceFactory;
	
	@Override
	public List<InvoiceDto> viewAllInvoices() {
		logger.info("+ viewAllInvoices");
		Iterable<Invoice> it = invoiceRepository.findAll();
		List<InvoiceDto> list = new ArrayList<>();
		it.forEach(new Consumer<Invoice>() {

			@Override
			public void accept(Invoice t) {
				list.add(invoiceFactory.convertEntityToDto(t));
			}
		});
		logger.info("- viewAllInvoices");
		return list; 
	}

	@Override
	public InvoiceDto viewInvoice(Long id) {
		Optional <Invoice> optional = invoiceRepository.findById(id);
		Invoice invoice = optional.get();
		return invoiceFactory.convertEntityToDto(invoice);
	}

	@Override
	public void addInvoice(InvoiceDto dto) {
		logger.info("+ add Invoice");
		Invoice i = invoiceFactory.convertDtoToEntity(dto);
		i = invoiceRepository.save(i);
		
		for(Iterator<ItemLine> it = i.getLineItems().iterator(); it.hasNext();) {
			ItemLine line = it.next();
			line.setInvoice(i);
			itemLineRepository.save(line);
		}
		logger.info("- add Invoice");
	}
}
