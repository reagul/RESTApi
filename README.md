## MongoDB Spring REST Service - Example 1
Author: Niclas Tegnér

This is an example of a REST service that loads and stores json data using Mongo DB. 

### Preparations
Mongo DB must be installed on your local machine. Please [download Mongo DB][1]
and follow [the install instructions][2]. 

### Feature highlights
- Rest service with CRUD support.
- Mongo DB 2.4.9 for loading and storing json data.
- Spring Framework 4.0.0
- Jersey 1.18
- Spring context is configured by Java configuration (instead of xml configuration)

### Testing Mongo DB via the REST service

First of all, you must start Mongo DB on your local machine:

```
> cd <mongodb_home_dir>
> cd bin
> mongod.exe
```

Use the REST service to create some support tickets:

```
curl -i -X POST -H "Content-Type: application/json" -d '{"subject":"We are out of coffee!!!","description":"Please help now!","createdDateTime":"2014-01-21T09:03:28","priority":9999}' http://localhost:8084/mongodb-spring-example1/supportticket
curl -i -X POST -H "Content-Type: application/json" -d '{"subject":"BROKEN KEYBOARD","description":"CAPSLOCK IS ALWAYS ON","createdDateTime":"2014-01-21T10:37:49","priority":2}' http://localhost:8084/mongodb-spring-example1/supportticket
```
Please pay attention to the responses because the url to get the created support tickets
will be found in the location part, like this:
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

Update the priority of a support ticket:

```
curl -i -X PUT http://localhost:8084/mongodb-spring-example1/supportticket/52de563a151caedae9c33a74/priority/5
```

Delete a support ticket:

```
curl -i -X DELETE http://localhost:8084/mongodb-spring-example1/supportticket/52de563a151caedae9c33a74
```

[1]: http://www.mongodb.org/downloads/
[2]: http://docs.mongodb.org/manual/installation/