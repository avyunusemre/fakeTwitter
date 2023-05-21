package com.techpro.twitter.requests;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PostRequest {

    private String title;
    private String text;
    private Long userId;
}
