# eoh

Please find details log onto the embedded H2 in-memory database below :
h2 db uri : localhost:8080/h2-console
spring.datasource.url=jdbc:h2:mem:bootapp;DB_CLOSE_DELAY=-1
spring.datasource.username=sa
spring.datasource.password=

Valid RESTful URIs are as shown below :
GET : http://localhost:8080/invoices
GET : http://localhost:8080/invoices/${id}
POST : http://localhost:8080/invoices - This expects a payload whose content-type is application/json similar to the one shown below :

{
	"client":"Mduduzi",
	"vatRate":14,
	"invoiceDate":"2018-10-26",
	"lineItems":[
			{"quantity":7,"description":"this is test item line one","unitPrice":10.01},
			{"quantity":5,"description":"this is test item line two","unitPrice":45.45}
		    ]
}

Please note that all test conducted where run on a local STS-bundle and a Spring boot embedded tomcat server and accesed via a web browser.

Thank you.  
