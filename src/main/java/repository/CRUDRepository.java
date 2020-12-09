package repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T, P> {

    T create(T model) throws RuntimeException;

    List<T> findAll();

    T findByPrimaryKey(P key);

    T update(T model, P key);

    void delete(P key);
}
