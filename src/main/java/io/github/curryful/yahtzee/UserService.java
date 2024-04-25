package io.github.curryful.yahtzee;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Map<String, String> userPasswords = Map.of(
            "alice", "iLoveYahtzee",
            "bob", "ambob",
            "charlie", "charlie123"
    );
    private final Map<String, Long> sessions = new HashMap<>();

    public String login(String username) {
        if (userPasswords.containsKey(username)) {
            long sessionToken = new Random().nextLong();
            sessions.put(username, sessionToken);
            return String.valueOf(sessionToken);
        }
        return "Invalid username";
    }

    public boolean validateToken(String token) {
        try {
            long sessionToken = Long.parseLong(token);
            return sessions.values().contains(sessionToken);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Long getSessionToken(String username) {
        return sessions.get(username);
    }
}
