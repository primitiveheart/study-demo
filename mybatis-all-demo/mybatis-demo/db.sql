create table users (
  `id` int auto_increment primary key,
  `name` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into users(id, name , city) values (1, "test", "上海");
