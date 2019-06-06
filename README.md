CRUD METHODS
----
### Info
**CRUD** shortcut stands for **C**reate, **R**ead/**R**etrieve, **U**pdate, **D**elete.

**CRUD** refers to major function that are implemented in relational database applications.

**CRUD** works on entities in databases and manipulates these entities.

Hibernate offers [Session API](http://docs.jboss.org/hibernate/core/3.5/api/org/hibernate/Session.html#load(java.lang.Class,%20java.io.Serializable)) that implements CRUD methods (save/persist, get/load, update, delete).

----
### TASK

Your task is to create a wrapper class in ``crud`` package that implements the ``ICrudMethods`` interface using Hibernate Session API.
Do not create session transaction before each CRUD method, just invoke appropriate methods on session object (``CrudHandler`` class should automatically handle transactions for you).
When you are done go to the ``App`` class and plug in your crud class (gaps marked as ``YOUR CRUD CLASS``).
Please run java app stage by stage (go to next stage when first is accomplished):
- Uncomment I stage and try to create data base. Check out if authors have been added successfully to data base (if so comment first stage).
- Uncomment II stage - check if author is printed out on console.
- Uncomment III stage - check in database if author has been successfully updated.
- Uncomment IV stage - check in database if author has been successfully removed.

Check how it works.

Have fun.
