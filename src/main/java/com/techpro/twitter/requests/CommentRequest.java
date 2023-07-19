package com.techpro.twitter.requests;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommentRequest {
    String text;
    Long post_id;
}
