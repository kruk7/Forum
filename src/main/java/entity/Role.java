package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Role implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String login;
    private String role;

    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public String getLogin()
    { return login; }

    public void setLogin(String login)
    { this.login = login; }

    public String getRole()
    { return role; }

    public void setRole(String role)
    { this.role = role; }
}
