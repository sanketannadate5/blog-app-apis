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

APIs
1. register
http://localhost:8080/api/auth/register

{
    "name":"Sanket",
    "email":"sanketjain@gmail.com",
    "password":"BestPassword",
    "about":"This is offocial profile"
}

2. login
http://localhost:8080/api/auth/login

3.create user
http://localhost:8080/api/user/create

4. delete user by id
http://localhost:8080/api/user/userId

5. get all users
http://localhost:8080/api/user/

6. create post
http://localhost:8080/api/post/create/user/1/category/1

{
    "title":"Ganga",
    "content":"The Holy river of India"
}

7. get post by id
http://localhost:8080/api/post/1

8. create comment
http://localhost:8080/api/comment/create/post/1/user/1

