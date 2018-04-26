package com.labbati.querydsldemo.controller

import com.labbati.querydsldemo.domain.Company
import com.labbati.querydsldemo.domain.Person
import com.labbati.querydsldemo.domain.QCompany
import com.labbati.querydsldemo.domain.QPerson
import com.querydsl.jpa.impl.JPAQuery
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import java.util.HashMap
import javax.persistence.EntityManager

@Controller
class KotlinControllerUsingJava @Autowired constructor(private val em: EntityManager){

    @GetMapping("sample")
    fun list() : ModelAndView {
        val persons = JPAQuery<Person>(em).from(QPerson.person).fetch()
        val companies = JPAQuery<Company>(em).from(QCompany.company).fetch()
        val model = HashMap<String, Any>()
        model["persons"] = persons
        model["companies"] = companies
        return ModelAndView("sample-view", model)
    }
}
