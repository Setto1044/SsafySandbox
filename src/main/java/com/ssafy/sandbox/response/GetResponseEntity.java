package com.ssafy.sandbox.response;


import com.ssafy.sandbox.todo.domain.Todo;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class GetResponseEntity {
    private List<Todo> todos;
}
