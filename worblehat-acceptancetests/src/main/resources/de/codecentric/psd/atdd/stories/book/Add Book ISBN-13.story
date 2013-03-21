Meta:
@themes Book

Narrative:
In order to add new books to the library
As a librarian
I want to add books with 13 digits ISBN through the website

Scenario:

Given an empty library
When a book with ISBN <isbn> is added
Then the library contains only the book with <isbn>

Examples:
 
| isbn        |
| 097522980X  |


