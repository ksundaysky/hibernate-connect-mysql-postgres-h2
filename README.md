# Hibernate object lifecycle

Hibernate objects can live in 4 states:
* transient
* persistent
* detached
* removed

Hibernate does not manage transient objects.
Persistent object exist in the database and Hibernate can manage it.
Detached object have a representation in the database, but changes to the object will not be reflected in the database, and vice-versa.
Last state is when object is deleted from session and database.

There are few methods to menage lifecycle of object.

* transient -> persistent: `save(), saveOrUpdate()`
* persistent -> detached: `evict(), clear(), close()`
* detached -> persistent: `update(), merge(), saveOrUpdate()`
* persistent -> removed: `delete()`

Go to Example class to see hibernate object lifecycle.