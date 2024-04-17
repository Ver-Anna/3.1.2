package an.vershinina.SpringBoot.dao;

import an.vershinina.SpringBoot.models.Person;
import java.util.List;

public interface PersonDAO {
    List<Person> index();
    Person show(int id);
    void save(Person person);
    void update(Person updatePerson);
    void delete(int id);
}
