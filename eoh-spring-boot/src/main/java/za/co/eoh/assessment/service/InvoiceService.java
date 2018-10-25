package za.co.eoh.assessment.service;

import java.util.List;

import za.co.eoh.assessment.dto.InvoiceDto;

public interface InvoiceService {
	
	public List <InvoiceDto> viewAllInvoices ();
	
	public InvoiceDto viewInvoice (Long id);
	
	public void addInvoice (InvoiceDto invoice);
}
