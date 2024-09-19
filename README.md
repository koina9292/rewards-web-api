***Rewards Spring Boot Web REST API***

Rewards API provides endpoints exposing reward calculation/points for given transactions

- The following business logic is applied when calculating individual transaction reward points:
    
    A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every
    dollar spent between $50 and $100 in each transaction.

**Build application**
    
    - Ensure maven is setup on local machine
    - Run the following from the root of the project
```
    mvn clean install       
```

**Run application**
    
    - Can be ran using spring-boot runner plugins through IDE
    - Alternatively application jar can be run using the following command from the terminal  
``mvn spring-boot:run``

**Exposed endpoints**

    - POST '/api/rewards/calculate'


