package com.ssafy.edu.service;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JwtTokenService {
	
	@Value("spring.jwt.secret")
	private String secretKey;
	
	private long tokenValidTime = 1000L*60*60*2;
	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
	private Logger logger = LoggerFactory.getLogger(JwtTokenService.class);

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String createToken(String userPk, String role) {
		Claims claims = Jwts.claims().setSubject(userPk);//여기서 pk는 email
		claims.put("role", role);
		Date now = new Date();
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + tokenValidTime))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
				
	}
	
//	public Authentication getAuthentication(String token) {
//		UserDetails userDetails = userDetailsService.loadUserByUsername(getUserPk(token));
//		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//	}
	
	// Jwt 토큰에서 회원 구별 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // Request의 Header에서 token 파싱 : "x-access-token: jwt토큰"
    public String resolveToken(HttpServletRequest req) {
    	logger.info(req.getHeader("x-access-token"));
        return req.getHeader("x-access-token");
    }

    // Jwt 토큰의 유효성 + 만료일자 확인
    public boolean validateToken(String jwtToken) {
    	if(jwtToken != null) {
	        try {
	            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
	            //logger.info("만료 시간 T/F? "+claims.getBody().getExpiration().before(new Date()));
	            return !claims.getBody().getExpiration().before(new Date());
	        } catch (Exception e) {
	            return false;
	        }
    	}
    	return false;
    }
	
}
