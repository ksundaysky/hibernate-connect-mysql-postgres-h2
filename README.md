## Date and time

@Temporal annotation in Hibernate

* @Temporal annotation in Hibernate is used with the pojo properties of type java.util.Date and java.util.Calendar
* @Temporal annotation automatically converts the date and time values from the Java object to the compatible database type
* There are 3 types of temporal in the hibernate framework i.e.
    1. TemporalType.TIMESTAMP maps the date as java.sql.Timestamp
    2. TemporalType.DATE maps the date as java.sql.Date
    3. TemporalType.TIME maps the date as java.sql.Time

*To avoid dependencies on the java.sql package, 
it’s common to use the java.util or java.time instead.*

    Something worth to know:

    * java.sql.Date - a milliseconds value represents the number of milliseconds that
    have passed since January 1, 1970 00:00:00.000 GMT.
    * TIMESTAMP is seconds since 1970, sitting in 4 bytes.
    It is stored in GMT. That is,the TimeZone offset is applied as you store a value,
    then reapplied when you fetch it.
    * DATETIME is an 8-byte string of digits "yyyymmddhhmmss"

#Task:

1. Implement in Author his date of birth using java.util.Calendar (remember about using proper TemporalType).
2. Next implement date of adding Author to the database using java.util.Date.
3. Implement date of issue in Book using java.time.


### Documentation 

Checkout documentation:

* [docs.jboss](https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#basic-datetime)
* [java.util.Calendar](https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html)
* [java.util.Date](https://docs.oracle.com/javase/7/docs/api/java/util/Date.html)
* [java.time](https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html)
* [java.time.ZoneOffset](https://docs.oracle.com/javase/8/docs/api/java/time/ZoneOffset.html)
* [java.time.OffsetTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetTime.html)

### Tips 

If you install db for first time (or forget how to do it):

* [MySQL](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-18-04)
* [PostgreSQL](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-postgresql-on-ubuntu-18-04)
* [H2](https://www.h2database.com/html/installation.html)