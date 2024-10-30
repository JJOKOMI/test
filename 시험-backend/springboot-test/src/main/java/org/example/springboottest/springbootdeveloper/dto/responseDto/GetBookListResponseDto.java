package org.example.springboottest.springbootdeveloper.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetBookListResponseDto {
    private final List<GetBookResponseDto> books;
}
