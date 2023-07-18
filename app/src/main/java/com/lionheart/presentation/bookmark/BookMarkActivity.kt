package com.lionheart.presentation.bookmark

import android.view.View
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityBookmarkBinding
import com.lionheart.domain.entity.BookmarkArticle

class BookMarkActivity : BindingActivity<ActivityBookmarkBinding>(R.layout.activity_bookmark) {
    private var bookmarkTitleAdapter: BookmarkTitleAdapter? = null
    private var bookmarkArticleAdapter: BookmarkArticleAdapter? = null

    private val bookmarkList = BookmarkArticle(
        articleSummaries = listOf(
            BookmarkArticle.ArticleSummary(
                true,
                "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
                listOf("hi", "hello", "bye"),
                "초음파 검사가 어렵다면? 초음파 검사의 모든 것1",
            ),
            BookmarkArticle.ArticleSummary(
                true,
                "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
                listOf("hi", "hello", "bye"),
                "초음파 검사가 어렵다면? 초음파 검사의 모든 것2",
            ),
            BookmarkArticle.ArticleSummary(
                true,
                "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
                listOf("hi", "hello", "bye"),
                "초음파 검사가 어렵다면? 초음파 검사의 모든 것3",
            ),
            BookmarkArticle.ArticleSummary(
                true,
                "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
                listOf("hi", "hello", "bye"),
                "초음파 검사가 어렵다면? 초음파 검사의 모든 것4",
            ),
            BookmarkArticle.ArticleSummary(
                true,
                "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
                listOf("hi", "hello", "bye"),
                "초음파 검사가 어렵다면? 초음파 검사의 모든 것5",
            ),
            BookmarkArticle.ArticleSummary(
                true,
                "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
                listOf("hi", "hello", "bye"),
                "초음파 검사가 어렵다면? 초음파 검사의 모든 것6",
            ),
        ),
        babyNickname = "사랑이",
    )

    override fun constructLayout() {
        initAdapter()
    }

    private fun initAdapter() {
        bookmarkTitleAdapter = BookmarkTitleAdapter()
        bookmarkArticleAdapter = BookmarkArticleAdapter()
        bookmarkTitleAdapter?.submitList(listOf(bookmarkList.babyNickname))
        bookmarkArticleAdapter?.submitList(bookmarkList.articleSummaries)

        binding.rvBookmarkArticle.adapter =
            ConcatAdapter(bookmarkTitleAdapter, bookmarkArticleAdapter)
    }
}
