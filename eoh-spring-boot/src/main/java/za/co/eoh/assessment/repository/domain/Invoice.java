package za.co.eoh.assessment.repository.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice extends BaseDomain{
	
	@Column (name="client", nullable = false)
	private String client;
	
	@Column (name="vat_rate", nullable = false)
	private Long vatRate;
	
	@Column (name="invoice_date", nullable = false)
	private Date invoiceDate;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="invoice")
	private List <ItemLine> lineItems;

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Long getVatRate() {
		return vatRate;
	}

	public void setVatRate(Long vatRate) {
		this.vatRate = vatRate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public List<ItemLine> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<ItemLine> lineItems) {
		this.lineItems = lineItems;
	}
}
