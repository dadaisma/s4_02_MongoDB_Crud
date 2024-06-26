package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n03.S04T02N03GognomsNom.model.repository.FruitRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
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
        if(fruitRepository.findByName(fruit.getName()).isPresent()){
            throw new EntityExistsException("Create new Fruit Failed: Invalid fruit name: "+ fruit.getName()+
                    " or ID: "+fruit.getId()+" -> ALREADY EXISTS in DataBase");
        }
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public Fruit updateFruit(String id, Fruit fruit){
        if(!fruitRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("Update Fruit Failed: Invalid fruit id: "+ id +
                    " -> DOESN'T EXIST in DataBase");
        }
            return fruitRepository.save(fruit);
        }


    @Override
    @Transactional
    public boolean deleteFruit(String id){
        if(!fruitRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("Delete Fruit Failed: Invalid fruit id: "+ id+
                    " -> DOESN'T EXIST in DataBase");
        }
            fruitRepository.deleteById(id);
            return true;
        }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Fruit> getAllFruits(){
        return fruitRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Fruit> getFruitById(String id){
        return Optional.ofNullable(fruitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Get One Fruit Failed: Invalid fruit id: " + id +
                " -> DOESN'T EXIST in DataBase")));
    }
}
