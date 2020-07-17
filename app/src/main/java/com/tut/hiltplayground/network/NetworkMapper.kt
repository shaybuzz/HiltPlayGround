package com.tut.hiltplayground.network

import com.tut.hiltplayground.model.Blog
import com.tut.hiltplayground.network.response.BlogNetworkEntity
import com.tut.hiltplayground.utils.EntityMapper
import javax.inject.Inject

//TODO use extension ??
class NetworkMapper @Inject constructor(): EntityMapper<BlogNetworkEntity, Blog> {
    override fun toDomainModel(entity: BlogNetworkEntity): Blog {
        return Blog(entity.pk, entity.body, entity.category, entity.image, entity.title)
    }

    override fun fromDomainModel(model: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(model.id, model.body, model.category, model.image, model.title)
    }

    fun toBlogs(list:List<BlogNetworkEntity>):List<Blog>{
        return list.map { toDomainModel(it) }
    }

}