create table if not exists products(id bigserial primary key, name varchar(255), price int);

insert into products (name, price) VALUES
                                       ('Apple', 250),
                                       ('Banana', 520),
                                       ('Rice', 300);

create table if not exists carts( CartID INT PRIMARY KEY, UserID INT);

CREATE TABLE cartItems (
                           CartID INT,
                           ProductID INT,
                           Quantity INT,
                           PRIMARY KEY (CartID, ProductID),
                           FOREIGN KEY (CartID) REFERENCES carts(CartID),
                           FOREIGN KEY (ProductID) REFERENCES products(id)
);