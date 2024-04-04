package com.platform.task.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.platform.task.backend.request.AuthRequest;
import com.platform.task.backend.response.TokenResponse;
import com.platform.task.backend.service.JwtService;

@RequestMapping("/")
public class TokenController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private JwtService jwtService;
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<TokenResponse> authenticate(@RequestBody AuthRequest request){
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContrasenia()));
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsuario());
		
		final String jwt = jwtService.generateToken(userDetails);
		
		return ResponseEntity.ok(new TokenResponse(jwt));
		
	}

}

