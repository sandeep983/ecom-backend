
-- For inserting data into the customer_support_hours table when the application starts up
INSERT INTO customer_support_hours (monday_to_thursday, friday, saturday, sunday) VALUES
('8:00am-7:45pm', '9:00am-7:45pm', '9:00am-5:45pm', '9:00am-5:45pm');

-- For inserting data into the customer_support_special_hours table when the application starts up
INSERT INTO customer_support_special_hours (date, hours) VALUES
('2024-08-05', '9:45am-6:45pm'),
('2024-08-06', '8:45am-7:45pm'),
('2024-08-07', '8:45am-6:45pm'),
('2024-08-10', '9:45am-5:45pm'),
('2024-08-15', '11:00am-3:00pm');