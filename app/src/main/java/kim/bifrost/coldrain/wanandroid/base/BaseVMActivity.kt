package kim.bifrost.coldrain.wanandroid.base

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * kim.bifrost.coldrain.wanandroid.base.BaseVMActivity
 * WanAndroid
 *
 * @author 寒雨
 * @since 2021/12/4 0:42
 **/
abstract class BaseVMActivity<VM : ViewModel, DB : ViewDataBinding>(isCancelStatusBar: Boolean = true) :
    BaseActivity<DB>(
        isCancelStatusBar
    ) {
    protected val viewModel by lazy {
        ViewModelProvider(this)[getViewModelClass()]
    }

    // 获得ViewModel的Class
    // class里的泛型没法实化，只能曲线救国
    @Suppress("UNCHECKED_CAST")
    private fun getViewModelClass(): Class<VM> {
        // 获取父类(即BaseVMActivity)的类型参数（包括泛型）数组
        val typeArguments = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
        for (type in typeArguments) {
            // 从中选出ViewModel类型
            if (type is Class<*> && ViewModel::class.java.isAssignableFrom(type)) {
                return type as Class<VM>
            }
        }
        error("failed to get ViewModel class")
    }
}