package io.github.curryful.yahtzee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        String sessionToken = userService.login(username.trim(), password.trim());
        if (sessionToken.equals("Invalid username or password")) {
            return ResponseEntity.status(401).body(sessionToken);
        }
        return ResponseEntity.ok(sessionToken);
    }
}
