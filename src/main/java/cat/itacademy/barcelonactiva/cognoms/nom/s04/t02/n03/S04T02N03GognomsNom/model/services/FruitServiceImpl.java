package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FruitServiceImpl implements  IFruitService {
    @Autowired
    private FruitRepository fruitRepository;

    @Override
    @Transactional
    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public Fruit updateFruit(String id, Fruit fruit){
        Optional<Fruit> existingFruit = fruitRepository.findById(id);
        if (existingFruit.isPresent()) {
            Fruit fruitToUpdate = existingFruit.get();
            fruitToUpdate.setName(fruit.getName());
            fruitToUpdate.setQuantityKg(fruit.getQuantityKg());
            return fruitRepository.save(fruitToUpdate);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteFruit(String id){
        Optional<Fruit> existingFruit = fruitRepository.findById(id);
        if(existingFruit.isPresent()){
            fruitRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Fruit> getAllFruits(){
        return fruitRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> getFruitById(String id){
        return fruitRepository.findById(id);
    }
}