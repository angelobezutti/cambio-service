package br.com.dev.msbook.repositories;

import br.com.dev.msbook.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
