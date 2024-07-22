# WarehouseDatabase
Данная программа реализую склад и все его возможности, поступление новых деталей, отправка их на склад, а также сборка кастомных деталей. Решение находится в ветке master. WareHouseDatabase реализуют базу данных и подключение к ней.
Для работы программы можно установить Dbeaver,
Создать подключение с PostgresSql,
Создать базу данных с именем postgres,
В скрипт базы данных вставить данный код:
{ 
  create table Shelf(
	shelf_id int Primary key not null,
	Check(shelf_id <= 20)
);
create table Detail(
	shelf_id int References Shelf(shelf_id),
	id int primary key,
	name varchar(96)
);
}
