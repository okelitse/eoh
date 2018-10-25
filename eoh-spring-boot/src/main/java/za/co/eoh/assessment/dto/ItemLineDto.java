package za.co.eoh.assessment.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="itemLine")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemLineDto extends BaseDto{
	
	private Long quantity;
	
	private String description;
	
	private BigDecimal unitPrice;
	
	private InvoiceDto invoice;

	
	public InvoiceDto getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceDto invoice) {
		this.invoice = invoice;
	}

	public Long getQuantity() {
		return quantity;
	}

	@XmlElement
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	@XmlElement
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getLineItemTotal() {
		return this.unitPrice.multiply(new BigDecimal(this.quantity));
	}
}
