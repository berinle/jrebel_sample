## Sample app to try and reproduce unnecessary reloading by Jrebel 
When two or more web applications are configured on the same server instance, we are seeing that changes to static files,
such as **javascript** and **images** are causing jrebel to reload the application context, which shouldn't be the case.

## Structure of sample application
1. foggy-persistence - provides data access layer infrastructure and is used by **foggy-core**
2. foggy-core - provides a service via httpinvoker that can be consumed by a client
3. foggy-web - front facing web application that consumes services provided by foggy-core


## Deployment
Both **foggy-core** and **foggy-web** are web applications, though foggy-core is a headless one. **foggy-core** can be deployed independently or can be deployed on the same server instance as **foggy-web**


## Running the sample
The application can be run via the command line or inside an IDE of your choosing.

From command line
-----------------

1. Clone the repo
2. Change directory into foggy-core
3. Run **gradle jettyRun**

This will start **foggy-core** on port 8888 by default. This can be changed in the **build.gradle** for this sub-module file.

4. Change directory into foggy-web
5. Run **gradle jettyRun**

This will start **foggy-web** which consumes **foggy-core** on 8080.

From the IDE
------------
1. Setup your IDE to point to a server e.g. tomcat
2. Deploy **foggy-core** and **foggy-web** onto the server


## Expected result
Changes in static files should cause JRebel to reload the application context of **foggy-web**


## Actual result
Not able to reproduce