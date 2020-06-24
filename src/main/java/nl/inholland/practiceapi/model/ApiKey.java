package nl.inholland.practiceapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class ApiKey {

    @Id
    private String apiKey;

    public ApiKey(String key) {
        this.apiKey = key;
    }
}
