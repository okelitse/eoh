package za.co.eoh.assessment.repository;

import org.springframework.data.repository.CrudRepository;

import za.co.eoh.assessment.repository.domain.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
