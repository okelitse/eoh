package za.co.eoh.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.eoh.assessment.dto.InvoiceDto;
import za.co.eoh.assessment.service.InvoiceService;

@RestController
@RequestMapping(value="/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping
	public ResponseEntity <Object> viewAllInvoices (){
		List<InvoiceDto> invoices = invoiceService.viewAllInvoices();
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity <Object> viewInvoice (@PathVariable("id") String id) {
		Long pk = Long.parseLong(id);
		
		InvoiceDto invoice = invoiceService.viewInvoice(pk);
		return new ResponseEntity<>(invoice, HttpStatus.OK);
	}
	
	@PostMapping(consumes= {"application/json"})
	public ResponseEntity <Object> addInvoice (@RequestBody InvoiceDto invoice) {
		invoiceService.addInvoice(invoice);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
