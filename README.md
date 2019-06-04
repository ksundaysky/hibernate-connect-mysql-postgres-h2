# Loggigng SQL

## Basic Logging
Logging sql queries send by Hibernate is important on development stage. It helps to see what exactly happens in the background.
Beneficial trump is use of statistics, which shows how many queries was created and in what time it was completed.

First way to add basic sql log is to set property SHOW_SQL on true in configuration. We can also use FORMAT_SQL to divide query
on parts. In documentation is written which properties we can use.

Documentation:
* http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#configurations-logging
* http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#best-practices-logging

## Log4j
Better is to have framework like log4j to log queries. To configure options, new version log4j 2 needs file "log4j2.xml" in resource.
Needed are two parts - appenders and loggers. First tell us about place, where our logs will be shown or saved and in what form.
Second defined what we want to log.

`<Logger name=" " level=" " additivity=" ">
    <AppenderRef ref=" " />
 </Logger>`

## Log parameters
Basic logging show us queries but without parameters passed to it. It's because the bind parameters are logged to the 
org.hibernate.type.descriptor.sql category with log level TRACE.

## Statistics
Last thing is statistics. In configuration must be turned on GENERATE_STATISTICS property.

Documentation:
* http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#statistics

Both of types can be configured in .xml file or programmatically directly at class.

#
Further instructions are available in --> App class.