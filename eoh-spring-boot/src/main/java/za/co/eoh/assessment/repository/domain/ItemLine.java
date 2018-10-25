package za.co.eoh.assessment.repository.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item_line")
public class ItemLine extends BaseDomain{
	
	@Column (nullable = false)
	private Long quantity;
	
	@Column (nullable = false)
	private String description;
	
	@Column (nullable = false)
	private BigDecimal unitPrice;
	
	@ManyToOne
	@JoinColumn(name="invoice")
	private Invoice invoice;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
