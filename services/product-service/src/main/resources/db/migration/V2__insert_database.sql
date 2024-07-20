-- Insert data into the category table using category_seq for IDs
INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Electronics devices and gadgets', 'Electronics'),
    (nextval('category_seq'), 'Books of various genres', 'Books'),
    (nextval('category_seq'), 'Clothing and accessories', 'Apparel'),
    (nextval('category_seq'), 'Home appliances and furniture', 'Home & Kitchen');

-- Insert data into the product table using product_seq for IDs
INSERT INTO product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 100, 'Smartphone with 6GB RAM and 128GB storage', 'Smartphone', 299.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 200, 'Science fiction novel', 'Sci-Fi Book', 19.99, (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 150, 'Men''s leather jacket', 'Leather Jacket', 89.99, (SELECT id FROM category WHERE name = 'Apparel')),
    (nextval('product_seq'), 80, 'Microwave oven with grill function', 'Microwave Oven', 79.99, (SELECT id FROM category WHERE name = 'Home & Kitchen')),
    (nextval('product_seq'), 50, 'LED TV with 4K resolution', 'LED TV', 499.99, (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 120, 'Romantic novel', 'Romance Book', 15.99, (SELECT id FROM category WHERE name = 'Books')),
    (nextval('product_seq'), 300, 'Women''s summer dress', 'Summer Dress', 39.99, (SELECT id FROM category WHERE name = 'Apparel')),
    (nextval('product_seq'), 60, 'Blender with multiple speed settings', 'Blender', 34.99, (SELECT id FROM category WHERE name = 'Home & Kitchen'));
