package com.jvision.web;

import com.jvision.service.posts.PostsService;
import com.jvision.web.dto.PostsResponseDto;
import com.jvision.web.dto.PostsSaveRequestDto;
import com.jvision.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
// Web Layer
// Controller와 JSP 등 뷰 템플릿 영역
// 이외에서 필터, 인터셉터, 컨트롤러 어드바이스 등 외부 요청과 응답에 대한 영역을 의미

@RequiredArgsConstructor
// Controller은 토스해주는 역할
@RestController
// 수정, 조회 API 코드 확인
public class PostsApiController {

    private final PostsService postsService;

    // PostMapping은 입력값이 안보임

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto)
    {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    // @pathVariable => 밑에 id가 전달받는 id값이다 라는 걸 알려주기 위해

    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
        // 클라이언트의 수정 요청 처리 메소드
    }

    @GetMapping("/api/v1/posts/{id}")
    // 클라이언트의 삭제 요청 처리 메소드
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
        // DB내 posts 삭제 후 id 리턴
    }

}
