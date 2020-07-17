package com.tut.hiltplayground.local

import com.tut.hiltplayground.model.Blog
import com.tut.hiltplayground.network.response.BlogNetworkEntity
import com.tut.hiltplayground.utils.EntityMapper
import javax.inject.Inject

class CacheEntityMapper @Inject constructor(): EntityMapper<BlogCacheEntity, Blog> {
    override fun toDomainModel(entity: BlogCacheEntity): Blog {
        return Blog(entity.id, entity.body, entity.category, entity.image, entity.title)
    }

    override fun fromDomainModel(model: Blog): BlogCacheEntity {
        return BlogCacheEntity(model.id, model.body, model.category, model.image, model.title)
    }

    fun toBlogs(list:List<BlogCacheEntity>):List<Blog>{
        return list.map { toDomainModel(it) }
    }
}