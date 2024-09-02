create table if not exists users(
    id bigserial primary key,
    username varchar(30) not null,
    password varchar(255) not null,
    email varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default  current_timestamp);

create table roles(
    id bigserial primary key ,
    name varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default  current_timestamp);

create table users_roles(
    user_id bigint not null references users(id),
    role_id bigint not null references roles(id),
    primary key (user_id, role_id)
);

insert into roles(name) values ('ROLE_ADMIN'), ('ROLE_USER');

insert into users(username, password, email) VALUES
                                                 ('bob', '$2a$12$8sT7KTIuAXprgeQ4WXQhauCAAeQuqaWeKUIrGvKsO8lcE8eSkz0Xi', 'email'),
                                                 ('john', '$2a$12$8sT7KTIuAXprgeQ4WXQhauCAAeQuqaWeKUIrGvKsO8lcE8eSkz0Xi', 'email');

insert into users_roles (user_id, role_id) VALUES
                                               (1, 1),
                                               (2, 2);