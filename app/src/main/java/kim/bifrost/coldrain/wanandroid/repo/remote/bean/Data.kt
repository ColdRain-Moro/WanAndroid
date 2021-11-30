package kim.bifrost.coldrain.wanandroid.repo.remote.bean

/**
 * kim.bifrost.coldrain.wanandroid.api.bean.Data
 * WanAndroid
 *
 * @author 寒雨
 * @since 2021/11/21 22:41
 **/
data class LoginData(
    val admin: Boolean,
    val chapterTops: MutableList<String>,
    val coinCount: Int,
    val collectIds: MutableList<String>,
    val email: String,
    val icon: String,
    val id: Long,
    val nickname: String,
    val password: String,
    val token: String,
    val type: Int,
    val username: String,
)

data class UserInfoData(
    val coinInfo: CoinInfoData?,
    val userInfo: LoginData,
) {
    data class CoinInfoData(
        val coinCount: Int,
        val level: Int,
        val nickname: String,
        val rank: Int,
        val userId: Int,
        val username: String,
    )
}

data class BannerData(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String,
)

data class ArticlesData(
    val curPage: Int,
    val datas: List<ArticleData>
)

data class ArticleData(
    val apkLink: String,
    val audit: Int,
    var author: String,
    val canEdit: Boolean,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val descMd: String,
    val envelopePic: String,
    val fresh: Boolean,
    val host: String,
    val id: Int,
    val link: String,
    val niceDate: String,
    val niceShareDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val realSuperChapterId: Int,
    val selfVisible: Int,
    val shareDate: Long,
    var shareUser: String,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<Tag>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int,
) {
    data class Tag(
        val name: String,
        val url: String,
    )
}







