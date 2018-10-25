insert into `invoice` set `client` =  'Okelitse', `vat_rate` = '14', `invoice_date` = now();

SET @InvoicePK = (select max(`id`) from `invoice` );

insert into `item_line` set `description` = 'this is test item line one', `quantity` = 4, `unit_price` = 23.21, `invoice` = @InvoicePK;

insert into `item_line` set `description` = 'this is test item line two', `quantity` = 3, `unit_price` = 89.45, `invoice` = @InvoicePK;
