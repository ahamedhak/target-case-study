# target-case-study (myRetail RESTful service)

# Startup
To start the service run the following script file
__windows__ - `run.bat`
__linux__ - `run.sh`

_*this will bring up both __PriceDemo__ and __ProductDemo__ spring boot services_
# Testing 

## 1.**GET** - http://localhost:8889/products/{id}
## Case 1 : _if product exist_
#### response body
```json
	{
		"id": 13860429,
		"name": "SpongeBob SquarePants: SpongeBob's Frozen Face-off",
		"current_price": {
			"value": 40.923977,
			"currency_code": "INR"
		}
	}
```
    
status code : **200 ok**


## Case 2 : _if product not exist_
#### response body
**empty body**
status code **404 not found**


## 2.**PUT/POST** - http://localhost:8889/products/{id}
#### request body
	{
		"id": 13860429,
		"name": "SpongeBob SquarePants: SpongeBob's Frozen Face-off",
		"current_price": {
			"value": 40.923977,
			"currency_code": "USD"
		}
	}
	
## Case 1 : _if product exist_
#### response body
	{
		"id": 13860429,
		"name": "SpongeBob SquarePants: SpongeBob's Frozen Face-off",
		"current_price": {
			"value": 40.923977,
			"currency_code": "USD"
		}
	}
status code : **200 ok**

## Case 1 : _if product not exist_
#### response body
**empty body**
status code **404 not found**

### *NOTE:-*

- PriceDemo service is used to store product price 
- PriceDemo service uses embedded H2 db
  - it expose 2 API which called within Product service
  -	**GET** - http://localhost:8888/price/{id}
  	response:
    ```json
    {
	    "id": 1234,
	    "value": 23.123598,
	    "currency_code": "USD"
    }
    ```
	*for first time fetch **'value'** is selected as a randon float value btw **1** to **100** and **'currency_code'** is selected as a randon value from the set **{USD,INR,EUR}***
		
  - **PUT** - http://localhost:8888/price/{id}
  - request:
	  ```json
    {
	    "id": 1234,
	    "value": 23.123598,
	    "currency_code": "USD"
    }
    ```
	response:
	```json
    {
	    "id": 1234,
	    "value": 23.123598,
	    "currency_code": "USD"
    }
    ```
	*if entity with id doesn't exist it will insert in db otherwise update the existing one*
			

