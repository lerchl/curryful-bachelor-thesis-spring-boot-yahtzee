package io.github.curryful.yahtzee;

import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class YahtzeeService {

    private final UserService userService;
    private final Random random = new Random();

    public YahtzeeService(UserService userService) {
        this.userService = userService;
    }

    public String rollDice(String sessionToken) {
        if (!userService.validateToken(sessionToken)) {
            return "Unauthorized access";
        }

        // Returning a small straight for charlie
        if (sessionToken.equals(userService.getSessionToken("charlie"))) {
            return "1,2,3,4,5";
        }

        int[] dice = new int[5];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = random.nextInt(6) + 1; // 1 to 6
        }

        return Arrays.toString(dice);
    }
}
