package kim.bifrost.coldrain.wanandroid.repo.data

import android.content.Context
import androidx.core.content.edit
import kim.bifrost.coldrain.wanandroid.App
import kim.bifrost.coldrain.wanandroid.repo.remote.bean.UserInfoData

/**
 * kim.bifrost.coldrain.wanandroid.repo.data.UserData
 * WanAndroid
 *
 *
 * @author 寒雨
 * @since 2021/11/23 8:55
 **/
object UserData {

    val isLogged: Boolean
        get() = App.cookieData.getString("cookie", null) != null
    var userInfoData: UserInfoData? = null
        set(value) {
            localData.edit {
                putString("userInfoData", App.gson.toJson(value))
            }
            field = value
        }

    // 本地缓存数据
    private val localData = App.context.getSharedPreferences("userdata", Context.MODE_PRIVATE)

    init {
        localData.getString("userInfoData", null)?.let {
            userInfoData = App.gson.fromJson(it, UserInfoData::class.java)
        }
    }

    // 释放
    fun releaseLocalData() {
        localData.edit {
            clear()
        }
        App.cookieData.edit {
            clear()
        }
    }

}