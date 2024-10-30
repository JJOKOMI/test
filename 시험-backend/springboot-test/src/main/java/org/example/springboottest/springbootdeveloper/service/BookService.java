package org.example.springboottest.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springboottest.springbootdeveloper.dto.requestDto.PostBookRequestDto;
import org.example.springboottest.springbootdeveloper.dto.responseDto.PostBookResponseDto;
import org.example.springboottest.springbootdeveloper.dto.responseDto.ResponseDto;
import org.example.springboottest.springbootdeveloper.entity.Book;
import org.example.springboottest.springbootdeveloper.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 1. 책 생성(Post)
    public ResponseDto<PostBookResponseDto> createBook(PostBookRequestDto requestDto) {
        Book book = new Book(
                null, requestDto.getBookTitle(), requestDto.getBookAuthor(),
                requestDto.getBookCategory()
        );

        Book savedBook = bookRepository.save(book);
        return ResponseDto.setSuccess(convertToResponseDto(savedBook));
    }

    // 2. 전체 책 조회
    public ResponseDto<List<PostBookResponseDto>> getAllBooks() {
        List<PostBookResponseDto> books = bookRepository.findAll()
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseDto.setSuccess(books);
    }

    // 3. 특정 ID 책 조회
    public ResponseDto<PostBookResponseDto> getBookById(Long id) {
        try {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다: " + id));
            return ResponseDto.setSuccess(convertToResponseDto(book));
        } catch (Exception e) {
            return ResponseDto.setFailure(e.getMessage());
        }
    }

    // Entity -> ResponseDto 변환
    private PostBookResponseDto convertToResponseDto(Book book) {
        return new PostBookResponseDto(
                book.getId(), book.getBookTitle(), book.getBookAuthor(), book.getBookCategory()
        );
    }
}
