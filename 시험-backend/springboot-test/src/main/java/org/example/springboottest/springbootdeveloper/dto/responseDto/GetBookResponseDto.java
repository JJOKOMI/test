package org.example.springboottest.springbootdeveloper.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetBookResponseDto {
    private Long id;
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
}
