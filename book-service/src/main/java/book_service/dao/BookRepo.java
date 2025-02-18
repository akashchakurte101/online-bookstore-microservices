package book_service.dao;

import book_service.model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where author= :author")
    Optional<Book> findByAuthor(@Param("author") String author);

}
