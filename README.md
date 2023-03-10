# Repository related to the course [SDET/Test Architect Essentials - Road to Full stack QA][course]

This course covers the following topics:

 - Section 2: Converting JDBC Results into Java object with POJO classes
 - Section 3: Jackson API to convert Java objects into Json file formats
 - Section 4: Introduction to Docker and its Advantages
 - Section 5: Implementation of Docker to Automation tests
 - Section 6: Creating Window Batch files and Monitoring Server Logs
 - Section 7: Docker Integration to Jenkins
 - Section 8: Introduction to Jenkin Pipelines
 - Section 9: Build Pipelines Dynamically with Groovy Script for CI/CD
 - Section 10: Integrating DataProvider with Excel for Robust Data Driven Implementation
 - Section 11: Java Streams- Map, Filter, Match,Collect- (Build Optimized Code)
 - Section 12: GIT Commands and it uses -Version Control System
 - Section 13: Upcoming Topic - ( Data Structures & Algorithms)
 - Section 14: Grid & Jenkin Basics (Optional topics to support above Sections)

## Section 2: Converting JDBC Results into Java object with POJO classes
The objective of this section is to create an automation that validates the update of the second database that is done daily at 4 pm, as shown in the diagram. ![diagram][diagram]
For section 2 it is necessary to install MySQL and create the Business database, which can be done with the commands present in [file][sql].

What to Automate?

- Create Mock Tables in DataBase for this Project 
- Connect to DataBase through Java code and retrieve records from Table
- Convert results of Table into Java object with the help of POJO class implementation 
- Build Array List to store multiple results from DB Table and create Objects from each element of List
- Convert Java objects into Json Files using Jackson API
- Send Json File as input to the API Automation Test

## Section 7: Docker Integration to Jenkins
For this session to work you need to have installed docker and jenkins (configured with a build for this test project)

With this test he will run a job in jenkins where he will upload the configuration of docker-compose.yaml which has a selenium hub and a container with firefox and one with chrome. Afterwards, it will scale 3 more chrome containers to run the 3 tests in parallel. Finishing dowing the containers.

## Section 10: Integrating DataProvider with Excel for Robust Data Driven Implementation
In this session it was possible to read data from an excel file and use it in a multidimensional array to run the tests separately, where each line of excel was used in a test.

## Section 11: Java Streams- Map, Filter, Match,Collect- (Build Optimized Code)
In this session some tests were done using stream. Map, filter and collect.

[course]: https://www.udemy.com/course/sdettraining-testarchitect-fullstackqa/?utm_source=adwords&utm_medium=udemyads&utm_campaign=DSA_Catchall_la.EN_cc.ROW&utm_content=deal4584&utm_term=_._ag_88010211481_._ad_535397282061_._kw__._de_c_._dm__._pl__._ti_dsa-705815702041_._li_20583_._pd__._&matchtype=&gclid=CjwKCAiA85efBhBbEiwAD7oLQK22v7tfDS21x2NtOcmZFFBRmW77xpdrGiikKJUqbW5lIfJXErHJRxoC8q0QAvD_BwE
[sql]: src/main/resources/sql.txt
[diagram]: src/main/resources/2problem.png