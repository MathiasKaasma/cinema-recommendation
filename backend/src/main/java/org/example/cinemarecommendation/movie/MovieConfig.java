package org.example.cinemarecommendation.movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
public class MovieConfig {
    private static final List<String> GENRES = List.of("Seiklus", "Draama", "Eesti", "Põnevus", "Komöödia", "Romantika");
    private static final List<String> LANGUAGES = List.of("Eesti", "Inglise", "Vene");
    private static final List<Integer> AGERATINGS = List.of(0, 13, 16, 18);
    private static final List<String> ADJECTIVES = Arrays.asList("Suurepärane", "Uskumatu", "Müstiline", "Imeline", "Fantaastiline");
    private static final List<String> NOUNS = Arrays.asList("seiklus", "rännak", "otsing", "müsteerium", "põnevik");
    private static final double MIN_RATING = 3.0;
    private static final double MAX_RATING = 5.0;

    @Bean
    public CommandLineRunner dataLoader(MovieRepository movieRepository) {
        return args -> {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                Movie movie = new Movie(
                        ADJECTIVES.get(random.nextInt(ADJECTIVES.size())) + " " + NOUNS.get(random.nextInt(NOUNS.size())),
                        GENRES.get(random.nextInt(GENRES.size())),
                        AGERATINGS.get(random.nextInt(AGERATINGS.size())),
                        LocalDateTime.now(),
                        LANGUAGES.get(random.nextInt(LANGUAGES.size())),
                        MIN_RATING + (MAX_RATING - MIN_RATING) * random.nextDouble(),
                        1
                );
                movieRepository.save(movie);
            }
        };
    }
}
