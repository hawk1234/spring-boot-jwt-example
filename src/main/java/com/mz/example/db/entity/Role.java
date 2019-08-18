package com.mz.example.db.entity;

import com.mz.example.db.Columns;
import com.mz.example.db.RoleName;
import com.mz.example.db.Tables;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = Tables.ROLE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @Column(name = Columns.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NaturalId//TODO: what is this for?
    @Enumerated(EnumType.STRING)//TODO: how does it work?
    @Column(name = Columns.NAME, length = 60)
    private RoleName name;
}
