# Change Notes
1. domain: Booking.java
- removed "cascade: from the Relationship annotations in order to test controller using Postman

2. application.properties
- removed query parameters from the "spring.datasource.url" configuration. Reason: Date values were becoming wrong because of ServerTimezone=UTC.

3. config: CarRentalWebSecurity.java
- change configure method to check functions without authorization using Postman
