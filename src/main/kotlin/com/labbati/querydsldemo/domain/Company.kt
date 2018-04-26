package com.labbati.querydsldemo.domain

import javax.persistence.*

@Entity
@Table(name = "companies")
open class Company (
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    open val id: Int,

    @Column(name = "name")
    open val name: String
) {
    private constructor() : this(0, "")
}
