# Recipe Manager

This recipe application lets users easily create their own recipe catalog. Users can fill in all the essential details like the recipe name, ingredients, cooking time, step-by-step instructions and difficulty level. There's also a feature to rate each recipe, helping users track their favorites.

Note: If you are a contributer, please read [CONTRIBUTING.md](https://github.com/acmpesuecc/recipe-manager/blob/main/CONTRIBUTING.md)

# Prerequisites

- IntelliJ IDEA
- MySQL

# Getting Started

### Database Connection

When you're using MySQL, make sure to configure the database properties (`src/main/resources/application.properties`). 

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/recipe
    spring.datasource.username=root
    spring.datasource.password= `ADD YOUR DATABASE PASSWORD HERE`
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

You can interact with the database using the MySQL CMD Line Client or use the command below to connect to the MySQL server using your username, with the server prompting you to enter the password for the user.
    
    mysql -u your_user_name -p 
    create database recipe;

## Running

1. Using IntelliJ IDEA
   * In the Run/Debug configurations make sure it says `com.example.HelloSQL.expApplication` under Build and Run.
   * Run the Application and open http://localhost:8080/recipe_catalog.html

## Resources

Go by example `https://gobyexample.com/`
