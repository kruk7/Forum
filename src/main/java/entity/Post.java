package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "posts")
public class Post implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private Timestamp date;
    private String content;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_topic")
    private Topic topic;

    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public Timestamp getDate()
    { return date; }

    public void setDate(Timestamp date)
    { this.date = date; }

    public String getContent()
    { return content; }

    public void setContent(String content)
    { this.content = content; }

    public User getUser()
    { return user; }

    public void setUser(User user)
    { this.user = user; }

    public Topic getTopic()
    { return topic; }

    public void setTopic(Topic topic)
    { this.topic = topic; }
}
