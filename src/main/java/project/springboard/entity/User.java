package project.springboard.entity;

import lombok.Builder;
import lombok.Getter;
import javax.persistence.*;

@Entity
@Getter
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String loginPassword;
    private String name;


    @Builder
    public User(Long id, String loginId, String loginPassword, String name){
        this.id = id;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
        this.name = name;
    }
}
