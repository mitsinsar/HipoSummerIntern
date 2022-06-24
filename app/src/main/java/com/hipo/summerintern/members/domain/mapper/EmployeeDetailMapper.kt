package com.hipo.summerintern.members.domain.mapper

import com.hipo.summerintern.members.domain.model.EmployeeDetail
import javax.inject.Inject

class EmployeeDetailMapper @Inject constructor() {

    fun mapToEmployeeDetail(position: String, startYear: Int): EmployeeDetail {
        return EmployeeDetail(
            position = position,
            startYear = startYear
        )
    }
}
