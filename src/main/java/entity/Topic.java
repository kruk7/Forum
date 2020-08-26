package entity;

import javafx.geometry.Pos;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topic implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topics_id")
    private Long id;
    private Timestamp date;
    private String title;
    @Lob
    private String content;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    @OrderBy("date ASC")
    private Set<Post> posts;

    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public Timestamp getDate()
    { return date; }

    public void setDate(Timestamp date)
    { this.date = date; }

    public String getTitle()
    { return title; }

    public void setTitle(String title)
    { this.title = title; }

    public String getContent()
    { return content; }

    public void setContent(String content)
    { this.content = content; }

    public User getUser()
    { return user; }

    public void setUser(User user)
    { this.user = user; }

    public Set<Post> getPosts()
    { return posts; }

    public void setPosts(Set<Post> posts)
    { this.posts = posts; }
}
