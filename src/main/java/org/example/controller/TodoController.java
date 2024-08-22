package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.model.TodoResponse;
import org.example.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
/*
@CrossOrigin은 CORS(Cross-Origin Resource Sharing)를 설정하는 데 사용됩니다.
웹 애플리케이션이 서로 다른 도메인 간에 리소스를 요청할 때 발생하는 보안 기능입니다. 이 어노테이션을 사용하면 특정 도메인에서 오는 요청을 허용할 수 있습니다.
- origins: 허용할 출처를 지정합니다. 기본값은 모든 출처를 허용하는 *입니다.
- methods: 허용할 HTTP 메서드를 지정합니다. 예를 들어 GET, POST 등을 지정할 수 있습니다.
- allowedHeaders: 허용할 HTTP 요청 헤더를 지정합니다.
- exposedHeaders: 클라이언트에 노출할 응답 헤더를 지정합니다.
- allowCredentials: 자격 증명(쿠키, 인증 헤더 등)을 포함한 요청을 허용할지 여부를 지정합니다.
- maxAge: 브라우저가 CORS 응답을 캐시할 수 있는 최대 시간을 초 단위로 지정합니다.
*/
@CrossOrigin
@AllArgsConstructor
/*
@RestController은 RESTful 웹 서비스를 구축하기 위해 사용됩니다.
@Controller와 @ResponseBody의 조합으로 동작하며, 컨트롤러의 각 메서드가 JSON이나 XML 형식으로 직접 응답
*/
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        log.info("Creating new todo: {}", request);

        if (ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();

        if (ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);

        if (ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);

        TodoEntity result = this.todoService.add(request);

        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        log.info("Reading all todos");
        List<TodoEntity> result = this.todoService.searchAll();
        List<TodoResponse> response = result.stream().map(TodoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    /*
     @PathVariable은 RESTful 웹 서비스에서 종종 경로 변수는 리소스의 식별자 역할을 하며, 이를 통해 동적 URL 매핑을 구현할 수 있습니다.
    */
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        log.info("Reading todo by id: {}", id);
        TodoEntity result = this.todoService.searchById(id);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest request) {
        log.info("Updating todo by id: {}", id);
        TodoEntity result = this.todoService.updateById(id, request);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        log.info("Deleting all todos");
        this.todoService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        log.info("Deleting todo by id: {}", id);
        this.todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
