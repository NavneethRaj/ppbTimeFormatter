# ppbTimeFormatter
Format Time For a Ninety Minute Game

To Run in IDE :

-------- RUN USING WEBINTERFACE ----------------------------------
1) Clone the project to your desired local destination
2) If you have IDE for JAVA you can import the projects
3) Run com.timeformat.PpdAssignmentApplication as JAVA Application
4) SpringBoot should be up and running 
5) You can access WEB using this link (default port is 8090):
   http://localhost:8090/matchTimeConvert
6) Enter the input time format
   Sample : [HT] 45:00.000

-------- RUN AS API ---------------------------------------------- 
1) Clone the project to your desired local destination
2) If you have IDE for JAVA you can import the projects
3) Run com.timeformat.PpdAssignmentApplication as JAVA Application
4) SpringBoot should be up and running 
5) You can access API using this link (default port is 8090):
   http://localhost:8090/matchtimeformatter
6) Send the request as JSON (I use POSTMAN)
   sample :
   {
    "inputTF": "[TH] 9:59.412"
   }
   
-------- RUN AS JNUIT ---------------------------------------------- 
1) Clone the project to your desired local destination
2) If you have IDE for JAVA you can import the projects
3) Run com.timeformat.PpdAssignmentApplicationTest as jUnit
4) SpringBoot should be up and running 
5) You can see the results at the end in the console
6) If you want to add more test data you can add it to inputTimeFormat Array and make sure expectedTimeFormat Array matches the index

-------- RUN AS MAVEN ---------------------------------------------- 
1) Project right click -> run as -> maven -> build...
2) Enter goal as package
3) Navigate to project folder and execute java -jar target/ppd-assignment-0.0.1-SNAPSHOT.jar
4) Server should be up and running 
5) Can test either with api or web interface


NOTE :
port and other config can be changed in applciation.properties file
version of JAVA can be changed in pom.xml, I am using 12 for this project

SAMPLE JUNIT OUTPUT :

|Input Value    |Actual Value               |Expected Value             |

|[PM] 0:00.000  |00:00 - PRE_MATCH          |00:00 - PRE_MATCH          |

|[PM] 0:00.001  |INVALID                    |INVALID                    |

|[PM] 00:01.000 |INVALID                    |INVALID                    |

|[H1] 00:00.001 |00:00 - FIRST_HALF         |00:00 - FIRST_HALF         |

|[H1] 0:15.025  |00:15 - FIRST_HALF         |00:15 - FIRST_HALF         |

|[H1] 3:07.513  |03:08 - FIRST_HALF         |03:08 - FIRST_HALF         |

|[H1] 45:00.001 |45:00 +00:00 - FIRST_HALF  |45:00 +00:00 - FIRST_HALF  |

|[H1] 46:15.752 |45:00 +01:16 - FIRST_HALF  |45:00 +01:16 - FIRST_HALF  |

|[HT] 45:00.000 |45:00 - HALF_TIME          |45:00 - HALF_TIME          |

|[HT] 45:00.001 |INVALID                    |INVALID                    |

|[H2] 5:59.412  |INVALID                    |INVALID                    |

|[H2] 45:00.001 |45:00 - SECOND_HALF        |45:00 - SECOND_HALF        |

|[H2] 45:00.500 |45:01 - SECOND_HALF        |45:01 - SECOND_HALF        |

|[H2] 66:59.789 |67:00 - SECOND_HALF        |67:00 - SECOND_HALF        |

|[H2] 89:59.412 |89:59 - SECOND_HALF        |89:59 - SECOND_HALF        |

|[H2] 90:00.908 |90:00 +00:01 - SECOND_HALF |90:00 +00:01 - SECOND_HALF |

|[FT] 90:00.000 |90:00 - FULL_TIME          |90:00 - FULL_TIME          |

|[FT] 99:59.412 |INVALID                    |INVALID                    |

|[H2] 95:59.412 |90:00 +05:59 - SECOND_HALF |90:00 +05:59 - SECOND_HALF |

|90:00          |INVALID                    |INVALID                    |

|[H3] 90:00.000 |INVALID                    |INVALID                    |

|[PM] -10:00.000|INVALID                    |INVALID                    |

|FOO            |INVALID                    |INVALID                    |

|[TH] 9:59.412  |INVALID                    |INVALID                    |
