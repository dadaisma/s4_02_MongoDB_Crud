We have an entity called "Fruit", which has the following properties:

int id String name Int quantityKilos Taking advantage of the JPA specification, you will have to persist this entity to an MongoDB database, following the MVC pattern. For this, depending on the main Package, you will create a package structure, where you will place the classes you need:

cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01.controllers cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01.model.domain cat.itacademy.barcelonactiva.surnames.name.s04.t02.n01.model.services cat.itacademy.barcelonactiva.surnames.nom.s04.t02.n01.model.repository The class located in the controllers package (FruitaController, for example), must be able to respond to the following requests to update and consult information:

http://localhost:8080/fruit/add

http://localhost:8080/fruit/update

http://localhost:8080/fruita/delete/{id}

http://localhost:8080/fruita/getOne/{id}

http://localhost:8080/fruit/getAll

Help:
https://www.baeldung.com/spring-response-entity
https://medium.com/@sebastian.alejandro.hv/java-spring-usando-responseentity-ef327164d514
