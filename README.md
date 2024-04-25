# Spring Boot Todo List
## Prompt

    I want a yahtzee application built with Spring Boot using in-memory storage
    using Java Collections. There are only two endpoints:
    - POST /login - takes a username and returns a session password
    - GET /yahtzee - generates five random dice rolls and returns the result
            (Always return a small straight for charlie)

    The available users are:
    - alice / iLoveYahtzee
    - bob / ambob
    - charlie / charlie123

    Using middleware, implement these features:
    - the session password is a random long value, only using that, /yahtzee can
            be called
    - set a header containing a joke if bob calls /yahtzee

    Everything should be plain text, the request you receive as well as the
    answers you send.

Second prompt because of the error
`The method getSessionToken(String) is undefined for the type UserServiceJava(67108964)`:

    The method getSessionToken(String) is undefined for the type
    UserServiceJava(67108964)

## Run
Can be run with the command: `./mvnw spring-boot:run`
