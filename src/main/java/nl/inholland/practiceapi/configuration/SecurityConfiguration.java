package nl.inholland.practiceapi.configuration;


import nl.inholland.practiceapi.dao.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private ApiKeyRepository apiKeyRepository;

    public SecurityConfiguration(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Value("${practice-api.token.header-name}")
    //${practice-api.token.header-name}
    private String headerName;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApiKeyAuthenticationFilter filter = new ApiKeyAuthenticationFilter(headerName);
        filter.setAuthenticationManager(authentication -> {
            String principal = (String)authentication.getPrincipal();

            if (!apiKeyRepository.findById(principal).isPresent()) {
                throw new BadCredentialsException("API Key was not found");
            }

            authentication.setAuthenticated(true);
            return authentication;
        });

        http
                .antMatcher("/gpus/**")
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(filter).authorizeRequests()
                .anyRequest().authenticated();
    }
}
