# Custom Login Web Application

Web application powered by Java, Spring, Hibernate that allows users to login and register. Application makes use of custom login and registration code and front-end design instead of Spring Security Default login screen. This application creates and makes use of default database schema required for Spring security to create new users and maintain existing ones. 

# How to use it? 

1.Execute the sql scripts provided in the repository. 
   - create-user.sql : Creates a new user for you to create your schema and to access it.
   - login-demo.sql : Creates the default schema required by Spring Security for login and registration.
   
   ![0](https://user-images.githubusercontent.com/16450711/62139007-3b71cc00-b306-11e9-8f34-525df681793a.PNG)

2.Use Apache Tomcat(or similar) as a server for the Java source code and run the web application on it.

3.If you used your own sql scripts, update the database information in persistence-mysql.properties in src/main/resources

4.The application will ask you to either login or register a new user. (Check for dummy user login info in the sql scripts)
![gg1](https://user-images.githubusercontent.com/16450711/62139055-4b89ab80-b306-11e9-8943-7f7f149df7b8.PNG)

![2](https://user-images.githubusercontent.com/16450711/62139073-547a7d00-b306-11e9-8ac3-33fcfa2e9ce4.PNG)

5.Once logged in you can see your user name and roles.
![gg3](https://user-images.githubusercontent.com/16450711/62139092-5e03e500-b306-11e9-9788-ed5e04fe6618.PNG)

