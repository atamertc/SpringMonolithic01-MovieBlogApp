# MOVIE APP - MONOLITHIC WITH SPRING BOOT
A repository to exercise applications of Monolithic Architecture and Spring Boot.

## App Requirements

### Entities

| User             | Movie             | MovieComment      | Genre |
| ---------------- | ----------------- |-------------------| ----- |
| id               | id                | id                | id    |
| name(50 char)    | genre             | content(500 char) | name  |
| surname(50 char) | language          | commentDate(date) |       |
| email(50 char)   | image             | movieId           |       |
| phone(15 char)   | name              | userId            |       |
| password(max32)  | country           |                   |       |
| favMovie         | rating            |                   |       |
| favGenre         | Summary(big data) |                   |       |
|                  | Premiered(date)   |                   |       |
|                  | url               |                   |       |

### Repository

- Bring users sorted by name
- The value entered from outside is present in the names of which users.
- Users whose emails contain the value we specified
- Users whose emails end according to the value we set
- User control by email and passcode
- Those whose password length is greater than the number we specify (Query will be written)

### Movie

- Bring those above a certain rating
- Bring movies that cover the interests of a specific user
- Write a method that lists the movies released before the date entered.
- Retrieve how many of a movie with a certain rating and the rating together (Query)
- How many movies have a certain rating.
- Get the movies with a rating of 7, 8, and 9 among the movies
- Get the movies with the name [ movie1, movie2 ]
- How many movies are in each country (Query)

### MovieComment

- Write a method that lists the comments of a movie
- Write a method that shows the comments made to a specific movie in given date ranges
- Write a method that lists the comments made by a user
- Write a method that shows the comments made by a user in a given date range
- Get the comments that have the word "very nice" in the content of the comment
- Get comments with a length greater than 20 characters