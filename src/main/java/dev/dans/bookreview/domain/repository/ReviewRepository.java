package dev.dans.bookreview.domain.repository;

import dev.dans.bookreview.domain.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    public void deleteAllByUserId(Long userId);
    public void deleteAllByBookId(Long bookId);
}
