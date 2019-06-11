#Eager vs. Lazy

There are two types of loading data from database by Hibernate.
* eager - doesn't matter if we use given field of loaded object, all fields will be loaded as well
* lazy - if entity has fields which are referenced to another entity, lazy loading won't load those fields

To see how it works, go to AppEager class and follow the instructions.