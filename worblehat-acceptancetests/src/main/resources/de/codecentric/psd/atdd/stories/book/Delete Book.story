Meta:
@themes Book

Narrative:
In order to have more space for new books
As a librarian
I want to delete unborrowed books

Scenario:

Given a library with only a single unborrowed book with <isbn> <title> <edition>

When librarian deletes the book <isbn> <title> <edition>

Then the book <isbn> <title> <edition> is not available anymore

Examples:
 
| isbn       | title         | edition |
| 1234567962 | Title		 | 1	   |
