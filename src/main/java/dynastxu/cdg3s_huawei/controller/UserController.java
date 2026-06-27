package dynastxu.cdg3s_huawei.controller;

import dynastxu.cdg3s_huawei.dto.LoginRequest;
import dynastxu.cdg3s_huawei.entity.User;
import dynastxu.cdg3s_huawei.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<UserService> {
    UserController(UserService userService) {
        super(userService);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginRequest request) {
        try {
            User user = service.login(request.getUsername(), request.getPassword());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "登录成功"
            ));
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        }
    }
}
