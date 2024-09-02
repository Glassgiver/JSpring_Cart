create table if not exists products(id bigserial primary key, name varchar(255), price int, secret_key varchar(255));

INSERT INTO products (name, price, secret_key) VALUES
                                       ('Apple', 250, 'key1'),
                                       ('Banana', 520, 'key2'),
                                       ('Rice', 300, 'key3'),
                                       ('Orange', 150, 'key4'),
                                       ('Milk', 400, 'key5'),
                                       ('Bread', 200, 'key6'),
                                       ('Butter', 350, 'key7'),
                                       ('Cheese', 600, 'key8'),
                                       ('Chicken', 700, 'key9'),
                                       ('Beef', 800, 'key10'),
                                       ('Pasta', 250, 'key11'),
                                       ('Tomato', 100, 'key12'),
                                       ('Onion', 80, 'key13'),
                                       ('Carrot', 90, 'key14'),
                                       ('Potato', 60, 'key15'),
                                       ('Cucumber', 120, 'key16'),
                                       ('Garlic', 50, 'key17'),
                                       ('Pepper', 180, 'key18'),
                                       ('Sugar', 220, 'key19'),
                                       ('Salt', 30, 'key20'),
                                       ('Coffee', 350, 'key21');

create table if not exists carts( CartID INT PRIMARY KEY, UserID INT);

CREATE TABLE cartItems (
                           CartID INT,
                           ProductID INT,
                           Quantity INT,
                           PRIMARY KEY (CartID, ProductID),
                           FOREIGN KEY (CartID) REFERENCES carts(CartID),
                           FOREIGN KEY (ProductID) REFERENCES products(id)
);