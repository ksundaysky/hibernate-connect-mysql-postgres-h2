# Existence of hibernate collections

1. Prepare H2 connection.
2. Go to CollectionsTest class.
3. Use prepared tests methods to prove, that a set of authors in the Book is a java.util.HashSet
   and after persistence is an org.hibernate.collection.internal.PersistentSet (use Author and Book classes).

## Documentation

Checkout documentation:

* [docs](https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/collections.html)