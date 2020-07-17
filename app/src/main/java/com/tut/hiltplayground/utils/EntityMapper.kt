package com.tut.hiltplayground.utils

interface EntityMapper<Entity, DomainModel> {
    fun toDomainModel(entity: Entity):DomainModel
    fun fromDomainModel(model: DomainModel):Entity
}