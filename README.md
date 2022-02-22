Attempt to reproduce https://github.com/quarkusio/quarkus/issues/18685


```
./startdb.java
quarkus dev
./putload.sh
```

this will boot up a sakila postgres instance (with some data to query on).

running quarkus and http://locahost:8080/hello will do a query against the db.

`putload.sh` just runs that query repeatedly in 10 parallel threads.

start/stop the postgres instance.
