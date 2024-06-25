package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.domain.Fruit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IFruitService {
    @Transactional
    Fruit addFruit(Fruit fruit);

    @Transactional
    Fruit updateFruit(String id, Fruit fruit);

    @Transactional
    boolean deleteFruit(String id);

    @Transactional(readOnly = true)
    Iterable<Fruit> getAllFruits();

    @Transactional(readOnly = true)
    Optional<Fruit> getFruitById(String id);
}
