<h3>Контроль показаний приборов учёта</h3>
Для запуска проекта:
<ul>
    <li>Сделать restore photoBee.sql через pgAdmin (photoBalans/photobee.sql)</li>
    <li>Скачать и установить Apache tomcat <a href="https://tomcat.apache.org/download-90.cgi">https://tomcat.apache.org/download-90.cgi</a></li>
    <li>В resources (photoBalans\src\main\resources) изменить <b>application.properties</b> ключ: <b>datasource.url</b> 
    на url своего сервера</li>
    <li>В resources (photoBalans\src\main\resources) изменить <b>application.properties</b> ключ: <b>path.upload</b>
    на путь для сохранения и загрузки img.</li>
 </ul>
