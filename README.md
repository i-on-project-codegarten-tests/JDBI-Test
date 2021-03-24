# JDBI-Test
Test repository for JDBI.

## Summary
To initialize the database connection we use `Jdbi.create(connectionString, username, password)`.

We can use `withHandle` to execute SQL commands that return something, and `useHandle` for commands with no return.
For some reason, we need to specify the Exception type whenever we use these methods.

We can use `registerRowMapper` to register ways to map a query result to a particular type.
For each data class, we need to register a RowMapper.

We can use `executeAndReturnGeneratedKeys` to obtain the auto-generated keys (e.g generated identity) and all the attributes that were inserted.

`inTransaction` executes a transaction, returning the result.
`useTransaction` executes a transaction without returing the result.

When interacting with the database, the standard procedure should be:
- Define the data classes (Update and Read)
- Define the data mappers (using `registerRowMapper`)
- Initialize database connection via `Jdbi.create`
- Interact with the database using `withHandle` or `useHandle`

	

