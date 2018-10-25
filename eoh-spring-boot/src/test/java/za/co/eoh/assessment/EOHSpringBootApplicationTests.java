package za.co.eoh.assessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import za.co.eoh.assessment.dto.InvoiceDto;
import za.co.eoh.assessment.dto.ItemLineDto;

public class EOHSpringBootApplicationTests extends AbstractEOHSpringBootApplicationTest{

	@Test
	public void getInvoicesList() throws Exception {
		setUp();
		String uri = "/invoices";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		InvoiceDto [] productlist = super.mapFromJson(content, InvoiceDto[].class);
		assertTrue(productlist.length > 0);
	}
	
	@Test
	public void getExistingInvoice () throws Exception {
		setUp();
		String uri = "/invoices/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		InvoiceDto invoice = super.mapFromJson(content, InvoiceDto.class);
		assertNotEquals(invoice, null);
	}
	
	@Test
	public void getNonExistingInvoice () throws Exception {
		setUp();
		String uri = "/invoices/300_000";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "For input string: \"300_000\"");
		//InvoiceDto invoice = super.mapFromJson(content, InvoiceDto.class);
		//assertEquals(invoice, null);
	}
	
	@Test
	public void createProduct() throws Exception {
		setUp();
		String uri = "/invoices";
		InvoiceDto invoice = new InvoiceDto();
		invoice.setClient("Random");
		invoice.setInvoiceDate("2018-03-12");
		invoice.setVatRate(15L);
		invoice.setItemLines(new ArrayList<ItemLineDto>());
		String inputJson = super.mapToJson(invoice);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
}
