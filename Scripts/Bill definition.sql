USE supermarket;

CREATE TABLE InvoiceLineItem (
    invoiceLineItemId INT AUTO_INCREMENT PRIMARY KEY,
    productId INT,
    quantity INT,
    taxes DOUBLE,
    discount DOUBLE,
    subtotal DOUBLE,
    points DOUBLE,
    taxesPCT DOUBLE,
    pointsPCT DOUBLE,
    discountPCT DOUBLE,
    FOREIGN KEY (productId) REFERENCES Product(Id)
);

CREATE TABLE TotalLineItem (
    totalLineItemId INT AUTO_INCREMENT PRIMARY KEY,
    employeeDiscount DOUBLE,
    totalQuantityProducts INT,
    totalDiscount DOUBLE,
    totalTaxes DOUBLE,
    totalToPay DOUBLE,
    totalAccumulatedPoints DOUBLE
);

CREATE TABLE Bill (
    billId INT AUTO_INCREMENT PRIMARY KEY,
    issueDate DATE,
    customerId INT,
    employeeId INT,
    totalLineItemId INT,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId),
    FOREIGN KEY (employeeId) REFERENCES Employee(employeeId),
    FOREIGN KEY (totalLineItemId) REFERENCES TotalLineItem(totalLineItemId)
);

CREATE TABLE Bill_InvoiceLineItem (
    billId INT,
    invoiceLineItemId INT,
    PRIMARY KEY (billId, invoiceLineItemId),
    FOREIGN KEY (billId) REFERENCES Bill(billId),
    FOREIGN KEY (invoiceLineItemId) REFERENCES InvoiceLineItem(invoiceLineItemId)
);







