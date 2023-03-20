package com.example.cinema.services;

import com.example.cinema.mapper.ScreeningRoomMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScreeningRoomService {

    private final ScreeningRoomMapper screeningRoomMapper;

    private final EntityManager entityManager;

    public Long getRoomCountByMovieId(Long id) {
        String hql = "SELECT count(sr) FROM ScreeningRoom sr Join Screening s WHERE s.movie.id = :id";
        TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
