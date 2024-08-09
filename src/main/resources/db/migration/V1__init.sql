create table if not exists products(id bigserial primary key, name varchar(255), price int);

INSERT INTO products (name, price) VALUES
                                       ('Apple', 250),
                                       ('Banana', 520),
                                       ('Rice', 300),
                                       ('Orange', 150),
                                       ('Milk', 400),
                                       ('Bread', 200),
                                       ('Butter', 350),
                                       ('Cheese', 600),
                                       ('Chicken', 700),
                                       ('Beef', 800),
                                       ('Pasta', 250),
                                       ('Tomato', 100),
                                       ('Onion', 80),
                                       ('Carrot', 90),
                                       ('Potato', 60),
                                       ('Cucumber', 120),
                                       ('Garlic', 50),
                                       ('Pepper', 180),
                                       ('Sugar', 220),
                                       ('Salt', 30),
                                       ('Coffee', 350);

create table if not exists carts( CartID INT PRIMARY KEY, UserID INT);

CREATE TABLE cartItems (
                           CartID INT,
                           ProductID INT,
                           Quantity INT,
                           PRIMARY KEY (CartID, ProductID),
                           FOREIGN KEY (CartID) REFERENCES carts(CartID),
                           FOREIGN KEY (ProductID) REFERENCES products(id)
);