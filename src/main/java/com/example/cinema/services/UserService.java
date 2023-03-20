package com.example.cinema.services;

import com.example.cinema.dto.ScreeningDto;
import com.example.cinema.dto.UserDto;
import com.example.cinema.mapper.ScreeningMapper;
import com.example.cinema.mapper.UserMapper;
import com.example.cinema.model.Screening;
import com.example.cinema.model.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final EntityManager entityManager;

    public List<UserDto> findUsersByScreeningId(Long screeningId) {
        String hql = "SELECT u FROM UserEntity u JOIN Reservation r WHERE r.screening.id = :screeningId";
        TypedQuery<UserEntity> query = entityManager.createQuery(hql, UserEntity.class);
        query.setParameter("screeningId", screeningId);
        return query.getResultList().stream().map(userMapper::mapToDto).toList();
    }

    public List<UserDto> findUsersByUsername(String username) {
        String hql = "SELECT u FROM UserEntity u WHERE u.username = :username";
        TypedQuery<UserEntity> query = entityManager.createQuery(hql, UserEntity.class);
        query.setParameter("username", username);
        return query.getResultList().stream().map(userMapper::mapToDto).toList();
    }
}
