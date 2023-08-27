package com.techpro.twitter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_seq", allocationSize = 2, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    private Long id;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
