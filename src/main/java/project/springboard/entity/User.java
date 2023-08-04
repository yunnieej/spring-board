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
    private String userId;
    private String userPassword;
    private String userName;

    @Builder
    public User(Long id, String userId, String userPassword, String userName, String userPhoneNumber, String userEmail){
        this.id = id;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;

    }

}
