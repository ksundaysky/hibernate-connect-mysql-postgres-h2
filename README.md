#Eager vs. Lazy

There are two types of loading from database by Hibernate.
* eager - no matter if we use object or not, all fields'll be load
* lazy - if entity has fields which are referenced to another entity, lazy loading won't load this fields

To see how it works, go to AppEager class and follow the instructions.