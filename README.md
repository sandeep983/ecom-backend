# ecom-house-backend
Backend APIs using Java 8 and Spring Boot 2.2.12

## Prerequisites:

Java 8 - [Download](https://docs.aws.amazon.com/corretto/latest/corretto-8-ug/downloads-list.html)

VS Code or Intellij Idea or STS or Eclipse or any other IDE which supports Maven Projects - [Download](https://code.visualstudio.com/download)

If using VS Code - [Download Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)


## How to Configure:
```
1. Open the project in VS Code or Import as Maven project in IDE (wait for some time so the dependencies can be downloaded)


2. After opening/importing the project goto resources package/folder and open application.properties
    
    Change these server and port properties according to your configuration
        server.address=192.168.1.9
        server.port=8080
    
    For getting the server address run this command
        Mac: ipconfig getifaddr en0
        Windows: ipconfig
    
    Copy and paste the public ip in place of 192.168.1.9
      

3. Now open EcomHouseBackendApplication.java and right click and click run java on VS Code or Run as Java Application on other IDEs
```


## Swagger Documentation:
**For Local**
visit -> localhost:8080/swagger or [Click Here](http://localhost:8080/swagger)
