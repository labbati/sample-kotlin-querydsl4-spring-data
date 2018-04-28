package com.labbati.querydsldemo.controller

import com.labbati.querydsldemo.domain.Company
import com.labbati.querydsldemo.domain.QCompany
import com.querydsl.jpa.impl.JPAQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import javax.persistence.EntityManager

@Controller
class KotlinControllerUsingJava @Autowired constructor(private val em: EntityManager){

    @GetMapping
    fun list() : ModelAndView {
        val companies = JPAQuery<Company>(em).from(QCompany.company).fetch()
        val model = mapOf("companies" to companies)
        return ModelAndView("sample-view", model)
    }
}
