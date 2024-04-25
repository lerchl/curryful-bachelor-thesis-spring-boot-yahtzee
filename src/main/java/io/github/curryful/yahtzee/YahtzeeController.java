package io.github.curryful.yahtzee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YahtzeeController {

    @Autowired
    private YahtzeeService yahtzeeService;

    @GetMapping("/yahtzee")
    public ResponseEntity<String> yahtzee(@RequestHeader("Authorization") String sessionToken) {
        return ResponseEntity.ok(yahtzeeService.rollDice(sessionToken));
    }
}
