package org.example.springboottest.springbootdeveloper.dto.requestDto;

import lombok.*;
// 책 생성 시 클라이언트가 서버에 전달하는 데이터
// : 요청에 대한 데이터
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class PostBookRequestDto {
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
}