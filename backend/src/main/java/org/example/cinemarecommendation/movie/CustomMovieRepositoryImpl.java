package org.example.cinemarecommendation.movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movie> findByFilters(String title, String genre, Integer ageRating, LocalDateTime startTime, String language, Double rating, Double suggestion) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> cq = cb.createQuery(Movie.class);

        Root<Movie> movie = cq.from(Movie.class);
        List<Predicate> predicates = new ArrayList<>();

        if (title != null) {
            predicates.add(cb.like(cb.lower(movie.get("title")), "%" + title.toLowerCase() + "%"));
        }
        if (genre != null) {
            predicates.add(cb.equal(movie.get("genre"), genre));
        }
        if (ageRating != null && ageRating != 0) {
            predicates.add(cb.equal(movie.get("ageRating"), ageRating));
        }
        if (startTime != null) {
            predicates.add(cb.greaterThanOrEqualTo(movie.get("startTime"), startTime));
        }
        if (language != null) {
            predicates.add(cb.equal(movie.get("language"), language));
        }
        if (rating != null && rating != 0.0) {
            predicates.add(cb.greaterThanOrEqualTo(movie.get("rating"), rating));
        }
        if (suggestion != null && suggestion != 0.0) {
            predicates.add(cb.greaterThanOrEqualTo(movie.get("suggestion"), suggestion));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(cq).getResultList();
    }
}
