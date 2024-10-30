package org.example.springboottest.springbootdeveloper.dto.responseDto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBookResponseDto {
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
}