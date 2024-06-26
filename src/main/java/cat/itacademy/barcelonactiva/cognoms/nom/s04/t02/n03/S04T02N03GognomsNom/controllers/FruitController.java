package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.controllers;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitServiceImpl fruitServiceImpl;

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", "token-value");
        return headers;
    }

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
            Fruit addedFruit = fruitServiceImpl.addFruit(fruit);
            return new ResponseEntity<>(addedFruit, createHeaders(),HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable String id, @RequestBody Fruit fruit) {
            Fruit updatedFruit = fruitServiceImpl.updateFruit(id, fruit);
            return new ResponseEntity<>(updatedFruit, createHeaders(),HttpStatus.OK);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable String id) {
            boolean isDeleted = fruitServiceImpl.deleteFruit(id);
            return new ResponseEntity<>(createHeaders(),HttpStatus.NO_CONTENT);
           }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {

            Iterable<Fruit> fruitIterable = fruitServiceImpl.getAllFruits();
            List<Fruit> fruits = StreamSupport.stream(fruitIterable.spliterator(), false)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(fruits, createHeaders(),HttpStatus.OK);


    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable String id) {
        Optional<Fruit> fruit = fruitServiceImpl.getFruitById(id);

        return fruit.map(value -> new ResponseEntity<>(value, createHeaders(),HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
