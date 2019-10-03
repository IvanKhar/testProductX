# testProductX
тестовое задание по реализации простого REST сервиса

задание: 
Дано: 
Сущность «Продукт» к примеру там «IPAD»,«IPhone»
Сущность «Характеристика» к примеру «CPU xxx»,«Memory xxx»,«Цвет xxx»,«Вес xxx»
 
Надо:
Используя EJB/Spring/SpringBoot  + Hibernate
Сделать 2 REST сервис
1. возвращает продукт + характеристики по имени продукта
2. Полный список продуктов + характеристики
Входной формат – query parameter
Выходной формат – Json


Приложение реализовано с использованием java 11, spring boot, spring web, spring jpa.
Используется in memory БД H2, пожтому есть возможность запустить и проверить приложение без развертывания отдельной БД.

доступные ресурсы: 
- (GET) http://localhost:8080/product - чтение product по id, на вход принимает параметр запроса "id"
- (GET) http://localhost:8080/product/all - возвращает все объекты product
- (POST) http://localhost:8080/product - создание product, на вход принимает json(пример приложен ниже)

пример тестового запроса на создание сущности Product:

`
{
    "name": "iPad",
    "characteristics": [
    	{
	        "name": "cpu",
	        "value": "10000"
	    },
    	{
	        "name": "memory",
	        "value": "256"
	    },
    	{
	        "name": "color",
	        "value": "blue"
	    }
	 ]
}
`

