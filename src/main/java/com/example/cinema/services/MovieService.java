package com.example.cinema.services;

import com.example.cinema.dto.MovieDto;
import com.example.cinema.mapper.MovieMapper;
import com.example.cinema.model.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieMapper movieMapper;

    private final EntityManager entityManager;

    public List<MovieDto> findMoviesByScreeningRoomId(Long roomId) {
        String hql = "SELECT DISTINCT m FROM Movie m JOIN m.screenings s WHERE s.screeningRoom.id = :roomId";
        TypedQuery<Movie> query = entityManager.createQuery(hql, Movie.class);
        query.setParameter("roomId", roomId);
        return query.getResultList().stream().map(movieMapper::mapToDto).toList();
    }
}
