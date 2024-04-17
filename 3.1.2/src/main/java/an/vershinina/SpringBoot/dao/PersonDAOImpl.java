package an.vershinina.SpringBoot.dao;

import an.vershinina.SpringBoot.models.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Person> index() { //запрос для выбора всех записей из таблицы
        return entityManager.createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public Person show(int id) { //ищем человека по айди
        return entityManager.find(Person.class, id);
    }

    @Transactional
    @Override
    public void save(Person person) { //сохраняем человека
        entityManager.persist(person);
    }

    @Transactional
    @Override
    public void update(Person updatePerson) {
        entityManager.merge(updatePerson);
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}


