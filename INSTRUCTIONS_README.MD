# Tech stack used in the project
* IDE - IntelliJ - Spring
* Build tool - Maven
* Database - H2 Database
* There are 2 Source folders. 
        1. Java - contains all the code
        2. Test - contians Junit and Integration
           testing folders.
* Github, bitbucket as versioning system. 
 

# Instructions to Run the Application

* import project from Git/bitbucket.
* Build the project as Maven project / convert a project to Maven project
* Your application will turn into Spring boot application.
* Goto OrdersApplication.class. The top most in the hierarchy
* Run as Java Project / spring boot application.
* The application is exposed as following REST APIs.


#### APIS for Orders:

`http://localhost:8088/orders`- Gets all the list of orders

`http://localhost:8088/orders/{"orderNo"}` - Gets specific order based on order number
 
 `http://localhost:8088/SearchOrders?status={"status"}&noOfProducts={"#ofproducts"}` - Gets an order from list of 
 orders that satisfies a hierarchical set of conditions given in other README document.
 
 
#### APIS for Product:
 
 `http://localhost:8088/products`- Gets all the list of products
 
 `http://localhost:8088/products/{"productNo"}` - Gets specific product based on product number
 
 `http://localhost:8088/productSearch/{"price"}` - Gets list of products greater than the price specified 


#### Test Suites

    * Right click on test folder and click on option "Run All Tests with coverage" (Intellij)
    * Check for results of code code coverage. Current coverage is 78% (# of lines)
    
    
#### Issues and Comments

    *  This is the first time I did Integration testing. Though it works I don't consider it to be the best effort. But I can learn it quickly.
    * I have provided a generic Search searvice. We can even query based on other statuses.
    * I have handled erroneous input situation and tested with Junit test cases.
    
    
    
 

####                    Thank you for the Opportunity.



   
  
 