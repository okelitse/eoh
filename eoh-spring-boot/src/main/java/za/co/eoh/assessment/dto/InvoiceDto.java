package za.co.eoh.assessment.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement (name="invoice")
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDto extends BaseDto{
	
	private String client;
	
	private Long vatRate;
	
	private String invoiceDate;
	
	private List <ItemLineDto> itemLines;

	public String getClient() {
		return client;
	}

	@XmlElement
	public void setClient(String client) {
		this.client = client;
	}

	public Long getVatRate() {
		return vatRate;
	}

	@XmlElement
	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	@XmlElement
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<ItemLineDto> getItemLines() {
		return itemLines;
	}

	@XmlElement
	public void setItemLines(List<ItemLineDto> itemLines) {
		this.itemLines = itemLines;
	}

	public BigDecimal getSubTotal() {
		BigDecimal subTotal = new BigDecimal(0);
		for(Iterator<ItemLineDto> it = this.itemLines.iterator(); it.hasNext();) {
			subTotal = subTotal.add(it.next().getLineItemTotal());
		}
		return subTotal;
	}
	
	public BigDecimal getVat() {
		return getSubTotal().multiply(new BigDecimal(this.vatRate).movePointLeft(2));
	}
	
	public BigDecimal getTotal() {
		return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
	}
	
}
