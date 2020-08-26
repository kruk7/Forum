package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String login;
    private String password;
    private Timestamp date;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Topic> topics;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Post> posts;

    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public String getLogin()
    { return login; }

    public void setLogin(String login)
    { this.login = login; }

    public String getPassword()
    { return password; }

    public void setPassword(String password)
    { this.password = password; }

    public Timestamp getDate()
    { return date; }

    public void setDate(Timestamp date)
    { this.date = date; }

    public Set<Topic> getTopics()
    { return topics; }

    public void setTopics(Set<Topic> topics)
    { this.topics = topics; }

    public Set<Post> getPosts()
    { return posts; }

    public void setPosts(Set<Post> posts)
    { this.posts = posts; }
}
