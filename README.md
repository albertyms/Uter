Endpoint Driver:

POST: localhost:8080/api/uter/driver
JSON: {
      	"name" : "",
      	"surName" : "",
      	"license" : 
      }
      
GET: http://localhost:8080/api/uter/driver
RESPONSE JSON: [
                   {
                       "id": 1,
                       "name": "",
                       "surName": "",
                       "license": ""
                   }
               ]

PUT: localhost:8080/api/uter/driver/1
RESPONSE JSON: {
               	"id" : 1,
               	"name" : "",
               	"surName" : "",
               	"license" : 
               }

DELETE: localhost:8080/api/uter/driver/1

Endpoint Vehicle:

POST: localhost:8080/api/uter/vehicle
JSON: {
      	"brand" : "Mercedes",
      	"model" : "X100",
      	"plate" : "ABC123",
      	"licenseRequired": "X"
      }

GET: http://localhost:8080/api/uter/vehicle
RESPONSE JSON: [
                   {
                       "id": 1,
                       "brand": "Mercedes",
                       "model": "X100",
                       "plate": "ABC123",
                       "licenseRequired": "X"
                   }
               ]

PUT: localhost:8080/api/uter/vehicle/1
JSON: {
              "id": 1,
              "brand": "Toyota",
              "model": "Tundra",
              "plate": "ABC321",
              "licenseRequired": "1"
      }
      
DELETE: localhost:8080/api/uter/vehicle/1


Endpoint TRIP:

POST: localhost:8080/api/uter/trip
JSON: {
      	"date" : "2019-10-27T07:00:00.000Z",
      	"vehicle" : {
      			"id": 1,
      	        "brand": "Mercedes",
      	        "model": "X100",
      	        "plate": "ABC123",
      	        "licenseRequired": "1"
      		},
      	"driver" :  {
      			"id": 1,
      	        "name": "Albert",
      	        "surName": "Medina",
      	        "license": "881675"
      		}
      }
      
GET: http://localhost:8080/api/uter/trip
RESPONSE JSON: [
                   {
                       "id": 1,
                       "vehicle": {
                           "id": 1,
                           "brand": "Mercedes",
                           "model": "X100",
                           "plate": "ABC123",
                           "licenseRequired": "X"
                       },
                       "driver": {
                           "id": 1,
                           "name": "Albert",
                           "surName": "Medina",
                           "license": "881675"
                       },
                       "date": "2019-10-27T07:00:00.000+0000"
                   }
               ]
               
