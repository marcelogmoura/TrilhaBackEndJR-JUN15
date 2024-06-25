package com.marcelo.infrastructure.components;

import java.util.Date;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenComponent {

	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${jwt.expiration}")
	private String jwtExpiration;

	public String generateToken(UUID usuarioId) {
		
		Date dataAtual = new Date();
		Date dataExpiracao = new Date(dataAtual.getTime() + Long.parseLong(jwtExpiration));

		return Jwts.builder()
				.setSubject(usuarioId.toString())
				.setNotBefore(dataAtual).setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, jwtSecret)
				.compact();
	}
	
	public UUID getIdFromToken(String token) { // extrair ID do token
		return UUID.fromString(getClaimFromToken(token, Claims::getSubject));
	}


	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		String secretKey = jwtSecret;
		final Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		return claimsResolver.apply(claims);
	}

	
	
	
}



