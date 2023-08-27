package com.techpro.twitter.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "p_like")
@Data
public class Like {
    @Id
    @SequenceGenerator(name = "seq_like", sequenceName = "seq_like", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_like")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
