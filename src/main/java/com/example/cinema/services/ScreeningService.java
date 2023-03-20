package com.example.cinema.services;

import com.example.cinema.dto.MovieDto;
import com.example.cinema.dto.ScreeningDto;
import com.example.cinema.mapper.MovieMapper;
import com.example.cinema.mapper.ScreeningMapper;
import com.example.cinema.model.Movie;
import com.example.cinema.model.Screening;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningMapper screeningMapper;

    private final EntityManager entityManager;

    public List<ScreeningDto> findScreeningsByRoomId(Long roomId) {
        String hql = "SELECT DISTINCT s FROM Screening s WHERE s.screeningRoom.id = :roomId";
        TypedQuery<Screening> query = entityManager.createQuery(hql, Screening.class);
        query.setParameter("roomId", roomId);
        return query.getResultList().stream().map(screeningMapper::mapToDto).toList();
    }

    public List<ScreeningDto> findScreeningsByMovieTitle(String movieTitle) {
        String hql = "SELECT s FROM Screening s WHERE s.movie.title = :movieTitle";
        TypedQuery<Screening> query = entityManager.createQuery(hql, Screening.class);
        query.setParameter("movieTitle", movieTitle);
        return query.getResultList().stream().map(screeningMapper::mapToDto).toList();
    }

    public List<ScreeningDto> findScreeningsByMovieId(Long movieId) {
        String hql = "SELECT s FROM Screening s WHERE s.movie.id = :movieId";
        TypedQuery<Screening> query = entityManager.createQuery(hql, Screening.class);
        query.setParameter("movieId", movieId);
        return query.getResultList().stream().map(screeningMapper::mapToDto).toList();
    }

    public List<ScreeningDto> findScreeningByUsername(String username) {
        String hql = "SELECT s FROM Screening s Join Reservation r WHERE r.user.username = :username";
        TypedQuery<Screening> query = entityManager.createQuery(hql, Screening.class);
        query.setParameter("username", username);
        return query.getResultList().stream().map(screeningMapper::mapToDto).toList();
    }

    public Long getBusyCount() {
        String hql = "SELECT count(s) FROM Screening s Join Reservation r";
        TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
        return query.getSingleResult();
    }
}
