## MongoDB Spring REST Service - Example 1
Author:Ravi Jagannathan

This is an example of a REST service that loads and stores json data using Mongo DB. 

### Preparations
Mongo DB must be installed on your local machine. 
### Feature highlights
- Rest service with CRUD support.
- Mongo DB 2.4.9 for loading and storing json data.
- Spring Framework 4.0.0
- Jersey 1.18
- Spring context is configured by Java configuration (instead of xml configuration)

### Using REST API using  Mongo DB datastore

First of all, you must start Mongo DB on your local machine:

```
On Windows 

> cd <mongodb_home_dir>
> cd bin
> mongod.exe
```
```
On Linux 

> cd <mongodb dir>
> /bin/mongod

```


Use the REST service to as a Template to create API . 

```
curl -i -X POST -H "Content-Type: application/json" -d '{"subject":"We are out of coffee!!!","description":"Please help now!","createdDateTime":"2014-01-21T09:03:28","priority":9999}' http://localhost:8084/RESTApi/
curl -i -X POST -H "Content-Type: application/json" -d '{"subject":"BROKEN KEYBOARD","description":"CAPSLOCK IS ALWAYS ON","createdDateTime":"2014-01-21T10:37:49","priority":2}' http://localhost:8084/RESTApi
```
RESPONSE
```
HTTP/1.1 201 Created
Server: Apache-Coyote/1.1
Location: http://localhost:8084/mongodb-spring-example1/supportticket/52de563a151caedae9c33a74
Content-Length: 0
Date: Tue, 21 Jan 2014 11:12:58 GMT
```

Get a newly created support ticket (url from the "201 Created" response):

```
curl -i -H "Accept: application/json" http://localhost:8084/mongodb-spring-example1/supportticket/52de563a151caedae9c33a74
```

