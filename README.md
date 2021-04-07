# r2dbc-json-converter-no-longer-working
A small demo to show that upgrading spring-data-r2dbc from 1.2.3 to 1.2.4 has caused the JSON converter to stop working.

In order to run this project, you'll need to have a Postgres database and have this project connect to it. You can
edit JsonConverterNoLongerWorking/src/main/resources/application.properties to allow this project to connect to
your database. After that, you'll want to run the JsonConverterNoLongerWorking/src/main/resources/database_script.sql
in your database. This will create the table and insert an entry to that table so that the JSON issue can be tested out.

You can then make a GET request to http://localhost:8080/houses. The request will end up failing due to a MappingException.
By switching spring-data-r2dbc from 1.2.4 to 1.2.3 in https://github.com/JoeBalduz/r2dbc-json-converter-no-longer-working/blob/main/JsonConverterNoLongerWorking/build.gradle.kts,
you can get the request to succeed.
