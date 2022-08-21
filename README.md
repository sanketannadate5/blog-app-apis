# blog-app-apis

boot backend project for securing rest apis in few important steps.
steps are as follow: 
1. Add dependency(io.jsonwebtoken)
2. Create JWT authenticationEntryPoint implements AuthenticationEntryPoint

3.Create JWTTokenHelper
4. JwtAuthenticationFilter  extends OnceRequestFilter                   
Get jwt token from request
Validate token
Get user from token
Load user associated with token
Set spring security 
5. Create JwtAuthResponse
6. Configure JWT in spring security config
7. Create login  api to return token
8. Test the application.

