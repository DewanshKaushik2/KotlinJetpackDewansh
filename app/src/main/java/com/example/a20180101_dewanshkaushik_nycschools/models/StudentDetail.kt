package com.example.a20180101_dewanshkaushik_nycschools.models

class StudentDetail() : ArrayList<StudentDetailItem>()

data class StudentDetailItem(
    val dbn: String,
    val num_of_sat_test_takers: String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String,
    val school_name: String
)
class gg(flag:Boolean)
data class MyPerson(val flag:Boolean)