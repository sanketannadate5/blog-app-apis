package com.sanket.blogappapis.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// 1. get token
		String requestToken = request.getHeader("Authorization");

		// 2. Bearer <Token>
		System.out.println("1.  " + requestToken);

		String userName = null;
		String token = null;

		if (!ObjectUtils.isEmpty(requestToken) && requestToken.startsWith("Bearer")) {
			token = requestToken.substring(7);
			try {
				userName = jwtTokenHelper.getUsernameFromToken(token);
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println("Unable to get JWT Token ");
			} catch (ExpiredJwtException expiredJwtException) {
				System.out.println("Toekn Expired ");
			} catch (MalformedJwtException malformedJwtException) {
				System.out.println("Invalid JWT ");
			}
		} else
			System.out.println("JWT TOken does not start with Bearer !!");

		// once we get the token
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
			if (jwtTokenHelper.validateToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else
				System.out.println("Invalid JWT Token ");
		} else
			System.out.println("username is null or context is not null");

		filterChain.doFilter(request, response);
	}
}