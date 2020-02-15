# Real Estate API

## Data-processing web API in Java.  
Program includes a file filled with csv data about real estate sales in California. As the server is started up the file is parsed and data is placed into a data structure in memory

Created a server using Spring Boot to access the data through API calls. Server listens for requests on port 8080 at the path "/housing-statistics". Users can input different parameters which will then affect the data that is returned

Created seperate java functions that iterate through the data structure and perform calculations on data (based on parameters passed through by server). Also applied unit testing to calculation methods using junit framework 
