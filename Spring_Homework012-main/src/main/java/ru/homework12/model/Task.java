package ru.homework12.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
public class Task {

    /**
     * ID задачи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Описание задачи
     */
    @Column(nullable = false)
    private String description;

    /**
     * Статус задачи
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /**
     * Дата создания задачи
     */
    private LocalDateTime creationDate;


}
