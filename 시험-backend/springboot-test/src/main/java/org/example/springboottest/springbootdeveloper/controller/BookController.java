package org.example.springboottest.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.ApiMappingPattern;
import org.example.springboottest.springbootdeveloper.dto.requestDto.PostBookRequestDto;
import org.example.springboottest.springbootdeveloper.dto.responseDto.PostBookResponseDto;
import org.example.springboottest.springbootdeveloper.dto.responseDto.ResponseDto;
import org.example.springboottest.springbootdeveloper.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.BOOK)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 책 생성
    @PostMapping
    public ResponseEntity<ResponseDto<PostBookResponseDto>> createBook(@RequestBody PostBookRequestDto requestDto) {
        ResponseDto<PostBookResponseDto> result = bookService.createBook(requestDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 전체 책 조회
    @GetMapping
    public ResponseEntity<ResponseDto<List<PostBookResponseDto>>> getAllBooks() {
        ResponseDto<List<PostBookResponseDto>> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // 단건 책 조회
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<PostBookResponseDto>> getBookById(@PathVariable Long id) {
        ResponseDto<PostBookResponseDto> book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
}
