Harshastores E-Commerce System REST API Documentation

This REST API documentation outlines the features and endpoints provided by the E-Commerce System API developed using Java Spring Boot framework.

Features

1. Adding Product with Product Variant CRUD Operations
Create Product:
Endpoint: POST /addProduct
Description: Create a new product with provided details including name, description, price, and variants details.

Create/Add muliple Product:
Endpoint: POST /addAllProducts
Description: Add multiple new products with provided details including name, description, price, and variants details.

Update Product:
Endpoint: PUT /updateproduct
Description: Update an existing product with new details.(Varient details will be updated only if the addVarients flag(Boolean) is sent as true from the request body)

Delete Product:
Endpoint: DELETE /product/{id}
Description: Delete a product and all the details by its ID.

Retrieve Product:
Endpoint: GET /product/{id}
Description: Retrieve details of a product by its ID.

Search Products by Condition:
Endpoint: POST /getProduct
Description: Search products by product name or description or variant name. Supports query parameters for search criteria. We have used Custom native queries for this search criteria.

Request and Response Formats with examples:

http://localhost:8080/api/harshaStores

1. Endpoint: POST /addProduct

requestBody:
{
    "name": "shirt",
    "description": "mens shirt",
    "price": 400.00,
    "variants": [
        {
            "name": "tshirt",
            "sku": "jsh1234567",
            "additionalCost": 50.00,
            "stockCount": 50
        }
    ]
}

Sample response:
{
    "id": 1,
    "name": "shirt",
    "description": "mens shirt",
    "price": 400.00,
    "variants": [
        {
            "id": 1,
            "name": "tshirt",
            "sku": "tsh1234567",
            "additionalCost": 50.00,
            "stockCount": 50
        }
	]
}

2. Endpoint: POST /addAllProducts

requestBody:
{
  [
    {
    "name": "shirt",
    "description": "mens shirt",
    "price": 400.00,
    "variants": [
        {
            "name": "tshirt",
            "sku": "jsh1234567",
            "additionalCost": 50.00,
            "stockCount": 50
        }
     }
     {
    "name": "pant",
    "description": "mens pant",
    "price": 800.00,
    "variants": [
        {
            "name": "cargos",
            "sku": "js33u74567",
            "additionalCost": 110.00,
            "stockCount": 150
        }
     }
    ]

}

Sample Response:
{
  [
    {
    "id": 1
    "name": "shirt",
    "description": "mens shirt",
    "price": 400.00,
    "variants": [
        {
	    "id": 1
            "name": "tshirt",
            "sku": "jsh1234567",
            "additionalCost": 50.00,
            "stockCount": 50
        }
     }
     {
    "id": 2
    "name": "pant",
    "description": "mens pant",
    "price": 800.00,
    "variants": [
        {
            "id": 2
            "name": "cargos",
            "sku": "js33u74567",
            "additionalCost": 110.00,
            "stockCount": 150
        }
     }
    ]

}

3. Endpoint: DELETE /product/{id}

path variable : id = 1

Sample response:
Product Deleted: 1

4. Endpoint: GET /product/{id}

path variable : id = 1

Sample response:

{
    "id": 1,
    "name": "shirt",
    "description": "mens shirt",
    "price": 400.00,
    "variants": [
        {
            "id": 1,
            "name": "tshirt",
            "sku": "tsh1234567",
            "additionalCost": 50.00,
            "stockCount": 50
        }
	]
}

5. Endpoint: POST /getProduct

requestBody:
{
   "name": "shirt"
}

or

requestBody:
{
   "description": "mens shirt"
}

or

requestBody:
{
   "addVariants": true,
   "variantName": tshirt
}



Sample response:

{
    "id": 1,
    "name": "shirt",
    "description": "mens shirt",
    "price": 400.00,
    "variants": [
        {
            "id": 1,
            "name": "tshirt",
            "sku": "tsh1234567",
            "additionalCost": 50.00,
            "stockCount": 50
        }
	]
}

6. Endpoint: PUT /updateproduct



Authentication and Authorization
This API does not require authentication for now. However, for production use, authentication and authorization mechanisms should be implemented.

How to run the project:

1. This project is developed in Spring boot version 2.7.0 and with the JDK 1.8 is being used. For the database storage we have used MySQL developer workbench. 
2. MySql configurations are already there in application.properties so creation of table happens when the database is connected locally via localhost and when we run the application via spring tool suit.
3. To test all the endpoints we have used the POSTMAN tool along with sts and Mysql workbench.