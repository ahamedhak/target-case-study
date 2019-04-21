# target-case-study

#Startup
To start the service run the following script file

win - run.bat
linux - run.sh

this will bring up both PriceDemo and Price spring boot services


#Testing 

available API

GET - http://localhost:8889/products/{id}

reponse if product exist

response body
	{
		"id": 13860429,
		"name": "SpongeBob SquarePants: SpongeBob's Frozen Face-off",
		"current_price": {
			"value": 40.923977,
			"currency_code": "INR"
		}
	}
status code 200 ok

reponse if product not exist

body
**empty**
status code 404 - not found


PUT/POST - http://localhost:8889/products/{id}
request body
	{
		"id": 13860429,
		"name": "SpongeBob SquarePants: SpongeBob's Frozen Face-off",
		"current_price": {
			"value": 40.923977,
			"currency_code": "USD"
		}
	}

reponse if product exist

response body
	{
		"id": 13860429,
		"name": "SpongeBob SquarePants: SpongeBob's Frozen Face-off",
		"current_price": {
			"value": 40.923977,
			"currency_code": "USD"
		}
	}
status code 200 ok

reponse if product not exist

body
**empty**
status code 404 - not found

NOTE:-
	1.PriceDemo service is used to store product price 
	1.PriceDemo service uses embedded H2 db
	2.it expose 2 API which called within Product service
		2.1 GET - http://localhost:8888/price/{id} with response
		{
			"id": 1234,
			"value": 23.123598,
			"currency_code": "USD"
		}
		*for first time fetch 'value' is selected as a randon float value btw 1 to 100 and 'currency_code' is selected as a randon value from the set {USD,INR,EUR}
		
		2.2 PUT - http://localhost:8888/price/{id} with request
		{
			"id": 1234,
			"value": 23.123598,
			"currency_code": "USD"
		}
		resposnse
		{
			"id": 1234,
			"value": 23.123598,
			"currency_code": "USD"
		}
		*if entity with id doesn't exist it will insert in db otherwise update the existing one
			

