package com.mz.example.db.entity;

import com.mz.example.db.Columns;
import com.mz.example.db.Tables;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Tables.USER, uniqueConstraints = {//TODO: read about that
        @UniqueConstraint(columnNames = {
                Columns.USERNAME
        }),
        @UniqueConstraint(columnNames = {
                Columns.EMAIL
        })
})
@Getter
@Setter
@NoArgsConstructor
public class User extends DateAudit {

    @Id
    @Column(name = Columns.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = Columns.NAME)
    @Size(max = 40)
    private String name;

    @NotBlank
    @Column(name = Columns.USERNAME)
    @Size(max = 15)
    private String username;

//    @NaturalId//TODO: what is this for?
    @NotBlank
    @Column(name = Columns.EMAIL)
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Column(name = Columns.PASSWORD)
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = Tables.USER_ROLE,
            joinColumns = @JoinColumn(name = Columns.USER_ID),
            inverseJoinColumns = @JoinColumn(name = Columns.ROLE_ID))
    private Set<Role> roles = new HashSet<>();

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
