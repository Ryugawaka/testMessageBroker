# testMessageBroker
в качестве брокера сообщений используется RabbitMQ
ссылка для скачивания: https://www.rabbitmq.com/#getstarted
интсрукция для установки: https://www.rabbitmq.com/download.html

для запуска сервиса выполнить команнду в терминале:./mvnw spring-boot:run
сервис передает полученный json String в брокер используя post запрос по адресу http://localhost:8080/send
пример запроса:
curl --location --request POST 'http://localhost:8080/send?=' \
--form 'json="{\"menu\": {  \"id\": \"fileы\",  \"value\": \"File\",  \"popup\": 
{    \"menuitem\": [      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},     
{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},     
{\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}    ]  }}}"'
