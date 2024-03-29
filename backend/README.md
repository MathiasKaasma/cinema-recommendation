Consideration: Setup Requirement
The requirement for your evaluators to set up a PostgreSQL database themselves can be seen as a minor inconvenience. However, you can mitigate this by providing a detailed setup guide in your documentation. Ensure to include:

Instructions on installing PostgreSQL or links to official installation guides.
A SQL script or a set of commands to create the necessary database and tables.
Guidance on configuring the application to connect to the database, including setting up the connection string in application.properties.
Alternatives and Enhancements
Dockerization: To further ease the setup process, consider dockerizing your application along with the PostgreSQL database. This way, evaluators would only need Docker installed, and they can get your application running with a single command, addressing the setup concern.

In-Memory Database for Testing: For testing purposes or initial evaluation, you might also consider integrating an in-memory database like H2. This allows the application to be tested without needing a PostgreSQL setup, although for production, PostgreSQL remains the preferred choice.