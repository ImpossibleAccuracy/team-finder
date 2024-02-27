package org.teamfinder.data.account

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
class Account(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    var id: Long,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @Column(name = "Email", nullable = false)
    var email: String,

    @Column(name = "Password", nullable = false)
    var password: String,

    @OneToOne(mappedBy = "id", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    var personal: AccountPersonal,
)
