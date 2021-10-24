package by.itstep.repository;

import by.itstep.models.BookList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookListRepository extends JpaRepository<BookList, Integer> {
}
