package project.springboard.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name="user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String loginPassword;
    private String name;
    private String email;

    @Builder
    public User(Long id, String loginId, String loginPassword, String name, String email){
        this.id = id;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
        this.email = email;
    }
}
